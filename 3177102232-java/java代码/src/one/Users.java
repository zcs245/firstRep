package one;

import java.sql.*;
import java.util.Scanner;
public class Users {
	int user(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
			String Password;
			int Uid = 0;
			while(true){
			System.out.printf("�û�����");
			Uid = sc.nextInt();
			System.out.printf("���룺");
			Password = sc.next();
			stmt = conn.createStatement();
			String sql="select * from user where Uid='"+Uid+"' and password='"+Password+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("��¼�ɹ�����ӭ����");
				break;}
			else
				System.out.println("��¼ʧ�ܣ����������룡");
			}
			return Uid;
			}catch (SQLException e){
					System.out.println("��¼�쳣");}
		return 0;
	}
}
