## LearnTrack Design Notes

---------------
* Why you used ArrayList instead of array ?
   * Dynamic Sizing : Arrays have fixed length at the instantiation. Arraylist will dynamically resize based on the students or courses or enrollments added. 
   * Builtin operations : Arraylist has built-in methods like `add()`, `remove()`, and `contains()` that can simplify data manipulation.
---------------
* Where you used static members and why
    * Static members represent class-level state or utility behaviors that do not depend on a specific object instance. In LearnTrack, static members are used in:
        1. `IdGenerator.java` (`private static int studentIdCounter`, etc.):Why:Auto-incrementing counters must persist across the entire lifetime of the application. Making these variables static ensures that every time a new entity is created, a single central counter is incremented, guaranteeing unique IDs across all instances.
        2. `Main.java` (`private static final StudentService studentService = ...`, `Scanner`):Why:Having static instances of the services allows all sub-menu helper methods (e.g., `handleStudentMenu()`) to interact with the exact same in-memory state without needing to pass service instances as arguments to every menu method.
----------------
* Where you used inheritance and what you gained from it
    * Inheritance was implemented using the parent class `Person.java` and child classes `Student.java` and `Trainer.java`.
     * Hierarchy
        * `Person` (Abstract Base Class)
           * `Student` (Extends `Person`)
           * `Trainer` (Extends `Person`)

     * Gains from Inheritance
        *  Code Reusability
        *  Polymorphism
-----------------
* Clean Code Principles and Meaningful Naming Conventions Applied:
    * Methods express precise intent: `findStudentById()`, `addCourse()`, `readIntInput()`.
    * Variable names are clear and descriptive (e.g., `durationInWeeks`, `enrollmentDate`) instead of generic placeholders like `doWork`, or `fun1`.
    * Short, Focused Methods: Menu choices are delegated to dedicated handler methods (`handleStudentMenu()`, `handleCourseMenu()`) rather than having a massive `main()` method.