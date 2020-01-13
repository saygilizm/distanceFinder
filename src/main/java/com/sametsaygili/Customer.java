package com.sametsaygili;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
public class Customer implements Comparable<Customer> {

  private String name;
  private Integer id;
  private Location location;

  public Customer(@NonNull JSONObject jsonEntry) {

      this.setId((Integer) jsonEntry.get("user_id"));
      this.setName((String) jsonEntry.get("name"));
      this.location = new Location(Double.parseDouble((String) jsonEntry.get("latitude")), Double.parseDouble((String) jsonEntry.get("longitude")));

  }

  @Override
  public int compareTo(Customer o) {

    return this.getId() - o.getId();

  }
}
