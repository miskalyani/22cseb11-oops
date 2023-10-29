import java.io.*;

public class BinaryFileIOExample {
    public static void main(String[] args) {
        // Create a binary file using byte stream
        writeBinaryFileByteStream("binaryfile_byte.dat");

        // Read and display the binary file using character stream
        readBinaryFileCharacterStream("binaryfile_byte.dat");
    }

    // Write binary data to a file using byte stream
    public static void writeBinaryFileByteStream(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(42); // Write an integer
            dos.writeDouble(3.141592); // Write a double
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read and display binary data from a file using character stream
    public static void readBinaryFileCharacterStream(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             DataInputStream dis = new DataInputStream(fis)) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();

            System.out.println("Read integer using character stream: " + intValue);
            System.out.println("Read double using character stream: " + doubleValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
