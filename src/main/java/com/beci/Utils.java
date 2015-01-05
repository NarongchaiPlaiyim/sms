package com.beci;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public enum Utils {
    ;
    public final static boolean TRUE = true;

    public static boolean isNull(final Object object){
        return object != null;
    }

    public static boolean isEmpty(final String string){
        return isZero(string);
    }

    public static int parseInt(Object input, int defaultValue){
        if(input == null)
            return defaultValue;
        else if (input instanceof Integer)
            return (Integer) input;
        else {
            String inputStr = input.toString();
            if(isEmpty(inputStr))
                return defaultValue;
            try{
                return Integer.parseInt(inputStr);
            }catch (ClassCastException e){
                return defaultValue;
            }
        }
    }

    public static boolean isZero(final String string){
        return 0 == string.length();
    }

    public static boolean equals(final String string, final String string2){
        return StringUtils.equals(string, string2);
    }

    public static<T> List<T> safetyList(final List<T> list) {
        return isNull(list) && list.size() > 0 ? list : (List<T>)Collections.EMPTY_LIST;
    }
}
