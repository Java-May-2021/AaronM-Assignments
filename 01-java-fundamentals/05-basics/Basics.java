import java.util.ArrayList;
import java.util.Arrays;

public class Basics {
    public static void counter() {
        for (int i = 1; i <= 255; i++){
            System.out.println("Number:" + i);
        }
    }

    public static void odds(){
        for (int i = 1; i <= 255; i++){
            if(i % 2 != 0)
                System.out.println("Number:" + i);
        }
    }
    
    public static void sum(){
        int sum = 0;            
        for (int i = 1; i <= 255; i++){
                sum += i;
                System.out.println("Number:" + i + " Sum:" + sum);
        }
    }

    public static void iterate(int[] arr){
		for(int val: arr)
			System.out.println(val);
	}

    public static void max(int[] arr){
        int max = arr[0];
        for(int val: arr)
            if (val > max){
                max = val;
            }
            System.out.println("Max:" + max);       
    }

    public static void average(int[] arr){
        double sum = 0;
        for(int val: arr)
            sum += val;
        double average = sum/arr.length;
            System.out.println("Average:" + average);
    }

    public static void oddArray(){
        ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 1; i <= 255; i++)
            if(i % 2 != 0){
                list.add(i);
            }
            System.out.println(list);
    }

    public static void greaterThanY(int[] arr, int y){
        int greater = 0;
        for(int val: arr)
            if(y < val){
                greater +=1;
            }
        System.out.println("There are " + greater + " numbers greater than " + y);
    }

    public static void square(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i]*arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void noNegatives(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void maxMinAverage(int[] arr){
        ArrayList<Object> list = new ArrayList<Object>();
        int max = arr[0];
        int min = arr[0];
        double sum = 0;
        for(int val: arr){
            if (val > max){
                max = val;
            }
            if (val < min){
                min = val;
            }
            sum += val;
        }
        double average = sum/arr.length;
        list.add(max);
        list.add(min);
        list.add(average);
        System.out.println(list);
    }

    public static void shiftArray(int[] arr){
        int save = arr[0];
        for(int i = 1; i < arr.length; i++){
                arr[i-1] = arr[i];
            }
        arr[arr.length-1] = save;
        System.out.println(Arrays.toString(arr));
    }

}
// print 1-255
// print 1-255 odd
// print sum
// iterate through array
// find max
// get average
// array with odd
// greater than y
// square the values array
// eliminate negative numbers
// max min average
// shift the array
