package com.kazimasum.firebasefragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdapterStudent extends FirebaseRecyclerAdapter<AddClassStudent, AdapterStudent.myviewholder>
{

    public AdapterStudent(@NonNull FirebaseRecyclerOptions<AddClassStudent> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final AddClassStudent model) {
      holder.nametext.setText(model.getName());
      holder.coursetext.setText(model.getCourse());
      holder.emailtext.setText(model.getEmail());
      Glide.with(holder.img1.getContext()).load(model.getPurl()).into(holder.img1);

              holder.img1.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      AppCompatActivity activity=(AppCompatActivity)view.getContext();
                      activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new descfragment(model.getName(),model.getCourse(),model.getEmail(),model.getPurl())).addToBackStack(null).commit();
                  }
              });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView nametext,coursetext,emailtext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            nametext=itemView.findViewById(R.id.nametext);
            coursetext=itemView.findViewById(R.id.coursetext);
            emailtext=itemView.findViewById(R.id.emailtext);
        }
    }

}
