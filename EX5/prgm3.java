package package1;

public class A {
    protected int protectedField = 42;
    int defaultField = 10; // This is package-private (default access)
}

package package2;

import package1.A;

public class B extends A {
    public void accessProtectedField() {
        System.out.println("Accessing protectedField from subclass B: " + protectedField);
    }
    
    public void tryToAccessDefaultField() {
        // Attempting to access the defaultField from class A (in a different package) will result in a compilation error.
        // System.out.println("Trying to access defaultField from subclass B: " + defaultField); // This line will cause a compilation error
    }
}