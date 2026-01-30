package com.scalesec.vulnado;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

    private Cowsay() {
public class Cowsay {
        throw new UnsupportedOperationException("Utility class");
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
        Logger logger = Logger.getLogger(Cowsay.class.getName());
        processBuilder.environment().put("PATH", "/usr/games:/usr/bin:/bin");
        if (input == null || input.trim().isEmpty() || input.contains(";")) {
        logger.info(cmd);
    processBuilder.command("bash", "-c", cmd);
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
            logger.severe("An error occurred: " + e.getMessage());
    }
    return output.toString();
  }
}
