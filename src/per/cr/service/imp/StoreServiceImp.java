package per.cr.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import per.cr.dao.StoreDao;
import per.cr.entity.Store;
import per.cr.service.StoreService;

@Service
public class StoreServiceImp implements StoreService {
	@Resource
	StoreDao storeDao;

	@Override
	public List<Store> findAll() {

		return storeDao.findAll();
	}

	@Override
	public Store findById(int id) {
		return storeDao.findById(id);
	}

	@Override
	public void add(Store entity) {
		storeDao.add(entity);

	}

	@Override
	public void update(Store entity) {
		storeDao.update(entity);

	}

	@Override
	public void deleteById(Serializable id) {
		storeDao.deleteById(id);

	}

	@Override
	public void delete(Serializable[] ids) {
		for (Serializable i : ids)
			storeDao.deleteById(i);

	}

	@Override
	public List<Store> findByPage(String page, String rows) {
		return storeDao.findByPage(page, rows);
	}

	@Override
	public List<Store> findByStoreId(String value) {
		return storeDao.findByTid(value);
	}

}
