package baryab.motesadi.activities;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;

import baryab.motesadi.BaseActivity;
import baryab.motesadi.Configuration;
import com.noavaran.system.vira.baryab.R;
import baryab.motesadi.customviews.CustomButton;
import baryab.motesadi.customviews.CustomEditText;
import baryab.motesadi.dialogs.GuidanceForObtainingApprovalDialog;
import baryab.motesadi.dialogs.InvalidUserDialog;
import baryab.motesadi.helpers.ActivitiesHelpers;
import baryab.motesadi.utils.DialerUtil;
import baryab.motesadi.utils.EditTextUtil;
import baryab.motesadi.utils.ValidationUtils;
import baryab.motesadi.utils.okhttp.OkHttpHelper;

import org.json.JSONObject;

public class LoginActivity extends BaseActivity {
    private CustomEditText etPhoneNumber;
    private CustomButton   btnLogin;

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        initComponents();
        setViewsListeners();
    }

    private void findViews() {
        etPhoneNumber = (CustomEditText) findViewById(R.id.acLogin_etPhoneNumber);
        btnLogin = (CustomButton) findViewById(R.id.acLogin_btnLogin);
    }

    private void initComponents() {

    }

    private void setViewsListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhoneNumber.getText().toString().isEmpty()) {
                    EditTextUtil.getInstance(LoginActivity.this).showErrorAndShake(etPhoneNumber, "لطفا شماره همراه خود را وارد نمایید");
                } else if (!ValidationUtils.isMobileNumber(etPhoneNumber.getText().toString())) {
                    EditTextUtil.getInstance(LoginActivity.this).showErrorAndShake(etPhoneNumber, "شماره همراه وارد شده نامعتبر می باشد");
                } else {
                    doLogin(etPhoneNumber.getText().toString());
                }
            }
        });
    }

    private void doLogin(String phoneNumber) {

        // http://89.32.250.117 /api/api/login";        //// MediaType.parse("application/json; charset=utf-8");
        OkHttpHelper okHttpHelper = new OkHttpHelper(LoginActivity.this, Configuration.API_LOGIN, OkHttpHelper.MEDIA_TYPE_JSON);
        okHttpHelper.doLogin(phoneNumber, new OkHttpHelper.OnCallback() {
            @Override
            public void onStart() {
                showDialogProgress("در حال ارسال اطلاعات به سرور");
            }

            @Override
            public void onResponse(JSONObject result) {
                loadLogin(result);
            }

            @Override
            public void onRequestReject(String message) {
                dismissDialogProgress();
                loadRequestReject(message);
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

    private void loadLogin(JSONObject result) {
        try {
            if (result.getBoolean("result")) {
                new ActivitiesHelpers(LoginActivity.this).gotoActivityVerification(etPhoneNumber.getText().toString());
            } else {
                showToastError(result.getString("message"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadRequestReject(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (message.equals("کاربربامشخصات واردشده یافت نشد.")) {
                        showInvalidUserDialog();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void showInvalidUserDialog() {
        InvalidUserDialog invalidUserDialog = new InvalidUserDialog(LoginActivity.this);
        invalidUserDialog.setOnDialogButtonsClickListener(new InvalidUserDialog.OnDialogButtonsClickListener() {
            @Override
            public void onHelp() {
                showGuidanceForObtainingApprovalDialog();
            }

            @Override
            public void onClose() {

            }
        });
        invalidUserDialog.show();
    }

    private void showGuidanceForObtainingApprovalDialog() {
        GuidanceForObtainingApprovalDialog guidanceForObtainingApprovalDialog = new GuidanceForObtainingApprovalDialog(LoginActivity.this);
        guidanceForObtainingApprovalDialog.setOnDialogButtonsClickListener(new GuidanceForObtainingApprovalDialog.OnDialogButtonsClickListener() {
            @Override
            public void onCall() {
                DialerUtil.getInstance(LoginActivity.this).openTheDialerApp(Configuration.SUPPORT_CENTER_PHONE_NUMBER);
            }

            @Override
            public void onClose() {

            }
        });
        guidanceForObtainingApprovalDialog.show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showToastInfo("برای خروج یکبار دیگر بازگشت را بزنید");

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}