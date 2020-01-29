package baryab.motesadi.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.provider.Telephony;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;

import baryab.motesadi.BaseActivity;
import baryab.motesadi.Configuration;

import com.noavaran.system.vira.baryab.R;

import baryab.motesadi.SPreferences;
import baryab.motesadi.customviews.CustomButton;
import baryab.motesadi.customviews.CustomEditText;
import baryab.motesadi.customviews.CustomTextView;
import baryab.motesadi.helpers.ActivitiesHelpers;
import baryab.motesadi.listeners.OnSingleClickListener;
import baryab.motesadi.utils.EditTextUtil;
import baryab.motesadi.utils.okhttp.OkHttpHelper;

import org.json.JSONObject;

public class VerificationActivity extends BaseActivity {
    private CustomEditText etCode;
    private CustomButton btnConfirm;
    private CustomTextView btnRequestCodeAgain;
    private CustomTextView tvCountDownTimer;

    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        findViews();
        initComponents();
        setViewsListeners();
        getIntents();

        registerIncomingMessageReceiver();
    }

    private void findViews() {
        etCode = findViewById(R.id.acVerification_etCode);
        btnConfirm = findViewById(R.id.acVerification_btnConfirm);
        btnRequestCodeAgain = findViewById(R.id.acVerification_btnRequestCodeAgain);
        tvCountDownTimer = findViewById(R.id.acVerification_tvCountDownTimer);
    }

    private void initComponents() {
    }

    private void setViewsListeners() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCode.getText().toString().isEmpty()) {
                    EditTextUtil.getInstance(VerificationActivity.this).showErrorAndShake(etCode, "لطفا کد تایید را وارد نمایید");
                } else {
                    doOneSignalProcess();
                }
            }
        });

        btnRequestCodeAgain.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                doRequestConfirmationCodeAgain(phoneNumber);
            }
        });
    }

    private void doOneSignalProcess() {
        showDialogProgress("لطفا کمی صبر کنید ...");

        doVerification(etCode.getText().toString(), phoneNumber, "", "");

      /* OneSignal.idsAvailable(
               new OneSignal.IdsAvailableHandler() {
           @Override
           public void idsAvailable(String userId, String registrationId) {
               if (registrationId != null) {
                    doVerification(etCode.getText().toString(), phoneNumber, userId, registrationId);
               } else {
                   doVerification(etCode.getText().toString(), phoneNumber, userId, "");
               }

                dismissDialogProgress();
            }
       });*/
    }

    private void doVerification(String code, String phoneNumber, String userId, String registrationId) {
        Log.i("test", "doVerification: ");

        OkHttpHelper okHttpHelper = new OkHttpHelper(VerificationActivity.this, Configuration.API_LOGIN, OkHttpHelper.MEDIA_TYPE_JSON);
Log.e("cahsei",Integer.parseInt(code)+"\n"
+phoneNumber+"\n"
        +userId+"\n"
        +registrationId);
        okHttpHelper.doVerify(Integer.parseInt(code), phoneNumber, userId, registrationId, new OkHttpHelper.OnCallback() {
            @Override
            public void onStart() {
                showDialogProgress("در حال ارسال اطلاعات به سرور");
            }

            @Override
            public void onResponse(JSONObject result) {
                Log.i("test", "onResponse: ");
                loadVerification(result);
            }

            @Override
            public void onRequestReject(String message) {
                showToastWarning(message);
                dismissDialogProgress();
            }

            @Override
            public void onFailure(String errorMessage) {
                showToastError(errorMessage);
                dismissDialogProgress();
            }

            @Override
            public void onNoInternetConnection() {
                dismissDialogProgress();
            }

            @Override
            public void onFinish() {
                dismissDialogProgress();
            }
        });
    }

    private void getIntents() {
        if (getIntent().getExtras() != null) {
            phoneNumber = getIntent().getExtras().getString("phoneNumber");
        }
    }


    private void doRequestConfirmationCodeAgain(String phoneNumber) {
        OkHttpHelper okHttpHelper = new OkHttpHelper(VerificationActivity.this, Configuration.API_LOGIN, OkHttpHelper.MEDIA_TYPE_JSON);
        okHttpHelper.doLogin(phoneNumber, new OkHttpHelper.OnCallback() {
            @Override
            public void onStart() {
                showDialogProgress("در حال ارسال اطلاعات به سرور");
            }

            @Override
            public void onResponse(JSONObject result) {
                loadRequestConfirmationCodeAgain(result);
            }

            @Override
            public void onRequestReject(String message) {
                showToastWarning(message);
                dismissDialogProgress();

            }

            @Override
            public void onFailure(String errorMessage) {
                showToastError(errorMessage);
                dismissDialogProgress();
            }

            @Override
            public void onNoInternetConnection() {
                dismissDialogProgress();
            }

            @Override
            public void onFinish() {
                dismissDialogProgress();
            }
        });
    }

    private void loadRequestConfirmationCodeAgain(final JSONObject result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try {
                    if (result.getBoolean("result")) {

                        btnRequestCodeAgain.setEnabled(false);
                        tvCountDownTimer.setVisibility(View.VISIBLE);
                        new CountDownTimer(59000, 1000) {
                            public void onTick(long millisUntilFinished) {
                                tvCountDownTimer.setText("مدت زمان باقیمانده جهت دریافت کد تایید : " + "00:" + millisUntilFinished / 1000);
                            }

                            public void onFinish() {
                                btnRequestCodeAgain.setEnabled(true);
                                tvCountDownTimer.setVisibility(View.GONE);
                            }
                        }.start();

                    } else {
                        showToastError(result.getString("message"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void loadVerification(JSONObject result) {
        try {
            dismissDialogProgress();

            if (result.getBoolean("result")) {

                SPreferences.getInstance(VerificationActivity.this).setToken(result.getString("data"));
                Log.i("test", "loadVerification: ");
                Log.i("token", SPreferences.getInstance(VerificationActivity.this).getToken());
                new ActivitiesHelpers(VerificationActivity.this).gotoActivityMain();

                VerificationActivity.this.finish();
            } else {
                showToastError(result.getString("message"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void registerIncomingMessageReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
//        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiverIncomingMessage, intentFilter);
    }

    private void unregisterIncomingMessageReceiver() {
        if (broadcastReceiverIncomingMessage != null) {
            unregisterReceiver(broadcastReceiverIncomingMessage);
            broadcastReceiverIncomingMessage = null;
        }
    }


    BroadcastReceiver broadcastReceiverIncomingMessage = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle intentExtras = intent.getExtras();
            if (intentExtras != null) {
                showDialogProgress("در حال خواندن کد تایید شما ...");
                Object[] smsExtra = (Object[]) intentExtras.get("pdus");
                SmsMessage[] msgs = new SmsMessage[smsExtra.length];
                SmsMessage sms = null;

                for (int i = 0; i < msgs.length; i++) {
                    sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);
                }

                String content = sms.getMessageBody().toString();
                String address = sms.getOriginatingAddress();

                dismissDialogProgress();
                String verifyCode = content.replaceAll("[^0-9]", "");
                etCode.setText(verifyCode);

                doOneSignalProcess();
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterIncomingMessageReceiver();
    }
}
