/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finale;

import java.sql.*;
import java.util.*;

/**
 *
 * @author harin
 */
public class globe {
    public static int total_count;
    public static int total_q;
    public static String q_now;
    public static String cag_now;
    public static int qid;
    public static int q_c;
    public static int randq;
    public static int randc = 0;
    public static int inc = 0;
    public static int time;
    public static int co;
    public static int rrw = 0;
    public static int score = 0;
    public static int id ;
    public static int cag ;
    public static String gname;
  public static ArrayList<Integer> li = new ArrayList<Integer>(); 
    public static void count(){
    try{
                        String url="jdbc:mysql://localhost:3306/new_account";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        Statement ps=con.createStatement();
            String sql="select id from users ORDER BY id DESC LIMIT 1";
            ResultSet rs=ps.executeQuery(sql);
            rs.next();
            
                total_count = rs.getInt(1);
                
                }catch(Exception e){System.out.println(e);}
}
public static void countq(){
    try{
                        String url="jdbc:mysql://localhost:3306/quiz";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        Statement ps=con.createStatement();
            String sql="select count(*) from quizat";
            ResultSet rs=ps.executeQuery(sql);
            rs.next();
                total_q = rs.getInt(1);
                
                }catch(Exception e){System.out.println(e);}
}

public static ArrayList random(int noq){
    int noc = 0;
    do{
        noc++;
        li.add(noc);
        }while(noc<noq);
    Collections.shuffle(li);
    return li;
}
}
