package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "Kim");
        map.put(2L, "Seo");
    }

    public static void main(String[] args) {
        findAndPrint(1L);
        findAndPrint(2L);
    }

    static void findAndPrint(Long id) {
        String name = findByName(id);

        if (name != null) System.out.println(id + ": " + name.toUpperCase());
        else System.out.println(id + ": " + "UNKNOWN");
    }

    private static String findByName(Long id) {
        return map.get(id);
    }
}
