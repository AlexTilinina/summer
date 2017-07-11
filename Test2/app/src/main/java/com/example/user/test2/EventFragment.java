package com.example.user.test2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.07.2017.
 */

public class EventFragment extends Fragment implements EventAdapter.OnEventClickListener {

    List<Event> list;
    RecyclerView.LayoutManager layoutManager;
    EventAdapter adapt;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createList();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapt = new EventAdapter(list, this);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createList(){
        list = new ArrayList<>();
        list.add(new Event("One", "olololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("1One", "ollolo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("O2ne", "ololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On3e", "oololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("One4", "ollo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On5e", "ollo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On6e", "olo00000lolo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("One", "olololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("1One", "ollolo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("O2ne", "ololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On3e", "oololo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("One4", "ollo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On5e", "ollo", "http://i.imgur.com/DvpvklR.png"));
        list.add(new Event("On6e", "olo00000lolo", "http://i.imgur.com/DvpvklR.png"));
    }

    @Override
    public void onEventClick(Event event) {
        Toast.makeText(getContext(), "Тык", Toast.LENGTH_SHORT).show();
    }
}
