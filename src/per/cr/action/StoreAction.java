package per.cr.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import per.cr.entity.Store;
import per.cr.service.StoreService;

/*
 * 控制层
 */
@Controller
public class StoreAction extends BaseController {
	@Resource
	StoreService storeService;

	// 增加
	@RequestMapping(value = "warehouse/store/add.action")
	public String add(Store store) throws Exception {
		store = transStore(store);
		storeService.add(store);
		return "/warehouse/store/storeList.jsp";
	}

	// 查询
	@RequestMapping(value = "warehouse/store/search.action")
	public @ResponseBody String search(String name, String value)
			throws Exception {
		List<Store> store = null;
		if (name.equals("id")) {
			store = storeService.findByStoreId(value);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", "1");
		map.put("rows", store);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 回显准备更新的数据
	@RequestMapping(value = "warehouse/store/toupdate.action")
	public String toUpdate(String sid, Model model) throws Exception {
		Store store = storeService.findById(Integer.valueOf(sid));
		model.addAttribute("store", store);
		return "/warehouse/store/storeUpdate.jsp";
	}

	// 更新数据
	@RequestMapping(value = "warehouse/store/doupdate.action")
	public String doUpdate(Store store) throws Exception {
		store = transStore(store);
		storeService.update(store);
		return "/warehouse/store/storeList.jsp";
	}

	// 删除数据
	@RequestMapping(value = "warehouse/store/delete.action")
	public String delete(String id, String num) {
		int idnum = Integer.valueOf(num);
		if (idnum > 1) {
			Serializable[] ids = new Serializable[idnum];
			String[] sids = id.split(",");
			for (int i = 0; i < sids.length; i++) {
				ids[i] = Integer.valueOf(sids[i]);
			}
			storeService.delete(sids);
		} else {
			storeService.deleteById(Integer.valueOf(id));
		}
		return "/warehouse/store/storeList.jsp";

	}

	// 获取数据
	@RequestMapping(value = "warehouse/store/list.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String list(String page, String rows, Model model)
			throws JsonProcessingException, UnsupportedEncodingException {
		if (page == null || page.length() == 0) {
			page = "1";
		}
		if (rows == null || rows.length() == 0) {
			rows = "10";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Store> Stores = storeService.findByPage(page, rows);
		map.put("total", storeService.findAll().size());
		map.put("rows", Stores);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 暂时表面解决乱码问题
	public Store transStore(Store store) throws Exception {
		store.setName(ISOToUTF8(store.getName()));
		store.setId(ISOToUTF8(store.getId()));
		store.setLocat(ISOToUTF8(store.getLocat()));
		return store;
	}

	public String ISOToUTF8(String str) throws UnsupportedEncodingException {
		String trstr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return trstr;
	}
}
