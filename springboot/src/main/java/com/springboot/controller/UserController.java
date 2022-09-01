package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.common.ResultObject;
import com.springboot.service.UserService;

/**
 * 用户表
 * @author
 * @since
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    UserService userService;


	/**
	 * 新增
	 * @param params
	 * @return
	 */
    @PostMapping("/add")
    public ResultObject add(@RequestBody Map<String, Object> params){
    	userService.add(params);
    	return ResultObject.isOk(); 
    }


	/**
	 * 更新
	 * @param params
	 * @return
	 */
    @PostMapping("/update")
    public ResultObject update(@RequestBody Map<String, Object> params){
    	userService.update(params);
    	return ResultObject.isOk();  
    }


	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
    public ResultObject delete(String id){
    	userService.delete(id);
    	return ResultObject.isOk();  
    }


	/**
	 * 查询分页数据
	 * @param params
	 * @return
	 */
	@PostMapping("queryList")
	public ResultObject queryList(@RequestBody Map<String, Object> params){
		Map<String, Object> result = userService.queryList(params);
		return ResultObject.isOk(result.get("list"),Integer.valueOf(result.get("count").toString()));
	}

	
	/**
	 * id查询
	 * @param id
	 * @return
	 */
    @GetMapping("/queryDetail")
    public ResultObject queryDetail(String id){
    	Map<String, Object> result = userService.queryDetail(id);
    	return ResultObject.isOk(result); 
    }
	
}
