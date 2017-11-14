package de.shareyourtrip.split;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    ArrayList<User> userArrayList;
    final Context mainContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userArrayList = new ArrayList<>();
        userArrayList.add(new User("https://images.unsplash.com/photo-1482540922003-fc2c0fc25584?auto=format&fit=crop&w=1050&q=60&ixid=dW5zcGxhc2guY29tOzs7Ozs%3D", "Maksim"));
        userArrayList.add(new User("https://scontent-frx5-1.xx.fbcdn.net/v/t1.0-1/p160x160/23376534_255791651614864_5284965160774921343_n.jpg?oh=0752b8208643c475abcb9041c4225dea&oe=5AAEAD68", "Alicia"));
        userArrayList.add(new User("https://scontent-frx5-1.xx.fbcdn.net/v/t1.0-1/c0.0.160.160/p160x160/22688664_1674925662540750_5512430327364917880_n.jpg?oh=142fb4344289d100f29daa6fb10153c1&oe=5A992FDB", "Maksim2"));

        RecyclerView rv = findViewById(R.id.user_list_recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return new UserViewHolder(
                        LayoutInflater
                                .from(parent.getContext())
                                .inflate(R.layout.user_viewholder, parent, false));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
                UserViewHolder holder = (UserViewHolder) viewHolder;

                User currentUser = userArrayList.get(position);
                Picasso.with(mainContext).load(currentUser.getAvatarURL()).resize(64,64).into(holder.imageView);
//                Glide.with(mainContext).load(currentUser.getAvatarURL()).into(holder.imageView);
                holder.textView.setText(currentUser.getUserName());
            }

            @Override
            public int getItemCount() {
                return userArrayList.size();
            }

            class UserViewHolder extends RecyclerView.ViewHolder {
                ImageView imageView;
                TextView textView;

                public UserViewHolder(View itemView) {
                    super(itemView);

                    this.imageView = (ImageView)itemView.findViewById(R.id.user_picture);
                    this.textView = (TextView)itemView.findViewById(R.id.username);

                }
            }
        });
    }
}
