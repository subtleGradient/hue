/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.beeswax.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import org.apache.log4j.Logger;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class BeeswaxException extends Exception implements TBase, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("BeeswaxException");
  private static final TField MESSAGE_FIELD_DESC = new TField("message", TType.STRING, (short)1);
  private static final TField LOG_CONTEXT_FIELD_DESC = new TField("log_context", TType.STRING, (short)2);
  private static final TField HANDLE_FIELD_DESC = new TField("handle", TType.STRUCT, (short)3);

  public String message;
  public static final int MESSAGE = 1;
  public String log_context;
  public static final int LOG_CONTEXT = 2;
  public QueryHandle handle;
  public static final int HANDLE = 3;

  private final Isset __isset = new Isset();
  private static final class Isset implements java.io.Serializable {
  }

  public static final Map<Integer, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new HashMap<Integer, FieldMetaData>() {{
    put(MESSAGE, new FieldMetaData("message", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(LOG_CONTEXT, new FieldMetaData("log_context", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(HANDLE, new FieldMetaData("handle", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, QueryHandle.class)));
  }});

  static {
    FieldMetaData.addStructMetaDataMap(BeeswaxException.class, metaDataMap);
  }

  public BeeswaxException() {
  }

  public BeeswaxException(
    String message,
    String log_context,
    QueryHandle handle)
  {
    this();
    this.message = message;
    this.log_context = log_context;
    this.handle = handle;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BeeswaxException(BeeswaxException other) {
    if (other.isSetMessage()) {
      this.message = other.message;
    }
    if (other.isSetLog_context()) {
      this.log_context = other.log_context;
    }
    if (other.isSetHandle()) {
      this.handle = new QueryHandle(other.handle);
    }
  }

  @Override
  public BeeswaxException clone() {
    return new BeeswaxException(this);
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void unsetMessage() {
    this.message = null;
  }

  // Returns true if field message is set (has been asigned a value) and false otherwise
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  public String getLog_context() {
    return this.log_context;
  }

  public void setLog_context(String log_context) {
    this.log_context = log_context;
  }

  public void unsetLog_context() {
    this.log_context = null;
  }

  // Returns true if field log_context is set (has been asigned a value) and false otherwise
  public boolean isSetLog_context() {
    return this.log_context != null;
  }

  public void setLog_contextIsSet(boolean value) {
    if (!value) {
      this.log_context = null;
    }
  }

  public QueryHandle getHandle() {
    return this.handle;
  }

  public void setHandle(QueryHandle handle) {
    this.handle = handle;
  }

  public void unsetHandle() {
    this.handle = null;
  }

  // Returns true if field handle is set (has been asigned a value) and false otherwise
  public boolean isSetHandle() {
    return this.handle != null;
  }

  public void setHandleIsSet(boolean value) {
    if (!value) {
      this.handle = null;
    }
  }

  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((String)value);
      }
      break;

    case LOG_CONTEXT:
      if (value == null) {
        unsetLog_context();
      } else {
        setLog_context((String)value);
      }
      break;

    case HANDLE:
      if (value == null) {
        unsetHandle();
      } else {
        setHandle((QueryHandle)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case MESSAGE:
      return getMessage();

    case LOG_CONTEXT:
      return getLog_context();

    case HANDLE:
      return getHandle();

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case MESSAGE:
      return isSetMessage();
    case LOG_CONTEXT:
      return isSetLog_context();
    case HANDLE:
      return isSetHandle();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BeeswaxException)
      return this.equals((BeeswaxException)that);
    return false;
  }

  public boolean equals(BeeswaxException that) {
    if (that == null)
      return false;

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    boolean this_present_log_context = true && this.isSetLog_context();
    boolean that_present_log_context = true && that.isSetLog_context();
    if (this_present_log_context || that_present_log_context) {
      if (!(this_present_log_context && that_present_log_context))
        return false;
      if (!this.log_context.equals(that.log_context))
        return false;
    }

    boolean this_present_handle = true && this.isSetHandle();
    boolean that_present_handle = true && that.isSetHandle();
    if (this_present_handle || that_present_handle) {
      if (!(this_present_handle && that_present_handle))
        return false;
      if (!this.handle.equals(that.handle))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_message = true && (isSetMessage());
    builder.append(present_message);
    if (present_message)
      builder.append(message);

    boolean present_log_context = true && (isSetLog_context());
    builder.append(present_log_context);
    if (present_log_context)
      builder.append(log_context);

    boolean present_handle = true && (isSetHandle());
    builder.append(present_handle);
    if (present_handle)
      builder.append(handle);

    return builder.toHashCode();
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id)
      {
        case MESSAGE:
          if (field.type == TType.STRING) {
            this.message = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case LOG_CONTEXT:
          if (field.type == TType.STRING) {
            this.log_context = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case HANDLE:
          if (field.type == TType.STRUCT) {
            this.handle = new QueryHandle();
            this.handle.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();


    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.message != null) {
      oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
      oprot.writeString(this.message);
      oprot.writeFieldEnd();
    }
    if (this.log_context != null) {
      oprot.writeFieldBegin(LOG_CONTEXT_FIELD_DESC);
      oprot.writeString(this.log_context);
      oprot.writeFieldEnd();
    }
    if (this.handle != null) {
      oprot.writeFieldBegin(HANDLE_FIELD_DESC);
      this.handle.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BeeswaxException(");
    boolean first = true;

    sb.append("message:");
    if (this.message == null) {
      sb.append("null");
    } else {
      sb.append(this.message);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("log_context:");
    if (this.log_context == null) {
      sb.append("null");
    } else {
      sb.append(this.log_context);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("handle:");
    if (this.handle == null) {
      sb.append("null");
    } else {
      sb.append(this.handle);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
  }

}

