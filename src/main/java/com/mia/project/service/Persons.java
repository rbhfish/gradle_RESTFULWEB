package com.mia.project.service;

public class Persons{
    private final int id;
    private final String firstName;
    private final String lastName;
    private int age;
    private final String strAddress;

    public Persons(int id, String fN,String lN, int age, String address)
    {
        this.id = id;
        firstName = fN;
        lastName = lN;
        this.age = age;
        strAddress = address;
    }
    public int getID()
    {
    	return id;
    }
    public String getFirstName()
    {
    	return firstName;
    }
    public String getLastName()
    {
    	return this.lastName;
    }
    public int getAge()
    {
    	return this.age;
    }
    public String getAddress()
    {
    	return this.strAddress;
    }
}
