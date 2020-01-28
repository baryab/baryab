package baryab.motesadi.activities;

import android.os.Bundle;
import android.view.View;

import baryab.motesadi.BaseActivity;
import com.noavaran.system.vira.baryab.R;
import baryab.motesadi.listeners.OnSingleClickListener;


public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        findViewById(R.id.acContact_btnBack).setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                finish();
            }
        });
    }
}
