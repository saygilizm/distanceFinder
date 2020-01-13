package com.sametsaygili;

import java.io.IOException;
import java.util.Collections;
import org.junit.Test;

public class FileOperationsTest {

  private FileOperations fileOperations = new FileOperations();


  @Test(expected = NullPointerException.class)
  public void fileReaderFail() throws IOException {

    fileOperations.fileReader(null);
  }


  @Test(expected = NullPointerException.class)
  public void fileWriterFail() throws IOException {

    fileOperations.fileWriter(Collections.emptyList(), null);
  }
}