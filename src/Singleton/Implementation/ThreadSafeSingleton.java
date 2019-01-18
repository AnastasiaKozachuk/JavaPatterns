package Singleton.Implementation;

/* Add synchronized to global access method.
 * Drawback: It implementation work fine, but reduces the performance.
 *           We need synchronizing only for the first few threads who might
 *           create the separate instance
 * To avoid this extra checking  double checked locking principle can be used.
 * */

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {

        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}
