package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

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
        Optional<String> optName = findByName(id);
        String name = optName.orElse("UNKNOWN");
        System.out.println(id + ": " + name.toUpperCase());
    }

    static Optional<String> findByName(Long id) {
        String findName = map.get(id);
        Optional<String> optName = Optional.ofNullable(findName);

        return optName;
    }
}
