package nitt.hackathon.oxytrees;

//import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


import nitt.hackathon.oxytrees.Tab.MyAdapter;
import nitt.hackathon.oxytrees.Tab.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private Drawer.Result result;
    private AccountHeader.Result headerNavigationLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager=(ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.global_color_green_primary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

        //===================================================================================

        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.nav1)
                .addProfiles(
                        new ProfileDrawerItem().withName("Kumar Paritosh").withEmail("kpritosh98@gmail.com").withIcon(getResources().getDrawable(R.drawable.me))
                )
                .build();

        /*
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                //.withOnDrawerItemClickListener()
                .build();

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(getResources().getDrawable(R.drawable.home)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(2).withName("profile").withIcon(getResources().getDrawable(R.drawable.profile)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(3).withName("Thanks Bucket").withIcon(getResources().getDrawable(R.drawable.thanks)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(4).withName("My Trees").withIcon(getResources().getDrawable(R.drawable.mine)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(5).withName("Create Events").withIcon(getResources().getDrawable(R.drawable.event)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(6).withName("Oxygen Consumption").withIcon(getResources().getDrawable(R.drawable.oxygen)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withIdentifier(7).withName("About Us").withIcon(getResources().getDrawable(R.drawable.about)));

       */

        PrimaryDrawerItem i1 =new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(getResources().getDrawable(R.drawable.home));
        PrimaryDrawerItem i2 =new PrimaryDrawerItem().withIdentifier(2).withName("profile").withIcon(getResources().getDrawable(R.drawable.profile));
        PrimaryDrawerItem i3 =new PrimaryDrawerItem().withIdentifier(3).withName("Thanks Bucket").withIcon(getResources().getDrawable(R.drawable.thanks));
        PrimaryDrawerItem i4 =new PrimaryDrawerItem().withIdentifier(4).withName("My Trees").withIcon(getResources().getDrawable(R.drawable.trees));
        PrimaryDrawerItem i5 =new PrimaryDrawerItem().withIdentifier(5).withName("Create Events").withIcon(getResources().getDrawable(R.drawable.event));
        PrimaryDrawerItem i6 =new PrimaryDrawerItem().withIdentifier(6).withName("Oxygen Consumption").withIcon(getResources().getDrawable(R.drawable.oxygen));
        PrimaryDrawerItem i7 =new PrimaryDrawerItem().withIdentifier(7).withName("About Us").withIcon(getResources().getDrawable(R.drawable.about));


        result = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                //.withOnDrawerItemClickListener()
                .addDrawerItems(i1,i2,i3,i4,i5,i6,i7)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem)
                    {


                        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                        //int x = drawerItem.getIdentifier();
                        switch (position)
                        {

                            case 0:
                                //Toast.makeText(getApplicationContext(),"okay",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                                // fragmentManager.beginTransaction()
                                //    .replace(R.id.content, new FriendFragment()).commit();

                                break;
                            case 1:
                                Intent j = new Intent(getApplicationContext(), profile.class);
                                startActivity(j);
                                //Toast.makeText(getApplicationContext(),"dekh le",Toast.LENGTH_SHORT).show();

                                break;
                            case 2:
                                Intent k = new Intent(getApplicationContext(), Thanks.class);
                                startActivity(k);
                                break;
                            case 3:
                                Intent l = new Intent(getApplicationContext(), MyTree.class);
                                startActivity(l);
                                break;
                            case 4:
                                Intent m = new Intent(getApplicationContext(), createEvents.class);
                                startActivity(m);
                                break;
                            case 5:
                                Intent n = new Intent(getApplicationContext(), Pollution.class);
                                startActivity(n);
                                break;
                            case 6:
                                Intent p = new Intent(getApplicationContext(), AboutUs.class);
                                startActivity(p);
                                break;

                        }


                    }
                })
                .build();


        //=======================================================================================================
//        bottomBar =(BottomBar)findViewById(R.id.bottombar);
//        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
//            Fragment fragment = null;
//            @Override
//            public void onTabSelected(@IdRes int tabId) {
//                if (tabId == R.id.tab_home){
//                    fragment = new HomeFragment();
//                }else if (tabId == R.id.tab_explore){
//                    fragment = new ExploreFragment();
//                }else if (tabId ==R.id.tab_chat){
//                    fragment = new ChatFragment();
//                }else if (tabId==R.id.tab_friends){
//                    fragment = new FriendFragment();
//                }
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.content, fragment)
//                        .commit();
//            }
//        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

