package per.cr.dao;



import java.util.List;

import per.cr.entity.Cargo;
/*
 * 此为产品特有属性，就是运输途中的状态
 */
import per.cr.entity.Json;

public interface CargoDao extends BaseDao<Cargo>{

	List<Json> findStoreIds();


}
