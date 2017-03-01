package com.mia.project.tool;

import java.sql.*;

public class SingletonDBOperation
{
    private static SingletonDBOperation singleton = null;
    private SingletonDBOperation() { }

    public static SingletonDBOperation getInstance()
    {
        if(singleton == null)
        {
            synchronized(SingletonDBOperation.class)
            {
                singleton = new SingletonDBOperation();
            }
        }
        return singleton;
    }

}
