package one;

import java.sql.*;
import java.util.Scanner;
public class Users {
	int user(Connection conn,Statement stmt,ResultSet rs,Scanner sc){
		try{
			String Password;
			int Uid = 0;
			while(true){
			System.out.printf("用户名：");
			Uid = sc.nextInt();
			System.out.printf("密码：");
			Password = sc.next();
			stmt = conn.createStatement();
			String sql="select * from user where Uid='"+Uid+"' and password='"+Password+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("登录成功，欢迎您！");
				break;}
			else
				System.out.println("登录失败，请重新输入！");
			}
			return Uid;
			}catch (SQLException e){
					System.out.println("登录异常");}
		return 0;
	}
}
