package com.sametsaygili;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONException;

public class CustomerFinder {

  private static final Location LOCATION_DUBLIN_OFFICE = new Location(53.339428, -6.257664);

  private static final Double MAX_DISTANCE = 100D;

  private FileOperations fileOperations;

  private DistanceCalculator distanceCalculator;

  private String inputFile;

  private String outputFile;

  public CustomerFinder(FileOperations fileOperations, DistanceCalculator distanceCalculator, String inputFile, String outputFile) {

    this.fileOperations = fileOperations;
    this.distanceCalculator = distanceCalculator;
    this.inputFile = inputFile;
    this.outputFile = outputFile;
  }

  public void findCustomers() throws IOException, JSONException, ClassCastException, NullPointerException{

    List<Customer> customerList = fileOperations.fileReader(inputFile);

    customerList = customerList.stream()
        .filter(item -> distanceCalculator.calculate(LOCATION_DUBLIN_OFFICE, item.getLocation()) <= MAX_DISTANCE)
        .sorted().collect(Collectors.toList());

    fileOperations.fileWriter(customerList, outputFile);
  }

}
