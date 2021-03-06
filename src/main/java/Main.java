/**
 * Created by karim on 3/27/16.
 */

import com.jana.karim.avro.generate.Data;
import com.jana.karim.avro.model.destination.*;


import com.jana.karim.avro.model.destination.Product;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.parquet.hadoop.ParquetOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import parquet.avro.AvroParquetOutputFormat;
import parquet.avro.AvroWriteSupport;
import scala.Tuple2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;

import com.jana.karim.kryo.KryoAvroClassRegistration;


public class Main {
    private static Logger log;

    public static void main(String[] args) throws IOException {
        log = Logger.getLogger(Main.class.getName());
        log.getLogger("org").setLevel(Level.OFF);
        log.getLogger("akka").setLevel(Level.OFF);
        log.info("hello world");


        KryoAvroClassRegistration a = new KryoAvroClassRegistration();
        String databricks = "com.databricks.spark.avro";
        Data.avroGenerate();

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Avro-Spark Job App");
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
            .set("spark.kryo.registrator", "com.jana.karim.kryo.KryoAvroClassRegistration");
        //Does not resolve error: com.esotericsoftware.kryo.KryoException:
        //java.lang.NullPointerException Serialization trace
        /*Class[] subscribers = {User.class, Address.class};
        List<Schema> avroSchemas = new ArrayList<Schema>();
        avroSchemas.add(User.SCHEMA$);
        avroSchemas.add(Address.SCHEMA$);
        avroSchemas.add(CustomerInfo.SCHEMA$);
        avroSchemas.add(MailAddress.SCHEMA$);
        avroSchemas.add(Name.SCHEMA$);
        //conf.registerKryoClasses(subscribers);
        conf.registerAvroSchemas(JavaConversions.asScalaBuffer(avroSchemas));*/

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

       DataFrame userDf = sqlContext.read().format(databricks)
                .load("src/main/avro/data/users.avro");
        DataFrame addressDf = sqlContext.read().format(databricks)
                .load("src/main/avro/data/addresses.avro");
        DataFrame productDf = sqlContext.read().format(databricks)
                .load("src/main/avro/data/product.avro");

        userDf.show();
        addressDf.show();
        productDf.show();

        JavaRDD<Row> userRdd = userDf.toJavaRDD();
        JavaRDD<Row> addressRdd = addressDf.toJavaRDD();
        JavaRDD<Row> productRdd = productDf.toJavaRDD();


        JavaRDD<CustomerInfo> partialRddCustomerInfoUser= userRdd.map(new UserPartialMapping());

        //partialRddCustomerInfoUser.foreach(new PrintJavaRdd());

        JavaRDD<CustomerInfo> partialRddCustomerInfoAddress = addressRdd.map(new AddressPartialMapping());

        //partialRddCustomerInfoAddress.foreach(new PrintJavaRdd());

        JavaRDD<CustomerInfo> partialRddCustomerInfoProduct = productRdd.map(new ProductPartialMapping());
        //partialRddCustomerInfoProduct.foreach(new PrintJavaRdd());

        JavaRDD<CustomerInfo> partialRddCustomerInfo = partialRddCustomerInfoUser
                                                            .union(partialRddCustomerInfoAddress)
                                                            .union(partialRddCustomerInfoProduct);
        partialRddCustomerInfo.foreach(new PrintJavaRdd());

        JavaPairRDD<Text, CustomerInfo> keyedPartialRddCustomerInfo = partialRddCustomerInfo
                                                                            .mapToPair(new ConvertToKeyValue());

        JavaPairRDD<Text, CustomerInfo> combinedPairRddCustomerInfo = keyedPartialRddCustomerInfo
                                                                        .combineByKey(new createCombiner(),
                                                                                        new mergeValue(),
                                                                                        new mergeCombiners());
        System.out.println("Before: ");
        combinedPairRddCustomerInfo.foreach(new PrintJavaPairRddText());

        JavaPairRDD<Text,CustomerInfo> fm = combinedPairRddCustomerInfo
                                                .flatMapToPair(new ExpandCustomersByProduct());

        System.out.println("After: ");
        fm.foreach(new PrintJavaPairRddText());

        combinedPairRddCustomerInfo = combinedPairRddCustomerInfo.union(fm);

        //combinedPairRddCustomerInfo.foreach(new PrintJavaPairRddText());

        String textOutputDir = "src/main/resources/textFile";
        String hadoopFileOutputDir = "src/main/resources/hadoopFile";
        String parquetStore = "src/main/resources/parquet";

        combinedPairRddCustomerInfo.saveAsTextFile(textOutputDir);

        combinedPairRddCustomerInfo.saveAsNewAPIHadoopFile(hadoopFileOutputDir,
                                                            Text.class,
                                                            CustomerInfo.class,
                                                            SequenceFileOutputFormat.class);


        JavaPairRDD<NullWritable, CustomerInfo> combinedFormattedNullAvroClass = combinedPairRddCustomerInfo.
                                                                            mapToPair(new ConvertToNullKeyValue());

        //Comment out if running without hdfs
        /*Job job = new Job();
        ParquetOutputFormat.setWriteSupportClass(job, AvroWriteSupport.class);
        AvroParquetOutputFormat.setSchema(job, CustomerInfo.SCHEMA$);
        ParquetOutputFormat<CustomerInfo> pOutput = new ParquetOutputFormat<CustomerInfo>();
        combinedFormattedNullAvroClass.saveAsNewAPIHadoopFile(parquetStore,
                                                            NullWritable.class,
                                                            CustomerInfo.class,
                                                            pOutput.getClass(),
                                                            job.getConfiguration());*/



    }
    static class createCombiner implements Function<CustomerInfo, CustomerInfo> {

