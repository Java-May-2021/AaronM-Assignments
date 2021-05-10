import java.util.ArrayList;
import java.util.Arrays;

public class PuzzlingTester{
    public static void main(String[] args){
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        String[] names = {"Bill", "Ted", "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        Puzzling puzzle = new Puzzling();
        puzzle.sumAndGreater(arr);
        puzzle.names(names);
        puzzle.alphabet();
        puzzle.randArray();
        puzzle.sortArray();
        puzzle.randString();
        puzzle.stringArray();
    }
}