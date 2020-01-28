package baryab.motesadi.activities;

import android.os.Bundle;
import android.view.View;

import baryab.motesadi.BaseActivity;
import com.noavaran.system.vira.baryab.R;
import baryab.motesadi.listeners.OnSingleClickListener;

public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        findViewById(R.id.acAbout_btnBack).setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                finish();
            }
        });
    }
}