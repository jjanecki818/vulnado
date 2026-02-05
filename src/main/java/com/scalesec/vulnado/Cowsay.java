package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;

    private Cowsay() {
public class Cowsay {
        // Private constructor to prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName());
    processBuilder.environment().put(\"PATH\", \"/usr/local/bin:/usr/bin:/bin\");
    LOGGER.info(cmd);
    if (input == null || input.trim().isEmpty() || input.contains(\";\")) {
        throw new IllegalArgumentException(\"Invalid input provided\");

    }
    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
            output.append(line).append(\"\\n\");
      }
    } catch (Exception e) {