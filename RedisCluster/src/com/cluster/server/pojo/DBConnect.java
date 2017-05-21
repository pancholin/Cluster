package com.cluster.server.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cluster.server.model.TBRedisCluster;
import com.cluster.server.model.TBUser;

public class DBConnect {
	Connection Con=null;
	Statement st=null;
	ResultSet rs=null;
	
	/**��ȡ���ݿ���������
	 * @return COnnection
	 * */
	public Connection getCon(){
		DBConstant constant=new DBConstant();
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
	public List<TBUser>executeUser(String sql){
		List<TBUser>list=new ArrayList<TBUser>();
		Connection con=getCon();
		if(con!=null){
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				TBUser user=new TBUser();
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));	
				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				list.add(user);
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
	
	/**��User��ִ�в�ѯ���
	 * @return List<User>
	 * */
	public List<TBRedisCluster>executeRedisCluster(String sql){
		List<TBRedisCluster>list=new ArrayList<TBRedisCluster>();
		Connection con=getCon();
		if(con!=null){
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				TBRedisCluster redisCluster=new TBRedisCluster();
				System.out.println(rs.getInt(1)+" "+rs.getTimestamp(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));	
				redisCluster.setId(rs.getInt(1));	
				redisCluster.setCreated_time(rs.getTimestamp(2).toString());
				redisCluster.setAllocated_memory(rs.getString(3));
				redisCluster.setUsed_memory(rs.getString(4));
				redisCluster.setName(rs.getString(5));
				redisCluster.setState(rs.getInt(6));
				redisCluster.setUserName(rs.getString(7));
				list.add(redisCluster);
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
	
	
	
	
	public SqlResponse insertAndGetId(String sql){
		SqlResponse re=new SqlResponse();
		Connection con=getCon();
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			ResultSet rs=st.executeQuery("SELECT LAST_INSERT_ID()");
			while(rs.next()){
				re.setStateCode(rs.getInt(1));
			};
            re.setMessage("success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error!����ʧ��");
			re.setStateCode(400);
			re.setMessage(e.toString());
			return re;
			
		}
		close();
		return re;
	};
	
	
	public SqlResponse insert(String sql){
		SqlResponse re=new SqlResponse();
		Connection con=getCon();
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			re.setStateCode(200);
			
            re.setMessage("success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error!����ʧ��");
			re.setStateCode(400);
			re.setMessage(e.toString());
			return re;
			
		}
		close();
		return re;
	};
	
	/**�ڲ�������ִ��ɾ�����
	 * @param sql ɾ�����  ����˵����delete from rediscluster where id=2;
	 * @return List<Score>
	 * */
	public SqlResponse delete(String sql){
		
		SqlResponse res=new SqlResponse();
		DBConnect cdb=new DBConnect();
		Connection con=cdb.getCon();
		
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			res.setStateCode(200);
			res.setMessage("ɾ���ɹ�");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error!ɾ��ʧ��");
			res.setStateCode(400);
			res.setMessage(e.toString());
			return res;
		}
		cdb.close();
		return res;
	};
	
	/**�ڲ�������ִ�и������
	 * @param sql �������  ����˵����delete from rediscluster where id=2;
	 * @return List<Score>
	 * */
	public SqlResponse update(String sql){
		SqlResponse re=new SqlResponse();
		DBConnect cdb=new DBConnect();
		Connection con=cdb.getCon();
		if(con==null){re.setStateCode(401);re.setMessage("dateBase not connection");}
		try {
			Statement st=con.createStatement();
			st.execute(sql);
			re.setStateCode(200);
			re.setMessage("���³ɹ�");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("error!����ʧ��");
			re.setStateCode(400);
			re.setMessage(e.toString());
			return re;
		}
		cdb.close();
		return re;
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
