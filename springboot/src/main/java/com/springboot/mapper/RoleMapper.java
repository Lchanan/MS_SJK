package com.springboot.mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author
 * @since
 */
public interface RoleMapper {

	/**
	 * 新增
	 * @param params
	 * @return
	 */
	void add(Map<String, Object> params);

	/**
	 * 查询分页数据
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> params);

	int queryCount(Map<String, Object> params);

	/**
	 * id查询详情
	 * @param id
	 * @return
	 */
	Map<String, Object> queryDetail(String id);

	/**
	 * 更新
	 * @param params
	 * @return
	 */
	void update(Map<String, Object> params);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	void delete(String id);

}
