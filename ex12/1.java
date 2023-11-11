import java.util.Arrays;

class ArrayOperations<T> {
    private T[] array;
    private int size;

    public ArrayOperations(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void addElementAtBeginning(T element) {
        ensureCapacity();
        System.arraycopy(array, 0, array, 1, size);
        array[0] = element;
        size++;
    }

    public void addElementAtMiddle(T element, int position) {
        ensureCapacity();
        System.arraycopy(array, position, array, position + 1, size - position);
        array[position] = element;
        size++;
    }

    public void addElementAtEnd(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void deleteElement(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }

        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, 2 * size);
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
}

public class GenericArrayOperationsDemo {
    public static void main(String[] args) {
        ArrayOperations<Integer> arrayOps = new ArrayOperations<>(5);

      
        arrayOps.addElementAtEnd(10);
        arrayOps.addElementAtEnd(20);
        arrayOps.addElementAtEnd(30);
        System.out.println("Original Array:");
        arrayOps.printArray();

        arrayOps.addElementAtBeginning(5);

        
        arrayOps.addElementAtMiddle(15, 2);

      
        System.out.println("\nArray after adding elements:");
        arrayOps.printArray();

        arrayOps.deleteElement(1);

        
        System.out.println("\nArray after deleting an element:");
        arrayOps.printArray();
    }
}
