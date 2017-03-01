package com.mia.project.tool;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SingletonTools
{
    private static SingletonTools singleton = null;
    private SingletonTools() { }
    public static SingletonTools getInstance()
    {
        if(singleton == null)
        {
            synchronized(SingletonTools.class)
            {
                singleton = new SingletonTools();
            }
        }
        return singleton;
    }

    public String getCurrentTime()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(new Date());
    }
}
