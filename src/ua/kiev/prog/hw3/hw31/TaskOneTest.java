package ua.kiev.prog.hw3.hw31;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaskOneTest {

    public static void main(String[] args)  {
        TaskOneTest taskOne = new TaskOneTest();
        Class<? extends TaskOneTest> taskOneTest = TaskOneTest.class;

        Method method = null;
        try {
            method = taskOneTest.getMethod("test", int.class, int.class);
            Annotation[] annotation = method.getAnnotations();
            int a = ((Test) annotation[0]).a();
            int b = ((Test) annotation[0]).b();
            method.invoke(taskOne, a, b);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test(a = 5, b = 3)
    public void test(int a, int b) {
        System.out.println("Result is  " + a * b);
    }

}



