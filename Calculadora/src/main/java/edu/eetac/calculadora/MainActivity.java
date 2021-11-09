package edu.eetac.calculadora;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView operationText ;
    TextView previousText ;
    TextView resultText;
    public double chainedResult;
    public String chainedNumber;
    public int lastOperation; //0->Sum, 1->Subst, 2->Multi, 3->Div, 4-> tg, 5-> cos, 6-> sin
    public int resultDone;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public Switch mySwitch;
    public int switchActive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.operationText = (TextView) findViewById(R.id.operationText);
        this.previousText = (TextView) findViewById(R.id.previousText);
        this.resultText = (TextView) findViewById(R.id.resultText);
        this.mySwitch = (Switch) findViewById(R.id.switchButton);
        this.chainedResult = 0;
        this.chainedNumber = "";
        this.resultDone = 0;
        this.switchActive = 0;
    }

    public void oneButtonClick(View view) {
        //Toast.makeText(this, "1 Button clicked", Toast.LENGTH_LONG).show();
        this.operationText.append("1");
        this.chainedNumber = this.chainedNumber + "1";
    }

    @SuppressLint("SetTextI18n")
    public void tanButtonClick(View view) {
        if (this.resultDone == 0) {
            if (this.chainedResult == 0) {
                this.operationText.setText("tan(" + this.operationText.getText() + ")");
                this.lastOperation = 4;
            } else {
                Toast.makeText(this, "Operation not permitted", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    public void acButtonClick(View view) {
        this.resultText.setText("");
        this.operationText.setText("");
        this.chainedResult = 0;
        this.chainedNumber = "";
        this.resultDone = 0;
    }

    @SuppressLint("SetTextI18n")
    public void cosButtonClick(View view) {
        if (this.resultDone == 0) {
            if (this.chainedResult == 0) {
                this.operationText.setText("cos(" + this.operationText.getText() + ")");
                this.lastOperation = 5;
            } else {
                Toast.makeText(this, "Operation not permitted", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void sinButtonClick(View view) {
        if (this.resultDone == 0) {
            if (this.chainedResult == 0) {
                this.operationText.setText("sin(" + this.operationText.getText() + ")");
                this.lastOperation = 6;
            } else {
                Toast.makeText(this, "Operation not permitted", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetTextI18n")
    public void equalButtonClick(View view) {
        this.resultText.setText("");
        if (this.lastOperation == 0){
            this.chainedResult = this.chainedResult + Double.parseDouble(this.chainedNumber);
        }
        else if (this.lastOperation == 1){
            this.chainedResult = this.chainedResult - Double.parseDouble(this.chainedNumber);
        }
        else if (this.lastOperation == 2){
            this.chainedResult = this.chainedResult * Double.parseDouble(this.chainedNumber);
        }
        else if (this.lastOperation == 3){
            this.chainedResult = this.chainedResult / Double.parseDouble(this.chainedNumber);
        }
        else if (this.lastOperation == 4){
            if (this.switchActive == 0) {
                this.chainedResult = Math.round(Math.tan(Math.toRadians(Double.parseDouble(this.chainedNumber))));
            }
            else{
                this.chainedResult = Math.round(Math.tan(Double.parseDouble(this.chainedNumber)));
            }
        }
        else if (this.lastOperation == 5){
            if (this.switchActive == 0) {
                this.chainedResult = Math.round(Math.cos(Math.toRadians(Double.parseDouble(this.chainedNumber))));
            }
            else{
                this.chainedResult = Math.round(Math.cos(Double.parseDouble(this.chainedNumber)));
            }
        }
        else if (this.lastOperation == 6){
            if (this.switchActive == 0) {
                this.chainedResult = Math.round(Math.sin(Math.toRadians(Double.parseDouble(this.chainedNumber))));
            }
            else{
                this.chainedResult = Math.round(Math.sin(Double.parseDouble(this.chainedNumber)));
            }
        }
        this.resultText.append(Double.toString(this.chainedResult));
        this.previousText.setText(Double.toString(this.chainedResult));
        this.resultDone = 1;
    }

    public void minusButtonClick(View view) {
        if (this.resultDone == 0) {
            this.operationText.append("-");
            if (this.chainedResult != 0) {
                if (this.lastOperation == 0) {
                    this.chainedResult = this.chainedResult + Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 1) {
                    this.chainedResult = this.chainedResult - Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 2) {
                    this.chainedResult = this.chainedResult * Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 3) {
                    this.chainedResult = this.chainedResult / Double.parseDouble(this.chainedNumber);
                }
            } else {
                this.chainedResult = Double.parseDouble(this.chainedNumber);
            }

            this.chainedNumber = "";
            this.lastOperation = 1;
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    public void plusButtonClick(View view) {
        if (this.resultDone == 0) {
            this.operationText.append("+");
            if (this.chainedResult != 0) {
                if (this.lastOperation == 0) {
                    this.chainedResult = this.chainedResult + Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 1) {
                    this.chainedResult = this.chainedResult - Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 2) {
                    this.chainedResult = this.chainedResult * Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 3) {
                    this.chainedResult = this.chainedResult / Double.parseDouble(this.chainedNumber);
                }
            } else {
                this.chainedResult = Double.parseDouble(this.chainedNumber);
            }
            this.chainedNumber = "";
            this.lastOperation = 0;
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    public void commaButtonClick(View view) {
        this.operationText.append(".");
    }

    public void eightButtonClick(View view) {
        this.operationText.append("8");
        this.chainedNumber = this.chainedNumber + "8";
    }

    public void sixButtonClick(View view) {
        this.operationText.append("6");
        this.chainedNumber = this.chainedNumber + "6";
    }

    public void nineButtonClick(View view) {
        this.operationText.append("9");
        this.chainedNumber = this.chainedNumber + "9";
    }

    public void multiplyButtonClick(View view) {
        if (this.resultDone == 0) {
            this.operationText.append("x");
            if (this.chainedResult != 0) {
                if (this.lastOperation == 0) {
                    this.chainedResult = this.chainedResult + Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 1) {
                    this.chainedResult = this.chainedResult - Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 2) {
                    this.chainedResult = this.chainedResult * Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 3) {
                    this.chainedResult = this.chainedResult / Double.parseDouble(this.chainedNumber);
                }
            } else {
                this.chainedResult = Double.parseDouble(this.chainedNumber);
            }
            this.chainedNumber = "";
            this.lastOperation = 2;
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    public void divButtonClick(View view) {
        if (this.resultDone == 0) {
            this.operationText.append("/");
            if (this.chainedResult != 0) {
                if (this.lastOperation == 0) {
                    this.chainedResult = this.chainedResult + Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 1) {
                    this.chainedResult = this.chainedResult - Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 2) {
                    this.chainedResult = this.chainedResult * Double.parseDouble(this.chainedNumber);
                } else if (this.lastOperation == 3) {
                    this.chainedResult = this.chainedResult / Double.parseDouble(this.chainedNumber);
                }
            } else {
                this.chainedResult = Double.parseDouble(this.chainedNumber);
            }
            this.chainedNumber = "";
            this.lastOperation = 3;
        }
        else{
            Toast.makeText(this, "Press AC first", Toast.LENGTH_LONG).show();
        }
    }

    public void twoButtonClick(View view) {
        this.operationText.append("2");
        this.chainedNumber = this.chainedNumber + "2";
    }

    public void sevenButtonClick(View view) {
        this.operationText.append("7");
        this.chainedNumber = this.chainedNumber + "7";
    }

    public void fourButtonClick(View view) {
        this.operationText.append("4");
        this.chainedNumber = this.chainedNumber + "4";
    }

    public void fiveButtonClick(View view) {
        this.operationText.append("5");
        this.chainedNumber = this.chainedNumber + "5";
    }

    public void threeButtonClick(View view) {
        this.operationText.append("3");
        this.chainedNumber = this.chainedNumber + "3";
    }

    public void zeroButtonClick(View view) {
        this.operationText.append("0");
        this.chainedNumber = this.chainedNumber + "0";
    }

    public void switchClick(View view) {
        if (this.mySwitch.isChecked()){
            this.switchActive = 1;
        }
        else{
            this.switchActive = 0;
        }
    }
}