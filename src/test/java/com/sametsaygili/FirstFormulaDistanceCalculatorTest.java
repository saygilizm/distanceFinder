package com.sametsaygili;

import org.junit.Test;

public class FirstFormulaDistanceCalculatorTest {

  private DistanceCalculator distanceCalculator = new FirstFormulaDistanceCalculator();

  @Test(expected = NullPointerException.class)
  public void calculateFail() {

    distanceCalculator.calculate(null, null);

  }
}