package per.cr.service.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import per.cr.dao.ManifestDao;
import per.cr.entity.Cargo;
import per.cr.entity.Json;
import per.cr.entity.Manifest;
import per.cr.service.ManifestService;

@Service
public class ManifestServiceImp implements ManifestService {

	@Resource
	ManifestDao manifestDao;

	@Override
	public List<Manifest> findAll() {

		return manifestDao.findAll();
	}

	@Override
	public Manifest findById(int id) {
		return manifestDao.findById(id);
	}

	@Override
	public void add(Manifest entity) {
		manifestDao.add(entity);
		List<Json> jsons = manifestDao.findStoreIds(entity.getCargo_id());
		int flag = 0;
		for (Json json : jsons) {
			if (json.getText().equals(entity.getStore_id())) {
				flag = 1;
				manifestDao.updateCargo(entity);
			}
		}
		if (flag == 0) {
			manifestDao.addCargo(entity);
		}

	}

	@Override
	public void addOut(Manifest manifest) {
		manifestDao.add(manifest);
		manifest.setNum(0 - manifest.getNum());
		manifestDao.updateCargo(manifest);

	}

	@Override
	public void update(Manifest entity) {
		manifestDao.update(entity);
		if (entity.getType().equals("1"))
			entity.setNum(0 - entity.getNum());
		manifestDao.updateCargo(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		Integer ids = (Integer) id;
		Manifest manifest = manifestDao.findById(ids);
		if (manifest.getType().equals("0"))
			manifest.setNum(0 - manifest.getNum());
		manifestDao.updateCargo(manifest);
		manifestDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		for (Serializable id : ids)
			deleteById(id);
	}

	@Override
	public List<Manifest> findByTypePage(String page, String rows, String type) {
		List<Manifest> manifests = manifestDao.findByTypePage(page, rows, type);
		return manifests;
	}

	@Override
	public List<Manifest> findByManifestId(String value) {
		return manifestDao.findByTid(value);
	}

	@Override
	public List<Json> findOperatorIds() {
		List<Json> ids = manifestDao.findOperatorIds();
		for (int i = 0; i < ids.size(); i++) {
			ids.get(i).setId(i);
		}
		return ids;
	}

	@Override
	public List<Json> findCargoIds() {
		List<Json> ids = manifestDao.findCargoIds();
		List<Json> id = new ArrayList<Json>();
		for (int i = 0; i < ids.size(); i++) {
			int flag = 0;
			int j = 0;
			for (; j < id.size(); j++) {
				if (id.get(j).getText().equals(ids.get(i).getText())) {
					flag = 1;
				}
			}
			if (flag == 0) {
				id.add(ids.get(i));
				id.get(i).setId(i);
			}
		}
		return id;
	}

	@Override
	public List<Json> findStoreIds(String cargoid) {
		List<Json> ids = manifestDao.findStoreIds(cargoid);
		for (int i = 0; i < ids.size(); i++) {
			ids.get(i).setId(i);
		}
		return ids;
	}

	@Override
	public List<Json> findStoreIds() {
		List<Json> ids = manifestDao.findStoreIds();
		for (int i = 0; i < ids.size(); i++) {
			ids.get(i).setId(i);
		}
		return ids;
	}

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ManifestServiceImp manifestServiceImp = (ManifestServiceImp) ac
				.getBean("manifestServiceImp");
		Manifest manifest = new Manifest();
		manifest.setCargo_id("W78");
		manifest.setId("C789");
		manifest.setNum(Double.valueOf(90.0));
		manifest.setOperator("O1037");
		manifest.setStore_id("S4");
		manifestServiceImp.manifestDao.update(manifest);

	}

	@Override
	public String checkNum(String cargo_id, String store_id, String num) {
		double nums;
		try {
			nums = Double.valueOf(num);
		} catch (Exception e) {
			return "请输入数字";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("cargo_id", cargo_id);
		map.put("store_id", store_id);
		Cargo cargo = manifestDao.getCargo(map);
		if (cargo.getNum() < nums)
			return "货物数量超出库存";
		else
			return "success";
	}

	@Override
	public void updateCargo(Manifest entity) {
		manifestDao.updateCargo(entity);
	}
}
