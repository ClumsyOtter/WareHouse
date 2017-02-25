package per.cr.dao.imp;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import per.cr.dao.CargoDao;
import per.cr.entity.Cargo;
import per.cr.entity.Json;

@Component
public class CargoDaoImp extends BaseDaoImp<Cargo> implements CargoDao {
	public CargoDaoImp() {
		super.setNamespace("mappers.CargoMapper");
	}

	@Override
	public List<Json> findStoreIds() {

		return getSqlSession().selectList(getNamespace()+".findStoreIds");
	}

	@SuppressWarnings("unused")
	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CargoDaoImp cargoDaoImp = (CargoDaoImp) ac.getBean("cargoDaoImp");
		
	}

}
