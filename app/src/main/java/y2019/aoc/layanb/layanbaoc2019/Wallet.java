package y2019.aoc.layanb.layanbaoc2019;

import java.util.ArrayList;

public class Wallet {

    private String Name;
    private double Income;
    private double Outcome;
    private ArrayList Budget;

    public Wallet(){

    }

    public Wallet(String Name,double income,double outcome,ArrayList Budget){

        this.Name=Name;
        this.Income=income;
        this.Outcome=outcome;
        this.Budget=Budget;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getIncome() {
        return Income;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public double getOutcome() {
        return Outcome;
    }

    public void setOutcome(double outcome) {
        Outcome = outcome;
    }

    public ArrayList getBudget() {
        return Budget;
    }

    public void setBudget(ArrayList budget) {
        Budget = budget;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "Name='" + Name + '\'' +
                ", Income=" + Income +
                ", Outcome=" + Outcome +
                ", Budget=" + Budget +
                '}';
    }
}
