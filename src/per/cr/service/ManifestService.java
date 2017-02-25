package per.cr.service;

import java.io.Serializable;
import java.util.List;

import per.cr.entity.Json;
import per.cr.entity.Manifest;

public interface ManifestService {
	public List<Manifest> findAll(); // 查询所有

	public Manifest findById(int id); // 只查询一个，常用于修改

	public void add(Manifest entity); // 增加，用实体作为参数

	public void update(Manifest entity); // 修改，用实体作为参数

	public void deleteById(Serializable id); // 按id删除，删除一条；支持整数型和字符串类型ID

	public void delete(Serializable[] ids); // 批量删除；支持整数型和字符串类型ID
	public List<Manifest> findByTypePage(String page, String rows, String type); //查询页面

	public List<Json> findStoreIds();

	public List<Manifest> findByManifestId(String value);

	public List<Json> findOperatorIds();

	public List<Json> findCargoIds();

	public List<Json> findStoreIds(String cargoid); //依照货物id来查询其对应的仓库id

	public void addOut(Manifest manifest);	//增加出货单
	
	public String checkNum(String cargo_id, String store_id,String num);
	
	public void updateCargo(Manifest entity);
}
