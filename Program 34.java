module com.utils {
    exports com.utils;
}
com/utils/Utility.java
  package com.utils;

public class Utility {
    public static void greet(String name) {
        System.out.println("Hello, " + name + " from com.utils!");
    }
}
module com.greetings {
    requires com.utils;
}
com/greetings/Main.java
  package com.greetings;

import com.utils.Utility;

public class Main {
    public static void main(String[] args) {
        Utility.greet("User");
    }
}
