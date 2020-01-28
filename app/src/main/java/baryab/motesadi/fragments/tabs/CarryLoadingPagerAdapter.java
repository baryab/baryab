package baryab.motesadi.fragments.tabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import baryab.motesadi.fragments.CarriedShipmentFragment;
import baryab.motesadi.fragments.CarringShipmentFragment;

public class CarryLoadingPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public CarryLoadingPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new CarriedShipmentFragment();
            case 1:
                return new CarringShipmentFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
