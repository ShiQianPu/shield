package shiqianpu.baway.com.shield;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import shiqianpu.baway.com.shield.adapter.CreamAdapter;
import shiqianpu.baway.com.shield.base.BaseActivity;
import shiqianpu.baway.com.shield.bean.CreamBean;
import shiqianpu.baway.com.shield.mvp.MainContract;
import shiqianpu.baway.com.shield.mvp.MainPresenterImpl;

public class MainActivity extends BaseActivity implements MainContract.IMainView {
    private MainContract.IMainPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void initData() {
        presenter.fromList("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10");
    }

    @Override
    protected void bindView() {
            recyclerView = findViewById(R.id.recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            presenter = new MainPresenterImpl();
            presenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
    @Override
    public void showList(String result) {
        Gson gson = new Gson();
        CreamBean creamBean = gson.fromJson(result, CreamBean.class);
        List<CreamBean.ResultBean> result1 = creamBean.getResult();
        CreamAdapter creamAdapter = new CreamAdapter(MainActivity.this, result1);
        recyclerView.setAdapter(creamAdapter);

    }
}
