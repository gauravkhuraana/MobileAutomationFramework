package com.udzial.constants;

import lombok.Getter;

import java.util.Objects;

// When we want to apply getter at class level
@Getter
public class FrameworkConstantsWithLombak {

    public static FrameworkConstantsWithLombak frameworkConstantsWithLombak;

    // to take care of multi threading as we implemented Singleton Pattern
    public static synchronized FrameworkConstantsWithLombak getInstance()
    {
        if(Objects.isNull(frameworkConstantsWithLombak))
        {
            frameworkConstantsWithLombak = new FrameworkConstantsWithLombak();
        }
        return frameworkConstantsWithLombak;
    }


    private  final String resourcePath = System.getProperty("user.dir") + "/src/test/resources";
    private  final String apkfilepath = resourcePath + "/apkfiles/ApiDemos-debug.apk";
    private  final String configFilepath = resourcePath + "/config/config.properties";

    // For static variable you can use like below
      private static @Getter  final String resourcePath1 = System.getProperty("user.dir") + "/src/test/resources";


}
