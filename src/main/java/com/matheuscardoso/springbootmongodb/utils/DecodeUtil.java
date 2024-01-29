package com.matheuscardoso.springbootmongodb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeUtil {
    public static String decodeParam(String textToDecode) {
        try {
            return URLDecoder.decode(textToDecode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
