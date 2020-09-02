package com.christos.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare our view variable
    private RadioGroup meatRG;
    private RadioGroup cheeseRG;
    private CheckBox hamCBX;
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
    private View.OnClickListener hamListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox) view).isChecked()){
                burger.setHamCal(Burger.PROSCUITTO);

            }
            else{
                //do something else
                burger.clearHamCalories();

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

        displayCalories();
    }

    private void displayCalories(){
        String calorieText = "Calories: " +burger.getTotalCalories();
        calorieTV.setText(calorieText);
    }
    private void registerChangeListener(){
        meatRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        hamCBX.setOnClickListener(hamListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }
}