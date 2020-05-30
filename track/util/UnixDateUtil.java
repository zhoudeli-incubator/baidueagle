package com.chinavisionary.link.app.track.util;

import com.google.common.base.CaseFormat;

import java.util.Date;

public class UnixDateUtil {

    public static int getUnixTimeStamp(Date date) {
        return (int)(date.getTime() / 1000);
    }
}
