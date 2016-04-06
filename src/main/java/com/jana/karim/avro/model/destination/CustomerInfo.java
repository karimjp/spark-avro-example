/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jana.karim.avro.model.destination;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CustomerInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5025295813733539880L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CustomerInfo\",\"namespace\":\"com.jana.karim.avro.model.destination\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"name\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Name\",\"fields\":[{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"nickname\",\"type\":[\"null\",\"string\"],\"default\":null}]}],\"default\":null},{\"name\":\"addresses\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"MailAddress\",\"fields\":[{\"name\":\"city\",\"type\":[\"null\",\"string\"],\"default\":null}]}}],\"default\":null},{\"name\":\"product_description\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"price\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"products\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Product\",\"fields\":[{\"name\":\"product_description\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"price\",\"type\":[\"null\",\"string\"],\"default\":null}]}}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public com.jana.karim.avro.model.destination.Name name;
  @Deprecated public java.util.List<com.jana.karim.avro.model.destination.MailAddress> addresses;
  @Deprecated public java.lang.CharSequence product_description;
  @Deprecated public java.lang.CharSequence price;
  @Deprecated public java.util.List<com.jana.karim.avro.model.destination.Product> products;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public CustomerInfo() {}

  /**
   * All-args constructor.
   */
  public CustomerInfo(java.lang.CharSequence id, com.jana.karim.avro.model.destination.Name name, java.util.List<com.jana.karim.avro.model.destination.MailAddress> addresses, java.lang.CharSequence product_description, java.lang.CharSequence price, java.util.List<com.jana.karim.avro.model.destination.Product> products) {
    this.id = id;
    this.name = name;
    this.addresses = addresses;
    this.product_description = product_description;
    this.price = price;
    this.products = products;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return addresses;
    case 3: return product_description;
    case 4: return price;
    case 5: return products;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (com.jana.karim.avro.model.destination.Name)value$; break;
    case 2: addresses = (java.util.List<com.jana.karim.avro.model.destination.MailAddress>)value$; break;
    case 3: product_description = (java.lang.CharSequence)value$; break;
    case 4: price = (java.lang.CharSequence)value$; break;
    case 5: products = (java.util.List<com.jana.karim.avro.model.destination.Product>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   */
  public com.jana.karim.avro.model.destination.Name getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(com.jana.karim.avro.model.destination.Name value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'addresses' field.
   */
  public java.util.List<com.jana.karim.avro.model.destination.MailAddress> getAddresses() {
    return addresses;
  }

  /**
   * Sets the value of the 'addresses' field.
   * @param value the value to set.
   */
  public void setAddresses(java.util.List<com.jana.karim.avro.model.destination.MailAddress> value) {
    this.addresses = value;
  }

  /**
   * Gets the value of the 'product_description' field.
   */
  public java.lang.CharSequence getProductDescription() {
    return product_description;
  }

  /**
   * Sets the value of the 'product_description' field.
   * @param value the value to set.
   */
  public void setProductDescription(java.lang.CharSequence value) {
    this.product_description = value;
  }

  /**
   * Gets the value of the 'price' field.
   */
  public java.lang.CharSequence getPrice() {
    return price;
  }

  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.CharSequence value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'products' field.
   */
  public java.util.List<com.jana.karim.avro.model.destination.Product> getProducts() {
    return products;
  }

  /**
   * Sets the value of the 'products' field.
   * @param value the value to set.
   */
  public void setProducts(java.util.List<com.jana.karim.avro.model.destination.Product> value) {
    this.products = value;
  }

  /**
   * Creates a new CustomerInfo RecordBuilder.
   * @return A new CustomerInfo RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.CustomerInfo.Builder newBuilder() {
    return new com.jana.karim.avro.model.destination.CustomerInfo.Builder();
  }
  
  /**
   * Creates a new CustomerInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CustomerInfo RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.CustomerInfo.Builder newBuilder(com.jana.karim.avro.model.destination.CustomerInfo.Builder other) {
    return new com.jana.karim.avro.model.destination.CustomerInfo.Builder(other);
  }
  
  /**
   * Creates a new CustomerInfo RecordBuilder by copying an existing CustomerInfo instance.
   * @param other The existing instance to copy.
   * @return A new CustomerInfo RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.CustomerInfo.Builder newBuilder(com.jana.karim.avro.model.destination.CustomerInfo other) {
    return new com.jana.karim.avro.model.destination.CustomerInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for CustomerInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CustomerInfo>
    implements org.apache.avro.data.RecordBuilder<CustomerInfo> {

    private java.lang.CharSequence id;
    private com.jana.karim.avro.model.destination.Name name;
    private com.jana.karim.avro.model.destination.Name.Builder nameBuilder;
    private java.util.List<com.jana.karim.avro.model.destination.MailAddress> addresses;
    private java.lang.CharSequence product_description;
    private java.lang.CharSequence price;
    private java.util.List<com.jana.karim.avro.model.destination.Product> products;

    /** Creates a new Builder */
    private Builder() {
      super(com.jana.karim.avro.model.destination.CustomerInfo.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.CustomerInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (other.hasNameBuilder()) {
        this.nameBuilder = com.jana.karim.avro.model.destination.Name.newBuilder(other.getNameBuilder());
      }
      if (isValidValue(fields()[2], other.addresses)) {
        this.addresses = data().deepCopy(fields()[2].schema(), other.addresses);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.product_description)) {
        this.product_description = data().deepCopy(fields()[3].schema(), other.product_description);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.products)) {
        this.products = data().deepCopy(fields()[5].schema(), other.products);
        fieldSetFlags()[5] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing CustomerInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.CustomerInfo other) {
            super(com.jana.karim.avro.model.destination.CustomerInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      this.nameBuilder = null;
      if (isValidValue(fields()[2], other.addresses)) {
        this.addresses = data().deepCopy(fields()[2].schema(), other.addresses);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.product_description)) {
        this.product_description = data().deepCopy(fields()[3].schema(), other.product_description);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.products)) {
        this.products = data().deepCopy(fields()[5].schema(), other.products);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public com.jana.karim.avro.model.destination.Name getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setName(com.jana.karim.avro.model.destination.Name value) {
      validate(fields()[1], value);
      this.nameBuilder = null;
      this.name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'name' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.jana.karim.avro.model.destination.Name.Builder getNameBuilder() {
      if (nameBuilder == null) {
        if (hasName()) {
          setNameBuilder(com.jana.karim.avro.model.destination.Name.newBuilder(name));
        } else {
          setNameBuilder(com.jana.karim.avro.model.destination.Name.newBuilder());
        }
      }
      return nameBuilder;
    }

    /**
     * Sets the Builder instance for the 'name' field
     * @return This builder.
     */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setNameBuilder(com.jana.karim.avro.model.destination.Name.Builder value) {
      clearName();
      nameBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'name' field has an active Builder instance
     * @return True if the 'name' field has an active Builder instance
     */
    public boolean hasNameBuilder() {
      return nameBuilder != null;
    }

    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearName() {
      name = null;
      nameBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'addresses' field.
      * @return The value.
      */
    public java.util.List<com.jana.karim.avro.model.destination.MailAddress> getAddresses() {
      return addresses;
    }

    /**
      * Sets the value of the 'addresses' field.
      * @param value The value of 'addresses'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setAddresses(java.util.List<com.jana.karim.avro.model.destination.MailAddress> value) {
      validate(fields()[2], value);
      this.addresses = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'addresses' field has been set.
      * @return True if the 'addresses' field has been set, false otherwise.
      */
    public boolean hasAddresses() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'addresses' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearAddresses() {
      addresses = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'product_description' field.
      * @return The value.
      */
    public java.lang.CharSequence getProductDescription() {
      return product_description;
    }

    /**
      * Sets the value of the 'product_description' field.
      * @param value The value of 'product_description'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setProductDescription(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.product_description = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'product_description' field has been set.
      * @return True if the 'product_description' field has been set, false otherwise.
      */
    public boolean hasProductDescription() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'product_description' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearProductDescription() {
      product_description = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.CharSequence getPrice() {
      return price;
    }

    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setPrice(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.price = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearPrice() {
      price = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'products' field.
      * @return The value.
      */
    public java.util.List<com.jana.karim.avro.model.destination.Product> getProducts() {
      return products;
    }

    /**
      * Sets the value of the 'products' field.
      * @param value The value of 'products'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder setProducts(java.util.List<com.jana.karim.avro.model.destination.Product> value) {
      validate(fields()[5], value);
      this.products = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'products' field has been set.
      * @return True if the 'products' field has been set, false otherwise.
      */
    public boolean hasProducts() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'products' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.CustomerInfo.Builder clearProducts() {
      products = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public CustomerInfo build() {
      try {
        CustomerInfo record = new CustomerInfo();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        if (nameBuilder != null) {
          record.name = this.nameBuilder.build();
        } else {
          record.name = fieldSetFlags()[1] ? this.name : (com.jana.karim.avro.model.destination.Name) defaultValue(fields()[1]);
        }
        record.addresses = fieldSetFlags()[2] ? this.addresses : (java.util.List<com.jana.karim.avro.model.destination.MailAddress>) defaultValue(fields()[2]);
        record.product_description = fieldSetFlags()[3] ? this.product_description : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.price = fieldSetFlags()[4] ? this.price : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.products = fieldSetFlags()[5] ? this.products : (java.util.List<com.jana.karim.avro.model.destination.Product>) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);  

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);  

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in));
  }

}
