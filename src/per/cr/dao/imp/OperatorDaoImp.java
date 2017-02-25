package per.cr.dao.imp;

import java.util.Random;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import per.cr.dao.OperatorDao;
import per.cr.entity.Operator;

@Component
public class OperatorDaoImp extends BaseDaoImp<Operator> implements OperatorDao {
	public OperatorDaoImp() {
		super.setNamespace("mappers.OperatorMapper");
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OperatorDaoImp operatorDaoImp = (OperatorDaoImp) ac.getBean("operatorDaoImp");
		Operator operator = new Operator();
		for(int i=0;i<100;i++){
			Random random = new Random();
			int num = random.nextInt(1000)+100;
			operator.setId("O"+num);
			operator.setName("Operator"+num);
			operator.setPower("0");
			operator.setPwd("pwd"+num);
			operatorDaoImp.add(operator);
		}
	}
}
