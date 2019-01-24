package Factory;


/* Advantages:
* 1) Code for interface rather than implementation
* 2) Removes the instantiation of actual implementation of classes from client code.
* 3) Provides abstraction between implementation and client classes through inheritance.
* */
public class TestFactory {

    public static void main(String[] args) {

        Computer pc = Factory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
        Computer server = Factory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");

        System.out.println("Factory PC Config::" + pc);
        System.out.println("Factory Server Config::" + server);
    }

}
