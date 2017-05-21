package com.cluster.kubeclient.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class KubeUtil {
	public static String Url="http://120.24.72.117:8086/api/v1";
	
	/*
	 * 输入文件地址，读取文件以字符串方式输出
	 */
	public  String ReadFile(String path) {  
        File file = new File(path);  
        BufferedReader reader = null;  
        String laststr = "";  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) {  
                laststr = laststr + tempString;  
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return laststr;  
    }  
	
	/*
	 * 获取创建RC所需json字符串
	 */
	public String getRCJson(String name){
		String str="{\"metadata\":{\"name\":\""+name+"\",\"labels\":{\"name\":\""+name+"\"}},\"apiVersion\":\"v1\",\"kind\":\"ReplicationController\",\"spec\":{\"template\":{\"metadata\":{\"labels\":{\"name\":\""+name+"\"}},\"spec\":{\"containers\":[{\"image\":\"redis\",\"name\":\"master\",\"ports\":[{\"containerPort\":6389}]}]}},\"replicas\":1,\"selector\":{\"name\":\""+name+"\"}}}";
		
		return str;	
	}
	
	/*
	 * 获取创建SVC所需json字符串
	 */
	public String getSVCJson(String name){
		String str="{\"metadata\":{\"name\":\""+name+"\",\"labels\":{\"name\":\""+name+"\"}},\"apiVersion\":\"v1\",\"kind\":\"Service\",\"spec\":{\"selector\":{\"name\":\""+name+"\"},\type\":\"NodePort\",\"ports\":[{\"port\":6389,\"nodePort\":8896}]}}";
		
		return str;
	}
	
	/*
	 * 获取创建RC、SVC所需标签，标签规则：命名规则：redis-用户名-集群id-位置i
	 */
	public String getName(String userName,int redisClusterId,int i){
		return "redis-"+userName+"-"+redisClusterId+"-"+i;
	}
	
	
	
	

}
