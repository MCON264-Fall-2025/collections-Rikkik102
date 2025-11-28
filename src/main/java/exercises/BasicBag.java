package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;
import edu.touro.mcon264.support.LLNode;

import java.util.Random;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    @Override
    public T grab() {
        if (numElements == 0) {
            return null;
        }
        Random rand = new Random();
        int i = rand.nextInt(numElements);
        T grabbed = elements[i];
        elements[i] = elements[numElements -1];
        elements[numElements -1] = null;
        numElements--;
        return grabbed;

    }

    @Override
    public int count(T target) {
        int found = 0;
        LLNode<T> previous = null;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                found++;
            }
        }
        return found;

    }

    @Override
    public int removeAll(T target) {
        int found = 0;
        int i = 0;
        while (i < numElements) {
            if (elements[i].equals(target)) {
                elements[i] = elements[numElements - 1];
                elements[numElements - 1] = null;
                numElements--;
                found++;
            } else {
                i++;
            }
        }
        return found;
    }

    @Override
    public void clear() {
            for (int i = 0; i < numElements; i++) {
                elements[i] = null;
            }
            numElements = 0;

    }

    // TODO: implement the methods in the BagInterface using an array as the underlying data structure
    // consider extending ArrayCollection<T>
    // put in the JavaDoc comments as specified in the BagInterface.
    // Which SOLID principles is being applied here?


}
