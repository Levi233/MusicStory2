package com.chenhao.musicstory2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.chenhao.musicstory2.adapter.StoryMultiTypeAdapter;
import com.chenhao.musicstory2.bean.Msg;
import com.chenhao.musicstory2.utils.IOUtils;
import com.chenhao.musicstory2.utils.ParserJson;

import org.json.JSONException;

import java.io.File;

public class MainActivity extends Activity {

    private ListView mListView;
    private LinearLayout mContentPage;
    private ProgressBar mLoading;
    private LinearLayout mErrorPage;
    private Button mRefreshTextView;
    private Msg msg;
    public static Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.List);
        mContentPage = (LinearLayout) findViewById(R.id.content_page);
        mLoading = (ProgressBar) findViewById(R.id.loading);
        mErrorPage = (LinearLayout) findViewById(R.id.error_page);
        mRefreshTextView = (Button) findViewById(R.id.refresh);
        initDataAndSetAdapter();
        isShowLoadingView();

        mRefreshTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mErrorPage.setVisibility(View.GONE);
                mLoading.setVisibility(View.VISIBLE);
                mRefreshTextView.setEnabled(false);
                initDataAndSetAdapter();
            }
        });
    }

    private void initDataAndSetAdapter() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File path = new File("/mnt/sdcard/gsll.json");
                String json = IOUtils.getFileData(path);
                ParserJson pj = new ParserJson(json);
                try {
                        msg = pj.parserMusicStoryJson();
                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setListAdapter(msg);
                                isShowLoadingView();
                            }
                        },1000);
                } catch (JSONException e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mRefreshTextView.setEnabled(true);
                            mContentPage.setVisibility(View.GONE);
                            mLoading.setVisibility(View.GONE);
                            mErrorPage.setVisibility(View.VISIBLE);
                        }
                    });
                }

            }
        }).start();
    }

    private void setListAdapter(Msg msg) {
        mListView.setAdapter(new StoryMultiTypeAdapter(MainActivity.this, msg, mHandler));
    }

    private void isShowLoadingView(){
        if(msg == null){
            mContentPage.setVisibility(View.GONE);
            mLoading.setVisibility(View.VISIBLE);
        }else{
            mContentPage.setVisibility(View.VISIBLE);
            mLoading.setVisibility(View.GONE);
        }
    }
}
