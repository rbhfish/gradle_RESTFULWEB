package com.mia.project.service;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mia.project.resource.URLResource;

@RestController
public class PersonsController
{
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/searchPerson/{personID}")
    public ResultPersons searchPersonbyID(@PathVariable("personID") int id)
    {
        Connection conn = null;
        Statement stmt = null;
        List<Persons> listPersons = new ArrayList();
        try{
            Class.forName(URLResource.JDBC_DRIVER);
            System.out.println("connecting to server DB......");
            conn = DriverManager.getConnection(URLResource.addressDB,URLResource.DBUser,URLResource.PASSWord);

            System.out.println("Search  Instantiate statement .......");
            stmt = conn.createStatement();
            String sql = "SELECT * from Persons WHERE Id_P = " + Integer.toString(id);
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                Persons tmp = new Persons(rs.getInt("Id_P"),rs.getString("FirstName"),rs.getString("LastName"),rs.getInt("age"),rs.getString("City"));
                listPersons.add(tmp);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null)
                    stmt.close();
            }catch(SQLException se2){}
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Done with Connection to DB.......");
        final int size = listPersons.size();
        Persons[] arrPersons = (Persons[])listPersons.toArray(new Persons[size]);
        return new ResultPersons(counter.incrementAndGet(),arrPersons);
    }
    @RequestMapping("/personList")
    public ResultPersons personList()
    {
        Connection conn = null;
        Statement stmt = null;
        List<Persons> listPersons = new ArrayList();
        try{
            Class.forName(URLResource.JDBC_DRIVER);
            System.out.println("connecting to server DB......");
            conn = DriverManager.getConnection(URLResource.addressDB,URLResource.DBUser,URLResource.PASSWord);

            System.out.println("Instantiate statement .......");
            stmt = conn.createStatement();
            String sql = "SELECT * from Persons";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                Persons tmp = new Persons(rs.getInt("Id_P"),rs.getString("FirstName"),rs.getString("LastName"),rs.getInt("age"),rs.getString("City"));
                listPersons.add(tmp);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null)
                    stmt.close();
            }catch(SQLException se2){}
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Done with Connection to DB.......");
        final int size = listPersons.size();
        Persons[] arrPersons = (Persons[])listPersons.toArray(new Persons[size]);
        return new ResultPersons(counter.incrementAndGet(),arrPersons);
    }
}
