package com.quanjing;

import java.io.IOException;

import org.htmlparser.tags.Div;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QuanJing {
	public static void getTag(String url){
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println("成功打开网站");
			Element divMs = doc.select("div.ms").first();
	//		System.out.println(divMs.toString());
			if(divMs != null){
			System.out.println(divMs.getElementsByTag("p").get(0).text());
			System.out.println(divMs.getElementsByTag("p").get(1).text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String url = "http://creative.quanjing.com/info/412-03995.html";
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println("成功打开网站");
			Element divMs = doc.select("div.ms").first();
	//		System.out.println(divMs.toString());
			System.out.println(divMs.getElementsByTag("p").get(0).text());
			System.out.println(divMs.getElementsByTag("p").get(1).text());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
