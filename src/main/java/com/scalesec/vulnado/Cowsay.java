package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.util.logging.Logger;
import java.io.InputStreamReader;

    private Cowsay() {
public class Cowsay {
        // Private constructor to prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    LOGGER.info(cmd);
    if (input == null || input.trim().isEmpty() || input.contains(";")) {
    processBuilder.environment().put("PATH", "/usr/local/bin:/usr/bin:/bin");
        throw new IllegalArgumentException("Invalid input provided");

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