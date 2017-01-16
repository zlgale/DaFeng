package com.zl.dafeng.novate.util;

import android.util.Log;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import java.lang.reflect.Type;
import java.util.List;

import static net.steamcrafted.materialiconlib.MaterialDrawableBuilder.IconValue.JSON;


/**
 * jsonUtil
 */
public class JsonUtil {


    public static <T> T parseObject(String jsonStr, Class<T> entityClass) {
        T ret = null;
        try {
            ret = com.alibaba.fastjson.JSON.parseObject(jsonStr, entityClass);
        } catch (Exception e) {
            Log.e("Novte", "parseObject-something Exception with:" + e.toString());
            e.printStackTrace();
        }

        return ret;
    }

    public static <T> T parseObject(String jsonStr, Type type) {
        T obj = null;
        try {
            obj = com.alibaba.fastjson.JSON.parseObject(jsonStr, type, Feature.AutoCloseSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static <T> T parseObject(String jsonStr, TypeReference<T> tf) {
        T obj = null;
        try {
            obj = com.alibaba.fastjson.JSON.parseObject(jsonStr, tf, Feature.AutoCloseSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    public static <T> List<T> parseList(String jsonStr, Class<T> entityClass) {
        List<T> ret = null;

        try {
            ret = com.alibaba.fastjson.JSON.parseArray(jsonStr, entityClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String toJSONString(Object obj) {
        String ret = null;

        try {
            ret = com.alibaba.fastjson.JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
