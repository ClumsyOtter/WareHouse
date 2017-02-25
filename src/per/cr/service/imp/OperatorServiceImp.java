package per.cr.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import per.cr.dao.OperatorDao;
import per.cr.entity.Operator;
import per.cr.service.OperatorService;

@Service
public class OperatorServiceImp implements OperatorService {

	@Resource
	OperatorDao operatorDao;

	@Override
	public List<Operator> findAll() {

		return operatorDao.findAll();
	}

	@Override
	public Operator findById(int id) {
		return operatorDao.findById(id);
	}

	@Override
	public void add(Operator entity) {
		operatorDao.add(entity);

	}

	@Override
	public void update(Operator entity) {
		operatorDao.update(entity);

	}

	@Override
	public void deleteById(Serializable id) {
		operatorDao.deleteById(id);

	}

	@Override
	public void delete(Serializable[] ids) {
		for (Serializable i : ids) {
			operatorDao.deleteById(i);
		}
	}

	@Override
	public List<Operator> findByPage(String page, String rows) {

		return operatorDao.findByPage(page, rows);
	}

	@Override
	public List<Operator> findByoperatorId(String value) {

		return operatorDao.findByTid(value);
	}

}
