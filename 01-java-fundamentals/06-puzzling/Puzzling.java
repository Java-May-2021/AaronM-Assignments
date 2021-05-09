import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class Puzzling {
    public static void sumAndGreater(int[] arr){
        ArrayList<Object> list = new ArrayList<Object>();
        int sum = 0;
        for(int val: arr){
            if (val > 10){
                list.add(val);
            }
            sum += val;
        }
        System.out.println("Sum of array is "+ sum + ". Numbers greater than 10: " +list);
    }

    public static void names(String[] names){
        String name = names[0];
        int arrayLength = names.length;
        int length = name.length();
        for(int i = 0; i < arrayLength; i++){
            name = names[i];
            length = name.length();
            if(length > 5){
                System.out.println(name + " is longer than 5 characters.");
            }
        }
        Collections.shuffle(Arrays.asList(names));
        System.out.println(Arrays.toString(names));
    }

    public static void alphabet() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        String message = "The first letter is not a vowel. The last letter is ";

        String vowels = "aeiouy";
        int a = vowels.indexOf(alphabet.get(0));

        if(a > -1)
            message = "The first letter is a vowel. The last letter is ";
        System.out.print(message + alphabet.get(25));
    }
}