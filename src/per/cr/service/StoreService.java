package per.cr.service;

import java.io.Serializable;
import java.util.List;

import per.cr.entity.Store;

public interface StoreService {
	public List<Store> findAll(); // 查询所有

	public Store findById(int id); // 只查询一个，常用于修改

	public void add(Store entity); // 增加，用实体作为参数

	public void update(Store entity); // 修改，用实体作为参数

	public void deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public void delete(Serializable[] ids); // 批量删除；支持整数型和字符串类型ID
	public List<Store> findByPage(String page, String rows); //查询页面

	public List<Store> findByStoreId(String value);
}
