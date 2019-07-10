package one;
import java.sql.*;
public class show {
	void showtable(Connection conn, Statement stmt, ResultSet rs){
		try{
			  stmt = conn.createStatement();
		      rs = stmt.executeQuery("select * from Book");
		      System.out.println("图书编号\t"+"\t图书名称\t"+"\t图书单价\t"+"\t图书库存");
		      while (rs.next()) {
		             int Bid = rs.getInt("Bid");
		             String Bname = rs.getString("Bname");
		             float Price = rs.getFloat("Price");
		             int Quantity = rs.getInt("Quantity");
		             System.out.printf("%3d\t%12s\t%12.1f\t%12d\n",Bid,Bname,Price,Quantity);
		      }
			}
			catch(SQLException e) {
				 System.out.println("遍历失败"); 	}
	}
}
