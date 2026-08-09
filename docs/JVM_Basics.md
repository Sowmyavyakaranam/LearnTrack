## LearnTrack

## 1. What is JDK, JRE, JVM

Java's runtime and development is structured into three main layers:

* **JDK (Java Development Kit):** The full toolkit for Java developers. It includes debugging tools, compiler tools (`javac`), documentation generators, and the JRE. You need a JDK to write and compile Java code.
* **JRE (Java Runtime Environment):** The runtime package required to run Java applications. It contains the standard class libraries (like `java.util`, `java.lang`) and the JVM. *(Note: Since Java 11, the JRE is integrated directly inside the JDK rather than distributed separately).*
* **JVM (Java Virtual Machine):** The abstract execution engine that actually runs Java programs. The JVM loads compiled bytecode (`.class` files), translates it into host machine instructions, and manages system memory (Garbage Collection).

---

## 2. What is Bytecode?

**Bytecode** is the intermediate representation of your Java source code produced by the Java Compiler (`javac`).

When you write Java code in a `.java` file and compile it, `javac` does not generate native binary code for your computer's specific processor. Instead, it outputs platform-neutral `.class` files containing **bytecode instructions**.

Because bytecode is independent of host hardware, any platform that has a JVM installed can read and execute those `.class` files.

---

## 3. What does “write once, run anywhere” mean (1–2 short paragraphs)

"Write Once, Run Anywhere" means that Java code written and compiled on one operating system can execute on any other operating system without needing to be rewritten or recompiled.

When you write Java code on Windows and run `javac`, it generates universal bytecode `.class` files. You can take those exact `.class` files and run them on macOS, Linux, or a cloud server. Each operating system has its own OS-specific JVM that translates the universal bytecode into that specific system's native hardware instructions at runtime.