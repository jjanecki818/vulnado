The provided code has issues reported by SonarQube. Let's address them one by one.

---

### **Analysis of Remarks**

#### **[13]: [ISSUE](java:S1118)**
- **Problem**: The class `LinkLister` has an implicit public constructor. SonarQube suggests adding a private constructor to hide it since this class is utility-based and does not require instantiation.
- **Solution**: Add a private constructor to the `LinkLister` class.

#### **[28]: [ISSUE](java:S106)**
- **Problem**: The use of `System.out.println` for logging is not recommended. Replace it with a proper logger.
- **Solution**: Introduce a logger (`java.util.logging.Logger`) and replace the `System.out.println` statement with a logging statement.

---

### **Code Fixes**

#### **Fix for [13]: Add a private constructor**
- Add a private constructor to the `LinkLister` class to prevent instantiation.

#### **Fix for [28]: Replace `System.out.println` with a logger**
- Introduce a logger and replace the `System.out.println` statement with a logging statement.

---

### **ContentEditor Operations**

#### **Operation for [13]**
```java
{
  "operation": "INSERT",
  "lineNumber": 13,
  "content": "private LinkLister() {"
},
{
  "operation": "INSERT",
  "lineNumber": 14,
  "content": "    // Prevent instantiation"
},
{
  "operation": "INSERT",
  "lineNumber": 15,
  "content": "}"
}
```

#### **Operation for [28]**
```java
{
  "operation": "INSERT",
  "lineNumber": 3,
  "content": "import java.util.logging.Logger;"
},
{
  "operation": "INSERT",
  "lineNumber": 4,
  "content": "import java.util.logging.Level;"
},
{
  "operation": "INSERT",
  "lineNumber": 12,
  "content": "private static final Logger LOGGER = Logger.getLogger(LinkLister.class.getName());"
},
{
  "operation": "REPLACE",
  "lineNumber": 28,
  "content": "LOGGER.log(Level.INFO, host);"
}
```

---

### **Final Code After Fixes**

```java
package com.scalesec.vulnado;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LinkLister {
    private static final Logger LOGGER = Logger.getLogger(LinkLister.class.getName());

    private LinkLister() {
        // Prevent instantiation
    }

    public static List<String> getLinks(String url) throws IOException {
        List<String> result = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a");
        for (Element link : links) {
            result.add(link.absUrl("href"));
        }
        return result;
    }

    public static List<String> getLinksV2(String url) throws BadRequest {
        try {
            URL aUrl = new URL(url);
            String host = aUrl.getHost();
            LOGGER.log(Level.INFO, host);
            if (host.startsWith("172.") || host.startsWith("192.168") || host.startsWith("10.")) {
                throw new BadRequest("Use of Private IP");
            } else {
                return getLinks(url);
            }
        } catch (Exception e) {
            throw new BadRequest(e.getMessage());
        }
    }
}
```

---

### **Summary of Changes**
1. Added a private constructor to the `LinkLister` class to prevent instantiation.
2. Introduced a logger (`java.util.logging.Logger`) and replaced `System.out.println` with `LOGGER.log(Level.INFO, host)`.

These changes ensure the code adheres to SonarQube's recommendations and follows Java best practices.
