package jm.mind.conference2017;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.ui.LibsActivity;

import java.util.ArrayList;

import jm.mind.conference2017.location.MapsActivity;
import jm.mind.conference2017.profile.ProfileModelHome;
import jm.mind.conference2017.social.FacebookActivity;
import jm.mind.conference2017.social.TweetActivity;
import jm.mind.conference2017.social.YoutubeActivity;

public class ContactActivity extends AppCompatActivity {

    private ListView lvProfilesm;
    private MyAppAdapter myAppAdapter;
    private ArrayList<ProfileModelHome> profileModelArrayList;

    FloatingActionButton fab_plus, fab_twitter, fab_facebook, fab_youtube;
    Animation FabOpen, FabClose, FabRClockwise, FabRAntiClockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profileModelArrayList = new ArrayList<>();
        profileModelArrayList.add(new ProfileModelHome("(876) 927-1761", "235A Old Hope Road\n" + "Kingston", R.drawable.pphone));
        profileModelArrayList.add(new ProfileModelHome("(876) 962-2183 ", "5 Perth Road,Mandeille\n" + "Manchester", R.drawable.pphone));
        profileModelArrayList.add(new ProfileModelHome("(876) 962-0428 ", "5 Perth Road,Mandeille\n" + "Manchester", R.drawable.pphone));
        profileModelArrayList.add(new ProfileModelHome("Website ", "http://www.mind.edu.jm/", R.drawable.webicon));
        profileModelArrayList.add(new ProfileModelHome("Email Us ", "marketing@mind.edu.jm", R.drawable.emaiicon));

        lvProfilesm = (ListView) findViewById(R.id.lblist);
        myAppAdapter = new MyAppAdapter(profileModelArrayList, getApplicationContext());
        lvProfilesm.setAdapter(myAppAdapter);
        lvProfilesm.setOnItemClickListener(new ItemList());

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });

        getSupportActionBar().setTitle("Contact Us");

        //---------------------- Floating Button--------------------------------
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_facebook = (FloatingActionButton) findViewById(R.id.fab_facebook);
        fab_twitter = (FloatingActionButton) findViewById(R.id.fab_twitter);
        fab_youtube = (FloatingActionButton) findViewById(R.id.fab_youtube);


        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRAntiClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_facebook.startAnimation(FabClose);
                    fab_twitter.startAnimation(FabClose);
                    fab_youtube.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRAntiClockwise);


                    fab_twitter.setClickable(false);
                    fab_facebook.setClickable(false);
                    fab_youtube.setClickable(false);
                    isOpen = false;

                } else {
                    fab_facebook.startAnimation(FabOpen);
                    fab_twitter.startAnimation(FabOpen);
                    fab_youtube.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);

                    fab_twitter.setClickable(true);
                    fab_facebook.setClickable(true);
                    fab_youtube.setClickable(true);
                    isOpen = true;

                }


            }

        });

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_facebook.startAnimation(FabClose);
                    fab_twitter.startAnimation(FabClose);
                    fab_youtube.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRAntiClockwise);


                    fab_twitter.setClickable(false);
                    fab_facebook.setClickable(false);
                    fab_youtube.setClickable(false);
                    isOpen = false;

                } else {
                    fab_facebook.startAnimation(FabOpen);
                    fab_twitter.startAnimation(FabOpen);
                    fab_youtube.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);

                    fab_twitter.setClickable(true);
                    fab_facebook.setClickable(true);
                    fab_youtube.setClickable(true);
                    isOpen = true;

                }


            }

        });


        fab_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this, FacebookActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                getSupportActionBar().setTitle("Facebook Feed");

            }

        });
        fab_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this, TweetActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                getSupportActionBar().setTitle("HEART Twitter Feed");
            }
        });
        fab_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this, YoutubeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();
                getSupportActionBar().setTitle("Youtube Feed");

            }
        });

    }

    public class MyAppAdapter extends BaseAdapter {

        public class ViewHolder {
            TextView username, country;
            ImageView profilePic;

        }

        public ArrayList<ProfileModelHome> profileList;

        public Context context;


        private MyAppAdapter(ArrayList<ProfileModelHome> apps, Context context) {
            this.profileList = apps;
            this.context = context;

        }

        @Override
        public int getCount() {
            return profileList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View rowView = convertView;
            MyAppAdapter.ViewHolder viewHolder;

            if (rowView == null) {
                LayoutInflater inflater = getLayoutInflater();
                rowView = inflater.inflate(R.layout.list_single, parent, false);

                viewHolder = new MyAppAdapter.ViewHolder();
                viewHolder.profilePic = (ImageView) rowView.findViewById(R.id.imgProfile);
                viewHolder.username = (TextView) rowView.findViewById(R.id.txtUsername);
                viewHolder.country = (TextView) rowView.findViewById(R.id.txtCountry);
                rowView.setTag(viewHolder);

            } else {
                viewHolder = (MyAppAdapter.ViewHolder) convertView.getTag();
            }

            viewHolder.username.setText(profileList.get(position).getUsername() + "");
            viewHolder.country.setText(profileList.get(position).getCountry() + "");
            Glide.with(getApplicationContext()).load(profileList.get(position).getProfilePic()).into(viewHolder.profilePic);

            return rowView;
        }
    }

    private class ItemList implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            if (i == 0) {

                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try{
                    Intent phoneDialerIntent= new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                }
                catch (Exception e)
                {
                }
            }

            else if (i == 1) {
                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try{
                    Intent phoneDialerIntent= new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                }
                catch (Exception e)
                {
                }

            }
            else if (i == 2) {
                ViewGroup vg = (ViewGroup) view;
                TextView tv = (TextView) vg.findViewById(R.id.txtUsername);
                Toast.makeText(ContactActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();


                try {
                    Intent phoneDialerIntent = new Intent(Intent.ACTION_DIAL);
                    phoneDialerIntent.setData(Uri.parse("tel:" + tv.getText().toString()));
                    startActivity(phoneDialerIntent);
                } catch (Exception e) {
                }
            }
            else if (i == 3) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.mind.edu.jm/"));
                startActivity(intent);

            }

            else if (i == 4) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"marketing@mind.edu.jm"});  //Heart Trust 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Add your Subject"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear MIND," + "");  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback/Query:"));
            }

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ContactActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        this.finish();
    }
}