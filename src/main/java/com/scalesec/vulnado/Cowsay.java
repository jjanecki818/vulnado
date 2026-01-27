package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.function.ToIntFunction;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.DoublePredicate;
import java.util.function.DoubleFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.LongPredicate;
import java.util.function.LongFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.IntPredicate;
import java.util.function.IntFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.Objects;
private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName());
import java.util.logging.Logger;

private Cowsay() {\n    // Prevent instantiation\n}
public class Cowsay {
  public static String run(String input) {
private static String validateInput(String input) {\n    if (input == null || input.isEmpty() || input.contains(\";\") || input.contains(\"&\")) {\n        throw new IllegalArgumentException(\"Invalid input detected\");\n    }\n    return input;\n}
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    LOGGER.info(cmd);
processBuilder.environment().put(\"PATH\", \"/usr/games\");
    processBuilder.command(\"bash\", \"-c\", validateInput(cmd));

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line);\noutput.append(\"\\n\");
      }
    } catch (Exception e) {
      LOGGER.severe(\"An error occurred: \" + e.getMessage());
    }
    return output.toString();
  }
}
