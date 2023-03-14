import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> set4 = new HashSet<>();
        Set<T> set5 = new HashSet<>();
        Set<T> set = new HashSet<>();

        set4.addAll(set1);
        set5.addAll(set2);
        set.addAll(set4);
        set4.retainAll(set5);
        set.addAll(set5);
        set.removeAll(set4);
        return set;
    }

}
