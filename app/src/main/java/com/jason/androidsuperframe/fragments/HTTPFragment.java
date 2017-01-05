package com.jason.androidsuperframe.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason.androidsuperframe.R;
import com.jason.superframe.base.SuperFragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：AndroidSuperFrame
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * 创建人：JasonGao
 * 创建日期：2017/1/4.10:32
 */

public class HTTPFragment extends SuperFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_http_fragment, container, false);
        return v;
    }

    private void get(String url) {
        OkHttpClient oc = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("", "")
                .build();
        oc.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
