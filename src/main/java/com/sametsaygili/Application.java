package com.sametsaygili;

public class Application {

  private static final String TARGET_FILE = "output.txt";

  public static void main(String[] args) {

    CustomerFinder distanceCalculator;

    try {

      String inputFile = args[0];
      distanceCalculator = new CustomerFinder(new FileOperations(),
          new FirstFormulaDistanceCalculator(), inputFile, TARGET_FILE);
      distanceCalculator.findCustomers();
      System.out.println("Result: Successful! Please find the output file named as \"" + TARGET_FILE
          + "\" in the following path: \"" + System.getProperty("user.dir") + "\"");

    } catch (Exception e) {

      System.err.println(
          "Result: Failure! Please contact to the team who is responsible for maintenance.");

    }
  }

}
