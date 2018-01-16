package iitropar.zeitgeist18;

import java.util.ArrayList;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class EventWinnerAdapter extends BaseAdapter {
    public ArrayList<EventWinnerModel> winnerList;
    Activity activity;

    public EventWinnerAdapter(Activity activity, ArrayList<EventWinnerModel> winnerList) {
        super();
        this.activity = activity;
        this.winnerList = winnerList;
    }

    @Override
    public int getCount() {
        return winnerList.size();
    }

    @Override
    public Object getItem(int position) {
        return winnerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView eventName;
        TextView winner1;
        TextView winner2;
        TextView winner3 ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_event_winner_card, null);
            holder = new ViewHolder();
            holder.eventName =  convertView.findViewById(R.id.eventName);
            holder.winner1 =  convertView.findViewById(R.id.winner1);
            holder.winner2 = convertView.findViewById(R.id.winner2);
            holder.winner3 = convertView.findViewById(R.id.winner3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        EventWinnerModel item = winnerList.get(position);
        holder.eventName.setText(item.getEventName());
        holder.winner1.setText(item.getWinner1());
        holder.winner2.setText(item.getWinner2());
        holder.winner3.setText(item.getWinner3());
        return convertView;
    }

}