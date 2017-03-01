package com.mia.project.service;

import com.mia.project.tool.SingletonTools;

public class ResultPersons
{
    private final String curTime;
    private final Persons[] arrPersons;
    private final long lID;

    public ResultPersons(long nTH,Persons[] arrPersons)
    {
        SingletonTools tools = SingletonTools.getInstance();
        lID = nTH;
        curTime = tools.getCurrentTime();
        this.arrPersons = arrPersons;
    }
    public long getLId()
    {
    	return this.lID;
    }
    public String getCurTime()
    {
    	return this.curTime;
    }
    public Persons[] getPersonsArray()
    {
    	return this.arrPersons;
    }
}
