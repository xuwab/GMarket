package com.example.wab.gmarket.http.data;

import android.content.Context;
import com.example.wab.gmarket.http.IDontObfuscate;
import com.example.wab.gmarket.util.LiveSharedPreferenceUtils;

/**
 * @description: 用户信息
 *
 * @author: Andruby
 * @time: 2016/10/31 18:07
 */
public class UserInfo extends IDontObfuscate {

    public String userId;
    public String nickname;
    public String headPic;
    public String sigId;
    public String sdkAppId;
    public String sdkAccountType;
    public String sex;

    public UserInfo() {
    }

    public UserInfo(String userId, String nickname, String headPic, String sex) {
        this.userId = userId;
        this.nickname = nickname;
        this.headPic = headPic;
        this.sex = sex;
    }

    public static void saveCache(Context context, String userId, String nickname, String headPic, String sigId) {
        LiveSharedPreferenceUtils.getInstance().putString(context, "userId", userId);
        LiveSharedPreferenceUtils.getInstance().putString(context, "nickname", nickname);
        LiveSharedPreferenceUtils.getInstance().putString(context, "headPic", headPic);
        LiveSharedPreferenceUtils.getInstance().putString(context, "sigId", sigId);
    }

    public static UserInfo getCache(Context context) {
        UserInfo userInfo = new UserInfo();
        userInfo.userId = LiveSharedPreferenceUtils.getInstance().getString(context, "userId", "");
        userInfo.nickname = LiveSharedPreferenceUtils.getInstance().getString(context, "nickname", "");
        userInfo.headPic = LiveSharedPreferenceUtils.getInstance().getString(context, "headPic", "");
        userInfo.sigId = LiveSharedPreferenceUtils.getInstance().getString(context, "sigId", "");
        return userInfo;
    }

    public static void clearCache(Context context){
        LiveSharedPreferenceUtils.getInstance().clear(context);
    }
}
