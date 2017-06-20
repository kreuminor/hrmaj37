package jm.mind.conference2017.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jm.mind.conference2017.R;
import jm.mind.conference2017.objects.AboutItem;

/**
 * Adapter for the {@link jm.mind.conference2017.AboutActivity}
 * @author Arnaud Camus
 */
public class SponsorAdapter extends ArrayAdapter<AboutItem> {

    public SponsorAdapter(Context context, int resource, List<AboutItem> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.adapter_about, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) v.findViewById(R.id.title);
            holder.subtitle = (TextView) v.findViewById(R.id.subtitle);
            holder.image = (ImageView) v.findViewById(R.id.image);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.title.setText(getItem(position).getTitle());
        holder.subtitle.setText(getItem(position).getSubtitle());
        holder.image.setImageResource(getItem(position).getDrawable());

        return v;
    }

    private class ViewHolder {
        TextView title;
        TextView subtitle;
        ImageView image;
    }
}
