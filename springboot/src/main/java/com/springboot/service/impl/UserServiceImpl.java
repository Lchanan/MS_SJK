package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 * @since
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserMapper userMapper;
 
    /**
	 * 新增
	 * @param params
	 * @return
	 */
    public void add(Map<String, Object> params) {
    	params.put("create_time", new Date());
		userMapper.add(params);
	}
 

	/**
	 * 查询分页数据
	 * @param params
	 * @return
	 */
    public Map<String, Object> queryList(Map<String, Object> params) {
		params.put("page",
				(Integer.valueOf(params.get("page").toString()) - 1) * Integer.valueOf(params.get("limit").toString()));
		List<Map<String, Object>> list = userMapper.queryList(params);
		int count = userMapper.queryCount(params);
		params = new HashMap<String, Object>();
		params.put("list", list);
		params.put("count", count);
		return params;
	}
	

	/**
	 * id查询详情
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryDetail(String id) {
		
		Map<String, Object> result = userMapper.queryDetail(id);
		return result;
	}

	/**
	 * 更新
	 * @param params
	 * @return
	 */
	public void update(Map<String, Object> params) {
		params.put("update_time", new Date());
		userMapper.update(params);
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		 
		userMapper.delete(id);
	}

}
