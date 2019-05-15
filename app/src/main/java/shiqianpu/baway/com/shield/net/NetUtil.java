package shiqianpu.baway.com.shield.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import shiqianpu.baway.com.shield.MyApplication;

public class NetUtil {
    private static final NetUtil ourInstance = new NetUtil();

    public static NetUtil getInstance() {
        return ourInstance;
    }
    private NetUtil() {
    }
    public void doHttpGet(final String url,final CallBackTask backTask){
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backTask.onSuccess(response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backTask.onError(2002,"无数据");
            }
        });
        MyApplication.getQueue().add(request);
    }
    public interface CallBackTask {
        void onSuccess(String s);
        void onError(int code,String msg);
    }

}
