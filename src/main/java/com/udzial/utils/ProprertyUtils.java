package com.udzial.utils;

import com.udzial.constants.FrameworkConstants;
import com.udzial.constants.FrameworkConstantsWithLombak;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProprertyUtils {

private static final Properties properties = new Properties();
private static java.util.Map<String,String> Map = new HashMap<>();

static
{
    try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilepath()))
    {
        properties.load(fileInputStream);

        //So we are able to use Singleton Pattern below by calling a getinstance method instead of
        // writing new everytime
        //FrameworkConstantsWithLombak.getInstance().getApkfilepath()
        //FrameworkConstantsWithLombak.getInstance().get

        //Below is a way to get for static methods
        //FrameworkConstantsWithLombak.getResourcePath1()


        for(Map.Entry<Object,Object> entry: properties.entrySet())
        {
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            Map.put(key,value);
        }


    } catch (IOException e) {
        e.printStackTrace();
        System.exit(0);
    }
}


public static String getValue(String key)
{
    return Map.get(key);
}

}
