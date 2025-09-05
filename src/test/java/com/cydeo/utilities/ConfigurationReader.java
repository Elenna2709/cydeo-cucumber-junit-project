package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1 - create the properties object
    //make it private so is not accesible outside the class-limiting acces to the object
    //"static" is to make sure its created and loaded before everything
    private static Properties properties = new Properties();

    static {
        try {
            //2 -open this file in Java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 -load the properties object with file
            properties.load(file);

            //close the file in the memory
            file.close();
        } catch (IOException e) {
            System.out.println("file not found with given path!!!");
            e.printStackTrace();
        }
    }
    // create a utility method to use the object to read
    //4 - use properties object to read from the file
    public static String getProperty (String keyword){
        return properties.getProperty(keyword);
    }
}
