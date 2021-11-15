package com.sbs.exam.demo.vo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Getter;

public class Rq {
	@Getter
	private boolean isLogined;
	@Getter
	private int loginedMemberId;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession httpSession; 
	public Rq(HttpServletRequest req, HttpServletResponse resp) {
		this.httpSession = req.getSession();
		this.req = req;
		this.resp = resp;
		
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
	}

	public void printHistoryBackJs() {
		resp.setContentType("text/html; charset=utf-8");
		print("<script>");
		print("		alert('로그인이 필요합니다.');");
		print("		history.back();");
		print("</script>");
		
	}
	
	public void print(String msg) {
		try {
			resp.getWriter().append(msg);			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
