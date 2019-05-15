package shiqianpu.baway.com.shield.mvp;

import shiqianpu.baway.com.shield.net.NetUtil;

public class MainModelImpl implements MainContract.IMainModel {
    private NetUtil util;

    public MainModelImpl() {
        util = NetUtil.getInstance();
    }

    @Override
    public void doHttpGet(String url, NetUtil.CallBackTask backTask) {
        util.doHttpGet(url,backTask);
    }
}
