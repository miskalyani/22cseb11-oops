import java.io.*;
import java.util.*;

public class FileInfoReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists.");

            // Check if the file is readable
            if (file.canRead()) {
                System.out.println("File is readable.");
            } else {
                System.out.println("File is not readable.");
            }

            // Check if the file is writable
            if (file.canWrite()) {
                System.out.println("File is writable.");
            } else {
                System.out.println("File is not writable.");
            }

            // Get the type of file
            if (file.isFile()) {
                System.out.println("File type: Regular file");
            } else if (file.isDirectory()) {
                System.out.println("File type: Directory");
            }

            // Get the length of the file in bytes
            System.out.println("File length (bytes): " + file.length());
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}
