import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Supplier;

// Define a Copyable interface
public interface Copyable<T> {
    T copy();
}

// Example class for demonstration
class MyItem implements Copyable<MyItem> {
    private String value;
    private int id;

    public MyItem(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public int getId() { return id; }

    @Override
    public MyItem copy() {
        return new MyItem(this.value, this.id); // Deep copy for primitive/immutable fields, or recursive for complex objects
    }

    @Override
    public String toString() {
        return "MyItem{value='" + value + "', id=" + id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyItem myItem = (MyItem) o;
        return id == myItem.id && value.equals(myItem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, id);
    }
}

public class CollectionDeepCopier {

    /**
     * Creates a deep copy of the given collection.
     * Each element in the original collection must implement the Copyable interface.
     *
     * @param original The collection to deep copy.
     * @param collectionFactory A supplier to create a new, empty collection of the desired type.
     * @param <T> The type of elements in the collection, must implement Copyable.
     * @param <C> The type of the collection.
     * @return A new collection of type C containing deep-copied elements.
     */
    public static <T extends Copyable<T>, C extends Collection<T>> C deepCopy(C original, Supplier<C> collectionFactory) {
        // Your code here

        C x = collectionFactory.get();
        for(T item : original)
        {
            T copyItem = item.copy();
            x.add(copyItem);
        }
        return x; // Placeholder
    }
}