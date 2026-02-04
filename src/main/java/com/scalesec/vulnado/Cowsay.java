package com.scalesec.vulnado;

import java.util.logging.Level;
import java.io.BufferedReader;
import java.util.logging.Logger;
import java.io.InputStreamReader;

    private Cowsay() {
        // Private constructor to prevent instantiation
    }
    String cmd = "/usr/games/cowsay '" + input + "'";
    processBuilder.environment().put(\"PATH\", \"/usr/local/bin:/usr/bin:/bin\");
    LOGGER.info(cmd);
        throw new IllegalArgumentException(\"Invalid input: Only alphanumeric characters and spaces are allowed.\");
    }

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
