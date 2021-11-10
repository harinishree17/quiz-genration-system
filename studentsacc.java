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
public class studentsacc extends globe{
    public static int ad(int pin, String type){
        int status=0;
        int h = 0;
            
		try{
                        String url="jdbc:mysql://localhost:3306/new_account";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        PreparedStatement ps=con.prepareStatement("insert into users (pin,type) values(?,?)");
			ps.setInt(1,pin);
                        ps.setString(2,type);
                        
			status=ps.executeUpdate();
			con.close();
                        globe.count();
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status;
                 
    }
    
}
