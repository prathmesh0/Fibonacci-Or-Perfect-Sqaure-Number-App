package com.example.fibbonacciorperfectsquarenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    class Numbers{
        int num;
        //perfect square
        public boolean perfectSqr(){
            double sqRoot = (int) Math.sqrt(num);

            if(sqRoot*sqRoot == num){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean perfectSqr(int num){
            double sqRoot = (int) Math.sqrt(num);

            if(sqRoot*sqRoot == num){
                return true;
            }
            else{
                return false;
            }
        }

        //Fibonacci Numbers
        public boolean isFibonacci(){
            return (perfectSqr(5*num*num+4) || perfectSqr(5*num*num-4) );
        }

    }
    public void OnButtonClick(View view){
         EditText editText = findViewById(R.id.editTextNumberSigned);
         String Message ;

         if(editText.getText().toString().isEmpty()){
             Message = "Please enter proper number";
         }
         else {
             Numbers myNum = new Numbers();
             myNum.num = Integer.parseInt(editText.getText().toString());

             Message = editText.getText().toString();
             if (myNum.isFibonacci() && myNum.perfectSqr()) {
                 Message += " is Perfect Square and Fibonacci Number";
             } else if (myNum.perfectSqr()) {
                 Message += " is Perfect Square but not fibonacci Number";
             } else if (myNum.isFibonacci()) {
                 Message += "  is Fibonacci Number but not Perfect Square";
             } else {
                 Message += " is neither Perfect Square nor fibonacci Number";
             }
         }
        Snackbar.make(view,Message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}