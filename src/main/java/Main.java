/**
 * Created by karim on 3/27/16.
 */

import com.jana.karim.avro.generate.Data;
import com.jana.karim.avro.model.source.Address;
import com.jana.karim.avro.model.source.User;
import com.jana.karim.avro.model.destination.CustomerInfo;
import com.jana.karim.avro.model.destination.Name;
import com.jana.karim.avro.model.destination.MailAddress;

import org.apache.avro.Schema;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import scala.Tuple2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) throws IOException {
        //Class[] subscribers = {User.class, Address.class};
        //List<Schema> avroSchemas = new ArrayList<Schema>();
        //avroSchemas.add(User.getClassSchema());
        //avroSchemas.add(Address.getClassSchema());
        String databricks = "com.databricks.spark.avro";
        Data.avroGenerate();

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Avro-Spark Job App");
        conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        //conf.registerKryoClasses(subscribers);
        //conf.registerAvroSchemas(JavaConversions.asScalaBuffer(avroSchemas));

        JavaSparkContext sc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(sc);

       DataFrame userDf = sqlContext.read().format("com.databricks.spark.avro")
                .load("src/main/avro/data/users.avro");
        DataFrame addressDf = sqlContext.read().format("com.databricks.spark.avro")
                .load("src/main/avro/data/addresses.avro");

        userDf.show();
        addressDf.show();

        JavaRDD<Row> userRdd = userDf.toJavaRDD();
        JavaRDD<Row> addressRdd = addressDf.toJavaRDD();

        JavaPairRDD<String, CustomerInfo> partialCustomerInfoUser = userRdd.mapToPair(new UserPartialMapping());

        partialCustomerInfoUser.foreach(new PrintJavaPairRdd());

        JavaPairRDD<String, CustomerInfo> partialCustomerInfoAddress = addressRdd.mapToPair(new AddressPartialMapping());

        partialCustomerInfoAddress.foreach(new PrintJavaPairRdd());

    }
    static class UserPartialMapping implements PairFunction <Row, String, CustomerInfo> {

        @Override
        public Tuple2<String, CustomerInfo> call(Row row) throws Exception {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(row.getAs("name_id"));
            Name name = new Name();
            name.setName(row.getAs("name"));
            name.setNickname(row.getAs("nickname"));
            customerInfo.setName(name);


            return new Tuple2<String, CustomerInfo>(customerInfo.getId().toString(), customerInfo);

        }
    }

    static class AddressPartialMapping implements PairFunction <Row, String, CustomerInfo> {

        @Override
        public Tuple2<String, CustomerInfo> call(Row row) throws Exception {
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(row.getAs("name_id"));
            MailAddress mailAddress = new MailAddress();
            mailAddress.setCity(row.getAs("city"));
            List<MailAddress> mailAddresses = new ArrayList<MailAddress>();
            mailAddresses.add(mailAddress);
            customerInfo.setAddresses(mailAddresses);

            return new Tuple2<String, CustomerInfo>(customerInfo.getId().toString(), customerInfo);

        }
    }

    static class PrintJavaPairRdd implements VoidFunction<Tuple2<String, CustomerInfo>>{

        @Override
        public void call(Tuple2<String, CustomerInfo> tuple2) throws Exception {
            System.out.println("key: "   + tuple2._1().toString());
            System.out.println("value: " + tuple2._2().toString());
        }
    }





}
