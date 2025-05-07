import com.google.gson.*; // Gson Library to deal with JSON Files
import java.io.*; // For File Reader/Writer
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.*;

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Student>>(){}.getType();

        try (FileReader reader = new FileReader("students.json")) {
            ArrayList<Student> students = gson.fromJson(reader, listType);
            for (Student s : students) {
                System.out.println("Name: " + s.name + ", ID: " + s.id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
