package shiqianpu.baway.com.shield.mvp;

import android.widget.ImageView;

import shiqianpu.baway.com.shield.net.NetUtil;

public interface MainContract {

    public interface IMainView{
        void showList(String result);
    }
    public interface IMainModel{
        //
        void doHttpGet(String url, NetUtil.CallBackTask backTask);
    }
    public interface IMainPresenter{
        void attach(IMainView view);

        void detach();
        void fromList(String url);
    }
}
