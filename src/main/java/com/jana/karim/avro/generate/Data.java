package com.jana.karim.avro.generate;

/**
 * Created by karim on 3/27/16.
 */

import com.jana.karim.avro.model.source.User;
import com.jana.karim.avro.model.source.Address;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static void avroGenerate() throws IOException {
        String dataPath = System.getProperty("user.dir").toString()
                + "/src/main/avro/data/";

        User user1 = new User();
        user1.setId("1");
        user1.setName("User1");
        user1.setNickname("user1_nickname");
        User user2 = new User();
        user2.setId("2");
        user2.setName("User2");
        user2.setNickname("user2_nickname");
        User user3 = new User();
        user3.setId("3");
        user3.setName("User3");
        user3.setNickname("user3_nickname");

        Address address1 = new Address();
        address1.setId("1");
        address1.setCity("City1");
        address1.setNameId("1");
        Address address2 = new Address();
        address2.setId("2");
        address2.setCity("City2");
        address2.setNameId("2");
        Address address3 = new Address();
        address3.setId("3");
        address3.setCity("City3");
        address3.setNameId("3");
        Address address4 = new Address();
        address4.setId("4");
        address4.setCity("City4");
        address4.setNameId("3");

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> userDataFileWriter = new DataFileWriter<User>(userDatumWriter);
        userDataFileWriter.create(user1.getSchema(), new File(dataPath + "users.avro"));
        userDataFileWriter.append(user1);
        userDataFileWriter.append(user2);
        userDataFileWriter.append(user3);
        userDataFileWriter.close();

        DatumWriter<User> addressDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> addressDataFileWriter = new DataFileWriter<User>(addressDatumWriter);
        addressDataFileWriter.create(user1.getSchema(), new File(dataPath + "addresses.avro"));
        addressDataFileWriter.append(user1);
        addressDataFileWriter.append(user2);
        addressDataFileWriter.append(user3);
        addressDataFileWriter.close();
    }
}
