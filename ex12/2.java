public class GenericMinFinder {

    public static <T extends Comparable<T>> T findMin(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        T min = array[0];

        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 3, 8, 2, 7, 1};
        Integer minInt = findMin(intArray);
        System.out.println("Minimum Integer: " + minInt);

        Double[] doubleArray = {2.5, 1.2, 3.8, 0.7, 4.2};
        Double minDouble = findMin(doubleArray);
        System.out.println("Minimum Double: " + minDouble);

        String[] stringArray = {"apple", "banana", "orange", "kiwi", "grape"};
        String minString = findMin(stringArray);
        System.out.println("Minimum String: " + minString);
    }
}
