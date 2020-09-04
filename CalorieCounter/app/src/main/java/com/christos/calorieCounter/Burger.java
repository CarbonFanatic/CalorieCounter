package com.christos.calorieCounter;

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCUITTO = 115;
    static final int KETCHUP = 15;
    static final int RELISH = 20;
    static final int MUSTARD = 30;
    static final int LETTUCE = 5;
    static final int TOMATOES = 10;
    static final int ONIONS = 7;
    static final int PICKLES = 3;

    int condiments;

    int meatCal;
    int cheeseCal;
    int hamCal;
    int sauceCal;


    public Burger() {
        meatCal = BEEF;
        cheeseCal = ASIAGO;
        hamCal = 0;
        sauceCal = 0;
        condiments = 0;

    }

    public void setMeatCal(int meatCal) {

        this.meatCal = meatCal;
    }

    public void setCheeseCal(int cheeseCal) {
        this.cheeseCal = cheeseCal;
    }

    public void setHamCal(int hamCal) {
        this.hamCal = hamCal;
    }

    public void setSauceCal(int sauceCal) {
        this.sauceCal = sauceCal;
    }

    public void addCondimentsCal(int val) {
        this.condiments += val;
    }

    public void removeCondimentsCal(int val) {
        this.condiments -= val;
    }

    public void clearHamCalories() {
        hamCal = 0;
    }


    public int getTotalCalories() {
        return meatCal + cheeseCal + hamCal + sauceCal + condiments;
    }
}
