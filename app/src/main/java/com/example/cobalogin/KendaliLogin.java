package com.example.cobalogin;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class KendaliLogin
{

    private SharedPreferences SP;
    private SharedPreferences.Editor SPEditor;

    public void setPref(Context ctx, String key, String value)
    {
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        SPEditor = SP.edit();
        SPEditor.putString(key, value);
        SPEditor.commit();
    }
    public String getPref(Context ctx, String key)
    {
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        String temp = SP.getString(key,null);
        return temp;
    }
    public Boolean isLogin(Context ctx, String key)
    {
        //SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        //String temp = SP.getString(key,null);
        if(this.getPref(ctx, key) != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
