package shiqianpu.baway.com.shield.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import shiqianpu.baway.com.shield.R;
import shiqianpu.baway.com.shield.bean.CreamBean;
import shiqianpu.baway.com.shield.holder.CreamHolder;

public class CreamAdapter extends RecyclerView.Adapter<CreamHolder> {
    private Context context;
    private List<CreamBean.ResultBean> datas;

    public CreamAdapter(Context context, List<CreamBean.ResultBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public CreamHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new CreamHolder(inflater.inflate(R.layout.item_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CreamHolder creamHolder, int i) {
        Glide.with(context).load(datas.get(i).getLogo()).into(creamHolder.img);
       creamHolder.t1.setText(datas.get(i).getName());
       creamHolder.t2.setText(datas.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