        public CustomerInfo call(CustomerInfo customerInfo) throws Exception {
            //Create the new object to combine in
            CustomerInfo newCustomerInfo = new CustomerInfo().newBuilder(customerInfo).build();
            return newCustomerInfo;
        }
    }
    static class mergeValue implements Function2<CustomerInfo,CustomerInfo,CustomerInfo> {

        public CustomerInfo call(CustomerInfo customerInfo, CustomerInfo customerInfo2) throws Exception {

            return valueMerge(customerInfo,customerInfo2);
        }
    }
    static class mergeCombiners implements Function2<CustomerInfo,CustomerInfo,CustomerInfo>{

        public CustomerInfo call(CustomerInfo customerInfo, CustomerInfo customerInfo2) throws Exception {

            return valueMerge(customerInfo,customerInfo2);
        }
    }
    static class ConvertToKeyValue implements  PairFunction<CustomerInfo, Text, CustomerInfo>{

        public Tuple2<Text, CustomerInfo> call(CustomerInfo customerInfo) throws Exception {
            return new Tuple2<Text,CustomerInfo>(new Text(customerInfo.getId().toString()), customerInfo);
        }
    }

    static class ConvertToNullKeyValue implements  PairFunction<Tuple2<Text,CustomerInfo>,NullWritable, CustomerInfo>{

        public Tuple2<NullWritable, CustomerInfo> call(Tuple2<Text, CustomerInfo> stringCustomerInfoTuple2) throws Exception {
            return new Tuple2<NullWritable, CustomerInfo>(NullWritable.get(), stringCustomerInfoTuple2._2());
        }
    }

    static class UserPartialMapping implements Function<Row, CustomerInfo>{

        public CustomerInfo call(Row row) throws Exception {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(row.getAs("name_id").toString());
            Name name = new Name();
            name.setName(row.getAs("name").toString());
            name.setNickname(row.getAs("nickname").toString());
            customerInfo.setName(name);
            return customerInfo;
        }
    }

    static class AddressPartialMapping implements Function<Row, CustomerInfo>{

        public CustomerInfo call(Row row) throws Exception {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(row.getAs("name_id").toString());
            MailAddress mailAddress = new MailAddress();
            mailAddress.setCity(row.getAs("city").toString());
            List<MailAddress> mailAddresses = new ArrayList<MailAddress>();
            mailAddresses.add(mailAddress);
            customerInfo.setAddresses(mailAddresses);
            return customerInfo;
        }
    }

    static class ProductPartialMapping implements Function<Row, CustomerInfo>{

