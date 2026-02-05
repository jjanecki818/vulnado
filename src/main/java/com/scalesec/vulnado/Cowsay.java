package com.scalesec.vulnado;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

    private Cowsay() {
public class Cowsay {
        // Private constructor to prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
        processBuilder.environment().put(\"PATH\", \"/usr/games\");
        if (input == null || input.contains(\";\") || input.contains(\"&\") || input.contains(\"|\")) {
        logger.info(cmd);
    processBuilder.command("bash", "-c", cmd);
            throw new IllegalArgumentException(\"Invalid input detected\");

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