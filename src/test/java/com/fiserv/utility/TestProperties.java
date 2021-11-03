package com.fiserv.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {

    public static String getProperty(String key) throws Exception {

        String filePath=System.getProperty("user.dir")+"/src/test/resources/testconfig/test.properties";
        Properties properties=new Properties();
        FileInputStream file=new FileInputStream(filePath);
        properties.load(file);
        String propertyValue=properties.get(key).toString();

        return propertyValue;
    }
}
