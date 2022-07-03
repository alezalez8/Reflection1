package ua.kiev.prog.myannotation;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.age = -10;
        this.name = "noname";
    }

    public Person(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    @MethodInfo(purpose = "purpose")
    public int getAge(String aaa) {
        return age;
    }

    public void printName(String name) {
        System.out.println(name);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
