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
public class studentacc {
    public static int det(int mark, int cid, int pid){
        int status=0;
        int h = -12;
            
		try{
                        String url="jdbc:mysql://localhost:3306/quiz";
                        String uname="root";
                        String upass="Seenuselvi@17";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con= DriverManager.getConnection(url,uname,upass);
                        
                        PreparedStatement pts=con.prepareStatement("insert into participants values(?,?,?,curdate())");
			pts.setInt(1,cid);
                        pts.setInt(2,pid);
                        pts.setInt(3,mark);
                       
			status=pts.executeUpdate();
			con.close();
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    return status;
                 
}
    
}
