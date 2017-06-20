package jm.mind.conference2017.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jm.mind.conference2017.BaseApplication;
import jm.mind.conference2017.R;
import jm.mind.conference2017.objects.AboutItem;
import jm.mind.conference2017.objects.Conference;

import static java.security.AccessController.getContext;

/**
 * Adapter for the {@link jm.mind.conference2017.AboutActivity}
 * @author Arnaud Camus
 */
public class SpeakerAdapter extends BaseAdapter {

    Context context;
    List<Conference> speakerList;
    private ArrayList<Conference> arraylist;
    List<String> arrayListNames;


    public SpeakerAdapter(Context context, List<Conference> speakerList) {
        this.context = context;
        this.speakerList = speakerList;
        this.arraylist = new ArrayList<Conference>();
        this.arraylist.addAll(speakerList);
    }


    @Override
    public int getCount() {
        if (speakerList==null){
            return 0;
        }
        return speakerList.size();
    }

    @Override
    public Object getItem(int position) {
      if(speakerList==null){
          return 0;
      }
      return speakerList.get(position);
    }

    @Override
    public long getItemId(int position) {

        if(speakerList==null){
            return 0;
        }
        return speakerList.indexOf(getItem(position));

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        Conference conference = speakerList.get(position);
        convertView = null;

        if(convertView==null){

            convertView = mInflater.inflate(R.layout.list_iteml, null);

            TextView speaker = (TextView) convertView.findViewById(R.id.speaker);
            speaker.setText(conference.getSpeaker());

            Picasso.with(context)
                    .load(conference.getSpeakerImageUrl())
                    .transform(((BaseApplication) context.getApplicationContext()).mPicassoTransformation)
                    .into((ImageView) convertView.findViewById(R.id.imageView3));


        }
        return convertView;
    }


}
