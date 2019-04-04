package com.codepath.parseinstagram;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.codepath.parseinstagram.Fragments.ComposeFragment;
import com.codepath.parseinstagram.Fragments.PostsFragment;
import com.codepath.parseinstagram.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private final String TAG="MainActivity";

    private BottomNavigationView bottomNavigationView;

//    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
 //   public String photoFileName = "photo.jpg";
 //   private File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager=getSupportFragmentManager();

        bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        fragment=new PostsFragment();
                    //    Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT);
                        break;
                    case R.id.action_compose:
                        fragment=new ComposeFragment();
                    //    Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT);
                        break;
                    //case R.id.action_Profile:
                    default:
                        fragment=new ProfileFragment();
                    //    Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT);
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_compose);
    }
}
