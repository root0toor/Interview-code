import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private static CacheManager instance;
    private HashMap<Integer, String> cache;
    private HashMap<String, String[]> colorsCache;
    private String cacheFilePath;

    private CacheManager() {
        cache = new HashMap<>();
        colorsCache = new HashMap<>();
        cacheFilePath = "cache.ser"; // Specify the file path for cache serialization
    }

    public static CacheManager getInstance() {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager();
                }
            }
        }
        return instance;
    }

    public void addToCache(Integer key, String value) {
        cache.put(key, value);
    }

    public String getFromCache(Integer key) {
        return cache.get(key);
    }

    public void removeFromCache(Integer key) {
        cache.remove(key);
    }

    public void addToColorsCache(String key, String[] value) {
        colorsCache.put(key, value);
    }

    public String[] getFromColorsCache(String key) {
        return colorsCache.get(key);
    }

    public void removeFromColorsCache(String key) {
        colorsCache.remove(key);
    }

    public void serializeCache() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(cacheFilePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cache);
            objectOutputStream.writeObject(colorsCache);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Cache serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing cache: " + e.getMessage());
        }
    }

    public void deserializeCache() {
        try {
            File cacheFile = new File(cacheFilePath);
            if (cacheFile.exists()) {
                FileInputStream fileInputStream = new FileInputStream(cacheFilePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                cache = (HashMap<Integer, String>) objectInputStream.readObject();
                colorsCache = (HashMap<String, String[]>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                System.out.println("Cache deserialized successfully.");
            } else {
                System.out.println("No cache file found. Creating a new cache.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing cache: " + e.getMessage());
        }
    }

    public void printCache() {
        System.out.println("Cache contents:");
        for (Map.Entry<Integer, String> entry : cache.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }

    public void printColorsCache() {
        System.out.println("Colors Cache contents:");
        for (Map.Entry<String, String[]> entry : colorsCache.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + Arrays.toString(value));
        }
    }
}
