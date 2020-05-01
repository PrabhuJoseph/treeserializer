package com.arrayserialize.java;

import com.arrayserialize.ArraySerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaArraySerializer implements ArraySerializer {

  public void serialize(int[] treeElements) throws IOException {
    try {
      File file = new File(FILE_PATH);
      if (!file.exists()) {
         file.createNewFile();
      }
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
      out.writeObject(treeElements);
      out.flush();
      out.close();
    } catch (IOException e) {
      System.err.println("Failed to serialize the array: " + e.getMessage());
      throw e;
    }
  }

  public int[] deserialize() throws IOException, ClassNotFoundException {
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH));
      int[] treeElements = (int[]) in.readObject();
      in.close();
      return treeElements;
     } catch (IOException e) {
       System.err.println("Failed to deserialize the array: " + e.getMessage());
       throw e;
     }
  }
}