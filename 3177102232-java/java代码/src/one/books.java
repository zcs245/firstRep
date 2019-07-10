package one;
import java.sql.*;
import java.util.Scanner;
public class books {
	public static void main(String[]args){
		Connection conn = null;//创建连接
		int select = 0;
		boolean ci = true;
		
		Scanner sc = new Scanner(System.in);
		try {
			//是com.mysql-connector-java5里的   固定写法
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			 System.out.println("无法找到驱动类");
		}
		try {
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/books?user=root&password=123");
			//mysqlURL=协议名+IP地址（域名）+端口+数据库名，用户名，密码
			System.out.println("建立连接成功！");
		} catch (SQLException e) {
			 System.out.println("连接失败！");
		}
		
		voluation val = new voluation();
		val.values(conn,null);
		
		int Oid = 1;
		System.out.println("----------图书管理系统----------");
		Users us = new Users();
		int Uid=us.user(conn,null,null,sc);
		
		while(ci){
		System.out.println("1.显示当前信息\t2.增加书目\t3.删除书目\n4.更改书目信息\t5.查询书目"
				+ "\t6.购买\t7.退出");
		System.out.println("输入你的选择");
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
				System.out.printf("关闭成功");
			}catch (SQLException e) {
				 System.out.println("无法关闭！"); 	}
		
	}
}
