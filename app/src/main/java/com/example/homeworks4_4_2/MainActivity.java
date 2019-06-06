
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
    private Spinner colorsSpinner;
    private String item;
    private String item1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() { //инициализация
        langSpinner = findViewById(R.id.spinner_lang);
        langSpinner.setOnItemSelectedListener(itemLangSelectedListener);
        initSpinnerLang();

        colorsSpinner = findViewById(R.id.spinner_indent);
        initSpinnerColor();
        colorsSpinner.setOnItemSelectedListener(itemColorsSelectedListener);
    }

    private void initSpinnerLang() {  //адаптер

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapterCountries);
    }

    private void initSpinnerColor() {  //адаптер

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.indents, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorsSpinner.setAdapter(adapterCountries);
    }

    AdapterView.OnItemSelectedListener itemLangSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            // Получаем выбранный объект
             item1 = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    AdapterView.OnItemSelectedListener itemColorsSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            // Получаем выбранный объект
            item = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public void onClick(View v) {

        if (item1.equals(getString(R.string.LANG_ENGLISH_STRING))) {
            Locale locale = new Locale("en");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }
       if  (item1.equals(getString(R.string.LANG_RUS_STRING))) {
            Locale locale = new Locale("ru");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        }

        // TODO Auto-generated method stub

        if (item.equals(getString(R.string.MARGIN1_RU)) ) {
            Utils.changeToTheme(this, Utils.THEME_MARGIN1);
        }
        if (item.equals(getString(R.string.MARGIN3_RU))) {
            Utils.changeToTheme(this, Utils.THEME_MARGIN3);
        }
        if (item.equals(getString(R.string.MARGIN10_RU))) {
            Utils.changeToTheme(this, Utils.THEME_MARGIN10);
        }
    }
}