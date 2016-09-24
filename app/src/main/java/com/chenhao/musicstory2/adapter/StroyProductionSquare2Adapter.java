package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chenhao.musicstory2.ImageLoader;
import com.chenhao.musicstory2.R;
import com.chenhao.musicstory2.bean.StoryInfo;
import com.chenhao.musicstory2.bean.StoryProductionInfo;

import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StroyProductionSquare2Adapter extends SingleViewAdapter<List<StoryInfo>>{

    public StroyProductionSquare2Adapter(Context context, List<StoryInfo> storyInfos, int type, Handler handler) {
        super(context, storyInfos, type, handler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        View view = convertView;
        if(view == null){
            holder = new Holder();
            view = getLayoutInflater().inflate(R.layout.production_item, parent, false);
            holder.img_l = (ImageView) view.findViewById(R.id.production_img_1);
            holder.img_r = (ImageView) view.findViewById(R.id.production_img_2);
            holder.praise_l = (TextView) view.findViewById(R.id.praise_text_1);
            holder.praise_r = (TextView) view.findViewById(R.id.praise_text_2);
            holder.name_l = (TextView) view.findViewById(R.id.name_text_1);
            holder.name_r = (TextView) view.findViewById(R.id.name_text_2);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        final StoryProductionInfo info = (StoryProductionInfo) getItem().get(0);
        final StoryProductionInfo info2 = (StoryProductionInfo) getItem().get(1);
        holder.name_l.setText(getItem().get(0).getName());
        holder.name_r.setText(getItem().get(1).getName());
        holder.praise_l.setText(info.getPraise());
        holder.praise_l.setText(info2.getPraise());
        holder.name_l.setText(info.getName());
        holder.name_r.setText(info2.getName());
        holder.img_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), info.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.img_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), info2.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        ImageLoader.getImageLoader().displayImage(info.getImg(),holder.img_l);
        ImageLoader.getImageLoader().displayImage(info2.getImg(),holder.img_r);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                BitmapFactory.Options opts = new BitmapFactory.Options();
//                opts.inSampleSize = 2;
//                final Bitmap bitmap1 = BitmapFactory.decodeFile(info.getImg(),opts);
//                final Bitmap bitmap2 = BitmapFactory.decodeFile(info2.getImg(),opts);
//                getHandler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.img_l.setImageBitmap(bitmap1);
//                        holder.img_r.setImageBitmap(bitmap2);
//                    }
//                },0);
//            }
//        }).start();
        return view;
    }

    public static class Holder{
        ImageView img_l;
        ImageView img_r;
        TextView praise_l;
        TextView praise_r;
        TextView name_l;
        TextView name_r;
    }
}
