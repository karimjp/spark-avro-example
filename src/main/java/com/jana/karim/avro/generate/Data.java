package com.jana.karim.avro.generate;

/**
 * Created by karim on 3/27/16.
 */

import com.jana.karim.avro.model.source.Address;
import com.jana.karim.avro.model.source.Product;
import com.jana.karim.avro.model.source.User;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;

public class Data {
    public static void avroGenerate() throws IOException {
        String dataPath = System.getProperty("user.dir").toString()
                + "/src/main/avro/data/";

        User user1 = new User();
        user1.setNameId("1");
        user1.setName("User1");
        user1.setNickname("user1_nickname");
        User user2 = new User();
        user2.setNameId("2");
        user2.setName("User2");
        user2.setNickname("user2_nickname");
        User user3 = new User();
        user3.setNameId("3");
        user3.setName("User3");
        user3.setNickname("user3_nickname");

        Address address1 = new Address();
        address1.setAddressId("1");
        address1.setCity("City1");
        address1.setNameId("1");
        Address address2 = new Address();
        address2.setAddressId("2");
        address2.setCity("City2");
        address2.setNameId("2");
        Address address3 = new Address();
        address3.setAddressId("3");
        address3.setCity("City3");
        address3.setNameId("3");
        Address address4 = new Address();
        address4.setAddressId("4");
        address4.setCity("City4");
        address4.setNameId("3");

        Product product1 = new Product();
        product1.setProductId("1");
        product1.setNameId("1");
        product1.setProductDescription("Product1");
        product1.setPrice("1.00");

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setNameId("1");
        product2.setProductDescription("Product2");
        product2.setPrice("2.00");

        Product product3 = new Product();
        product3.setProductId("3");
        product3.setNameId("1");
        product3.setProductDescription("Product3");
        product3.setPrice("3.00");

        Product product4 = new Product();
        product4.setProductId("4");
        product4.setNameId("1");
        product4.setProductDescription("Product3");
        product4.setPrice("3.00");



        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> userDataFileWriter = new DataFileWriter<User>(userDatumWriter);
        userDataFileWriter.create(user1.getSchema(), new File(dataPath + "users.avro"));
        userDataFileWriter.append(user1);
        userDataFileWriter.append(user2);
        userDataFileWriter.append(user3);
        userDataFileWriter.close();

        DatumWriter<Address> addressDatumWriter = new SpecificDatumWriter<Address>(Address.class);
        DataFileWriter<Address> addressDataFileWriter = new DataFileWriter<Address>(addressDatumWriter);
        addressDataFileWriter.create(address1.getSchema(), new File(dataPath + "addresses.avro"));
        addressDataFileWriter.append(address1);
        addressDataFileWriter.append(address2);
        addressDataFileWriter.append(address3);
        addressDataFileWriter.append(address4);
        addressDataFileWriter.close();

        DatumWriter<Product> productDatumWriter = new SpecificDatumWriter<Product>(Product.class);
        DataFileWriter<Product> productDataFileWriter = new DataFileWriter<Product>(productDatumWriter);
        productDataFileWriter.create(product1.getSchema(), new File(dataPath + "product.avro"));
        productDataFileWriter.append(product1);
        productDataFileWriter.append(product2);
        productDataFileWriter.append(product3);
        productDataFileWriter.append(product4);
        productDataFileWriter.close();
    }
}
