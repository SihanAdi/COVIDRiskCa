package com.cs.covidriskca;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class InformationCollection extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
//    sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

    private EditText age;
    private EditText steps;
    private EditText height;
    private EditText weight;
    private Spinner state;
    private Spinner states;
    RadioGroup gender;
    RadioGroup medication ;
    RadioGroup vaccination;
    RadioGroup heart_disease;
    RadioGroup Lung_disease;
    RadioGroup diabetes ;
    RadioGroup cough;
    RadioGroup fever ;
    EditText budytemp;
    RadioGroup hspt;
    RadioGroup postive;
    Button btcal;
    Boolean al;
    boolean gender_man;
    int daily_step;//
    int vage;//
    int vheight;//
    int vweight;//
    boolean vmedication;
    boolean vaccination_status;

    boolean vheart_disease;
    boolean vLung_disease;
    boolean vdiabetes;
    boolean vaccination_status_1 =false;
    boolean vaccination_status_full =false;
    boolean vcough;
    boolean vfever;
    double body_temperature;//
    boolean go_to_hospital;
    boolean exposure_history;

    HashMap<String, String> map = new HashMap<String, String>();



    String city = "DC";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_collection);

        age =  findViewById(R.id.editTextName1);//
        steps =  findViewById(R.id.editTextName2);//
        height =  findViewById(R.id.editTextName3);//
        weight =  findViewById(R.id.editTextName4);//
        state =  findViewById(R.id.spinner_simple);////
        states =  findViewById(R.id.spinner_simple1);////
        gender =  findViewById(R.id.radioGroup);
        medication =  findViewById(R.id.radioGroup1);
        vaccination =  findViewById(R.id.radioGroup2);
        heart_disease =  findViewById(R.id.radioGroup13);
        Lung_disease =  findViewById(R.id.radioGroup113);
        diabetes =  findViewById(R.id.radioGroup1113);
        cough =  findViewById(R.id.radioGroup41);
        fever =  findViewById(R.id.radioGroup51);
        budytemp =  findViewById(R.id.editTextN3ame1);//
        hspt =  findViewById(R.id.radioGroup551);
        postive =  findViewById(R.id.radioGroup9551);
        btcal = findViewById(R.id.button);
        map.put("CA", "high");
        map.put("VA", "medium");
        map.put("WA","high");
        map.put("AK", "low");
        map.put("DC", "medium");


        btcal.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         System.out.println("点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了点了");
                                         daily_step =   Integer. parseInt(steps.getText().toString());
                                         vage = Integer. parseInt(age.getText().toString());
                                         vheight =Integer. parseInt(height.getText().toString());
                                         vweight = Integer. parseInt(weight.getText().toString());
                                         body_temperature = Integer. parseInt(budytemp.getText().toString());

                                         int score = 99835499;
                                         System.out.println("score is : "+score);
                                          score = analysis(city, gender_man, daily_step, vage, vheight, vweight, vmedication, vaccination_status, map,
                                                 vheart_disease, vLung_disease, vdiabetes,vaccination_status_1, vaccination_status_full, vcough, vfever,body_temperature,go_to_hospital,exposure_history);
                                         System.out.println("score is : "+score);
                                         Intent intent = new Intent(InformationCollection.this,Result.class);

                                         String ans = Integer.toString(score);
//                                         StringBuilder sb = new StringBuilder(1024);
//                                         sb.append("你大爷的分数是 ");
//                                         sb.append(ans);
//                                         ans = sb.toString();
                                         intent.putExtra("showdata",ans);
                                         startActivity(intent);





                                     }
                                 });


                postive.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radbtn = (RadioButton) findViewById(checkedId);

                        exposure_history = checkYN(radbtn.getText().toString());
                    }
                });





        hspt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                go_to_hospital = checkYN(radbtn.getText().toString());
            }
        });

        fever.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vfever = checkYN(radbtn.getText().toString());
            }
        });



        cough.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vcough = checkYN(radbtn.getText().toString());
            }
        });




        diabetes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vdiabetes = checkYN(radbtn.getText().toString());
            }
        });



        Lung_disease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vLung_disease = checkYN(radbtn.getText().toString());
            }
        });


        heart_disease.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vheart_disease = checkYN(radbtn.getText().toString());
            }
        });


        vaccination.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vaccination_status = checkYN(radbtn.getText().toString());
            }
        });


        medication.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);

                vmedication = checkYN(radbtn.getText().toString());
            }
        });


         int ans = 0;
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //当item被选择后调用此方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取我们所选中的内容
                String str = parent.getItemAtPosition(position).toString();

                str = (String) parent.getSelectedItem();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                //Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
                if ("male".equals(radbtn.getText())){
                    //gender_man =  true;
                    aaa();
                }
                else{

                }
            }
        });








    }














    public Boolean checkYN(String YN){
        if ("Yes".equals(YN)){
            return true;
        }
        else{
            return  false;
        }
    }
    public void aaa(){
        gender_man =  true;
        }



    public static int analysis(String city, boolean gender_man, int daily_step, int age, int height, int weight, boolean medication, boolean vaccination_status,
                               HashMap<String, String> map, boolean heart_disease, boolean Lung_disease, boolean diabetes,
                               boolean vaccination_status_1, boolean vaccination_status_full, boolean cough, boolean fever,
                               double body_temperature, boolean go_to_hospital, boolean exposure_history){
        int score = 0;
        if (fever == true){
            if (body_temperature >= 38.5){
                score += 10;
            }else{
                score += 5;
            }
        }
        if (cough == true){
            score += 5;
        }
        if (go_to_hospital == true){
            score += 3;
        }
        if (exposure_history == true){
            score += 20;
        }
        double BMI = weight / (height * height);
        if (BMI >= 30){
            score += 5;
        }
        if (age >= 50){
            score += 4;
        }
        if (gender_man == true){
            score += 1;
        }
        if (daily_step >= 10000){
            score -= 10;
        }
        else if (daily_step >= 5000 && daily_step < 10000){
            score += 5;
        }else{
            score += 10;
        }
        if (heart_disease == true){
            score += 10;
        }
        if (Lung_disease == true){
            score += 10;
        }
        if (diabetes == true){
            score += 10;
        }
        if (vaccination_status == true){
            if (vaccination_status_1 == true){
                score -= 10;
            }
            else if (vaccination_status_full == true){
                score -= 20;
            }
        }else{
            score += 20;
        }
        if (map.get(city) == "high"){
            score += 50;
        }
        else if (map.get(city) == "low"){
            score += 10;
        }else{
            score += 30;
        }
        return score;
    }

}