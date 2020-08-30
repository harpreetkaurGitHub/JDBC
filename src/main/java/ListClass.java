import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListClass {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");

        for (String k:list) {
            System.out.println(k);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

// todo 1. fails-fast,Fail-safe
