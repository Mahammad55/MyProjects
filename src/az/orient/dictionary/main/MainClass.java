package az.orient.dictionary.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        Map<String,String> stringMap =new HashMap<>();
        stringMap.put("salam","hello");
        stringMap.put("kitab","book");
        System.out.println(stringMap.entrySet());
        for (Map.Entry<String, String> entry: stringMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
