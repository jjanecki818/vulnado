package com.scalesec.vulnado;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

private Cowsay() {
    // Prevent instantiation
}
public class Cowsay {
  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    Logger logger = Logger.getLogger(Cowsay.class.getName());
logger.info(cmd);
    if (input == null || input.trim().isEmpty() || input.contains(";")) {
    throw new IllegalArgumentException("Invalid input provided.");
}
processBuilder.command("/bin/bash", "-c", cmd);

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append("\n");
      }
    } catch (Exception e) {
      logger.severe("An error occurred: " + e.getMessage());
    }
    return output.toString();
  }
}
