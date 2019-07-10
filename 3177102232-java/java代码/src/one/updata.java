package one;
import java.sql.*;
import java.util.Scanner;
public class updata {
	void updatatable(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		 try{
			 	stmt = conn.createStatement();
			 	int Bid = 0;
			 	int GBid = 0;
			 	String Bname;
			 	float Price = 0.0f;
			 	int Quantity = 0;
			 	String compare;
			 	System.out.println("请输入你想要更新的图书的图书编码");
			 	Bid = sc.nextInt();
			 	rs = stmt.executeQuery("select * from Book where Bid="+Bid);
			 	if(rs.next()==false){
			 		System.out.println("未找到编号的书");
			 		return;
			 	}
			 	System.out.println("请输入你想要更新的类型（如 图书编号）");
			 	compare = sc.next();
			 	
			 	if(compare.equals("图书编号")){
			 		System.out.println("请输入你想要更新的值");
			 		GBid = sc.nextInt();
			 		String sql = "update Book set Bid ="+GBid+" where Bid ="+Bid;
				 	stmt.executeUpdate(sql);//执行SQL语句
			 	}else{
			 		if(compare.equals("图书名称")){
			 			System.out.println("请输入你想要更新的值");
			 			Bname = sc.next();
			 			String sql = "update Book set Bname ='"+Bname+"'where Bid ="+Bid;
					 	stmt.executeUpdate(sql);//执行SQL语句
			 		}else{
			 			if(compare.equals("图书单价")){
			 				System.out.println("请输入你想要更新的值");
			 				Price = sc.nextFloat();
			 				String sql = "update Book set Price ="+Price+" where Bid ="+Bid;
						 	stmt.executeUpdate(sql);//执行SQL语句
			 			}else{
			 				if(compare.equals("图书库存")){
			 					System.out.println("请输入你想要更新的值");
			 					Quantity = sc.nextInt();
			 					String sql = "update Book set Quantity ="+Quantity+" where Bid ="+Bid;
							 	stmt.executeUpdate(sql);//执行SQL语句
			 				}else{
			 					System.out.println("输入类型有误");
			 					return;
			 				}
			 			}
			 		}
			 	}
			 	System.out.println("更新成功");
			}catch (SQLException e) {
				 System.out.println("更新失败"); 
			}
	}
}
