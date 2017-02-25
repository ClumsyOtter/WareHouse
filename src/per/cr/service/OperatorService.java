package per.cr.service;

import java.io.Serializable;
import java.util.List;

import per.cr.entity.Operator;

public interface OperatorService {
	public List<Operator> findAll(); // 查询所有

	public Operator findById(int id); // 只查询一个，常用于修改

	public void add(Operator entity); // 增加，用实体作为参数

	public void update(Operator entity); // 修改，用实体作为参数

	public void deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public void delete(Serializable[] ids); // 批量删除；支持整数型和字符串类型ID
	public List<Operator> findByPage(String page, String rows); //查询页面

	public List<Operator> findByoperatorId(String value);
}
