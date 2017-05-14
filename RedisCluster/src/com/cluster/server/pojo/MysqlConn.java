package com.cluster.server.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cluster.server.model.User;



public class MysqlConn {
	Connection Con=null;
	Statement st=null;
	ResultSet rs=null;
	
	/**��ȡ���ݿ���������
	 * @return COnnection
	 * */
	public Connection getCon(){
		Constant constant=new Constant();
		try {
			try {
				Class.forName(constant.JDBC_DRIVER);
				Con=DriverManager.getConnection(constant.url,constant.SQL_USER_NAME,constant.SQL_PASSWORD);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return null;
		}
		
		return Con;
	}
	
	/**��User��ִ�в�ѯ���
	 * @return List<User>
	 * */
	public List<User>executeUser(String sql){
		List<User>list=new ArrayList<User>();
		Connection con=getCon();
		if(con!=null){
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				User user=new User();
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));	
				user.setName(rs.getString(0));
				user.setPassword(rs.getString(1));
				user.setEmail(rs.getString(2));
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		}
		else{
			return null;
		}	
	};
	
	/*
	 * �ر����ݿ�����
	 */
	public void close(){
		
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(Con!=null)Con.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}

	

}
