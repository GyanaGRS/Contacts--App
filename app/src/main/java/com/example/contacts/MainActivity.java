package com.example.contacts;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerContact= findViewById(R.id.recyclerContact);

        recyclerContact.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ContactModel> arrayContact= new ArrayList<>();

        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Aditya pati", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Debasis ray", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "jhansi igit", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "subrat sharma", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Loki", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Ajay kulangar", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "gyana kumar", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Tony Stark", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Black Panther", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "BLADE", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Thanos", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Deadpool", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Logan", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "HULK", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Wanda", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Vision", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "IronMan", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Spider Boy", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Thor", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Dare devil", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Captain America", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Chris Evans", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "ODIN", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Nick Furey", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Ultron", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon, "Wanda", "647283487"));
        arrayContact.add(new ContactModel(R.drawable.female_lawer_icon, "Doctor Strange", "647283487"));

        RecyclerContactAdapter adapter= new RecyclerContactAdapter(MainActivity.this,arrayContact);

        recyclerContact.setAdapter(adapter);

        //Float Button
        FloatingActionButton actionBtn= findViewById(R.id.actionBtn);

        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog= new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.activity_updation);

                EditText editContactName= dialog.findViewById(R.id.editContactName);
                EditText editContactNum= dialog.findViewById(R.id.editContactNum);
                AppCompatButton editBtn= dialog.findViewById(R.id.editBtn);

                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name= "", number="";

                        if(!editContactName.getText().toString().equals("")) {
                            name = editContactName.getText().toString();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "PLEASE ENTER THE CONTACT NAME", Toast.LENGTH_SHORT).show();
                        }
                        if(!editContactNum.getText().toString().equals("")) {
                            number = editContactNum.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this, "PLEASE ENTER THE CONTACT NUMBER", Toast.LENGTH_SHORT).show();
                        }

                        arrayContact.add(new ContactModel(R.drawable.male_lawer_icon,name,number));

                        adapter.notifyItemInserted(arrayContact.size());
                        recyclerContact.scrollToPosition(arrayContact.size()-1);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}