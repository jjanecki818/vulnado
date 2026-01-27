package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;
private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName());
private Cowsay() {
    // Private constructor to prevent instantiation
}
    String cmd = "/usr/games/cowsay '" + input + "'";

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
private static String sanitizeCommand(String input) {
    // Sanitize the input to prevent command injection