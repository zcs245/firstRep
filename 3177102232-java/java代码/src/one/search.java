package one;
import java.sql.*;
import java.util.Scanner;
public class search {
	void searchtable(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
			stmt = conn.createStatement();
			boolean IsNULL = true;
		    System.out.println("输入想要查询的图书的编号");
		    int CBid = sc.nextInt();
		    rs = stmt.executeQuery("select * from Book");
		    while (rs.next()) {
		    	 int Bid = rs.getInt("Bid");
	             String Bname = rs.getString("Bname");
	             float Price = rs.getFloat("Price");
	             int Quantity = rs.getInt("Quantity");
		    	if(CBid==Bid){
		    		 System.out.printf("%3d\t%12s\t%12.1f\t%12d\n",Bid,Bname,Price,Quantity);
		    		 IsNULL = false;
		    		 break;
		    	}
		    	else
		    		continue;
		    }
		    if(IsNULL)
		    	System.out.println("未找到相应书籍");
		}catch (SQLException e) {
			 System.out.println("查询异常！"); 	}
	}
}
