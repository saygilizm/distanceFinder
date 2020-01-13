package com.sametsaygili;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

  private static final Double LATITUDE = 53.339428D;
  private static final Double LONGITUDE = -6.257664D;

  @Test(expected = NullPointerException.class)
  public void constructorWhenNullPointerException() {

    new Location(null, null);

  }

  @Test
  public void constructorWhenSuccessful() {

    Location location = new Location(LATITUDE, LONGITUDE);

    Assert.assertTrue(location.getLatitude() == LATITUDE);
    Assert.assertTrue(location.getLongitude() == LONGITUDE);

  }

}