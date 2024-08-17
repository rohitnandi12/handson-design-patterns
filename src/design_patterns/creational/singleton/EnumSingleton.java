package design_patterns.creational.singleton;

import java.io.Serializable;

public enum EnumSingleton implements Serializable, Cloneable {
    INSTANCE;

    // always safeguarded against Reflection because enum doesn't have a constructor
    // always safeguarded against Cloneable because enum is not cloneable

    public void someTask(Object anyParam) {

    }

    public Object readResolve() {
        return INSTANCE;
    }

    // Can't override
//    @Override
//    protected Object clone() {
//        // throws new CloneNotSupportedException();
//        return INSTANCE;
//    }
}
