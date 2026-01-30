package com.scalesec.vulnado;

import java.util.logging.Level;
import java.util.logging.Logger;

    private Cowsay() {
public class Cowsay {
        // Prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    processBuilder.environment().put("PATH", "/usr/games");
    LOGGER.info(cmd);
        throw new IllegalArgumentException("Invalid input detected");

    }
    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
      }
    } catch (Exception e) {
    }
    return output.toString();
  }
}
