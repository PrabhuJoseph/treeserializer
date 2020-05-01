package com.arrayserialize;

import java.io.IOException;

public interface ArraySerializer {

  String FILE_PATH = "/tmp/file.dat";

  void serialize(int[] treeElements) throws IOException;

  int[] deserialize() throws Exception;
}
