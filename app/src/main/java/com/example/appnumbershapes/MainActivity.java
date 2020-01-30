package com.example.appnumbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public class Number{
        public int val;
        public boolean triangle = false;
        public boolean square = false;

        public boolean isTriangle(){
            double triangleVal = (-1+Math.sqrt(1+4*2*val))/2;
            return triangleVal == Math.floor(triangleVal);
        }

        public boolean isSquare(){
            double squareVal = Math.sqrt(val);
            return squareVal == Math.floor(squareVal);
        }
    }

    public void verifyAppShapes(View view){
        EditText input = (EditText)findViewById(R.id.editText);
        Number num = new Number();
        num.val = Integer.parseInt(input.getText().toString());

        if(num.val > 0){
            String message;

            if(num.isTriangle() && num.isSquare())
                message = num.val + " is a Triangle and a Square number";
            else if(num.isTriangle())
                message = num.val + " is a Triangle number";
            else if(num.isSquare())
                message = num.val + " is a Square number";
            else
                message = num.val + " is neither a Triangle or a Square number";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
        ((EditText)findViewById(R.id.editText)).setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
