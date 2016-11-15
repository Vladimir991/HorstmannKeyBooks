package ChapterThirteen.Collection.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListMain {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();

        a.add("I");
        a.add("Want");
        a.add("to");
        a.add("work");
        a.add("in");
        a.add("the");
        a.add("company");
        a.add("Codeborne");
        a.add(".com");

        List<String> b = new LinkedList<>();
        b.add("This");
        b.add("company");
        b.add("has");
        b.add("the");
        b.add("right");
        b.add("approach");
        b.add("to");
        b.add("programming");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }
}
