package com.sbs.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.service.ArticleService;
import com.sbs.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = articleService.writeArticle(title, body);
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 없는 게시물 입니다.";
		}
		
		return article;
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 없는 게시물입니다.";
		}
		
		articleService.deleteArticle(id);
		
		return id + "번 게시물이 삭제되었습니다.";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 없는 게시물입니다.";
		}
		
		articleService.modifyArticle(id, title, body);
		
		return id + "번 게시물이 수정되었습니다." + "\n" + article;
	}
}
