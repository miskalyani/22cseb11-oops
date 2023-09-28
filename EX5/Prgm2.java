package main1;
import pack1.MathOperations;
import pack2.StringOperation;
import pack3.Calculator;

public class main {
    public static void main(String[] args) {
        // Testing MathOperations
        MathOperations mathOps = new MathOperations();
        int sum = mathOps.add(5, 3);
        int difference = mathOps.sub(8, 2);

        System.out.println("MathOperations:");
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);

        // Testing StringOperations
        StringOperation stringOps = new StringOperation();
        String concatResult = stringOps.concatenate("Hello, ", "world!");
        String reverseResult = stringOps.reverse("Java");

        System.out.println("\nStringOperations:");
        System.out.println("Concatenation: " + concatResult);
        System.out.println("Reversed: " + reverseResult);

        // Testing Calculator
        Calculator calculator = new Calculator();
        int product = calculator.multiply(4, 5);
        String divisionResult = calculator.divide(8, 2);

        System.out.println("\nCalculator:");
        System.out.println("Product: " + product);
        System.out.println("Division: " + divisionResult);
    }
}

package pack1;

/**
 *
 * 
 */
public class MathOperations {
    public static int add(int a, int b)
    {
        return a+b;
    }
    public static int sub(int a, int b)
    {
        return a-b;
    }
}

package pack2;

/**
 *

 */
public class StringOperation {
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    public String reverse(String str) {
        int length = str.length();
        StringBuilder reversed = new StringBuilder(length);
        
        for (int i = length - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        
        return reversed.toString();
    }
}
package pack3;

/**
 *

 */
public class Calculator {
     public int multiply(int a, int b) {
        return a * b;
    }

    public String divide(int a, int b) {
        if (b == 0) {
            return "Division by zero is not allowed";
        }
        return String.valueOf(a / b);
    }
}