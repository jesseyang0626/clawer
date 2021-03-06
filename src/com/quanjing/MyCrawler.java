/**
 * hzdd Software Inc.
 * Copyright (c) 2015 All Rights Reserved.
 *<pre>
 *<li>Author: 廖永光</li>
 *<li>Date: 2016年8月24日</li>
 *</pre>
 */
package com.quanjing;

import java.util.Set;

/**
 *                       
 * @Filename: MyCrawler.java
 * @Description: 
 * @Version: 1.0
 * @Author: 廖永光
 * @Email: 964793210@qq.com
 *<li>Date: 2016年8月24日</li>
 * @History:<br>
 * 
 */
public class MyCrawler {
	/** 
	  * 使用种子初始化URL队列 
	  */  
	 private void initCrawlerWithSeeds(String[] seeds) {  
	  for (int i = 0; i < seeds.length; i++)  
	   SetQueue.addUnvisitedUrl(seeds[i]);  
	 }  
	 // 定义过滤器，提取以 <a target=_blank href="http://www.xxxx.com/" style="color: rgb(0, 102, 153); text-decoration: none;">http://www.xxxx.com</a>开头的链接  
	 public void crawling(String[] seeds) {  
//	  LinkFilter filter = new LinkFilter() {  
//	   @Override
//	public boolean accept(String url) {  
//	    if (url.startsWith("http://www.baidu.com/"))  
//	     return true;  
//	    else  
//	     return false;  
//	   }  
//	  };  
	  // 初始化 URL 队列  
	  initCrawlerWithSeeds(seeds);  
	  // 循环条件：待抓取的链接不空且抓取的网页不多于 1000  
	  while (!SetQueue.unVisitedUrlsEmpty()  
	    && SetQueue.getVisitedUrlNum() <= 10000) {  
	   // 队头 URL 出队列  
	   String visitUrl = (String) SetQueue.unVisitedUrlDeQueue();  
	   if (visitUrl == null)  
	    continue;  
//	   DownLoad downLoader = new DownLoad();  
	   // 下载网页  
//	   downLoader.downloadFile(visitUrl);  
	   //下载图片
//	   DownLoad.downloadImg(visitUrl);
	   // 该 URL 放入已访问的 URL 中  
	   QuanJing.getTag(visitUrl);
	   SetQueue.addVisitedUrl(visitUrl);  
	   // 提取出下载网页中的 URL  
	   //Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);  
	   Set<String> links =JsoupTool.extracLinks(visitUrl);
	   // 新的未访问的 URL 入队  
	   for (String link : links) {  
	    SetQueue.addUnvisitedUrl(link);  
	   }  
	  }  
	 }  
	
	 public static void main(String[] args) {  
	  MyCrawler crawler = new MyCrawler();  
	  crawler.crawling(new String[] { "http://creative.quanjing.com/creative/#人车生活" });  
	 }  
}
