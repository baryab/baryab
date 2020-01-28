package baryab.motesadi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.noavaran.system.vira.baryab.R;
import baryab.motesadi.models.ProvinceType;

import java.util.List;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.MyViewHolder> {
    private Context mContext;
    private List<ProvinceType.province> provinceList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private LinearLayout lyMain;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = view.findViewById(R.id.txt_title);
            lyMain = view.findViewById(R.id.layout_main);
        }
    }

    public ProvinceAdapter(Context mContext, List<ProvinceType.province> provinceInfo) {
        this.mContext = mContext;
        this.provinceList = provinceInfo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_province_type, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ProvinceType.province province = provinceList.get(position);
        holder.txtTitle.setText(province.getCityname());

//        holder.lyMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return provinceList.size();
    }

}
