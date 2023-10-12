import java.util.Scanner;

public class MessageEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a message
        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();

        // Prompt the user for an encryption key (for simplicity, a number)
        System.out.print("Enter an encryption key (an integer): ");
        int key = scanner.nextInt();

        // Encrypt the message
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    // Encryption function
    public static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c + key);
                encryptedMessage.append(shiftedChar);
            } else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    }

    // Decryption function
    public static String decrypt(String encryptedMessage, int key) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isLetter(c)) {
                char shiftedChar = (char) (c - key);
                decryptedMessage.append(shiftedChar);
            } else {
                decryptedMessage.append(c);
            }
        }
        return decryptedMessage.toString();
    }
}