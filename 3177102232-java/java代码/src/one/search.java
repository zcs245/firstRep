package one;
import java.sql.*;
import java.util.Scanner;
public class search {
	void searchtable(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
			stmt = conn.createStatement();
			boolean IsNULL = true;
		    System.out.println("������Ҫ��ѯ��ͼ��ı��");
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
		    	System.out.println("δ�ҵ���Ӧ�鼮");
		}catch (SQLException e) {
			 System.out.println("��ѯ�쳣��"); 	}
	}
}
