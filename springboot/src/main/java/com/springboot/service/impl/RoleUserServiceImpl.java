package com.springboot.service.impl;

import com.springboot.mapper.RoleUserMapper;
import com.springboot.service.RoleUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author
 * @since
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

	@Autowired
    RoleUserMapper roleUserMapper;
 
    /**
	 * 新增
	 * @param params
	 * @return
	 */
    public void add(Map<String, Object> params) {
		roleUserMapper.add(params);
	}
 

	/**
	 * 查询分页数据
	 * @param params
	 * @return
	 */
    public Map<String, Object> queryList(Map<String, Object> params) {
		params.put("page",
				(Integer.valueOf(params.get("page").toString()) - 1) * Integer.valueOf(params.get("limit").toString()));
		List<Map<String, Object>> list = roleUserMapper.queryList(params);
		int count = roleUserMapper.queryCount(params);
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
		
		Map<String, Object> result = roleUserMapper.queryDetail(id);
		return result;
	}

	/**
	 * 更新
	 * @param params
	 * @return
	 */
	public void update(Map<String, Object> params) {
		 
		roleUserMapper.update(params);
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		 
		roleUserMapper.delete(id);
	}

}
