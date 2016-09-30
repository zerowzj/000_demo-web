package com.noriental.jobweb.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Date Util
 *
 * @author wangzhj
 */
public abstract class DateUtil {

    private static final String LONG_TIME = "yyyy-MM-dd HH:mm:ss.sss";

    private static final Map<String, SimpleDateFormat> SDF_MAP = new HashMap<>();

    static {
        SDF_MAP.put(LONG_TIME, new SimpleDateFormat(LONG_TIME));
    }

    /**
     *
     */
    public static String getLongTimeStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = SDF_MAP.get(LONG_TIME);
        return sdf.format(date);
    }

    /**
     *
     */
    public static Date parse(String dateStr) {
        SimpleDateFormat sdf = SDF_MAP.get(LONG_TIME);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }
}
