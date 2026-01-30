package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

    private Cowsay() {
public class Cowsay {
        throw new UnsupportedOperationException("Utility class");
    public static String run(String input) {
    }
        ProcessBuilder processBuilder = new ProcessBuilder();
        String cmd = "/usr/games/cowsay " + input;
    private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName());
    LOGGER.info(cmd);
    if (!input.matches("^[a-zA-Z0-9_ ]*$")) {
    processBuilder.environment().put("PATH", "/usr/bin:/bin");
        throw new IllegalArgumentException("Invalid input");

    }
    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
      }
    } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred", e);
    }
    return output.toString();
  }
}
