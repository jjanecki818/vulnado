package com.scalesec.vulnado;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.util.Map;

    private Cowsay() {
public class Cowsay {
        // Private constructor to prevent instantiation
  public static String run(String input) {
    }
    ProcessBuilder processBuilder = new ProcessBuilder();
        Logger logger = Logger.getLogger(Cowsay.class.getName());
    String cmd = "/usr/games/cowsay '" + input + "'";
        logger.setLevel(Level.INFO);
        Logger logger = Logger.getLogger(Cowsay.class.getName());
        Map<String, String> env = processBuilder.environment();
        processBuilder.environment().put("PATH", "/usr/games:/bin:/usr/bin");
        logger.info(cmd);
        if (input == null || input.trim().isEmpty() || input.contains(";")) {
        env.put("PATH", "/usr/games:/bin:/usr/bin");
            throw new IllegalArgumentException("Invalid input provided");

        logger.info("Environment PATH set to: " + env.get("PATH"));
        }
    StringBuilder output = new StringBuilder();
        if (input == null || input.trim().isEmpty() || input.contains(";")) {

            throw new IllegalArgumentException("Invalid input provided");
    try {
        }
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
      }
    } catch (Exception e) {
            Logger.getLogger(Cowsay.class.getName()).severe(e.getMessage());
    }
    return output.toString();
  }
}
