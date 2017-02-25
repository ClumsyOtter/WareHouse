package per.cr.dao.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import per.cr.dao.BaseDao;

/**
 * 
 * @author msi baseDao为通用的dao层所以不能将参数写死，而是使用灵活的泛型将参数对象的具体类型交给使用者来选择
 * @param <T>
 */
@Component
public class BaseDaoImp<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	/*
	 * 将sqlsessionfactory 通过spring依赖注入进来
	 * 
	 * @see
	 * org.mybatis.spring.support.SqlSessionDaoSupport#setSqlSessionFactory(
	 * org.apache.ibatis.session.SqlSessionFactory)
	 */
	/*
	 * 设置namespace mybatis中利用namespace来寻找sql语句
	 * 
	 * @see per.cr.dao.BaseDao#findPage(per.cr.page.Page)
	 */
	private String namespace;

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 增加
	@Override
	public void add(T entity) {
		this.getSqlSession().insert(getNamespace() + ".add", entity);
	}

	// 删除
	@Override
	public void deleteById(Serializable id) {
		this.getSqlSession().delete(getNamespace() + ".deleteById", id);
	}

	@Override
	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(getNamespace() + ".delete", ids);
	}

	// 更新
	@Override
	public void update(T entity) {
		this.getSqlSession().update(getNamespace() + ".update", entity);
	}

	// 查找
	@Override
	public T findById(int id) {
		return this.getSqlSession().selectOne(getNamespace() + ".findById", id);
	}

	@Override
	public List<T> findAll() {
		return this.getSqlSession().selectList(getNamespace() + ".findAll");
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public List<T> findByPage(String page, String rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Integer pagenum = Integer.valueOf(page);
		Integer rowsnum = Integer.valueOf(rows);
		Integer start = (pagenum - 1) * rowsnum;
		Integer end = rowsnum;
		map.put("start", start);
		map.put("end", end);
		return this.getSqlSession().selectList(getNamespace() + ".findByPage",
				map);
	}

	@Override
	public List<T> findByTid(String id) {
		return this.getSqlSession().selectList(getNamespace() + ".findByTid",
				id);
	}
}
