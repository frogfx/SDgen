package au.com.anthonybruno.generator;

import au.com.anthonybruno.generator.defaults.*;

import java.util.HashMap;
import java.util.Map;

public class GeneratedValue<T> {

    private final Class<T> type;
    private T value;

    private static final Map<Class<?>, Generator<?>> defaultGenerators = getDefaultGenerators();

    public GeneratedValue(Class<T> type) {
        this.type = type;
    }

    public T get() {
        if (value == null) {
            Generator<?> generator = defaultGenerators.get(type);
            if (generator == null) {
                throw new RuntimeException("No generator for type: " + type);
            }
            value = (T) generator.generate();
        }
        return value;
    }

    private static Map<Class<?>, Generator<?>> getDefaultGenerators() {
        Map<Class<?>, Generator<?>> map = new HashMap<>();
        map.put(String.class, new StringGenerator());
        map.put(int.class, new IntGenerator());
        map.put(boolean.class, new BooleanGenerator());
        map.put(char.class, new CharGenerator());
        map.put(double.class, new DoubleGenerator());
        map.put(long.class, new LongGenerator());
        map.put(short.class, new ShortGenerator());
        return map;
    }
}