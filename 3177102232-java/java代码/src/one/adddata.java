package one;
import java.sql.*;
import java.util.Scanner;
public class adddata {
	void add(Connection conn,Statement stmt,Scanner sc){
		 try{
				int Bid=0,Quantity=0;
				float Price = 0.0f;
				String Bname;
				System.out.println("����������ͼ����");
				stmt = conn.createStatement();
				Bid = sc.nextInt();
				System.out.println("����������ͼ������");
				Bname = sc.next();
				System.out.println("����������ͼ�鵥��");
				Price = sc.nextFloat();
				System.out.println("����������ͼ����");
				Quantity  = sc.nextInt();
			    String sql = "insert into Book(Bid,Bname,Price,Quantity)values("
				+Bid+",'"+Bname+"',"+Price+","+Quantity+")";
			    stmt.executeUpdate(sql);//ִ��SQL���
			    System.out.println("�����ɹ���");
			}catch(SQLException e) {
				 System.out.println("����ʧ�ܣ�");}
	}

}
