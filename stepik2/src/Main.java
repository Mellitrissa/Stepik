import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> set4 = new HashSet<>();
        Set<T> set5 = new HashSet<>();

        set4.addAll(set1);
        set5.addAll(set2);
        set4.removeAll(set2);
        set5.removeAll(set1);
        set4.addAll(set5);

        return set4;
    }

}
