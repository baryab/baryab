package baryab.motesadi.activities.delegates;

import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;

import baryab.motesadi.customviews.CustomEditText;
import baryab.motesadi.customviews.CustomSwitchButton;
import baryab.motesadi.customviews.CustomTextView;
import baryab.motesadi.customviews.ExpandableLayout;
import baryab.motesadi.info.TruckTypeInfo;
import baryab.motesadi.utils.okhttp.response.ShipmentDetailResponse;

public interface EditShipmentDelegate {
    interface View {
        CustomTextView getTvLocationHint();

        CustomTextView getTvCarChooseHint();

        CustomTextView getTvCarLengthHeaderLabel();

        CustomEditText getEtCarLengthFrom();

        CustomEditText getEtCarLengthTo();

        CustomTextView getTvCarWidthHeaderLabel();

        CustomEditText getEtCarWidthFrom();

        CustomEditText getEtCarWidthTo();

        ExpandableLayout getElCarHeight();

        CustomTextView getTvCarHeightHeaderLabel();

        CustomEditText getEtCarHeightFrom();

        CustomEditText getEtCarHeightTo();

        CustomEditText getEtLoadingType();

        CustomEditText getEtLoadingWeight();

        RecyclerView getLoadingFareTypeRecyclerView();

        CustomTextView getTvLoadingFareTypeHint();

        CustomEditText getEtLoadingFare();

        public void setLoadingFareViewVisiablity(int visiablity);

        CustomTextView getTvLoadingTimeHint();

        CustomEditText getEtّDescription();

        ImageView getIvLoadingPhotoPreview();

        CustomEditText getEtSpendingWarehouse();

        CustomTextView getTvDetermineDischargeTimeHint();

        CustomTextView getTvDetermineExpirationTimeHint();

        CustomSwitchButton getBtnPaymentIsPaidAfterLoadingArriveToDestination();

        CustomSwitchButton getBtnLoadingIsGoingRound();

        CustomSwitchButton getBtnHavingIntactTent();

        void setCarChooserHint(String carTypeFullname);

        ExpandableLayout getCarLengthView();

        void setCarLengthHeaderLabel(String text);

        ExpandableLayout getCarWidthView();

        void setCarWidthHeaderLabel(String text);

        ExpandableLayout getCarHeightView();

        void setCarHeightHeaderLabel(String text);

        void collapseAllExpandableLayout();
    }

    interface Controller {
        void setShipmentData(ShipmentDetailResponse shipmentData);

        ShipmentDetailResponse getShipmentData();

        void setType(int type);

        int getType();

        void setTruckTypeInfo(TruckTypeInfo truckTypeInfo);

        void save();
    }
}
