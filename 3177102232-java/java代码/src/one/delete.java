package one;
import java.sql.*;
import java.util.Scanner;
public class delete {
	void deletetable(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
				stmt = conn.createStatement();
				int Bid = 0;
				System.out.println("输入你想删除的图书的图书编号");
				Bid = sc.nextInt();
				rs = stmt.executeQuery("select * from Book where Bid="+Bid);
			 	if(rs.next()==false){
			 		System.out.println("未找到可删除的图书编号");
			 		return;
			 	}
				String sql = "delete from Book where Bid = "+Bid;
				stmt.execute(sql);//执行SQL语句
				System.out.println("删除成功！");
		}catch (SQLException e) {
			 System.out.println("删除失败"); }
	}
}