        public CustomerInfo call(Row row) throws Exception {

            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(row.getAs("name_id").toString());
            Product product = new Product();
            product.setProductDescription(row.getAs("product_description").toString());
            product.setPrice(row.getAs("price").toString());
            List<Product> products = new ArrayList<Product>();
            products.add(product);
            customerInfo.setProducts(products);

            return customerInfo;
        }
    }

    static class PrintJavaRdd implements VoidFunction<CustomerInfo>{

        public void call(CustomerInfo customerInfo) throws Exception {
            System.out.println("CustomerInfo: " + customerInfo.toString());
        }
    }

    static class PrintJavaPairRdd implements VoidFunction<Tuple2<String, CustomerInfo>>{

        public void call(Tuple2<String, CustomerInfo> tuple2) throws Exception {
            System.out.println("key: "   + tuple2._1().toString());
            System.out.println("value: " + tuple2._2().toString());
        }
    }

    static class ExpandCustomersByProduct implements PairFlatMapFunction<Tuple2<Text,CustomerInfo>, Text, CustomerInfo>{

        public Iterable<Tuple2<Text, CustomerInfo>> call(Tuple2<Text, CustomerInfo> tuple) throws Exception {


            List<Tuple2<Text, CustomerInfo>> expandedCustomers = new ArrayList<Tuple2<Text, CustomerInfo>>();

            CustomerInfo customerInfo = tuple._2();
            List<Product> products = customerInfo.getProducts();
            List<Product> uniqueProducts = new ArrayList<Product>();

            Product previous = new Product();
            for(Product current : products ){
                int equalityCheck = previous.compareTo(current);
                if (equalityCheck != 0){
                    uniqueProducts.add(current);
                }
                previous = previous.newBuilder(current).build();
            }

            for(Product product : uniqueProducts){
                expandedCustomers.add(
                        new Tuple2<Text,CustomerInfo>(
                                tuple._1(),
                                CustomerInfo.newBuilder(customerInfo)
                                        .setProductDescription(product.getProductDescription())
                                        .setPrice(product.getPrice()
                                        ).build()
                        )
                );
            }

            return expandedCustomers;

        }
    }


    static class PrintJavaPairRddText implements VoidFunction<Tuple2<Text, CustomerInfo>>{

        public void call(Tuple2<Text, CustomerInfo> tuple2) throws Exception {
            System.out.println("key: "   + tuple2._1().toString());
            System.out.println("value: " + tuple2._2().toString());
        }
    }

    public static CustomerInfo valueMerge(CustomerInfo customerInfo, CustomerInfo customerInfo2){
        //names
        Name name = new Name();

        if (customerInfo.getName() != null && customerInfo2.getName() == null){
            name = customerInfo.getName();
        }
        if (customerInfo.getName() == null && customerInfo2.getName() != null){
            name = customerInfo2.getName();
        }
        customerInfo.setName(name);

        //addresses
        List<MailAddress> addresses = new ArrayList<MailAddress>();
        if (customerInfo.getAddresses() != null && customerInfo2.getAddresses() == null){
            for(MailAddress address : customerInfo.getAddresses()){
                addresses.add(address);
            }
        }
        if (customerInfo.getAddresses() == null && customerInfo2.getAddresses() != null){
            for(MailAddress address : customerInfo2.getAddresses()){
                addresses.add(address);
            }
        }
        if (customerInfo.getAddresses() != null && customerInfo2.getAddresses() != null){
            for(MailAddress address : customerInfo.getAddresses()){
                addresses.add(address);
            }
            for(MailAddress address : customerInfo2.getAddresses()){
                addresses.add(address);
            }

        }

        customerInfo.setAddresses(addresses);

        //product
        List<Product> products = new ArrayList<Product>();
        if (customerInfo.getProducts() != null && customerInfo2.getProducts() == null){
            for(Product product : customerInfo.getProducts()){
                products.add(product);
            }
        }
        if (customerInfo.getProducts() == null && customerInfo2.getProducts() != null){
            for(Product product : customerInfo2.getProducts()){
                products.add(product);
            }
        }
        if (customerInfo.getProducts() != null & customerInfo2 != null){
            for(Product product : customerInfo.getProducts()){
                products.add(product);
            }
            for(Product product : customerInfo2.getProducts()){
                products.add(product);
            }

        }

        customerInfo.setProducts(products);
        return customerInfo;

    }





}
