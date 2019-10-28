package com.didimoner.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Runs {@link Test} annotated methods in provided classes.
 */
public final class TestRunner {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Test {

    }

    private TestRunner() {

    }

    /**
     * @param clazz class with @Test methods.
     */
    public static void run(Class<?> clazz) {
        Object target = null;
        try {
            Constructor constructor = clazz.getConstructor();
            if (constructor != null) {
                target = constructor.newInstance();
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Error: Provided class doesn't have default public constructor");
            e.printStackTrace();
            return;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(target);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
