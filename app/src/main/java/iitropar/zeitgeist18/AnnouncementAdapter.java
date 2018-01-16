package iitropar.zeitgeist18;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;


public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<AnnouncementModel> dataList;




    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title , description  , time ;

        public ViewHolder(View view) {
            super(view);
            title =  view.findViewById(R.id.title);
            time =  view.findViewById(R.id.time);
            description = view.findViewById(R.id.description);

        }
    }

    public AnnouncementAdapter(Context context, ArrayList<AnnouncementModel> dataList ){
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.announcement_card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final AnnouncementModel data = dataList.get(position);
        // setting the value of perameter
        holder.title.setText(data.getTitle());
        holder.time.setText(data.getTime());
        holder.description.setText(data.getDescription());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
