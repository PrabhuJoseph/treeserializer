package com.arrayserialize.kryo;

import com.arrayserialize.ArraySerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.Input;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
Kryo is a fast and efficient binary object graph serialization framework for Java.
Kryo is used by various Apache Projects like Spark, Hive.
https://github.com/EsotericSoftware/kryo
 */
public class KryoArraySerializer implements ArraySerializer {

  private Kryo kryo;

  public KryoArraySerializer() {
    kryo = new Kryo();
   // kryo.register(int[].class);
  }

  public void serialize(int[] treeElements) throws IOException {
    try {
      File file = new File(FILE_PATH);
      if (!file.exists()) {
        file.createNewFile();
      }
      Output output = new Output(new FileOutputStream(FILE_PATH));
      kryo.writeObject(output, treeElements);
      output.close();
    } catch (IOException e) {
      System.err.println("Failed to serialize the array: " + e.getMessage());
      throw e;
    }
  }

  public int[] deserialize() throws IOException {
    try {
      Input input = new Input(new FileInputStream(FILE_PATH));
      int[] treeElements = kryo.readObject(input, int[].class);
      return treeElements;
    } catch (IOException e) {
      System.err.println("Failed to deserialize the array: " + e.getMessage());
      throw e;
    }
  }
}
