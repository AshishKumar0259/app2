package my.fishdetection.Adepter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import my.fishdetection.R;
import my.fishdetection.model.recycleviewModel;

public class reycleviewAdepter extends RecyclerView.Adapter<reycleviewAdepter.viewholder> {
    ArrayList<recycleviewModel> fishlist;

    public reycleviewAdepter(ArrayList<recycleviewModel> fishlist) {
        this.fishlist = fishlist;
    }

    @NonNull
    @Override
    public reycleviewAdepter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);

        return new viewholder(view);
    }

    //change colour
    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull reycleviewAdepter.viewholder holder, int position) {

        holder.image1.setImageResource(fishlist.get(position).getImage());
        holder.text1.setText(fishlist.get(position).getTextview1());
        holder.text2.setText(fishlist.get(position).getTextview2());
        holder.text3.setText(fishlist.get(position).getTextview3());
        //change colour
        //holder.mcard.setCardBackgroundColor(holder.itemView.getResources().getColor(getrandamcolur(), null));

    }

    //change colour
    /*private int getrandamcolur() {
        List<Integer> colourCode = new ArrayList<>();
        colourCode.add(R.color.recy_colour_gray);
        colourCode.add(R.color.recy_colour_blue);
        colourCode.add(R.color.recy_colour_3);
        colourCode.add(R.color.recy_colour_4);
        colourCode.add(R.color.recy_colour_5);
        colourCode.add(R.color.recy_colour_6);
        Random random = new Random();
        int number = random.nextInt(colourCode.size());
        return colourCode.get(number);
    }*/

    @Override
    public int getItemCount() {
        return fishlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        private ImageView image1;
        private TextView text1;
        private TextView text2;
        private TextView text3;
        //CardView mcard;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.fish_image);
            text1 = itemView.findViewById(R.id.fish_name_val);
            text2 = itemView.findViewById(R.id.fish_cmn_val);
            text3 = itemView.findViewById(R.id.fish_dist_val);
            //change colour
            //mcard = itemView.findViewById(R.id.card);
        }

    }
}
