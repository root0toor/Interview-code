import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> {
    private LinkedHashMap<K, V> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void display() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class Lru {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "Apple");
        cache.put(2, "Banana");
        cache.put(3, "Cherry");

        System.out.println("Initial cache contents:");
        cache.display();

        cache.put(4, "Durian"); // Adding an element beyond the capacity, which will trigger eviction

        System.out.println("\nCache contents after adding Durian:");
        cache.display();

        System.out.println("\nAccessing an element:");
        System.out.println(cache.get(2)); // Accessing Banana, which should bring it to the front

        System.out.println("\nCache contents after accessing Banana:");
        cache.display();
    }
}
