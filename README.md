# Logger 

## Overview
This project implements a **Logger** system using the **Chain of Responsibility** design pattern in Java. The Chain of Responsibility pattern allows multiple objects to handle a request dynamically by passing it along a chain of handlers.

## Features
- Implements **INFO**, **DEBUG**, and **ERROR** log levels.
- Uses the **Chain of Responsibility** pattern to process logs at different levels.
- Allows flexible addition of new log processors without modifying existing code.

## Design Pattern: Chain of Responsibility
The **Chain of Responsibility** design pattern is used to process log messages through a chain of different log processors. Each processor decides whether it can handle the request or if it should pass it to the next processor in the chain.

### **How It Works**
- The **LogProcessor** class acts as the base abstract class for different log levels.
- The **InfoLogProcessor**, **DebugLogProcessor**, and **ErrorLogProcessor** classes extend the LogProcessor and handle their respective log levels.
- If a processor cannot handle a log message, it passes the message to the next processor in the chain.

## Project Structure
```
LoggerProject/
│── src/
│   ├── Main.java
│   ├── model/
│   │   ├── LogProcessor.java
│   │   ├── InfoLogProcessor.java
│   │   ├── DebugLogProcessor.java
│   │   ├── ErrorLogProcessor.java
│── README.md
```

## Classes and Responsibilities

### **1. LogProcessor (Abstract Class)**
- Defines the base structure for handling logs.
- Stores a reference to the next log processor in the chain.
- Implements the **log()** method to pass log messages along the chain.

```java
public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel, String message) {
        if (this.nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }
}
```

### **2. InfoLogProcessor**
- Handles **INFO** level logs.
- Passes unhandled logs to the next processor.

```java
public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("Info Log: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
```

### **3. DebugLogProcessor**
- Handles **DEBUG** level logs.
- Passes unhandled logs to the next processor.

```java
public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("Debug Log: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
```

### **4. ErrorLogProcessor**
- Handles **ERROR** level logs.
- Passes unhandled logs to the next processor.

```java
public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.out.println("Error Log: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
```

### **5. Main.java (Driver Class)**
The **Main** class sets up the chain and triggers the logging process.

```java
public class Main {
    public static void main(String[] args) {
        // Setting up the chain: INFO -> DEBUG -> ERROR
        LogProcessor loggerObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        // Logging different levels
        loggerObj.log(LogProcessor.INFO, "This is an INFO log");
        loggerObj.log(LogProcessor.DEBUG, "This is a DEBUG log");
        loggerObj.log(LogProcessor.ERROR, "This is an ERROR log");
    }
}
```

## Output
When running the **Main.java**, the following output will be displayed:
```
Info Log: This is an INFO log
Debug Log: This is a DEBUG log
Error Log: This is an ERROR log
```

## How to Run
1. Clone this repository:
   ```sh
   git clone https://github.com/VamsiMakke87/Logger.git
   ```
2. Navigate to the project directory:
   ```sh
   cd LoggerProject
   ```
3. Compile the Java files:
   ```sh
   javac src/model/*.java src/Main.java
   ```
4. Run the application:
   ```sh
   java src/Main
   ```

## Advantages of Using Chain of Responsibility
✅ **Decouples request senders and receivers** – Each processor handles its responsibility without knowing about the others.
✅ **Enhances flexibility** – New log levels can be added without modifying existing code.
✅ **Reduces conditional statements** – Avoids large if-else statements for handling log levels.

## Future Enhancements
- Add support for **File Logging** and **Database Logging**.
- Implement **Asynchronous Logging** to improve performance.
- Introduce **Logging Levels Configuration** via a properties file.

## Conclusion
This **Logger** project effectively demonstrates the **Chain of Responsibility** pattern in Java. It provides a scalable and maintainable way to handle logging at different levels dynamically. 🚀

---
### **Author:** Vamsi Makke
GitHub: [VamsiMakke87](https://github.com/VamsiMakke87)

