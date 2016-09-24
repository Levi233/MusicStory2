package com.chenhao.musicstory2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenhao on 2016/8/28.
 */
public class ImageLoader {

    private static final String TAG = "ImageLoader";
    private static final int MAX_MEMORY_SIZE = 30 * 1024 * 1024;

    private ExecutorService mServices;
    private LruCache<String, Bitmap> mMemoryCache;
    private final Object mLock = new Object();

    private static ImageLoader mImageLoader = new ImageLoader();

    private ImageLoader() {

        mServices = Executors.newSingleThreadExecutor();
        mMemoryCache = new LruCache<String, Bitmap>(MAX_MEMORY_SIZE) {

            @Override
            protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
                Log.e(TAG,key + " is remove" );

            }

            @Override
            protected int sizeOf(String key, Bitmap value) {
                return getBitmapSize(value);
            }
        };
    }

    public static ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public final void displayImage(final String path, final ImageView imageView) {
        if (TextUtils.isEmpty(path) || imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.ic_launcher);
        Bitmap bitmap = getBitmap(path);
        if (bitmap == null) {
            mServices.submit(new Runnable() {
                @Override
                public void run() {
                    imageView.setTag(path);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    final Bitmap b = BitmapFactory.decodeFile(path, options);
                    addBitmap(path, b);
                    MainActivity.mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            String p = (String) imageView.getTag();
                            if (path.equals(p)) {
                                imageView.setImageBitmap(b);
                            }
                        }
                    });
                }
            });
        } else {
            imageView.setTag("");
            imageView.setImageBitmap(bitmap);
        }
    }

    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0; //ui 1.0 ab huawei npe
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public void addBitmap(String path, Bitmap bitmap) {
        synchronized (mLock) {
            if (TextUtils.isEmpty(path) || bitmap == null) {
                return;
            }
            if (mMemoryCache.get(path) == null) {
                mMemoryCache.put(path, bitmap);
            }
        }
    }

    public Bitmap getBitmap(String path) {
        synchronized (mLock) {
            if (!TextUtils.isEmpty(path)) {
                return mMemoryCache.get(path);
            }
        }
        return null;
    }

}
