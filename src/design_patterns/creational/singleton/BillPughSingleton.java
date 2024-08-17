package design_patterns.creational.singleton;

import java.io.Serializable;

public final class BillPughSingleton implements Serializable, Cloneable {

    private BillPughSingleton() {
        // to safeguard against reflection
        if(SingletonHolder.INSTANCE != null) {
            throw new RuntimeException("Instance already created");
        }
//        System.setSecurityManager(new SecurityManager()); // deprecated
    }
    private static class SingletonHolder {

        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        static {
            System.out.println("SingletonHolder is loaded");
        }
    }
    public static BillPughSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    protected Object clone() {
        // throws new CloneNotSupportedException();
        return getInstance();
    }
}
