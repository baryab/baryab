package baryab.motesadi.fragments.delegates;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ScrollView;

import baryab.motesadi.customviews.CustomEditText;
import baryab.motesadi.customviews.CustomSwitchButton;
import baryab.motesadi.customviews.CustomTextView;
import baryab.motesadi.customviews.ExpandableLayout;

public interface NewLoadDelegate {
    interface View {
        ScrollView getSvContainer();

        void setLocationHint(String location);

        void setCarChooserHint(String carTypeFullname);

        CustomTextView getLocationHint();

        CustomTextView getCarChooseHint();

        ExpandableLayout getCarLengthView();

        ExpandableLayout getCarWidthView();

        ExpandableLayout getCarHeightView();

        CustomEditText getEditTextCarLengthFrom();

        CustomEditText getEditTextCarLengthTo();

        CustomEditText getEditTextCarWidthFrom();

        CustomEditText getEditTextCarWidthTo();

        CustomEditText getEditTextCarHeightFrom();

        CustomEditText getEditTextCarHeightTo();

        CustomEditText getEditTextLoadingType();

        CustomEditText getEditTextLoadingWeight();

        CustomEditText getEditTextLoadingFare();

        CustomTextView getEditTextLoadingTimeHint();

        CustomEditText getEditTextDescription();

        ImageView getImagViewLoadingPhotoPreview();

        CustomEditText getEditTextSpendingWarehouse();

        CustomTextView getTextViewDetermineDischargeTimeHint();

        CustomTextView getTextViewDetermineExpirationTimeHint();

        CustomSwitchButton getSwithchButtonPaymentIsPaidAfterLoadingArriveToDestination();

        CustomSwitchButton getSwithchButtonLoadingIsGoingRound();

        CustomSwitchButton getSwithchButtonHavingIntactTent();

        void setCarLengthHeaderLabel(String text);

        void setCarWidthHeaderLabel(String text);

        void setCarHeightHeaderLabel(String text);

        void hideLoadingFareView();

        void showLoadingFareView();

        RecyclerView getLoadingFareTypeRecyclerView();

        CustomTextView getTextViewLoadingFareTypeHint();

        void collapseAllExpandableLayout();

        void removeCroppedImage();
    }

    interface Controller {
        void save();
    }
}