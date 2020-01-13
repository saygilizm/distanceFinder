package com.sametsaygili;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;

public class FileOperations {

  public List<Customer> fileReader(String fileName)
      throws IOException, JSONException, ClassCastException {

    InputStream is = new FileInputStream(fileName);

    try(BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")))) {

      return rd.lines().map(item -> new Customer(new JSONObject(item)))
          .collect(Collectors.toList());
    } finally {

      is.close();
    }

  }

  public void fileWriter(List<Customer> customerList, String url) throws IOException {

    FileWriter writer = new FileWriter(url);

    try {

      for (Customer customer : customerList) {
        writer.write(customer.getName().concat(" ").concat(customer.getId().toString())
            .concat(System.lineSeparator()));
      }

    } finally {

      writer.close();
    }
  }
}
