package per.cr.dao;

import java.util.List;
import java.util.Map;

import per.cr.entity.Cargo;
import per.cr.entity.Json;
/*
 * 此为产品特有属性，就是运输途中的状态
 */
import per.cr.entity.Manifest;

public interface ManifestDao extends BaseDao<Manifest> {

	public List<Json> findStoreIds(String cargoid);

	public List<Json> findStoreIds();

	public List<Json> findOperatorIds();

	public List<Json> findCargoIds();

	public void updateCargo(Manifest entity);

	public void addCargo(Manifest entity);

	public List<Manifest> findByTypePage(String page, String rows, String type);
	public Cargo getCargo(Map<String, String> map);

}
