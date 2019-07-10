package one;
import java.sql.*;
import java.util.Scanner;
public class adddata {
	void add(Connection conn,Statement stmt,Scanner sc){
		 try{
				int Bid=0,Quantity=0;
				float Price = 0.0f;
				String Bname;
				System.out.println("输入新增的图书编号");
				stmt = conn.createStatement();
				Bid = sc.nextInt();
				System.out.println("输入新增的图书名称");
				Bname = sc.next();
				System.out.println("输入新增的图书单价");
				Price = sc.nextFloat();
				System.out.println("输入新增的图书库存");
				Quantity  = sc.nextInt();
			    String sql = "insert into Book(Bid,Bname,Price,Quantity)values("
				+Bid+",'"+Bname+"',"+Price+","+Quantity+")";
			    stmt.executeUpdate(sql);//执行SQL语句
			    System.out.println("新增成功！");
			}catch(SQLException e) {
				 System.out.println("新增失败！");}
	}

}
