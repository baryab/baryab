package baryab.motesadi.utils;

public class IntegerUtil {
    public static String getDigitsFromString(String str) {
        return str.replaceAll("[^0-9]", "");
    }
}
