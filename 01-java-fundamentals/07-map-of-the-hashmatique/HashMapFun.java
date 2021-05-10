import java.util.Set;
import java.util.HashMap;

public class HashMapFun {
    public static void listForm(){
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("Changes", "Oh, yeah.. Mmm Still don't know what I was waitin' for");
        userMap.put("Oh! You Pretty Things", "Wake up, you sleepy head Put on some clothes");
        userMap.put("Eight Line Poem", "The tactful cactus by your window. Surveys the prairie of your room");
        userMap.put("Life on Mars?", "It's a God-awful small affair. To the girl with the mousy hair");
        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(userMap.get(key));   
        }
    }    
    public static void oneSong(String input){
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("Changes", "Oh, yeah.. Mmm Still don't know what I was waitin' for");
        userMap.put("Oh! You Pretty Things", "Wake up, you sleepy head Put on some clothes");
        userMap.put("Eight Line Poem", "The tactful cactus by your window. Surveys the prairie of your room");
        userMap.put("Life on Mars?", "It's a God-awful small affair. To the girl with the mousy hair");
        // get the keys by using the keySet method
        System.out.println(input);
        System.out.println(userMap.get(input));   
    }
}
