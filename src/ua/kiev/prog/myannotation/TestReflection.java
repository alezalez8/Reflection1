package ua.kiev.prog.myannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        //class1 class2 method

        Class<?> classObject1 = Class.forName(scanner.next());
        Class<?> classObject2 = Class.forName(scanner.next());
        String methodName = scanner.next();

        Method method = classObject1.getMethod(methodName, classObject2);
        Object o1 = classObject1.getDeclaredConstructor().newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");
        method.invoke(o1, o2);
        System.out.println(o1);




    }

}
