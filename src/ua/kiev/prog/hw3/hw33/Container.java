package ua.kiev.prog.hw3.hw33;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "C:\\file.txt")
public class Container {

    private String text = "This text is needed to save in file";

    public Container() {
    }

    public Container(String text) {
        this.text = text;
    }

    @Saver
    public void save(String text, File file) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.write(text);
        } catch (IOException e) {
            System.out.println("Can not write this text " + e.getMessage());
        }
    }

    public void setText(String text) {
        this.text = text;
    }
}
