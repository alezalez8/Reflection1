package ua.kiev.prog.hw3.hw33;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, NoSuchFieldException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Person person = new Person("Aleks", 49);
        person.setPassword("qazwsx");
        System.out.println("Before serial: \n\r" + person);
        File file = new File("D:\\backup.bin");
        ServiceSaver.Serializer(person, file);
        person = (Person) ServiceSaver.Deserializer(person, file);
        System.out.println("After deserial: \n\r" + person);

    }
}

class Person {

    @Save
    private String name;
    @Save
    private int age;

    private String password;
    @Save
    private long id = 10L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
