package com.sametsaygili;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Location {

  private Double latitude;
  private Double longitude;

  public Location(@NonNull Double latitude, @NonNull Double longitude){

    this.setLatitude(latitude);
    this.setLongitude(longitude);

  }
}
