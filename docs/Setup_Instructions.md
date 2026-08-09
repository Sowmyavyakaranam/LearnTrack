# LearnTrack - Setup & Execution Instructions

## 1. Environment Details
* **JDK Version Used:** JDK 21 
* **IDE:** IntelliJ IDEA (Community / Ultimate Edition)
* **Build System:** Standard Java Project (No Maven/Gradle external build dependencies required)

---

## 2. JDK Setup & Verification

To verify that your Java environment is properly configured, run the following command in your terminal: java -version

**Expected Output:**\
openjdk version "21.0.2" 2024-01-16 \
OpenJDK Runtime Environment (build 21.0.2+13-LTS)\
OpenJDK 64-Bit Server VM (build 21.0.2+13-LTS, mixed mode, sharing

## 3. "Hello World" Test

Before running the full `LearnTrack` application, you can test your environment with a simple standalone program:

### Code (`HelloWorld.java`)
public class HelloWorld {
public static void main(String[] args) {
System.out.println("Hello, World! LearnTrack environment is ready.");
}
}
### Steps to Run in IntelliJ IDEA
1. Open IntelliJ IDEA and load the project root directory.
2. In the `src/` directory, create `HelloWorld.java`.
3. Click the green **Run** triangle ($\triangleright$) in the gutter next to `public static void main`.
4. Observe the output in the bottom **Run Window**.

### Execution Log / Output Verification
/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home/bin/java ... HelloWorld\
Hello, World! LearnTrack environment is ready.\
Process finished with exit code 0