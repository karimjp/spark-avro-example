/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jana.karim.avro.model.destination;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MailAddress extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1199541131448944841L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MailAddress\",\"namespace\":\"com.jana.karim.avro.model.destination\",\"fields\":[{\"name\":\"city\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence city;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public MailAddress() {}

  /**
   * All-args constructor.
   */
  public MailAddress(java.lang.CharSequence city) {
    this.city = city;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return city;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: city = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'city' field.
   */
  public java.lang.CharSequence getCity() {
    return city;
  }

  /**
   * Sets the value of the 'city' field.
   * @param value the value to set.
   */
  public void setCity(java.lang.CharSequence value) {
    this.city = value;
  }

  /**
   * Creates a new MailAddress RecordBuilder.
   * @return A new MailAddress RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.MailAddress.Builder newBuilder() {
    return new com.jana.karim.avro.model.destination.MailAddress.Builder();
  }
  
  /**
   * Creates a new MailAddress RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MailAddress RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.MailAddress.Builder newBuilder(com.jana.karim.avro.model.destination.MailAddress.Builder other) {
    return new com.jana.karim.avro.model.destination.MailAddress.Builder(other);
  }
  
  /**
   * Creates a new MailAddress RecordBuilder by copying an existing MailAddress instance.
   * @param other The existing instance to copy.
   * @return A new MailAddress RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.MailAddress.Builder newBuilder(com.jana.karim.avro.model.destination.MailAddress other) {
    return new com.jana.karim.avro.model.destination.MailAddress.Builder(other);
  }
  
  /**
   * RecordBuilder for MailAddress instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MailAddress>
    implements org.apache.avro.data.RecordBuilder<MailAddress> {

    private java.lang.CharSequence city;

    /** Creates a new Builder */
    private Builder() {
      super(com.jana.karim.avro.model.destination.MailAddress.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.MailAddress.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing MailAddress instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.MailAddress other) {
            super(com.jana.karim.avro.model.destination.MailAddress.SCHEMA$);
      if (isValidValue(fields()[0], other.city)) {
        this.city = data().deepCopy(fields()[0].schema(), other.city);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'city' field.
      * @return The value.
      */
    public java.lang.CharSequence getCity() {
      return city;
    }

    /**
      * Sets the value of the 'city' field.
      * @param value The value of 'city'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.MailAddress.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.city = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'city' field has been set.
      * @return True if the 'city' field has been set, false otherwise.
      */
    public boolean hasCity() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'city' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.MailAddress.Builder clearCity() {
      city = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public MailAddress build() {
      try {
        MailAddress record = new MailAddress();
        record.city = fieldSetFlags()[0] ? this.city : (java.lang.CharSequence) defaultValue(fields()[0]);
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
