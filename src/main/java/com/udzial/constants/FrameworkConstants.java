package com.udzial.constants;

import java.awt.*;

public class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String resourcePath = System.getProperty("user.dir") + "/src/test/resources";
    private static final String apkfilepath = resourcePath + "/apkfiles/ApiDemos-debug.apk";
    private static final String configFilepath = resourcePath + "/config/config.properties";


    public static String getApkfilepath()
    {
        return apkfilepath;
    }

    public static String getConfigFilepath()
    {
        return configFilepath;
    }

}
