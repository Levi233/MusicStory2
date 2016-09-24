package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chenhao.musicstory2.ImageLoader;
import com.chenhao.musicstory2.R;
import com.chenhao.musicstory2.bean.StoryInfo;

import java.util.List;

/**
 * Created by chenhao on 2016/8/24.
 */
public class StoryFriendListAdapter extends SingleViewAdapter<List<StoryInfo>>{

    public StoryFriendListAdapter(Context context, List<StoryInfo> storyInfos, int type, Handler handler) {
        super(context, storyInfos, type, handler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        View view = convertView;
        if(view == null){
            holder = new Holder();
            view = getLayoutInflater().inflate(R.layout.list_item, parent, false);
            holder.imgview_1 = (ImageView) view.findViewById(R.id.friend_img_1);
            holder.imgview_2 = (ImageView) view.findViewById(R.id.friend_img_2);
            holder.imgview_3 = (ImageView) view.findViewById(R.id.friend_img_3);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        ImageLoader.getImageLoader().displayImage(getItem().get(0).getImg(),holder.imgview_1);
        ImageLoader.getImageLoader().displayImage(getItem().get(1).getImg(),holder.imgview_2);
        ImageLoader.getImageLoader().displayImage(getItem().get(2).getImg(),holder.imgview_3);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                BitmapFactory.Options opts = new BitmapFactory.Options();
//                opts.inSampleSize = 2;
//                final Bitmap bitmap = BitmapFactory.decodeFile(getItem().get(0).getImg(), opts);
//                final Bitmap bitmap2 = BitmapFactory.decodeFile(getItem().get(1).getImg(), opts);
//                final Bitmap bitmap3 = BitmapFactory.decodeFile(getItem().get(2).getImg(), opts);
//                getHandler().post(new Runnable() {
//                    @Override
//                    public void run() {
//                        holder.imgview_1.setImageBitmap(bitmap);
//
//                        holder.imgview_2.setImageBitmap(bitmap2);
//
//                        holder.imgview_3.setImageBitmap(bitmap3);
//                    }
//                });
//            }
//        }).start();
        return view;
    }

    public static class Holder{
        ImageView imgview_1;
        ImageView imgview_2;
        ImageView imgview_3;
    }
}
