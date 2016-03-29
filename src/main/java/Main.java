/**
 * Created by karim on 3/27/16.
 */

import com.jana.karim.avro.generate.Data;
import com.jana.karim.avro.model.destination.CustomerInfo;
import com.jana.karim.avro.model.destination.Name;
import com.jana.karim.avro.model.destination.MailAddress;



import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import scala.Tuple2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jana.karim.kryo.KryoAvroClassRegistration;


public class Main {

    public static void main(String[] args) throws IOException {
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

        userDf.show();
        addressDf.show();

        JavaRDD<Row> userRdd = userDf.toJavaRDD();
        JavaRDD<Row> addressRdd = addressDf.toJavaRDD();


        JavaRDD<CustomerInfo> partialRddCustomerInfoUser= userRdd.map(new UserPartialMapping());

        partialRddCustomerInfoUser.foreach(new PrintJavaRdd());

        JavaRDD<CustomerInfo> partialRddCustomerInfoAddress = addressRdd.map(new AddressPartialMapping());

        partialRddCustomerInfoAddress.foreach(new PrintJavaRdd());

        JavaRDD<CustomerInfo> partialRddCustomerInfo = partialRddCustomerInfoUser
                                                            .union(partialRddCustomerInfoAddress);

        JavaPairRDD<String, CustomerInfo> keyedPartialRddCustomerInfo = partialRddCustomerInfo
                                                                            .mapToPair(new ConvertToKeyValue());

        JavaPairRDD<String, CustomerInfo> combinedPairRddCustomerInfo = keyedPartialRddCustomerInfo
                                                                        .combineByKey(new createCombiner(),
                                                                                        new mergeValue(),
                                                                                        new mergeCombiners());
        combinedPairRddCustomerInfo.foreach(new PrintJavaPairRdd());

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
            if (customerInfo.getAddresses() != null & customerInfo2 != null){
                for(MailAddress address : customerInfo.getAddresses()){
                    addresses.add(address);
                }
                for(MailAddress address : customerInfo2.getAddresses()){
                    addresses.add(address);
                }

            }

            customerInfo.setAddresses(addresses);

            return customerInfo;
        }
    }
    static class mergeCombiners implements Function2<CustomerInfo,CustomerInfo,CustomerInfo>{

        public CustomerInfo call(CustomerInfo customerInfo, CustomerInfo customerInfo2) throws Exception {
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
            if (customerInfo.getAddresses() != null & customerInfo2 != null){
                for(MailAddress address : customerInfo.getAddresses()){
                    addresses.add(address);
                }
                for(MailAddress address : customerInfo2.getAddresses()){
                    addresses.add(address);
                }

            }

            customerInfo.setAddresses(addresses);
            return customerInfo;
        }
    }
    static class ConvertToKeyValue implements  PairFunction<CustomerInfo, String, CustomerInfo>{

        public Tuple2<String, CustomerInfo> call(CustomerInfo customerInfo) throws Exception {
            return new Tuple2<String,CustomerInfo>(customerInfo.getId().toString(), customerInfo);
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





}
