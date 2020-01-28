package baryab.motesadi.helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import baryab.motesadi.Configuration;
import baryab.motesadi.activities.AboutActivity;
import baryab.motesadi.activities.ApplicantDriversActivity;
import baryab.motesadi.activities.CarriedShipmentDetailActivity;
import baryab.motesadi.activities.CarryingShipmentDetailActivity;
import baryab.motesadi.activities.CommentActivity;
import baryab.motesadi.activities.ContactActivity;
import baryab.motesadi.activities.EditShipmentActivity;
import baryab.motesadi.activities.FaqActivity;
import baryab.motesadi.activities.LoginActivity;
import baryab.motesadi.activities.MainActivity;
import baryab.motesadi.activities.MapsActivity;
import baryab.motesadi.activities.MyLoadingDetailsActivity;
import baryab.motesadi.activities.OnlineDriverTrackingActivity;
import baryab.motesadi.activities.ProfileActivity;
import baryab.motesadi.activities.VerificationActivity;
import baryab.motesadi.activities.WebViewActivity;

public class ActivitiesHelpers {
    private static ActivitiesHelpers activitiesHelpers;
    private Context context;

    public ActivitiesHelpers(Context context) {
        this.context = context;
    }

    public static ActivitiesHelpers getInstance(Context context) {
        if (activitiesHelpers == null)
            activitiesHelpers = new ActivitiesHelpers(context);

        return activitiesHelpers;
    }

    public void gotoActivityLogin() {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void gotoActivityVerification(String phoneNumber) {
        Intent intent = new Intent(context, VerificationActivity.class);
        intent.putExtra("phoneNumber", phoneNumber);
        context.startActivity(intent);
    }

    public void gotoActivityMain() {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        Log.i("test", "gotoActivityMain: ");
    }

    public void gotoActivityMaps(String strPlacesInfo) {
        Intent intent = new Intent(context, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("place_info", strPlacesInfo);
        intent.putExtra("places", bundle);
        ((MainActivity) context).startActivityForResult(intent, Configuration.REQUEST_CODE_PLACES_INFO);
    }

    public void gotoActivityMaps(EditShipmentActivity activity, String strPlacesInfo) {
        Intent intent = new Intent(context, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("place_info", strPlacesInfo);
        intent.putExtra("places", bundle);
        activity.startActivityForResult(intent, Configuration.REQUEST_CODE_PLACES_INFO);
    }

    public void gotoActivityCarriedShipmentDetail(String shipmentId) {
        Intent intent = new Intent(context, CarriedShipmentDetailActivity.class);
        intent.putExtra("shipmentId", shipmentId);
        context.startActivity(intent);
    }

    public void gotoActivityCarryingShipmentDetail(String shipmentId) {
        Intent intent = new Intent(context, CarryingShipmentDetailActivity.class);
        intent.putExtra("shipmentId", shipmentId);
        context.startActivity(intent);
    }

    public void gotoActivityOnlineDriverTracking(String draftId, String info) {
        Intent intent = new Intent(context, OnlineDriverTrackingActivity.class);
        intent.putExtra("draftId", draftId);
        intent.putExtra("info", info);
        context.startActivity(intent);
    }

    public void gotoMyLoadingDetailsActivity(String shipmentId) {
        Intent intent = new Intent(context, MyLoadingDetailsActivity.class);
        intent.putExtra("shipmentId", shipmentId);
        ((MainActivity) context).startActivityForResult(intent, Configuration.REQUEST_CODE_REFRESH_DATA);
    }

    public void gotoActivityEditShipment(String shipmentDetail, int type) {
        Intent intent = new Intent(context, EditShipmentActivity.class);
        intent.putExtra("shipment_detail", shipmentDetail);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    public void gotoActivityApplicantDrivers(String shipmentId) {
        Intent intent = new Intent(context, ApplicantDriversActivity.class);
        intent.putExtra("shipmentId", shipmentId);
        context.startActivity(intent);
    }

    public void gotoActivityProfile() {
        context.startActivity(new Intent(context, ProfileActivity.class));
    }

    public void gotoActivityWebView(String title, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public void gotoActivityAboutUs() {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    public void gotoActivityContact() {
        context.startActivity(new Intent(context, ContactActivity.class));
    }

    public void gotoActivityFAQ() {
        context.startActivity(new Intent(context, FaqActivity.class));
    }

    public void gotoActivityComment() {
        context.startActivity(new Intent(context, CommentActivity.class));
    }
}