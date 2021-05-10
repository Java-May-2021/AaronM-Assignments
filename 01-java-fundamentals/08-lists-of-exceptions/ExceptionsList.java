import java.util.ArrayList;

public class ExceptionsList {
    public static void exceptions(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for(int i = 0; i < myList.size(); i++) {
            try{
            Integer castedValue = (Integer) myList.get(i);
            }catch (ClassCastException e) {
                System.out.println("There was an error at index point: "+ i + ". In the attempt to add " + myList.get(i) + ". Error: " + e.toString());
            }
        }
    }
}
