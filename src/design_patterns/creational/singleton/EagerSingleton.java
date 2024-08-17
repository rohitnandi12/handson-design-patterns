package design_patterns.creational.singleton;

import java.io.Serializable;

public final class EagerSingleton implements Serializable, Cloneable {

    private EagerSingleton() {
        // to safeguard against reflection
        if(instance != null) {
            throw new RuntimeException("Instance already created");
        }
    }

    // this approach doesn't handle any exception or multi line code
//    private static final EagerSingleton instance = new EagerSingleton();

    private static EagerSingleton instance;
    static {
        try {
            instance = new EagerSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception Occurred");
        }
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() {
        // throws new CloneNotSupportedException();
        return getInstance();
    }
}
