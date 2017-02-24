package com.cn;

import java.util.LinkedList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisQueue {
		//使用redis
		Jedis queue = new Jedis("localhost");
		
		/** 
		  * 将t加入到队列中 
		  */  
		 public void inQueue(String t) {  
		  queue.lpush("todo", t);  
		 }  
		 /** 
		  * 移除队列中的第一项并将其返回 
		  */  
		 public String outQueue() {  
		  return queue.lpop("todo");  
		 }  
		 /** 
		  * 返回队列是否为空 
		  */  
		 public boolean isQueueEmpty() {  
		  return (queue.llen("todo") == 0);  
		 }  
		 /** 
		  * 判断并返回队列是否包含t 
		  */  
		 public boolean contians(String t) { 
			 boolean flag = false;
			List<String> lists = queue.lrange("todo",0,Integer.parseInt(String.valueOf(queue.llen("todo"))));
	
			 for(String s:lists){
				 if(s.equals(t)){
					 flag = true;
				 }else{
					 flag =  false;
				 }
			 }
			 return flag;
		 }  
		 /** 
		  * 判断并返回队列是否为空 
		  */  
		 public boolean empty() {  
		  return (queue.llen("todo") == 0);  
		 }  
		 
		 

}
