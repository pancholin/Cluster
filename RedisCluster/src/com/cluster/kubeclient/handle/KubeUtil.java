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
	
	
	public String getRCJson(){
		String str="{\"kind\":\"ReplicationController\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"redis-master\",\"labels\":{\"name\":\"redis-master\"}},\"spec\":{\"replicas\":1,\"selector\":{\"name\":\"redis-master\"},\"template\":{\"metadata\":{\"labels\":{\"name\":\"redis-master\"}},\"spec\":{\"containers\":[{\"name\":\"master\",\"image\":\"redis\",\"ports\":[{\"containerPort\":6379}]}]}}}}";
		
		return str;	
	}
	
	
	public String getSVCJson(){
		String str="{\"metadata\":{\"name\":\"redis-master\",\"labels\":{\"name\":\"redis-master\"}},\"apiVersion\":\"v1\",\"kind\":\"Service\",\"spec\":{\"selector\":{\"name\":\"redis-master\"},\"ports\":[{\"port\":6379,\"targetPort\":6390}]}}";
		return str;
	}
	
	
	
	
	
	
	

}
