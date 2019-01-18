package Singleton.Implementation;

/* Class created at the time of class loading.
 * Drawback: instance will be created even if client app will not use it*/

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {

    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
