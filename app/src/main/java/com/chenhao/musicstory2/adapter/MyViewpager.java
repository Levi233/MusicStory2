package com.chenhao.musicstory2.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chenhao.musicstory2.ImageLoader;
import com.chenhao.musicstory2.bean.StoryInfo;

import java.util.ArrayList;


public class MyViewpager extends PagerAdapter {

	private Context mContext;
	private ArrayList<StoryInfo> mStoryInfos;
	private Handler mHandler = new Handler();
	
	public MyViewpager(Context context, ArrayList<StoryInfo> StoryInfos){
		this.mContext = context;
		this.mStoryInfos = StoryInfos;
	}
	
	public void setData(ArrayList<StoryInfo> StoryInfos){
		this.mStoryInfos = StoryInfos;
	}
	
	@Override
	public int getCount() {
		return mStoryInfos.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		final ImageView imageView = new ImageView(mContext);
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, mStoryInfos.get(position).toString(), Toast.LENGTH_SHORT).show();
			}
		});

		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		ImageLoader.getImageLoader().displayImage(mStoryInfos.get(position).getImg(),imageView);
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				BitmapFactory.Options opts = new Options();
//				opts.inSampleSize = 2;
//				final Bitmap bitmap = BitmapFactory.decodeFile(mStoryInfos.get(position).getImg(),opts);
//				mHandler.post(new Runnable() {
//					@Override
//					public void run() {
//						imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//						imageView.setImageBitmap(bitmap);
//					}
//				});
//			}
//		}).start();
		container.addView(imageView);
		return imageView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View)object);
	}
}
