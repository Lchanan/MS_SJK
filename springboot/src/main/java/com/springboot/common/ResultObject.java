package com.springboot.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 返回类
 * @param  
 */
public class ResultObject {

	 	public static final Integer SUCCESS_CODE = 0;
	    public static final String SUCCESS_MSG="接口调用成功";
	    public static final Integer ERROR_CODE = 1;
	    public static final String ERROR_MSG = "接口调用失败";

	    private Integer code; 
		
		private String msg;
		
		@JsonInclude(Include.NON_NULL)
		private Object data;
		
		private Integer count; 
		
		public static ResultObject isOk(Object data){
			return new ResultObject(SUCCESS_CODE,"OK",data,0);
		}
		
		public static ResultObject isOk(Object data,Integer count){
			
			return new ResultObject(SUCCESS_CODE,"OK",data,count);
		} 
		
	   public static ResultObject isOk(Integer code,Object data,Integer count){
			
			return new ResultObject(SUCCESS_CODE,"OK",data,count);
		}
		

		public static ResultObject isOk(){
			return new ResultObject(SUCCESS_CODE,"OK",0);
		}  
		
		
		public static ResultObject ErrorMsg(){
			return new ResultObject(ERROR_CODE,"error",0);
		}
		
		public static ResultObject ErrorMsg(Object data){
			return new ResultObject(500,"error",data,0);
		} 
		
		
		public static ResultObject ErrorMsg(Integer code,Object data){
			return new ResultObject(code,"error",data,0);
		}
		
		public ResultObject() {
			super();
		}

		public ResultObject(Integer code, String msg, Integer count) {
			super();
			this.code = code;
			this.msg = msg;
			this.count = count;
		}

		public ResultObject(Integer status, String msg, Object data, Integer count) {
			super();
			this.code = status;
			this.msg = msg;
			this.data = data;
			this.count = count;
		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

    
}
