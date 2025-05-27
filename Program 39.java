import java.lang.reflect.*;

public class ReflectionExample {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionExample");
        Object obj = cls.getDeclaredConstructor().newInstance();

        for (Method method : cls.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }

        Method greetMethod = cls.getMethod("greet", String.class);
        greetMethod.invoke(obj, "World");
    }
}
