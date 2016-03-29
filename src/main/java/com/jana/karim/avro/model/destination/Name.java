/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jana.karim.avro.model.destination;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Name extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5846141053056375004L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Name\",\"namespace\":\"com.jana.karim.avro.model.destination\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"nickname\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.CharSequence nickname;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Name() {}

  /**
   * All-args constructor.
   */
  public Name(java.lang.CharSequence id, java.lang.CharSequence name, java.lang.CharSequence nickname) {
    this.id = id;
    this.name = name;
    this.nickname = nickname;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return nickname;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: nickname = (java.lang.CharSequence)value$; break;
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
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'nickname' field.
   */
  public java.lang.CharSequence getNickname() {
    return nickname;
  }

  /**
   * Sets the value of the 'nickname' field.
   * @param value the value to set.
   */
  public void setNickname(java.lang.CharSequence value) {
    this.nickname = value;
  }

  /**
   * Creates a new Name RecordBuilder.
   * @return A new Name RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.Name.Builder newBuilder() {
    return new com.jana.karim.avro.model.destination.Name.Builder();
  }
  
  /**
   * Creates a new Name RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Name RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.Name.Builder newBuilder(com.jana.karim.avro.model.destination.Name.Builder other) {
    return new com.jana.karim.avro.model.destination.Name.Builder(other);
  }
  
  /**
   * Creates a new Name RecordBuilder by copying an existing Name instance.
   * @param other The existing instance to copy.
   * @return A new Name RecordBuilder
   */
  public static com.jana.karim.avro.model.destination.Name.Builder newBuilder(com.jana.karim.avro.model.destination.Name other) {
    return new com.jana.karim.avro.model.destination.Name.Builder(other);
  }
  
  /**
   * RecordBuilder for Name instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Name>
    implements org.apache.avro.data.RecordBuilder<Name> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private java.lang.CharSequence nickname;

    /** Creates a new Builder */
    private Builder() {
      super(com.jana.karim.avro.model.destination.Name.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.Name.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.nickname)) {
        this.nickname = data().deepCopy(fields()[2].schema(), other.nickname);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing Name instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jana.karim.avro.model.destination.Name other) {
            super(com.jana.karim.avro.model.destination.Name.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.nickname)) {
        this.nickname = data().deepCopy(fields()[2].schema(), other.nickname);
        fieldSetFlags()[2] = true;
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
    public com.jana.karim.avro.model.destination.Name.Builder setId(java.lang.CharSequence value) {
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
    public com.jana.karim.avro.model.destination.Name.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.Name.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
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
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.Name.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'nickname' field.
      * @return The value.
      */
    public java.lang.CharSequence getNickname() {
      return nickname;
    }

    /**
      * Sets the value of the 'nickname' field.
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.Name.Builder setNickname(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.nickname = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'nickname' field.
      * @return This builder.
      */
    public com.jana.karim.avro.model.destination.Name.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Name build() {
      try {
        Name record = new Name();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.nickname = fieldSetFlags()[2] ? this.nickname : (java.lang.CharSequence) defaultValue(fields()[2]);
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
