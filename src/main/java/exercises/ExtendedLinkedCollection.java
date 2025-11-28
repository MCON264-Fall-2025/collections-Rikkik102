package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LLNode current = head;
        while (current != null){
            sb.append(current.getInfo());
            current = current.getLink();
        }
        return sb.toString();
        //ТОDO: implement this method. Use StringBuider. Create Javadoc.
    }


    public int count(T target) {
        int found = 0;
        LLNode<T> current = head;
        while (current != null ) {
            if (current.getInfo().equals(target)) {
                found++;
            }
            current = current.getLink();
        }
        return found;
        //ТОDO: implement this method. Count the number of times target appears in the collection. Create Javadoc.
    }

    public int removeAll(T target) {
        int found = 0;
        while (head != null && head.getInfo().equals(target)) {
            head = head.getLink();
            numElements--;
            found++;
        }
        if (head == null) {
            return found;
        }
        LLNode<T> previous = head;
        LLNode<T> current = head.getLink();

        while (current != null) {
            if (current.getInfo().equals(target)) {
                previous.setLink(current.getLink());
                numElements--;
                found++;
                current = previous.getLink();
            } else {
                previous = current;
                current = current.getLink();
            }
        }
//ТОDO: implement this method. Remove all occurrences of target from the collection and return the number of elements removed. Create Javadoc.
        return found;
    }
}




