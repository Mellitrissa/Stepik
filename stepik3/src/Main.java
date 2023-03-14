import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> num = new ArrayDeque<>();
        int value;
        int i = 0;
        while (scanner.hasNext()) {
            value = scanner.nextInt();
            if (i % 2 != 0) {
                num.add(value);
            } else scanner.next();
            i++;
        }
        Iterator<Integer> iterator = num.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}