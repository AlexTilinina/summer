package com.example.user.test2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{

    private List<Event> events;
    private OnEventClickListener listener;

    public EventAdapter(List<Event> events, OnEventClickListener listener) {
        this.events = events;
        this.listener = listener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.event_item,parent,false));
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {
        holder.eventName.setText(events.get(position).getDescription());
        holder.about.setText(events.get(position).getAbout());
        /*Picasso.with(holder.eventName.getContext())
                .load(events.get(position).getImage())
                .into(holder.imageView);*/
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEventClick(events.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{

        TextView eventName;
        TextView about;
        ImageView imageView;
        RelativeLayout relativeLayout;

        public EventViewHolder(View itemView) {
            super(itemView);
            eventName = (TextView) itemView.findViewById(R.id.about);
            about = (TextView) itemView.findViewById(R.id.about2);
            imageView = (ImageView) itemView.findViewById(R.id.event_im);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative);
        }
    }

    public interface OnEventClickListener {
        void onEventClick(Event event);
    }
}
