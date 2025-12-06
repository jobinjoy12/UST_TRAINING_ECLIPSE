import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;

	public LRUCache(int capacity) {
		super(capacity + 1, 1.0f, true); // Access order = true
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		// Your code here
        return size() > capacity;
		
	}
}