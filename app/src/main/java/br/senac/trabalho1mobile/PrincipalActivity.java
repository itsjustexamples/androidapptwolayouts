package br.senac.trabalho1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_activity);
        populateToClockIn();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateToClockIn();
    }

    private void populateToClockIn() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutToClockIn);
        int numberOfChildren = layout.getChildCount();
        int hour = new GregorianCalendar().get(Calendar.HOUR_OF_DAY);

        int clockPoints = hour > 12? hour-9: hour-8;

        if (clockPoints > 8 ) {
            clockPoints = 8;
        }

        for (int i = numberOfChildren; i < clockPoints; i++) {
            EditText editText = new EditText(this);
            editText.setHint(generateHint(i));
            editText.setSingleLine(true);
            layout.addView(editText);
        }
    }

    private String generateHint(int point) {
        point += 8;
        if (point > 11) {
            point++;
        }
        String inicialHour = String.valueOf(point);
        String finalHour = String.valueOf(point + 1);
        return String.format("%s:00 - %s:00", inicialHour, finalHour);
    }
}