package com.sbs.exam.demo.vo;

import lombok.Getter;

public class ResultData<DT> {
	@Getter
	private String msg;
	@Getter
	private String resultCode;
	@Getter
	private DT data1;
	@Getter
	private String data1Name;
	
	private ResultData() {
		
	}
	
	public static <DT> ResultData<DT> from(String resultCode, String msg, String data1Name, DT data1) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1Name = data1Name;
		rd.data1 = data1;
		
		return rd;
	}
	

	public static ResultData from(String resultCode, String msg) {
		return from(resultCode, msg, null, null);
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}
	
	public static <DT> ResultData<DT> newRd(ResultData oldRd, String data1Name, DT data1) {
		return from(oldRd.getResultCode(), oldRd.getMsg(), data1Name, data1);
	}
}

