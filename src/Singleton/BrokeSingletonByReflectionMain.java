package Singleton;

import Singleton.Implementation.LazyInitializedSingleton;

import java.lang.reflect.Constructor;

public class BrokeSingletonByReflectionMain {

    public static void main(String[] args) {

        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceTwo = LazyInitializedSingleton.getInstance();

        System.out.println("HashCode of object 1: " + instanceOne.hashCode());
        System.out.println("HashCode of object 2: " + instanceTwo.hashCode());
        System.out.println("Is 1 and 2 objects are equals: " + instanceTwo.equals(instanceOne));

        LazyInitializedSingleton instanceThree = null;

        try {

            Constructor[] constructors = LazyInitializedSingleton.class.getDeclaredConstructors();

            for(Constructor constructor: constructors){
                constructor.setAccessible(true);
                instanceThree = (LazyInitializedSingleton) constructor.newInstance();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("HashCode of object 3: " + instanceThree.hashCode());

    }

}
