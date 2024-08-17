package design_patterns.creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleton {

    public static void main(String[] args) throws Exception {
        breakByReflection();
        breakBySerialization();
        breakByClonning();
    }

    private static void breakByClonning() {
        BillPughSingleton singleton1 = BillPughSingleton.getInstance();
        System.out.println(singleton1.hashCode());
        BillPughSingleton singleton2 = (BillPughSingleton)singleton1.clone();
        System.out.println(singleton2.hashCode());
    }

    /**
     * Prevent reflection breaking by:
     * - Using EnumSingleton
     * - throwing exception from constructor if instance is created
     */
    public static void breakByReflection() {
        try {
            LazyDoubleCheckSingleton singleton1 = LazyDoubleCheckSingleton.getInstance();
            System.out.println(singleton1.hashCode());

            Constructor<LazyDoubleCheckSingleton> constructor = LazyDoubleCheckSingleton
                    .class.getDeclaredConstructor();

            constructor.setAccessible(true);
            LazyDoubleCheckSingleton singleton2 = constructor.newInstance();
            System.out.println(singleton2);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                 | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prevent by implementing readResolve() method
     * @throws Exception
     */
    public static void breakBySerialization() throws Exception {

        EagerSingleton instanceOne = EagerSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
        EagerSingleton instanceTwo = (EagerSingleton) in.readObject();
        in.close();

        System.out.println("hashCode of instance 1 is - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 is - " + instanceTwo.hashCode());
    }
}
