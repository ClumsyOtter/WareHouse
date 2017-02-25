package per.cr.service;

import java.io.Serializable;
import java.util.List;

import per.cr.entity.Cargo;
import per.cr.entity.Json;

public interface CargoService {
	public List<Cargo> findAll(); // 查询所有

	public Cargo findById(int id); // 只查询一个，常用于修改

	public void add(Cargo entity); // 增加，用实体作为参数

	public void update(Cargo entity); // 修改，用实体作为参数

	public void deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public void delete(Serializable[] ids); // 批量删除；支持整数型和字符串类型ID

	public List<Cargo> findByPage(String page, String rows); //查询页面

	public List<Cargo> findByCargoId(String value);

	public List<Json> findStoreIds();//查询store的编号，来限制增加货物时只能加入已有的仓库

}
