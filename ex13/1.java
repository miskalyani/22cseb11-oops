import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectionExample {

    public static <T extends Comparable<T>> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.retainAll(list2);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 4, 8, 9, 11, 15, 17, 28, 41, 59);

        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 4, 7, 11, 17, 19, 20, 23, 28, 37, 59, 81);

        List<Integer> intersection = intersect(list1, list2);

        System.out.println("Intersection: " + intersection);
    }
}
