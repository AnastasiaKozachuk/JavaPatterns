package Singleton.Implementation;

/* Creates an instance in global access method.
*  Drawback: this implementation works fine only in thread-safe environment;
*            in multithreaded system, multiple threads can be inside the if
*            condition in the same time. It will destroy the singleton.
*            Both threads get the different instances.
* */

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static LazyInitializedSingleton getInstance() {

        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }

}
