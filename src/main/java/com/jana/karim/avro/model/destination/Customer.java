/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jana.karim.avro.model.destination;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public interface Customer {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Customer\",\"namespace\":\"com.jana.karim.avro.model.destination\",\"types\":[{\"type\":\"record\",\"name\":\"Name\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"nickname\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"MailAddress\",\"fields\":[{\"name\":\"city\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]},{\"type\":\"record\",\"name\":\"CustomerInfo\",\"fields\":[{\"name\":\"name\",\"type\":\"Name\"},{\"name\":\"address\",\"type\":\"MailAddress\"}]}],\"messages\":{}}");

  @SuppressWarnings("all")
  public interface Callback extends Customer {
    public static final org.apache.avro.Protocol PROTOCOL = com.jana.karim.avro.model.destination.Customer.PROTOCOL;
  }
}