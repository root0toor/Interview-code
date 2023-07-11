import java.util.HashMap;
import java.util.Map;

class CacheEntry {
    private final String key;
    private final String value;
    private final long creationTime;
    private long accessTime;
    private long expirationTime;

    public CacheEntry(String key, String value, long expirationTime) {
        this.key = key;
        this.value = value;
        this.creationTime = System.currentTimeMillis();
        this.accessTime = this.creationTime;
        this.expirationTime = expirationTime;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public boolean isExpired() {
        return expirationTime > 0 && System.currentTimeMillis() > expirationTime;
    }
}

class Cache {
    private final int capacity;
    private final Map<String, CacheEntry> cacheMap;

    public Cache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
    }

    public String get(String key) {
        CacheEntry entry = cacheMap.get(key);
        if (entry != null) {
            entry.setAccessTime(System.currentTimeMillis());
            return entry.getValue();
        }
        return null;
    }

    public void put(String key, String value, long expirationTime) {
        if (cacheMap.size() >= capacity) {
            evict();
        }
        CacheEntry entry = new CacheEntry(key, value, expirationTime);
        cacheMap.put(key, entry);
    }

    private void evict() {
        CacheEntry evictEntry = null;
        for (CacheEntry entry : cacheMap.values()) {
            if (evictEntry == null || entry.getAccessTime() < evictEntry.getAccessTime()) {
                evictEntry = entry;
            }
        }
        if (evictEntry != null) {
            cacheMap.remove(evictEntry.getKey());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a cache with a capacity of 3
        Cache cache = new Cache(3);

        // Put items into the cache
        cache.put("key1", "value1", -1);  // No expiration time
        cache.put("key2", "value2", 5000);  // Expiration time of 5 seconds
        cache.put("key3", "value3", -1);
        cache.put("key4", "value4", 10000);  // Expiration time of 10 seconds

        // Retrieve items from the cache
        System.out.println(cache.get("key1"));  // Output: value1
        System.out.println(cache.get("key2"));  // Output: value2
        System.out.println(cache.get("key3"));  // Output: value3
        System.out.println(cache.get("key4"));  // Output: null (expired)

        // Put additional items to trigger eviction
        cache.put("key5", "value5", -1);

        // Retrieve items again
        System.out.println(cache.get("key1"));  // Output: null (evicted)
        System.out.println(cache.get("key2"));  // Output: value2
        System.out.println(cache.get("key3"));  // Output: value3
        System.out.println(cache.get("key4"));  // Output: null (expired)
        System.out.println(cache.get("key5"));  // Output: value5
    }
}