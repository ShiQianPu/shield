package shiqianpu.baway.com.shield.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shiqianpu.baway.com.shield.R;

public class CreamHolder extends RecyclerView.ViewHolder {

    public final ImageView img;
    public final TextView t1;
    public final TextView t2;


    public CreamHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);

    }
}
