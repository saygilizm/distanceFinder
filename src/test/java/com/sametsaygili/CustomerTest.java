package com.sametsaygili;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

  private final JSONObject customerA = new JSONObject(
      "{\"latitude\": \"59.3260668\", \"user_id\": \"ID\", \"name\": \"Samet Saygili\", \"longitude\": \"17.8419707\"}");
  private final JSONObject customerB = new JSONObject(
      "{\"latitude\": \"53.339528\", \"id\": 2, \"name\": \"Phoebe Buffay\", \"longitude\": \"-6.256665\"}");
  private final JSONObject customerC = new JSONObject(
      "{\"latitude\": \"53.339528\", \"user_id\": 2, \"name\": \"Joey Tribbiani\", \"longitude\": \"-6.256665\"}");

  @Test(expected = ClassCastException.class)
  public void constructorWhenClassCastException() {

    new Customer(customerA);
  }
  @Test(expected = JSONException.class)
  public void constructorWhenJSONException() {

    new Customer(customerB);
  }

  @Test(expected = NullPointerException.class)
  public void constructorWhenNullPointerException() {

    new Customer(null);
  }

  @Test
  public void constructorWhenSuccessful() {

    Customer customer = new Customer(customerC);

    Assert.assertTrue(customer.getName().equals("Joey Tribbiani"));
  }

}