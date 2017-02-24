/**
 * hzdd Software Inc.
 * Copyright (c) 2015 All Rights Reserved.
 *<pre>
 *<li>Author: 廖永光</li>
 *<li>Date: 2016年8月24日</li>
 *</pre>
 */
package com.quanjing;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 *                       
 * @Filename: HtmlParserTool.java
 * @Description: 
 * @Version: 1.0
 * @Author: 廖永光
 * @Email: 964793210@qq.com
 *<li>Date: 2016年8月24日</li>
 * @History:<br>
 * 
 */
public class HtmlParserTool {
	// 获取一个网站上的链接，filter 用来过滤链接  
	 public static Set<String> extracLinks(String url, LinkFilter filter) {  
	  Set<String> links = new HashSet<String>();  
	  try {  
	   Parser parser = new Parser(url);  
	   parser.setEncoding("UTF-8");  
	   // 过滤 <frame >标签的 filter，用来提取 frame 标签里的 src 属性  
	   NodeFilter frameFilter = new NodeFilter() {
		
		@Override
		public boolean accept(Node node) {
			  if (node.getText().startsWith("frame src=")) {  
			      return true;  
			     } else {  
			      return false;  
			     }  
			    } 
		};
	   // OrFilter 来设置过滤 <a> 标签和 <frame> 标签  
	   OrFilter linkFilter = new OrFilter(new NodeClassFilter(  
	     LinkTag.class), frameFilter);  
	   // 得到所有经过过滤的标签  
	   NodeList list = parser.extractAllNodesThatMatch(linkFilter);  
	   for (int i = 0; i < list.size(); i++) {  
	    Node tag = list.elementAt(i);  
	    if (tag instanceof LinkTag)// <a> 标签  
	    {  
	     LinkTag link = (LinkTag) tag;  
	     String linkUrl = link.getLink();// URL  
	     if (filter.accept(linkUrl)) 
	      System.out.println(linkUrl);
	      links.add(linkUrl);  
	    } else// <frame> 标签  
	    {  
	     // 提取 frame 里 src 属性的链接， 如 <frame src="test.html"/>  
	     String frame = tag.getText();  
	     int start = frame.indexOf("src=");  
	     frame = frame.substring(start);  
	     int end = frame.indexOf(" ");  
	     if (end == -1)  
	      end = frame.indexOf(">");  
	     String frameUrl = frame.substring(5, end - 1);  
	     if (filter.accept(frameUrl))  
	      links.add(frameUrl);  
	    }  
	   }  
	  } catch (ParserException e) {  
	   e.printStackTrace();  
	  }  
	  return links;  
	 }  
}
