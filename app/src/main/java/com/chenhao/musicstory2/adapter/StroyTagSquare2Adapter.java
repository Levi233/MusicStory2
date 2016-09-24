package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chenhao.musicstory2.R;
import com.chenhao.musicstory2.bean.StoryInfo;

import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StroyTagSquare2Adapter extends SingleViewAdapter<List<StoryInfo>>{

    public StroyTagSquare2Adapter(Context context, List<StoryInfo> storyInfos, int type, Handler handler) {
        super(context, storyInfos, type, handler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View view = convertView;
        if(view == null){
            holder = new Holder();
            view = getLayoutInflater().inflate(R.layout.tags_item, parent, false);
            holder.tag_1 = (TextView) view.findViewById(R.id.tag_1);
            holder.tag_2 = (TextView) view.findViewById(R.id.tag_2);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.tag_1.setText(getItem().get(0).getName());
        holder.tag_2.setText(getItem().get(1).getName());

        holder.tag_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), ((StoryInfo) getItem().get(0)).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.tag_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), ((StoryInfo) getItem().get(1)).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public static class Holder{
        TextView tag_1;
        TextView tag_2;
    }
}
