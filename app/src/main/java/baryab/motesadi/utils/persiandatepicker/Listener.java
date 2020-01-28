package baryab.motesadi.utils.persiandatepicker;

import baryab.motesadi.utils.persiandatepicker.util.PersianCalendar;

public interface Listener {
    void onDateSelected(PersianCalendar persianCalendar);

    void onDisimised();
}
