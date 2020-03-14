package com.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerApp {

	public static void main(String[] args) {
		
		WebCrawler webCrawler = new WebCrawler();
		
		String rootUrl = "http://www.bbc.com";
		
		webCrawler.discoverWeb(rootUrl);

	}

}

class WebCrawler{
	
	private Queue<String> queue;
	private List<String> discoverWesSitesList;
	
	
	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoverWesSitesList = new ArrayList<>();
	}
	
	public void discoverWeb(String root) {
		
		this.queue.add(root);
		this.discoverWesSitesList.add(root);
		
		while(!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHtml = readURL(v);
			
			String regexp = "(https?://)?(www\\.)?\\w+\\.com";
			
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawHtml);
			
			while(matcher.find()) {
				
				String actualUrl = matcher.group();
				
				if(!discoverWesSitesList.contains(actualUrl)) {
					discoverWesSitesList.add(actualUrl);
					System.out.println("WebSite has been foud with URL  "+actualUrl);
					queue.add(actualUrl);
				}
				
				
			}
			
		}
		
	}

	private String readURL(String v) {
		String rawHtml = "";
		
		try {
			
			URL url = new URL(v);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			
			while((inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rawHtml;
	}
	
	
	
}
