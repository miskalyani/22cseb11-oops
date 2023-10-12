import java.util.Scanner;

public class ConstructID {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for full name
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        // Prompt the user for the street address
        System.out.print("Enter your street address: ");
        String address = scanner.nextLine();

        // Extract initials from the full name
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            initials.append(name.charAt(0));
        }

        // Remove non-numeric characters from the address
        String numericPart = address.replaceAll("[^0-9]", "");

        // Construct the ID
        String userID = initials.toString() + numericPart;

        // Print the constructed ID
        System.out.println("Your ID is: " + userID);
    }
}
