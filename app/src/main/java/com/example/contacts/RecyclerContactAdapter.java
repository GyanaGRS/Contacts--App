package com.example.contacts;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContact;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact) {
        this.context= context;
        this.arrContact= arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel model= (ContactModel) arrContact.get(position);
        holder.imgContactLogo.setImageResource(arrContact.get(position).img);
        holder.txtContactNumber.setText(arrContact.get(position).number);
        holder.txtContactName.setText(arrContact.get(position).name);
        holder.contactLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog= new Dialog(context);
                dialog.setContentView(R.layout.activity_updation);

                EditText editContactName= dialog.findViewById(R.id.editContactName);
                EditText editContactNum= dialog.findViewById(R.id.editContactNum);
                AppCompatButton editBtn= dialog.findViewById(R.id.editBtn);

                //editContactName.setText(arrContact.get(position);
                //editContactNum.setText(arrContact.get(position).number);

                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name= "", number="";

                        if(!editContactName.getText().toString().equals("")) {
                            name = editContactName.getText().toString();
                        }
                        else{
                            Toast.makeText(context, "PLEASE ENTER THE CONTACT NAME", Toast.LENGTH_SHORT).show();
                        }
                        if(!editContactNum.getText().toString().equals("")) {
                            number = editContactNum.getText().toString();
                        }else {
                            Toast.makeText(context, "PLEASE ENTER THE CONTACT NUMBER", Toast.LENGTH_SHORT).show();
                        }

                        //arrContact.set(position,new ContactModel(R.drawable.male_lawer_icon,name, number));
                       // notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtContactName, txtContactNumber;
        ImageView imgContactLogo;
        LinearLayout contactLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtContactName= itemView.findViewById(R.id.txtContactName);
            txtContactNumber= itemView.findViewById(R.id.txtContactNumber);
            imgContactLogo= itemView.findViewById(R.id.imgContactLogo);
            contactLayout= itemView.findViewById(R.id.contactLayout);
        }
    }
}

