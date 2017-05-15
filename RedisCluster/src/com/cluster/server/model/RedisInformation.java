package com.cluster.server.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Redis") 
public class RedisInformation {
	
	String connection_blocker; //被阻塞的连接数
	String connection_connected; //已连接的连接数
	String cpu;   //cpu使用率
	String flow_in; //网络流入量
	String flow_out; //网络流出量
	String hit_rate; //命中率
	String keys_delete; //key已删除
	String keys_expired;  //key已过期
	String keys_setted_expired; //key设置过期
	String key_total;  //key总量
	String memory_total; //总内存
	String memory_using; //已用内存
	String qps;  //每秒查询命令数
	
	public String getConnection_blocker() {
		return connection_blocker;
	}
	public void setConnection_blocker(String connection_blocker) {
		this.connection_blocker = connection_blocker;
	}
	public String getConnection_connected() {
		return connection_connected;
	}
	public void setConnection_connected(String connection_connected) {
		this.connection_connected = connection_connected;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getFlow_in() {
		return flow_in;
	}
	public void setFlow_in(String flow_in) {
		this.flow_in = flow_in;
	}
	public String getFlow_out() {
		return flow_out;
	}
	public void setFlow_out(String flow_out) {
		this.flow_out = flow_out;
	}
	public String getHit_rate() {
		return hit_rate;
	}
	public void setHit_rate(String hit_rate) {
		this.hit_rate = hit_rate;
	}
	public String getKeys_delete() {
		return keys_delete;
	}
	public void setKeys_delete(String keys_delete) {
		this.keys_delete = keys_delete;
	}
	public String getKeys_expired() {
		return keys_expired;
	}
	public void setKeys_expired(String keys_expired) {
		this.keys_expired = keys_expired;
	}
	public String getKeys_setted_expired() {
		return keys_setted_expired;
	}
	public void setKeys_setted_expired(String keys_setted_expired) {
		this.keys_setted_expired = keys_setted_expired;
	}
	public String getKey_total() {
		return key_total;
	}
	public void setKey_total(String key_total) {
		this.key_total = key_total;
	}
	public String getMemory_total() {
		return memory_total;
	}
	public void setMemory_total(String memory_total) {
		this.memory_total = memory_total;
	}
	public String getMemory_using() {
		return memory_using;
	}
	public void setMemory_using(String memory_using) {
		this.memory_using = memory_using;
	}
	public String getQps() {
		return qps;
	}
	public void setQps(String qps) {
		this.qps = qps;
	}
	
	

}
