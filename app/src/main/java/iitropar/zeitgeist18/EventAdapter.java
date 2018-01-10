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


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<Event> eventList;
    private FragmentManager fragmentManager ;
    private DBHandler dba ;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name , description , venue , time ;
        public CheckBox checkBox ;
        public Button register ;
        public ViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            venue = view.findViewById(R.id.venue);
            time =  view.findViewById(R.id.time);
            description = view.findViewById(R.id.description);
            checkBox = view.findViewById(R.id.checkbox);
            register = view.findViewById(R.id.register);
            dba = new DBHandler(context, null, null, 1);
        }
    }

    public EventAdapter(Context context, ArrayList<Event> eventList , FragmentManager fragmentManager){
        this.context = context;
        this.eventList = eventList;
        this.fragmentManager = fragmentManager ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_day_card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Event event = eventList.get(position);
        // setting the value of perameter
        holder.name.setText(event.getEventName());
        holder.venue.setText(event.getEventVenue());
        holder.time.setText(event.getEventTime());
        holder.description.setText(event.getEventDescription());
        if (event.isEventNotify() == true){
            holder.checkBox.setChecked(true);
        }
        else {
            holder.checkBox.setChecked(false);
        }



        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eventList.get(position).isEventNotify()){
                    holder.checkBox.setChecked(false);
                    eventList.get(position).setEventNotify(false);
                    dba.updateNotifiy(0,event.getEventPk());
                }
                else {
                    holder.checkBox.setChecked(true);
                    eventList.get(position).setEventNotify(true);
                    dba.updateNotifiy(1,event.getEventPk());
                }
            }
        });
        holder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String url = "https://www.facebook.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                  i.setData(Uri.parse(url));
                  context.startActivity(i);

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialogFragment userViewBS = EventBS.newInstance(event.getEventName(),event.getEventRules());
                userViewBS.show(fragmentManager, userViewBS.getTag());
            }
        });

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }






  
}
