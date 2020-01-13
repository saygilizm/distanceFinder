package com.sametsaygili;

public class FirstFormulaDistanceCalculator implements DistanceCalculator {

  private static final Integer R = 6371;

  @Override
  public Double calculate(Location location1, Location location2) throws NullPointerException{

    double deltaSigma;
    double deltaLambda;

    deltaLambda = Math.toRadians(location2.getLongitude() - location1.getLongitude());
    deltaSigma =
        Math.acos(
            Math.sin(Math.toRadians(location1.getLatitude())) * Math.sin(Math.toRadians(location2.getLatitude()))
                + Math.cos(Math.toRadians(location1.getLatitude())) * Math
                .cos(Math.toRadians(location2.getLatitude())) * Math
                .cos(deltaLambda)
        );

    return R * deltaSigma;
  }
}
