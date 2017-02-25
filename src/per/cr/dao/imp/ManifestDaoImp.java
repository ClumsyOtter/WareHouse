package per.cr.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import per.cr.dao.ManifestDao;
import per.cr.entity.Cargo;
import per.cr.entity.Json;
import per.cr.entity.Manifest;

@Component
public class ManifestDaoImp extends BaseDaoImp<Manifest> implements ManifestDao {
	public ManifestDaoImp() {
		super.setNamespace("mappers.ManifestMapper");
	}

	@Override
	public List<Json> findStoreIds() {
		return getSqlSession().selectList(getNamespace() + ".findStoreIds");
	}

	@Override
	public List<Json> findOperatorIds() {
		return getSqlSession().selectList(getNamespace() + ".findOperatorIds");
	}

	@Override
	public List<Json> findCargoIds() {
		return getSqlSession().selectList(getNamespace() + ".findCargoIds");
	}

	@Override
	public List<Json> findStoreIds(String cargoid) {
		return getSqlSession().selectList(getNamespace() + ".findStoreId",
				cargoid);
	}

	@Override
	public void updateCargo(Manifest entity) {
		getSqlSession().update(getNamespace() + ".updateCargo", entity);
	}

	@Override
	public void addCargo(Manifest entity) {
		List<Cargo> cargos = getSqlSession().selectList(
				getNamespace() + ".getCargos", entity.getCargo_id());
		Cargo cargo = null;
		if (cargos.size() > 0)
			cargo = cargos.get(0);
		cargo.setNum(entity.getNum());
		cargo.setStore_id(entity.getStore_id());
		getSqlSession().insert(getNamespace() + ".addCargo", cargo);
	}

	@Override
	public List<Manifest> findByTypePage(String page, String rows, String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer pagenum = Integer.valueOf(page);
		Integer rowsnum = Integer.valueOf(rows);
		Integer start = (pagenum - 1) * rowsnum;
		Integer end = rowsnum;
		map.put("start", start);
		map.put("end", end);
		map.put("type", type);
		return getSqlSession().selectList(getNamespace() + ".findByTypePage", map);
	}

	@Override
	public Cargo getCargo(Map<String, String> map) {
		
		return getSqlSession().selectOne(getNamespace()+".getCargo",map);
	}
}
