public class Calculator{
    private double num1;
    private double num2;
    private char operator;
    private double results;

    public Calculator(){

    }
    public void setNum1(double num1){
        this.num1=num1;
    }
    public void setNum2(double num2){
        this.num2=num2;
    }
    public void setOperator(char operator){
        this.operator = operator;
    }
    public void performOperation(){
        if (this.operator == '+'){
            results = (num1+num2);
        }
        if (this.operator == '-'){
            results = (num1-num2);
        }
        else{
            System.out.println("INVALID OPERATOR");
        }
    }
    public void getResults(){
        System.out.println(this.results);
    }
}