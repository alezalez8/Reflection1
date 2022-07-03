package ua.kiev.prog.hw3.hw33;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        Class<? extends Container> clazz = Container.class;
        Method[] methods = clazz.getMethods();

        if (clazz.isAnnotationPresent(SaveTo.class)) {
            for (Method method : methods
            ) {
                if (method.isAnnotationPresent(Saver.class)) {
                    File file = new File(clazz.getAnnotation(SaveTo.class).path());

                    try {
                        Field field =  clazz.getDeclaredField("text");
                        field.setAccessible(true);
                        String text = (String)field.get(container);
                        method.invoke(container, text, file);
                    } catch (InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                }
             }
        }

    }
}
