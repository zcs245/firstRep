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
			System.out.println("������Ҫ�����ͼ���ͼ����");
			int MBid = sc.nextInt();
			rs = stmt.executeQuery("select * from Book where Bid="+MBid);
			
		 	if(rs.next()==false){
		 		System.out.println("δ�ҵ��������ͼ��");
		 		return;
		 	}
		 	
		   int Bid = rs.getInt("Bid");
           float Price = rs.getFloat("Price");
           int Quantity = rs.getInt("Quantity");
          
           
			System.out.println("���������������ͼ�������");
			int Num = sc.nextInt();
			if(Quantity-Num<0){
				System.out.println("����Ҫ����������������");
				return;
			}
			Total =Total+ Num*Price;
			String[] sqls = new String[3];
			sqls[0] ="insert into Order_detail(Oid,Bid,Num)values("+Oid+","+Bid+","+Num+")";
			sqls[1] ="update Book set Quantity ="+(Quantity-Num)+" where Bid ="+Bid;
			stmt.executeUpdate(sqls[0]);//ִ��SQL���
			stmt.executeUpdate(sqls[1]);//ִ��SQL���
			
			System.out.println("�Ƿ�������򣿣��ǡ�Y��,��N��)");
			T = sc.next();
			if(T.equals("Y")){
				continue;
			}else{
				if(T.equals("N")){
					sqls[2] ="update Orders set Total ="+Total+",Odate = now() where Oid ="+Oid;
					stmt.executeUpdate(sqls[2]);//ִ��SQL���
					break;
				}
				else{
					System.out.println("�������");
					return;}
				}
			}
			
			System.out.println("----------ͼ�鶩��----------");
			System.out.println("ͼ�鶩���ţ�"+String.format("%04d",Oid));
			System.out.println("\tͼ������\t"+"\tͼ������\t"+"\tͼ�鵥��");
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
			System.out.println("\n�����ܶ�:"+Total+"      ���ڣ�"+date+"\n--------------------");
		}catch(SQLException e) {
			 System.out.println("����ʧ��");}
	}
}
