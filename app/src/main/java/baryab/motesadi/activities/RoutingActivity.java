package baryab.motesadi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.noavaran.system.vira.baryab.R;
import baryab.motesadi.adapters.ProvinceAdapter;
import baryab.motesadi.models.ProvinceType;
import baryab.motesadi.rest.ApiClient;
import baryab.motesadi.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoutingActivity extends AppCompatActivity {
    private ImageView imgPlaceLocation;
    private RecyclerView rv_LoadingProvince;
    private ProvinceAdapter mAdapter;
    private List<ProvinceType.province> provinceTypes = new ArrayList<>();
    private int id;

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routing);
        imgPlaceLocation = findViewById(R.id.acMaps_ivPlaceChooserMarker);
        rv_LoadingProvince = findViewById(R.id.acRouting_rcSelectState);
        rv_LoadingProvince.setVisibility(View.VISIBLE);

        initFindView();
        initComponents();
    }

    private void initComponents() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new ProvinceAdapter(this, provinceTypes);
        layoutManager.setReverseLayout(true);
        rv_LoadingProvince.setLayoutManager(layoutManager);
        rv_LoadingProvince.setAdapter(mAdapter);

        getProvince();

    }

    private void getProvince() {
        ApiInterface apiInterface = ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);
        Call<ProvinceType> call = apiInterface.getProvince();
        Log.i("status", "aaaaaaaaaa");

        call.enqueue(new Callback<ProvinceType>() {
            @Override
            public void onResponse(Call<ProvinceType> call, Response<ProvinceType> response) {
                if (response.isSuccessful()) {
                    Log.i("status", "ccccccccc");

//                    if (response.body().getStatuscode() == 2005) {
                            Log.i("status", "bbbbbbbbb");
                            Log.i("status", String.valueOf(response.body().getStatuscode()));
                            provinceTypes.addAll(response.body().getDataList().get(0).getProvinceList());
                            mAdapter.notifyDataSetChanged();


//                    }
                }
            }

            @Override
            public void onFailure(Call<ProvinceType> call, Throwable t) {
                Toast.makeText(RoutingActivity.this, "ارتباط با سرور برقرار نشد دوباره امتحان کنید", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void initFindView() {

        findViewById(R.id.acRouting_lyt_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FindLocationActivity.class));
            }
        });

        findViewById(R.id.acRouting_btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
