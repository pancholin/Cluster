package com.cluster.server.pojo;

public class Constant {
	
	public  final String DB="kubeCluster";//在MySQL中定义的数据库名字
	public  final String USER_TABLE="user";//在MySQL中定义的表
	
	public  final String JDBC_DRIVER="com.mysql.jdbc.Driver";//驱动器
	public  final String url="jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";//地址
	//120.77.46.44
	public  final String SQL_USER_NAME="root";//MYSQL中配置的用户名
	public  final String SQL_PASSWORD="linpanxue";//MYSQL中配置的用户登录密码
	
	
}
