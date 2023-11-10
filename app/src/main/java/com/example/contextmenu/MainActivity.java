package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private EditText editText;
    private static final int PASTE = 1;
    private static final int APPEND = 2;
    private static final int UPPER = 3;
    private static final int COPY = 4;
    private static final int CUT = 5;
    private String text=" ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
        editText = findViewById(R.id.edtText);

        registerForContextMenu(txtView);
        registerForContextMenu(editText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        mt("onCreateContextMenu");

        if(v==txtView){
            menu.add(1,PASTE,0,"Paste");
            menu.add(1,APPEND,0,"Append");
            menu.add(1,UPPER,0,"Upper");
        }
        if(v==editText){
            menu.add(2,COPY,0,"Copy");
            menu.add(2,CUT,0,"Cut");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case PASTE:
                txtView.setText(text);
                break;
            case APPEND:
                txtView.append(text);
                break;
            case UPPER:
                txtView.setText(txtView.getText().toString().toUpperCase());
                break;
            case COPY:
                text = editText.getText().toString();
                break;
            case CUT:
                text = editText.getText().toString();
                editText.setText(" ");
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void mt(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
