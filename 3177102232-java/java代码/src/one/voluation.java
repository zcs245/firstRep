package one;

import java.sql.*;
public class voluation {
	void values(Connection conn,Statement stmt){
		try{
				String[] sqls = new String[2];
				sqls[0]="insert into user(Uid,Password) values(1,'111'),(2,'222'),(3,'333')";
				sqls[1] = "insert into Book(Bid,Bname,Price,Quantity) values(1,'���ݿ�ԭ���Ӧ��',36.5,26),"
						+ "(2,'Java���Կ���',45.1,30),(3,'C���Գ������',26,24),"
						+ "(4,'�������',39.5,60),"
						+ "(5,'���������',22,41)";
				stmt=conn.createStatement();//����һ��Statement����
				stmt.executeUpdate(sqls[0]);//ִ��SQL���
				stmt.executeUpdate(sqls[1]);//ִ��SQL���
				System.out.println("���뵽���ݿ�ɹ�");
			}catch(SQLException e) {
				System.out.println("�������ݿ�ʧ�ܣ�");
			}
	}
}
