package com.christos.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare our view variable
    private RadioGroup meatRG;
    private RadioGroup cheeseRG;
    private CheckBox hamCBX;
    private CheckBox ketchupCBX;
    private CheckBox relishCBX;
    private CheckBox mustardCBX;
    private CheckBox lettuceCBX;
    private CheckBox tomatoesCBX;
    private CheckBox onionCBX;
    private CheckBox picklesCBX;
    private SeekBar sauceSBR;
    private TextView calorieTV;

    private Burger burger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        burger = new Burger();
        initialize();
        registerChangeListener();
    }

    private  RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int radioID) {
            switch (radioID){
                case R.id.radio_beef:
                    //do something
                    burger.setMeatCal(Burger.BEEF);
                    break;
                case R.id.radio_lamb:
                    //something again
                    burger.setMeatCal(Burger.LAMB);

                    break;
                case R.id.radio_ostrich:
                    burger.setMeatCal(Burger.OSTRICH);

                    break;
                case R.id.radio_cheddar:
                    burger.setCheeseCal(Burger.ASIAGO);
                    break;
                case R.id.radio_provolone:
                    burger.setCheeseCal(Burger.CREME_FRAICHE);
                    break;
            }
            displayCalories();
        }
    };

    private View.OnClickListener Checkboxlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            switch (view.getId()){

                case R.id.ham_checkbox:
                   if (checked) {
                       burger.setHamCal(Burger.PROSCUITTO);

                   }
                   else{
                       burger.clearHamCalories();

                }
                    break;
                case R.id.ketchup_CheckBox:
                    if (checked) {
                        burger.addCondimentsCal(Burger.KETCHUP);

                    }
                    else {
                        burger.removeCondimentsCal(Burger.KETCHUP);
                    }
                    break;

                case R.id.relish_CheckBox:
                    if (checked) {
                        burger.addCondimentsCal(Burger.RELISH);
                    }
                    else{
                        burger.removeCondimentsCal(Burger.RELISH);
                    }
                    break;
                case R.id.mustard_CheckBox:
                    if(checked){
                        burger.addCondimentsCal(Burger.MUSTARD);
                    }
                    else {
                        burger.removeCondimentsCal(Burger.MUSTARD);
                    }
                    break;
                case R.id.lettuce_CheckBox:
                    if(checked){
                        burger.addCondimentsCal(Burger.LETTUCE);
                    }
                    else {
                        burger.removeCondimentsCal(Burger.LETTUCE);
                    }
                    break;
                case R.id.tomatoes_CheckBox:
                    if(checked){
                        burger.addCondimentsCal(Burger.TOMATOES);
                    }
                    else{
                        burger.removeCondimentsCal(Burger.TOMATOES);
                    }
                    break;
                case R.id.onions_CheckBox:
                    if(checked){
                        burger.addCondimentsCal(Burger.ONIONS);
                    }
                    else {
                        burger.removeCondimentsCal(Burger.ONIONS);
                    }
                    break;
                case R.id.pickles_CheckBox:
                    if(checked){
                        burger.addCondimentsCal(Burger.PICKLES);
                    }
                    else {
                        burger.removeCondimentsCal(Burger.PICKLES);
                    }

            }
            displayCalories();

        }

    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        burger.setSauceCal(seekBar.getProgress());
        displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private void initialize(){
        //find views an instantiate the reference variables
        meatRG = findViewById(R.id.meat_rgroup);
        cheeseRG = findViewById(R.id.cheese_rgroup);
        hamCBX = findViewById(R.id.ham_checkbox);
        sauceSBR = findViewById(R.id.sauce_seekbar);
        calorieTV = findViewById(R.id.calories_textview);
        ketchupCBX = findViewById(R.id.ketchup_CheckBox);
        relishCBX  = findViewById(R.id.relish_CheckBox);
        mustardCBX  = findViewById(R.id.mustard_CheckBox);
        lettuceCBX  = findViewById(R.id.lettuce_CheckBox);
        tomatoesCBX  = findViewById(R.id.tomatoes_CheckBox);
        onionCBX =  findViewById(R.id.onions_CheckBox);
        picklesCBX  = findViewById(R.id.pickles_CheckBox);

        displayCalories();
    }

    private void displayCalories(){
        String calorieText = "Calories: " +burger.getTotalCalories();
        calorieTV.setText(calorieText);
    }
    private void registerChangeListener(){
        meatRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        hamCBX.setOnClickListener(Checkboxlistener);
        ketchupCBX.setOnClickListener(Checkboxlistener);
        relishCBX.setOnClickListener(Checkboxlistener);
        mustardCBX.setOnClickListener(Checkboxlistener);
        lettuceCBX.setOnClickListener(Checkboxlistener);
        tomatoesCBX.setOnClickListener(Checkboxlistener);
        onionCBX.setOnClickListener(Checkboxlistener);
        picklesCBX.setOnClickListener(Checkboxlistener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }
}