package per.cr.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import per.cr.dao.CargoDao;
import per.cr.entity.Cargo;
import per.cr.entity.Json;
import per.cr.service.CargoService;

@Service
public class CargoServiceImp implements CargoService {
	@Resource
	CargoDao cargoDao;

	@Override
	public List<Cargo> findAll() {

		return cargoDao.findAll();
	}

	@Override
	public Cargo findById(int id) {
		return cargoDao.findById(id);
	}

	@Override
	public void add(Cargo entity) {
		cargoDao.add(entity);

	}

	@Override
	public void update(Cargo entity) {
		cargoDao.update(entity);

	}

	@Override
	public void deleteById(Serializable id) {
		cargoDao.deleteById(id);

	}

	@Override
	public void delete(Serializable[] ids) {
		for (int i = 0; i < ids.length; i++) {
			cargoDao.deleteById(ids[i]);
		}

	}

	@Override
	public List<Cargo> findByPage(String page, String rows) {

		return cargoDao.findByPage(page, rows);
	}

	@SuppressWarnings({ "resource", "unused" })
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CargoServiceImp cargoService = (CargoServiceImp) ac
				.getBean("cargoServiceImp");
	}

	@Override
	public List<Cargo> findByCargoId(String valueOf) {

		return cargoDao.findByTid(valueOf);
	}

	@Override
	public List<Json> findStoreIds() {
		List<Json> jsons = cargoDao.findStoreIds();
		for (int i = 0; i < jsons.size(); i++) {
			jsons.get(i).setId(i);
		}
		return jsons;
	}

}
