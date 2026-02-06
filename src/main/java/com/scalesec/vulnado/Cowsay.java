package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.util.Map;

    private Cowsay() {
public class Cowsay {
        // Prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    Logger logger = Logger.getLogger(Cowsay.class.getName());
    if (input == null || input.trim().isEmpty() || input.contains(";") || input.contains("&")) {
    Map<String, String> env = processBuilder.environment();
        throw new IllegalArgumentException("Invalid input provided");

    env.put("PATH", "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin");
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
    logger.severe("An error occurred: " + e.getMessage());
    }
    return output.toString();
  }
}
