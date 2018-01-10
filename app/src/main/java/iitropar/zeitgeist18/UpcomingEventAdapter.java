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


public class UpcomingEventAdapter extends RecyclerView.Adapter<UpcomingEventAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<Event> eventList;
    private FragmentManager fragmentManager ;



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name , description , venue , time ;

        public ViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.current_name);
            venue = view.findViewById(R.id.current_venue);
            time =  view.findViewById(R.id.current_time);
            description = view.findViewById(R.id.current_description);

        }
    }

    public UpcomingEventAdapter(Context context, ArrayList<Event> eventList , FragmentManager fragmentManager){
        this.context = context;
        this.eventList = eventList;
        this.fragmentManager = fragmentManager ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_event_card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Event event = eventList.get(position);

        holder.name.setText(event.getEventName());
        holder.venue.setText(event.getEventVenue());
        holder.time.setText(event.getEventTime());
        holder.description.setText(event.getEventDescription());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }







}
