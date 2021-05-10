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
        int firstLetter = vowels.indexOf(alphabet.get(0));

        if(firstLetter > -1)
            message = "The first letter is a vowel. The last letter is ";
        System.out.println(message + alphabet.get(25));
    }

    public static void randArray() {
        int[] numList = new int[10];
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            numList[i] =r.nextInt(46)+55;
        }
        System.out.println(Arrays.toString(numList));
    }

    public static void sortArray(){
        int[] numList = new int[10];
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            numList[i] =r.nextInt(46)+55;
        }
        Arrays.sort(numList);
        System.out.println(Arrays.toString(numList));
        System.out.println("The Minimum is: " + numList[0]);
        System.out.println("The Maximum is: " + numList[9]);
    }

    public static void randString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            int index = rnd.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println(randomString);
    }

    public static void stringArray(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String[] stringArray = new String[10];
        for(int j = 0; j < 10; j++){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++){
                int index = rnd.nextInt(chars.length());
                char randomChar = chars.charAt(index);
                sb.append(randomChar);
            }
        String randomString = sb.toString();
        stringArray[j] = randomString;
        }
        System.out.println(Arrays.toString(stringArray));

    }

}