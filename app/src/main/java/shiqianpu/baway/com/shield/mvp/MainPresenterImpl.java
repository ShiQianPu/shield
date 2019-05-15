package shiqianpu.baway.com.shield.mvp;

import android.widget.ImageView;

import shiqianpu.baway.com.shield.net.NetUtil;

public class MainPresenterImpl implements MainContract.IMainPresenter {
    private MainContract.IMainModel model;
    private MainContract.IMainView view;
    @Override
    public void attach(MainContract.IMainView view) {
        this.view = view;
        model = new MainModelImpl();
    }

    @Override
    public void detach() {
        if (view != null){
            view = null;
        }
        if (model!=null){
            model = null;
        }
    }

    @Override
    public void fromList(String url) {
        model.doHttpGet(url, new NetUtil.CallBackTask() {
            @Override
            public void onSuccess(String s) {
                view.showList(s);
            }

            @Override
            public void onError(int code, String msg) {

            }
        });
    }
}
