package com.christos.calorieCounter;

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCUITTO = 115;

    int meatCal;
    int cheeseCal;
    int hamCal;
    int sauceCal;

    public Burger() {
        meatCal = BEEF;
        cheeseCal = ASIAGO;
        hamCal = 0;
        sauceCal = 0;
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

    public void clearHamCalories(){
        hamCal=0;
    }
    public int getTotalCalories(){
        return meatCal + cheeseCal + hamCal + sauceCal;
    }
}
