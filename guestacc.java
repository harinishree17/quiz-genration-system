/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finale;
import java.sql.*;

/**
 *
 * @author harin
 */
public class guestacc {
    public static int det(String gname){
        int status=0;
        int h = -12;
            
		try{
                        String url="jdbc:mysql://localhost:3306/new_account";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("insert into guest values(?,?,?)");
			ps.setString(1,gname);
                        ps.setInt(2,h);
                        ps.setInt(3,h);
                        
			status=ps.executeUpdate();
			con.close();
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status;
                 
}
    public static int update(int mark, int id){
        int status=0;
        int h = -12;
            
		try{
                        String url="jdbc:mysql://localhost:3306/new_account";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("update guest set quiz_id = ? and marks = ? where quiz_id = "+h+"");
			ps.setInt(1,id);
                        ps.setInt(2,mark);
                        ps.setInt(3,h);
			status=ps.executeUpdate();
			con.close();
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status;
                 
}
}