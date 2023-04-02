import java.util.*;
import java.util.function.Consumer;



public class MailService <T> implements Consumer<Sendable<T>> {
    public class MyHashMap<K, V> extends HashMap<K, V> {
        @Override
        public V get(Object key) {
            V element = super.get(key);

            if (element == null) {
                element = (V) Collections.emptyList();
            }

            return element;
        }
    }

    private HashMap<String, List<T>>mailBox;
    public MailService(){
        mailBox=new MyHashMap<>();

    }

    public HashMap<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> t) {
        List<T> list;
        if (mailBox.containsKey(t.getTo())) {
            list = mailBox.get(t.getTo());
            list.add(t.getContent());
            mailBox.put(t.getTo(), list);
        } else {
            list = new ArrayList<>();
            list.add(t.getContent());
            mailBox.put(t.getTo(), list);
        }
    }
}
