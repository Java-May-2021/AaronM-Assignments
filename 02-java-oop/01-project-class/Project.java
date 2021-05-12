
public class Project {
    private String name;
    private String description;
    private double initialCost;

    public String getName(){
        return name;
    }
    public void project(String name){
        this.name = name;
    }
    public void project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getInitialCost(){
        return initialCost;
    }
    public void setInitialCost(double cost){
        initialCost = cost;
    }
    public String elevatorPitch(){
        return this.name + "($"+this.initialCost+"): " + this.description;
    }

}