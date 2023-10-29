import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (if needed)
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
}

public class StudentFileProcessing {
    public static void main(String[] args) {
        // Read student details from IN file, convert to lowercase, and write to OUT file
        try {
            FileReader inFile = new FileReader("IN.txt");
            BufferedReader reader = new BufferedReader(inFile);

            FileWriter outFile = new FileWriter("OUT.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into name and age (assuming a specific format)
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].toLowerCase(); // Convert name to lowercase
                    int age = Integer.parseInt(parts[1]);

                    Student student = new Student(name, age);

                    // Write the student details to the OUT file
                    outFile.write(student.getName() + "," + student.getAge() + "\n");
                }
            }

            inFile.close();
            outFile.close();

            System.out.println("Data written to OUT.txt successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
