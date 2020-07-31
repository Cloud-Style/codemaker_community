package com.codemaker.community.util;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * @author 马洁
 * @date 2020/7/30 - 20:49
 */
public class HttpUtil {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static final OkHttpClient client = new OkHttpClient();

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String assembleUrl(String url, Map<?, ?>data) {
        if (data.isEmpty()) {
            return url;
        }

        StringBuffer buffer = new StringBuffer(url);
        buffer.append('?');

        data.forEach((k, v) -> {
            buffer.append(k).append('=').append(v);
            buffer.append('&');
        });

        buffer.deleteCharAt(buffer.length() - 1);

        return buffer.toString();
    }
}
