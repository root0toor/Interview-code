import java.util.HashMap;
import java.util.Map;

public class InMemoryRedisStorage {
    private static InMemoryRedisStorage instance;
    private Map<String, String> storage;

    private InMemoryRedisStorage() {
        storage = new HashMap<>();
    }

    public static InMemoryRedisStorage getInstance() {
        if (instance == null) {
            synchronized (InMemoryRedisStorage.class) {
                if (instance == null) {
                    instance = new InMemoryRedisStorage();
                }
            }
        }
        return instance;
    }

    public void set(String key, String value) {
        storage.put(key, value);
    }

    public String get(String key) {
        return storage.get(key);
    }

    public void delete(String key) {
        storage.remove(key);
    }
}
