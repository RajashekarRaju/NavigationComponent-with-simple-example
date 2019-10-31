package com.developersbreach.navigator;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Navigator> mNavigatorList;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = view.findViewById(R.id.navigator_recycler_view);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
        NavigatorAdapter navigatorAdapter = new NavigatorAdapter(getContext(), mNavigatorList, new NavigatorListener());
        mRecyclerView.setAdapter(navigatorAdapter);
    }

    private class NavigatorListener implements NavigatorAdapter.NavigatorAdapterListener {

        @Override
        public void onNavigatorSelected(Navigator navigator, View view) {
            /*
             * Using Navigation object we find navigation controller with view then we will call
             * navigate with it's action name and pass argument to open correct item.
             * You can change this action name "actionListFragmentToDetailFragment" of your choice
             * in navigation.xml file and make both match properly.
             */
            NavDirections action = ListFragmentDirections.actionListFragmentToDetailFragment(navigator);
            Navigation.findNavController(view).navigate(action);
        }
    }

    private void loadData() {
        mNavigatorList = new ArrayList<>();
        mNavigatorList.add(new Navigator(R.drawable.ic_arrow_back, "Back"));
        mNavigatorList.add(new Navigator(R.drawable.ic_arrow_downward, "Downward"));
        mNavigatorList.add(new Navigator(R.drawable.ic_navigation, "Navigation"));
        mNavigatorList.add(new Navigator(R.drawable.ic_near_me, "Near me"));
        mNavigatorList.add(new Navigator(R.drawable.ic_arrow_forward, "Forward"));
        mNavigatorList.add(new Navigator(R.drawable.ic_arrow_upward, "Upward"));
        mNavigatorList.add(new Navigator(R.drawable.ic_chevron_left, "Chevron left"));
        mNavigatorList.add(new Navigator(R.drawable.ic_chevron_right, "Chevron right"));
        mNavigatorList.add(new Navigator(R.drawable.ic_expand_less, "Expand less"));
        mNavigatorList.add(new Navigator(R.drawable.ic_expand_more, "Expand more"));
        mNavigatorList.add(new Navigator(R.drawable.ic_first_page, "First page"));
        mNavigatorList.add(new Navigator(R.drawable.ic_last_page, "Last page"));
        mNavigatorList.add(new Navigator(R.drawable.ic_subdirectory_arrow_left, "Subdirectory left"));
        mNavigatorList.add(new Navigator(R.drawable.ic_subdirectory_arrow_right, "Subdirectory right"));
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_settings, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.menu_item_settings && getView() != null) {
            NavDirections action = ListFragmentDirections.actionListFragmentToSettingsFragment();
            Navigation.findNavController(getView()).navigate(action);
        }
        return super.onOptionsItemSelected(item);
    }

}
