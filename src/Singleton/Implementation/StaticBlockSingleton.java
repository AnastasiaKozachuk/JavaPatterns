package Singleton.Implementation;

/* Creation instance of class is similar to eager initialization.
 * Static block provides option for exception handling.
 * Drawback: instance will be created even if client app will not use it
 * */

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }

}
