package com.sbs.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.service.MemberService;
import com.sbs.exam.demo.util.Ut;
import com.sbs.exam.demo.vo.Member;
import com.sbs.exam.demo.vo.ResultData;

@Controller
public class UsrMemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		if(Ut.empty(loginId)) {
			return ResultData.from("F-1", "아이디를 입력해주세요.");
		}
		if(Ut.empty(loginPw)) {
			return ResultData.from("F-2", "비밀번호를 입력해주세요.");
		}
		if(Ut.empty(name)) {
			return ResultData.from("F-3", "이름을 입력해주세요.");
		}
		if(Ut.empty(nickname)) {
			return ResultData.from("F-4", "닉네임을 입력해주세요.");
		}
		if(Ut.empty(cellphoneNo)) {
			return ResultData.from("F-5", "전화번호를 입력해주세요.");
		}
		if(Ut.empty(email)) {
			return ResultData.from("F-6", "이메일을 입력해주세요.");
		}
		
		ResultData joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		if(joinRd.isFail()) {
			return joinRd;
		}
		
		Member member = memberService.getMemberById((int) joinRd.getData1());
		
		return ResultData.newRd(joinRd, "member", member);
	}
	
	@RequestMapping("/usr/member/getMember")
	@ResponseBody
	public ResultData<Member> getMember(int id) {
		Member member = memberService.getMemberById(id);
		
		if(member == null) {
			return ResultData.from("F-1", "없는 회원번호 입니다.");
		}
		
		return ResultData.from("S-1", Ut.f("%d번 회원 입니다.", id), "member", member);
	}
	
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public ResultData doLogin(HttpSession httpSession, String loginId, String loginPw) {
		boolean isLogined = false;
		
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}
		
		if (isLogined) {
			return ResultData.from("F-5", "이미 로그인되었습니다.");
		}
		
		if(Ut.empty(loginId)) {
			return ResultData.from("F-1", "아이디를 입력해주세요.");
		}
		if(Ut.empty(loginPw)) {
			return ResultData.from("F-2", "비밀번호를 입력해주세요.");
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null) {
			return ResultData.from("F-3", "존재하지 않는 아이디입니다.");
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return ResultData.from("F-4", "비밀번호를 다시 확인해주세요.");
		}
		
		httpSession.setAttribute("loginedMemberId", member.getId());
		
		return ResultData.from("S-1", Ut.f("%s님 환영합니다!", member.getNickname()));
	}
	
	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public ResultData doLogout(HttpSession httpSession) {
		boolean isLogined = false;
		
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			isLogined = true;
		}
		
		if (isLogined) {
			return ResultData.from("S-1", "이미 로그아웃 상태입니다.");
		}
		
		httpSession.removeAttribute("loginedMemberId");
		
		return ResultData.from("S-2", "로그아웃 되셨습니다.");
	}
}


