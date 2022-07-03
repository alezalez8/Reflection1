package ua.kiev.prog.myannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//@MethodInfo(purpose = "")
public class Test {

    //@MethodInfo(author = "Neil", dateOfCreation = 2019, purpose = "Print Hello World")
    @MethodInfo(purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello world");


    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Test test = new Test();
        test.printHelloWorld();


       /* Person person = new Person(49, "Lena");

        Class personClass = person.getClass();
        Class aClass = Person.class;*/
/*
        Field[] fields = aClass.getDeclaredFields();
        for (Field f: fields
             ) {
            System.out.println(f.getName() + " " + f.getModifiers());
        }

        System.out.println("Before modification  " + person);
        System.out.println("---------------------------------");
        Field field;
        try {
            field = aClass.getDeclaredField("name");
            field.setAccessible(true);
            field.set(person, "Aleks");
            field = aClass.getDeclaredField("age");
            field.setAccessible(true);
            field.set(person, 50);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("After modification  " + person);*/
       /* Annotation[] annotations = aClass.getAnnotations();
        for (Annotation ann: annotations
             ) {
            if (ann instanceof MethodInfo) {
                System.out.println("Yes");
            }
        }*/

       /* Method [] methods = aClass.getMethods();
        for (Method met: methods
             ) {
            Annotation[] annot =  met.getDeclaredAnnotations();
            if (annot.length != 0) {
                System.out.println(met.getName() +
                        " accept params as: " + Arrays.toString(met.getParameterTypes()) + " ,   annotation = "
                + Arrays.toString(annot));
            }
        }*/

       //Class myS = String.class;
       // Method m = myS.getMethod("indexOf", String.class, int.class);

        //System.out.println(m.invoke( String.class, "hello");


    }

}
