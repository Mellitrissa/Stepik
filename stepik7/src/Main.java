
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        Map<String, Long> resultMap = new BufferedReader(new InputStreamReader(System.in)).lines()
                .flatMap(n-> Arrays.stream(n.split("[\\p{Punct}\\s]+")))
                .map(w-> w.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        resultMap.entrySet().stream()
                .sorted((e1,e2)->{
                    if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));

    }
}
