package one;
import java.sql.*;
import java.util.Scanner;
public class books {
	public static void main(String[]args){
		Connection conn = null;//��������
		int select = 0;
		boolean ci = true;
		
		Scanner sc = new Scanner(System.in);
		try {
			//��com.mysql-connector-java5���   �̶�д��
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			 System.out.println("�޷��ҵ�������");
		}
		try {
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/books?user=root&password=123");
			//mysqlURL=Э����+IP��ַ��������+�˿�+���ݿ������û���������
			System.out.println("�������ӳɹ���");
		} catch (SQLException e) {
			 System.out.println("����ʧ�ܣ�");
		}
		
		voluation val = new voluation();
		val.values(conn,null);
		
		int Oid = 1;
		System.out.println("----------ͼ�����ϵͳ----------");
		Users us = new Users();
		int Uid=us.user(conn,null,null,sc);
		
		while(ci){
		System.out.println("1.��ʾ��ǰ��Ϣ\t2.������Ŀ\t3.ɾ����Ŀ\n4.������Ŀ��Ϣ\t5.��ѯ��Ŀ"
				+ "\t6.����\t7.�˳�");
		System.out.println("�������ѡ��");
		select = sc.nextInt();
		switch (select)
		{
		case 1:
			show sh = new show();
			sh.showtable(conn,null,null);
			break;
		case 2:
			adddata ad =  new adddata();
			ad.add(conn,null,sc);
			break;
		case 3:
			delete de = new delete();
			de.deletetable(conn,null,null,sc);
			break;
		case 4:
			updata up = new updata();
			up.updatatable(conn,null,null,sc);
			break;
		case 5:
			search se = new search();
			se.searchtable(conn,null,null,sc);
			break;
		case 6:
			pay P = new pay();
			P.payment(conn,null,null,sc,Oid,Uid);
			Oid = Oid +1;
			break;
		case 7:
			ci = false;
			break;
		}
	}
		try {
				conn.close();
				System.out.printf("�رճɹ�");
			}catch (SQLException e) {
				 System.out.println("�޷��رգ�"); 	}
		
	}
}
