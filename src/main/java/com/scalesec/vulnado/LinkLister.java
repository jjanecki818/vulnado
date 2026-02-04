The provided code has two remarks from SonarQube. Let's address them one at a time.

---

### **Remark 1: [13]**
- **[ISSUE](java:S1118)**: Add a private constructor to hide the implicit public one.

#### **Analysis**
The class `LinkLister` is a utility class with only static methods. According to Java best practices, utility classes should not have public constructors. Adding a private constructor will prevent instantiation of the class.

#### **Fix**
Add a private constructor to the `LinkLister` class.

---

### **Remark 2: [28]**
- **[ISSUE](java:S106)**: Replace this use of `System.out` by a logger.

#### **Analysis**
The use of `System.out.println` is not recommended for logging purposes. Instead, a proper logging framework should be used. We will replace `System.out.println` with a logger. Additionally, we need to import the `java.util.logging.Logger` class.

#### **Fix**
1. Add an import statement for `Logger`.
2. Declare a static logger instance in the `LinkLister` class.
3. Replace the `System.out.println` statement with a call to the logger.

---

### **Proposed Changes**
Here are the changes to be made to the code:

1. Add a private constructor to the `LinkLister` class.
2. Replace `System.out.println` with a logger.

---

### **ContentEditor Operations**

```json
{
  "operations": [
    {
      "operation": "INSERT",
      "lineNumber": 12,
      "content": "import java.util.logging.Logger;"
    },
    {
      "operation": "INSERT",
      "lineNumber": 13,
      "content": "private static final Logger LOGGER = Logger.getLogger(LinkLister.class.getName());"
    },
    {
      "operation": "INSERT",
      "lineNumber": 14,
      "content": "private LinkLister() {"
    },
    {
      "operation": "INSERT",
      "lineNumber": 15,
      "content": "    // Prevent instantiation"
    },
    {
      "operation": "INSERT",
      "lineNumber": 16,
      "content": "}"
    },
    {
      "operation": "REPLACE",
      "lineNumber": 28,
      "content": "LOGGER.info(host);"
    }
  ]
}
```

---

### **Updated Code**
Here is the updated code after applying the fixes:

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
            LOGGER.info(host);
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

### **Explanation of Changes**
1. **Private Constructor**:
   - Added a private constructor to the `LinkLister` class to prevent instantiation.
   - This addresses the `java:S1118` issue.

2. **Logger**:
   - Imported `java.util.logging.Logger`.
   - Declared a static logger instance: `LOGGER`.
   - Replaced `System.out.println(host)` with `LOGGER.info(host)`.
   - This addresses the `java:S106` issue.

---

Let me know if you need further assistance!
