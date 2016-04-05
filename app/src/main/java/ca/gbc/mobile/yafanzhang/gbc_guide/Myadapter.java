package ca.gbc.mobile.yafanzhang.gbc_guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yafanzhang on 14-11-07.
 */
public class Myadapter extends ArrayAdapter<campus> {
    public Myadapter(Context context, ArrayList<campus> restaurants) {
        super(context, R.layout.row_layout,restaurants);
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent)
    {
        campus campus=getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }


        TextView name =
                (TextView)convertView.findViewById(R.id.textView);
        ImageView image =
                (ImageView)convertView.findViewById(R.id.imageView);

        name.setText(campus.name);
        image.setBackgroundResource(campus.image);
        return convertView;
    }
}
