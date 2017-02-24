/**
 * hzdd Software Inc.
 * Copyright (c) 2015 All Rights Reserved.
 *<pre>
 *<li>Author: 廖永光</li>
 *<li>Date: 2016年8月24日</li>
 *</pre>
 */
package com.quanjing;

import java.util.LinkedList;

/**
 *                       
 * @Filename: Queue.java
 * @Description: 
 * @Version: 1.0
 * @Author: 廖永光
 * @Email: 964793210@qq.com
 *<li>Date: 2016年8月24日</li>
 * @History:<br>
 * 
 */

/** 
 * 自定义队列类 保存TODO表 
 */  
public class Queue {
		//使用链表实现队列
	private   static final LinkedList<Object> queue;
	static{
		queue=new LinkedList<Object>();
	}
	/** 
	  * 将t加入到队列中 
	  */  
	 public void inQueue(Object t) {  
	  queue.addLast(t);  
	 }  
	 /** 
	  * 移除队列中的第一项并将其返回 
	  */  
	 public Object outQueue() {  
	  return queue.removeFirst();  
	 }  
	 /** 
	  * 返回队列是否为空 
	  */  
	 public boolean isQueueEmpty() {  
	  return queue.isEmpty();  
	 }  
	 /** 
	  * 判断并返回队列是否包含t 
	  */  
	 public boolean contians(Object t) {  
	  return queue.contains(t);  
	 }  
	 /** 
	  * 判断并返回队列是否为空 
	  */  
	 public boolean empty() {  
	  return queue.isEmpty();  
	 }  
	
}
