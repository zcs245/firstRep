package one;

import java.sql.*;
public class voluation {
	void values(Connection conn,Statement stmt){
		try{
				String[] sqls = new String[2];
				sqls[0]="insert into user(Uid,Password) values(1,'111'),(2,'222'),(3,'333')";
				sqls[1] = "insert into Book(Bid,Bname,Price,Quantity) values(1,'数据库原理和应用',36.5,26),"
						+ "(2,'Java语言开发',45.1,30),(3,'C语言程序设计',26,24),"
						+ "(4,'软件工程',39.5,60),"
						+ "(5,'计算机导论',22,41)";
				stmt=conn.createStatement();//创建一个Statement对象
				stmt.executeUpdate(sqls[0]);//执行SQL语句
				stmt.executeUpdate(sqls[1]);//执行SQL语句
				System.out.println("插入到数据库成功");
			}catch(SQLException e) {
				System.out.println("插入数据库失败！");
			}
	}
}
