package com.arrayserialize;

import com.arrayserialize.kryo.KryoArraySerializer;
import com.arrayserialize.java.JavaArraySerializer;

public class ArraySerializerFactory {
  private static volatile ArraySerializer arraySerializer = null;

  public static ArraySerializer getInstance(String name) {
    System.out.println("Array is Serialized using: " + name);
    if (arraySerializer == null) {
      synchronized (ArraySerializerFactory.class) {
       if (arraySerializer == null) {
         if (name.equals("java")) {
           arraySerializer = new JavaArraySerializer();
         } else if (name.equals("kryo")) {
           arraySerializer = new KryoArraySerializer();
         } else {
           // Default is KryoArraySerializer
           return new KryoArraySerializer();
         }
       }
      }
    }
    return arraySerializer;
  }
}
