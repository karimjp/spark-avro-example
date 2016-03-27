/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jana.karim.avro.model.source;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Address extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Address\",\"namespace\":\"com.jana.karim.avro.model.source\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"city\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence city;

  /**
   * Default constructor.
   */
  public Address() {}

  /**
   * All-args constructor.
   */
  public Address(java.lang.CharSequence id, java.lang.CharSequence city) {
    this.id = id;
    this.city = city;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return city;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: city = (java.lang.CharSequence)value$; break;
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

  /** Creates a new Address RecordBuilder */
  public static com.jana.karim.avro.model.source.Address.Builder newBuilder() {
    return new com.jana.karim.avro.model.source.Address.Builder();
  }
  
  /** Creates a new Address RecordBuilder by copying an existing Builder */
  public static com.jana.karim.avro.model.source.Address.Builder newBuilder(com.jana.karim.avro.model.source.Address.Builder other) {
    return new com.jana.karim.avro.model.source.Address.Builder(other);
  }
  
  /** Creates a new Address RecordBuilder by copying an existing Address instance */
  public static com.jana.karim.avro.model.source.Address.Builder newBuilder(com.jana.karim.avro.model.source.Address other) {
    return new com.jana.karim.avro.model.source.Address.Builder(other);
  }
  
  /**
   * RecordBuilder for Address instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Address>
    implements org.apache.avro.data.RecordBuilder<Address> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence city;

    /** Creates a new Builder */
    private Builder() {
      super(com.jana.karim.avro.model.source.Address.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.jana.karim.avro.model.source.Address.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing Address instance */
    private Builder(com.jana.karim.avro.model.source.Address other) {
            super(com.jana.karim.avro.model.source.Address.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.city)) {
        this.city = data().deepCopy(fields()[1].schema(), other.city);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.jana.karim.avro.model.source.Address.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.jana.karim.avro.model.source.Address.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'city' field */
    public java.lang.CharSequence getCity() {
      return city;
    }
    
    /** Sets the value of the 'city' field */
    public com.jana.karim.avro.model.source.Address.Builder setCity(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.city = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'city' field has been set */
    public boolean hasCity() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'city' field */
    public com.jana.karim.avro.model.source.Address.Builder clearCity() {
      city = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Address build() {
      try {
        Address record = new Address();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.city = fieldSetFlags()[1] ? this.city : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
