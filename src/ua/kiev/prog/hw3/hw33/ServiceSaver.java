package ua.kiev.prog.hw3.hw33;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ServiceSaver {

    private final Object o;

    public ServiceSaver(Object o) {
        this.o = o;
    }


    public static void Serializer(Object o, File file) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields
        ) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                builder.append(field.getName()).append(":");
                if (field.getType() == int.class)
                    builder.append(field.getInt(o));
                if (field.getType() == char.class)
                    builder.append(field.getChar(o));
                if (field.getType() == long.class)
                    builder.append(field.getLong(o));
                if (field.getType() == String.class)
                    builder.append((String) field.get(o));
                builder.append(";");
            }
        }
        saveDataToFile(builder.toString(), file);
    }

    public static Object Deserializer(Object o, File file) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String data = loadDataFromFile(file);
        String[] lines = data.split(";");
        Class<?> clazz = o.getClass();
        Object o1 = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < lines.length; i++) {
            String[] keyValue = lines[i].split(":");
            Field field = clazz.getDeclaredField(keyValue[0]);

            if (Modifier.isPrivate(field.getModifiers()))
                field.setAccessible(true);

            if (field.getType() == int.class)
                field.setInt(o1, Integer.parseInt(keyValue[1]));

            if (field.getType() == long.class)
                field.setLong(o1, Long.parseLong(keyValue[1]));

            if (field.getType() == String.class)
                field.set(o1, keyValue[1]);

        }
        return o1;
    }

    private static void saveDataToFile(String data, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    public static String loadDataFromFile(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String result = "";
            String temp = "";
            for (; ; ) {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                result += temp + ";";
            }
            return result.substring(0, result.length() - 1);
        } catch (IOException e) {
            throw e;
        }
    }
}
