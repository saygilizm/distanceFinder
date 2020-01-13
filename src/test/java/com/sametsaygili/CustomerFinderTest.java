package com.sametsaygili;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerFinderTest {


  private final JSONObject customer1 = new JSONObject(
      "{\"latitude\": \"59.3260668\", \"user_id\": 1, \"name\": \"Samet Saygili\", \"longitude\": \"17.8419707\"}");
  private final JSONObject customer2 = new JSONObject(
      "{\"latitude\": \"53.339528\", \"user_id\": 2, \"name\": \"Joey Tribbiani\", \"longitude\": \"-6.256665\"}");
  private final JSONObject customer3 = new JSONObject(
      "{\"latitude\": \"53.349427\", \"user_id\": 3, \"name\": \"Phoebe Buffay\", \"longitude\": \"-6.257664\"}");
  @Mock
  private FileOperations fileOperations;
  @InjectMocks
  private CustomerFinder customerFinder = new CustomerFinder(new FileOperations(), new FirstFormulaDistanceCalculator(), "inputUrl", "outputUrl");

  @Test(expected = IOException.class)
  public void calculateWhenInputFileHasProblem() throws IOException {

    doThrow(IOException.class).when(fileOperations).fileReader(any());

    customerFinder.findCustomers();
  }

  @Test(expected = IOException.class)
  public void calculateWhenWritingHasProblem() throws IOException {

    List<Customer> customers = new ArrayList<>();

    customers.add(new Customer(customer2));

    when(fileOperations.fileReader(any())).thenReturn(customers);
    doThrow(IOException.class).when(fileOperations).fileWriter(anyList(), any());

    customerFinder.findCustomers();
  }

  @Test
  public void calculateWhenCustomerListIsAvailable() throws IOException {

    List<Customer> customers = new ArrayList<>();

    customers.add(new Customer(customer1));
    customers.add(new Customer(customer2));
    customers.add(new Customer(customer3));

    when(fileOperations.fileReader(any())).thenReturn(customers);
    customerFinder.findCustomers();

    verify(fileOperations, times(1)).fileWriter(anyList(), any());

  }
}