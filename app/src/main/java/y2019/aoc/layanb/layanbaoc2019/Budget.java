package y2019.aoc.layanb.layanbaoc2019;

import java.io.Serializable;

public class Budget implements Serializable {
    private String Name;
    private String BudFor;
    private double Goal;
    private double current;

    public Budget(String Name,String BudFor,double Goal) {

        this.Name = Name;
        this.BudFor = BudFor;
        this.Goal = Goal;
    }
    public Budget(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBudFor() {
        return BudFor;
    }

    public void setBudFor(String budFor) {
        BudFor = budFor;
    }

    public double getGoal() {
        return Goal;
    }

    public void setGoal(double goal) {
        Goal = goal;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "Name='" + Name + '\'' +
                ", BudFor='" + BudFor + '\'' +
                ", Goal=" + Goal +
                '}';
    }
}

