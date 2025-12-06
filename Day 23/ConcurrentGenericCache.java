import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentGenericCache<K, V> {

    private final ConcurrentHashMap<K, CacheEntry<V>> cache;
    private final long expirationMillis;
    private final ScheduledExecutorService cleanupScheduler;

    private static class CacheEntry<V> {
        final V value;
        final long expirationTime; // System.currentTimeMillis() + expirationMillis

        CacheEntry(V value, long expirationMillis) {
            this.value = value;
            this.expirationTime = System.currentTimeMillis() + expirationMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }
    }

    public ConcurrentGenericCache(long expirationMillis) {
        this(expirationMillis, 0); // No periodic cleanup by default
    }

    public ConcurrentGenericCache(long expirationMillis, long cleanupIntervalSeconds) {
        if (expirationMillis <= 0) {
            throw new IllegalArgumentException("Expiration time must be positive.");
        }
        this.expirationMillis = expirationMillis;
        this.cache = new ConcurrentHashMap<>();

        if (cleanupIntervalSeconds > 0) {
            cleanupScheduler = Executors.newSingleThreadScheduledExecutor();
            cleanupScheduler.scheduleAtFixedRate(this::cleanExpiredEntries,
                                                 cleanupIntervalSeconds,
                                                 cleanupIntervalSeconds,
                                                 TimeUnit.SECONDS);
        } else {
            cleanupScheduler = null;
        }
    }

    /**
     * Puts a key-value pair into the cache.
     *
     * @param key The key.
     * @param value The value.
     */
    public void put(K key, V value) {
        cache.put(key, new CacheEntry<>(value , expirationMillis));
    }

    /**
     * Retrieves a value from the cache.
     * If the entry is expired, it's removed and Optional.empty() is returned.
     *
     * @param key The key.
     * @return An Optional containing the value if found and not expired, otherwise Optional.empty().
     */
    public Optional<V> get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if(entry == null)
        {
            return Optional.empty();
            
        }
        if(entry.isExpired())
        {
            cache.remove(key);
            return Optional.empty();
        }
        return Optional.ofNullable(entry.value); // Placeholder
    }


    /**
     * Removes an entry from the cache.
     *
     * @param key The key to remove.
     * @return True if an entry was removed, false otherwise.
     */
    public boolean remove(K key) {
        // Your code here
        return cache.remove(key) != null; // Placeholder
    }

    /**
     * Performs a cleanup of expired entries.
     * This method can be called periodically or manually.
     */
    public void cleanExpiredEntries() {
        
        cache.entrySet().removeIf(entry->entry.getValue().isExpired());
    }

    /**
     * Returns the current size of the cache (including potentially expired entries).
     */
    public int size() {
        return cache.size();
    }

    /**
     * Shuts down the periodic cleanup scheduler if it's running.
     * Should be called when the cache is no longer needed to prevent resource leaks.
     */
    public void shutdown() {
        if (cleanupScheduler != null) {
            cleanupScheduler.shutdownNow();
        }
    }
}