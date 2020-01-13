package com.sametsaygili;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private static final PrintStream ORIGINAL_ERR = System.err;

  @Before
  public void setUpStreams() {

    System.setErr(new PrintStream(errContent));

  }

  @After
  public void restoreStreams() {

    System.setErr(ORIGINAL_ERR);

  }

  @Test
  public void testMainWithNullArgument() {
      Application.main(null);
      System.setIn(System.in);
      assertTrue(errContent.toString().length() > 0);
  }
}