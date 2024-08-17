package design_patterns.creational.singleton;

import java.io.Serializable;

// can't be inherited
public final class LazyDoubleCheckSingleton implements Serializable, Cloneable {

    // can't be instantiated
    private LazyDoubleCheckSingleton() {
        // to safeguard against reflection
        if(instance != null) {
            throw new RuntimeException("Instance already created");
        }
    }

    /**
     * Double-Checked Locking: It uses the volatile keyword to ensure that changes to the instance
     * variable are immediately visible to other threads.
     */
    private static volatile LazyDoubleCheckSingleton instance; // Lazy initialization

    /**
     * using synchronized can decrease performance, which can be a bottleneck if
     * this method is called frequently.
     * */
    // public static synchronized MasterSingletonImplementation getINSTANCE() {
    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized(LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
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
