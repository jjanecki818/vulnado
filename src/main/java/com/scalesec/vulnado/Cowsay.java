package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.util.logging.Logger;

    private Cowsay() {
        // Private constructor to prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    processBuilder.environment().put(\"PATH\", \"/usr/games\");
    LOGGER.info(cmd);
        throw new IllegalArgumentException(\"Invalid input provided\");

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
