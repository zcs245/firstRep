package one;
import java.sql.*;
import java.util.Scanner;
public class delete {
	void deletetable(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
				stmt = conn.createStatement();
				int Bid = 0;
				System.out.println("��������ɾ����ͼ���ͼ����");
				Bid = sc.nextInt();
				rs = stmt.executeQuery("select * from Book where Bid="+Bid);
			 	if(rs.next()==false){
			 		System.out.println("δ�ҵ���ɾ����ͼ����");
			 		return;
			 	}
				String sql = "delete from Book where Bid = "+Bid;
				stmt.execute(sql);//ִ��SQL���
				System.out.println("ɾ���ɹ���");
		}catch (SQLException e) {
			 System.out.println("ɾ��ʧ��"); }
	}
}
