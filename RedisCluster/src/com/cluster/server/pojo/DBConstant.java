package com.cluster.server.pojo;

public class DBConstant {
	
	public  final String DB="kubecluster";//��MySQL�ж�������ݿ�����
	public  final String USER_TABLE="user";//��MySQL�ж���ı�
	public  final String REDISCLUSTER_TABLE="redis_cluster"; //
	public  final String CLUSTERLINK_TABLE="cluster_link";
	
	
	public  final String JDBC_DRIVER="com.mysql.jdbc.Driver";//������
	public  final String url="jdbc:mysql://123.207.6.42:3306/"+DB+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";//��ַ
	//120.77.46.44
	public  final String SQL_USER_NAME="root";//MYSQL�����õ��û���
	public  final String SQL_PASSWORD="qnmdlpx";//MYSQL�����õ��û���¼����
	
	
}
