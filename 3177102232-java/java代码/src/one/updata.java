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
			 	System.out.println("����������Ҫ���µ�ͼ���ͼ�����");
			 	Bid = sc.nextInt();
			 	rs = stmt.executeQuery("select * from Book where Bid="+Bid);
			 	if(rs.next()==false){
			 		System.out.println("δ�ҵ���ŵ���");
			 		return;
			 	}
			 	System.out.println("����������Ҫ���µ����ͣ��� ͼ���ţ�");
			 	compare = sc.next();
			 	
			 	if(compare.equals("ͼ����")){
			 		System.out.println("����������Ҫ���µ�ֵ");
			 		GBid = sc.nextInt();
			 		String sql = "update Book set Bid ="+GBid+" where Bid ="+Bid;
				 	stmt.executeUpdate(sql);//ִ��SQL���
			 	}else{
			 		if(compare.equals("ͼ������")){
			 			System.out.println("����������Ҫ���µ�ֵ");
			 			Bname = sc.next();
			 			String sql = "update Book set Bname ='"+Bname+"'where Bid ="+Bid;
					 	stmt.executeUpdate(sql);//ִ��SQL���
			 		}else{
			 			if(compare.equals("ͼ�鵥��")){
			 				System.out.println("����������Ҫ���µ�ֵ");
			 				Price = sc.nextFloat();
			 				String sql = "update Book set Price ="+Price+" where Bid ="+Bid;
						 	stmt.executeUpdate(sql);//ִ��SQL���
			 			}else{
			 				if(compare.equals("ͼ����")){
			 					System.out.println("����������Ҫ���µ�ֵ");
			 					Quantity = sc.nextInt();
			 					String sql = "update Book set Quantity ="+Quantity+" where Bid ="+Bid;
							 	stmt.executeUpdate(sql);//ִ��SQL���
			 				}else{
			 					System.out.println("������������");
			 					return;
			 				}
			 			}
			 		}
			 	}
			 	System.out.println("���³ɹ�");
			}catch (SQLException e) {
				 System.out.println("����ʧ��"); 
			}
	}
}
