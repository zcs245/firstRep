package one;
import java.sql.*;
import java.util.Scanner;
public class pay {
	void payment(Connection conn,Statement stmt,ResultSet rs,Scanner sc,int Oid,int Uid){
		try{
			String T;
			String date = null;
			float Total = 0f;
			stmt = conn.createStatement();
			String sql ="insert into Orders(Oid,Uid)values("+Oid+","+Uid+")";
			stmt.execute(sql);
			
			while(true){
			System.out.println("输入你要购买的图书的图书编号");
			int MBid = sc.nextInt();
			rs = stmt.executeQuery("select * from Book where Bid="+MBid);
			
		 	if(rs.next()==false){
		 		System.out.println("未找到你想买的图书");
		 		return;
		 	}
		 	
		   int Bid = rs.getInt("Bid");
           float Price = rs.getFloat("Price");
           int Quantity = rs.getInt("Quantity");
          
           
			System.out.println("请继续输入你想买图书的数量");
			int Num = sc.nextInt();
			if(Quantity-Num<0){
				System.out.println("你想要购买的数量超过库存");
				return;
			}
			Total =Total+ Num*Price;
			String[] sqls = new String[3];
			sqls[0] ="insert into Order_detail(Oid,Bid,Num)values("+Oid+","+Bid+","+Num+")";
			sqls[1] ="update Book set Quantity ="+(Quantity-Num)+" where Bid ="+Bid;
			stmt.executeUpdate(sqls[0]);//执行SQL语句
			stmt.executeUpdate(sqls[1]);//执行SQL语句
			
			System.out.println("是否继续购买？（是“Y”,否“N”)");
			T = sc.next();
			if(T.equals("Y")){
				continue;
			}else{
				if(T.equals("N")){
					sqls[2] ="update Orders set Total ="+Total+",Odate = now() where Oid ="+Oid;
					stmt.executeUpdate(sqls[2]);//执行SQL语句
					break;
				}
				else{
					System.out.println("输入错误");
					return;}
				}
			}
			
			System.out.println("----------图书订单----------");
			System.out.println("图书订单号："+String.format("%04d",Oid));
			System.out.println("\t图书名称\t"+"\t图书数量\t"+"\t图书单价");
			String sqlp = "  select * from User join Orders on User.Uid = Orders.Uid  and User.Uid ="+Uid
					+" join Order_detail on Order_detail.Oid = Orders.Oid and Orders.Oid ="+Oid
				    +" join book on book.Bid = Order_detail.Bid";
			rs = stmt.executeQuery(sqlp);
			while (rs.next()) {
	             String Bname = rs.getString("Bname");
	             int Num = rs.getInt("Num");
	             float Price = rs.getFloat("Price");
	             date = rs.getString("Odate");
	             System.out.printf("%12s\t%12d\t%12.1f\n",Bname,Num,Price);
			}
			System.out.println("\n订单总额:"+Total+"      日期："+date+"\n--------------------");
		}catch(SQLException e) {
			 System.out.println("购买失败");}
	}
}
