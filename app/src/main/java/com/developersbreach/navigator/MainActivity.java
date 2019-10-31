package com.developersbreach.navigator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavController mNavigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationController  = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(mNavigationController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, mNavigationController, configuration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return mNavigationController.navigateUp();
    }
}
