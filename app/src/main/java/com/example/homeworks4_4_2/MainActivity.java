
package com.example.homeworks4_4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner langSpinner;
    private Spinner marginSpinner;
    private String item;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main);
        initViews();
        initSpinnerColor();
    }

    private void initViews() { //инициализация
        langSpinner = findViewById(R.id.spinner_lang);
        initSpinnerLang();
        langSpinner.setOnItemSelectedListener(itemLangsSelectedListener);

        marginSpinner = findViewById(R.id.spinner_indent);
        initSpinnerColor();
        marginSpinner.setOnItemSelectedListener(itemMarginsSelectedListener);
    }

    private void initSpinnerLang() {  //адаптер

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,R.array.language, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapterCountries);
    }

    private void initSpinnerColor() {  //адаптер

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.indents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marginSpinner.setAdapter(adapter);
    }

    AdapterView.OnItemSelectedListener itemLangsSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            // Получаем выбранный объект
             item = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener itemMarginsSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            // Получаем выбранный объект
            index = adapterView.getSelectedItemPosition();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public void onClick(View v) {

        if (item.equals(getString(R.string.LANG_ENGLISH_STRING))) {
            Locale locale = new Locale("en");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
       if  (item.equals(getString(R.string.LANG_RUS_STRING))) {
            Locale locale = new Locale("ru");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }

        switch (index) {
            case 1:
                Utils.changeToTheme(this, Utils.THEME_MARGIN1);
                break;
            case 2:
                Utils.changeToTheme(this, Utils.THEME_MARGIN3);
                break;
            case 3:
                Utils.changeToTheme(this, Utils.THEME_MARGIN10);
                break;
        }
    }
}