package com.thiman.android.reservationmanager10;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button checkIn;
    Button checkOut;
    Button search,rincre,rdecre,aincre,adecre,cincre,cdecre;
    ElegantNumberButton elegantBtnroom,elegantBtnadult,elegantBtnchild;
    DatePickerDialog picker;
    TextView tvci,tvco,noroom,noadult,nochild,noroom1,noadult1,nochild1;
    int room = 1,adult = 1,child = 1;

    Animation fadeIn;
    RelativeLayout rl1;
    LinearLayout ll2;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fadeIn = AnimationUtils.loadAnimation(this,R.anim.imageanim);
        rl1 = findViewById(R.id.home);
        rl1.setAnimation(fadeIn);
        ll2 = findViewById(R.id.ll2);
        rl1.setAnimation(fadeIn);
        search = findViewById(R.id.search1);
        search.setAnimation(fadeIn);
        checkIn = findViewById(R.id.buttonci);
        checkOut = findViewById(R.id.buttonco);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setAnimation(fadeIn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
                intent.putExtra("sms_body", "Your Reservation has been Confirmed.Contact Us for more details.Thank You");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_booking:
                Intent bookingIntent = new Intent(Home.this,Booking.class);
//                //    Common.currentUser= user;
//              bookingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(bookingIntent);
                break;
//              finish();

            case R.id.nav_rooms:

                Intent availableIntent = new Intent(Home.this,AvailableRooms.class);
//                //    Common.currentUser= user;
//              availableIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(availableIntent);
                break;
//finish();

            case R.id.nav_RoomDe:
                Log.i("Tag :", "rd");
                Intent roomDetails = new Intent(Home.this,RoomDetails.class);
//                //    Common.currentUser= user;
//              availableIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(roomDetails);
                Log.i("Tag :", "intent RD");
                break;

            case R.id.nav_promo:


            case R.id.nav_reports:


            case R.id.nav_currency:


            case R.id.nav_settings:

            case R.id.nav_language:

            case R.id.nav_send:

            case R.id.nav_about:

            case R.id.nav_help:


            case R.id.nav_share:

            case R.id.nav_logout:
        }


//        if (id == R.id.nav_promo) {
//            // Handle the camera action
//        } else if (id == R.id.nav_booking) {
//
//        } else if (id == R.id.nav_rooms) {
//
//        } else if (id == R.id.nav_RoomDe) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void select(View view){
//        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this,AlertDialog.THEME_HOLO_DARK);
//        View selectView = getLayoutInflater().inflate(R.layout.select,null);
//
//        noroom = (TextView)findViewById(R.id.room);
//        noadult = (TextView)findViewById(R.id.adult);
//        nochild = (TextView)findViewById(R.id.child);
//
//        //final Intent roomitent=new Intent(getApplicationContext(),Home.class);
//
//           elegantBtnroom = (ElegantNumberButton)findViewById(R.id.numOfrooms);
//        elegantBtnroom.setOnClickListener(new ElegantNumberButton.OnClickListener() {
//                                             @Override
//                                            public void onClick(View view) {
//                                                  room = Integer.parseInt(elegantBtnroom.getNumber());
//                                                // Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
//////
//////        rincre = (Button)findViewById(R.id.increr) ;
//////        rdecre = (Button)findViewById(R.id.decrer) ;
//////        aincre = (Button)findViewById(R.id.increa);
//////        adecre = (Button)findViewById(R.id.decrea);
//////        cincre = (Button)findViewById(R.id.increc);
//////        cdecre = (Button)findViewById(R.id.decrec);
////
//                                             }
////
//       }) ;
//
//
//
//
//
//                builder.setView(selectView);
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//
//




    }








