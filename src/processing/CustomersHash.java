package processing;

import java.util.HashMap;
import java.util.Map;

public class CustomersHash {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public CustomersHash() {
        map.put("user2", 2);
        map.put("user1", 1);
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
