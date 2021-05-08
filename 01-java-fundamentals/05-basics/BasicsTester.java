import java.util.ArrayList;
import java.util.Arrays;

public class BasicsTester{
    public static void main(String[] args){
        int y = 3;
        int[] arr = {1,2,3,4,5,6,7,-1};
        Basics fun = new Basics();
        fun.counter();
        fun.odds();
        fun.sum();
        fun.iterate(arr);
        fun.max(arr);
        fun.average(arr);
        fun.oddArray();
        fun.greaterThanY(arr, y);
        fun.square(arr);
        fun.noNegatives(arr);
        fun.maxMinAverage(arr);
        fun.shiftArray(arr);
    }
}
