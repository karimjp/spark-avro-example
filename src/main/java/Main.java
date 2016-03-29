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
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

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



    }
}