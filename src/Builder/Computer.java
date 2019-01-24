package Builder;

/*
* There are three major issues with Factory and Abstract Factory
* design patterns when the Object contains a lot of attributes.
*
* 1) Too Many arguments to pass from client program to the Factory
*    class that can be error prone because most of the time, the type
*    of arguments are same and from client side its hard to maintain the order
*    of the argument.
*
* 2) Some of the parameters might be optional but in Factory pattern, we are forced
*    to send all the parameters and optional parameters need to send as NULL.
*
* 3) If the object is heavy and its creation is complex, then all that complexity will
*    be part of Factory classes that is confusing.
*
* Builder design patterns:
*
* 1. First of all you need to create a static nested class and then copy all the
*    arguments from the outer class to the Builder class. We should follow the naming convention
*    and if the class name is Computer then builder class should be named as ComputerBuilder.
*
* 2. Java Builder class should have a public constructor with all the required attributes as parameters.
*
* 3. Java Builder class should have methods to set the optional parameters and it should return the same
*    Builder object after setting the optional attribute.
*
* 4. The final step is to provide a build() method in the builder class that will return the Object needed by
* client program. For this we need to have a private constructor in the Class with Builder class as argument.
*
* */

public class Computer {

    //required parameters
    private String HDD;
    private String RAM;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    public static class ComputerBuilder {

        //required parameters
        private String HDD;
        private String RAM;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}
