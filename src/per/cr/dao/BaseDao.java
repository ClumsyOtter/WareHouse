package per.cr.dao;

import java.io.Serializable;
import java.util.List;
public interface BaseDao<T> {
	/**
	 * @note 通用基础dao接口 Serializable 作用是可以接受实现了此接口的所有子类包括（String Double integer
	 *       等等）
	 */
	public List<T> findAll(); // 查询所有

	public T findById(int id); // 只查询一个，常用于修改

	public void add(T entity); // 增加，用实体作为参数

	public void update(T entity); // 修改，用实体作为参数

	public void deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public void delete(Serializable[] ids); // 批量删除；支持整数型和字符串类型ID

	List<T> findByPage(String page, String rows); //分页
	
	List<T> findByTid(String valueOf); //查询T的id
	
}
