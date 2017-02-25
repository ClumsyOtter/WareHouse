package per.cr.dao.imp;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import per.cr.dao.StoreDao;
import per.cr.entity.Store;

@Component
public class StoreDaoImp extends BaseDaoImp<Store> implements StoreDao {
	public StoreDaoImp() {
		super.setNamespace("mappers.StoreMapper");
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		StoreDaoImp storeDaoImp = (StoreDaoImp) ac.getBean("storeDaoImp");
		Store store = new Store();
		for(int i=0;i<10;i++){
			store.setId("S"+(i+1));
			store.setName("仓库"+(i+1));
			store.setLocat("江西理工大学");
			storeDaoImp.add(store);
		}
	}
}
