//package com.sbs.exam.demo.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.sbs.exam.demo.vo.Article;
//
//@Controller
//public class UsrHomeController {
//	@RequestMapping("/usr/home/getInt")
//	@ResponseBody
//	public int getInt() {
//		return Integer.SIZE;
//	}
//	
//	@RequestMapping("/usr/home/getFloat")
//	@ResponseBody
//	public float getFLoat() {
//		return Float.SIZE;
//	}
//	
//	@RequestMapping("/usr/home/getDouble")
//	@ResponseBody
//	public double getDouble() {
//		return Double.SIZE;
//	}
//	
//	@RequestMapping("/usr/home/getBoolean")
//	@ResponseBody
//	public boolean getBoolean() {
//		return true;
//		
//	}
//	@RequestMapping("/usr/home/getChar")
//	@ResponseBody
//	public char getChar() {
//		return Character.SIZE;
//	}
//	
//	@RequestMapping("/usr/home/getString")
//	@ResponseBody
//	public String getString() {
//		return "sadf";
//	}
//	
//	@RequestMapping("/usr/home/getMap")
//	@ResponseBody
//	public Map<String, Object> getMap() {
//		Map<String, Object> map = new HashMap<>();
//		
//		map.put("철수의 나이", 22);
//		map.put("영희의 나이", 33);
//		
//		return map;
//	}
//	
//	@RequestMapping("/usr/home/getList")
//	@ResponseBody
//	public List<String> getList() {
//		List<String> list = new ArrayList<>();
//		
//		list.add("철수의 나이");
//		list.add("영희의 나이");
//		
//		return list;
//	}
//	
//	@RequestMapping("/usr/home/getArticle")
//	@ResponseBody
//	public Article getArticle() {
//		Article article = new Article();
//		
//		return article;
//	}
//	
//	@RequestMapping("/usr/home/getArticles")
//	@ResponseBody
//	public List<Article> getArticles() {
//		Article article1 = new Article(1, "제목1");
//		Article article2 = new Article(1, "제목2");
//		
//		List<Article> list = new ArrayList<>();
//		
//		list.add(article1);
//		list.add(article2);
//		
//		return list;
//	}
//}