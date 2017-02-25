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

import per.cr.entity.Cargo;
import per.cr.entity.Json;
import per.cr.service.CargoService;

/*
 * 控制层
 */
@Controller
public class CargoAction extends BaseController{

	@Resource
	CargoService cargoService;

	// 增加
	@RequestMapping(value = "warehouse/cargo/add.action")
	public String add(Cargo cargo) throws Exception {
		
		cargo = transCargo(cargo);
		cargoService.add(cargo);
		return "/warehouse/cargo/cargoList.jsp";
	}

	// 增加前的数据回显
	@RequestMapping(value = "warehouse/cargo/storeList.action")
	public @ResponseBody String toAdd(Model model) throws Exception {
		List<Json> jsons = cargoService.findStoreIds();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(jsons);
		return json;
	}

	// 查询
	@RequestMapping(value = "warehouse/cargo/search.action")
	public @ResponseBody String search(String name, String value)
			throws Exception {
		List<Cargo> cargos = null;
		if (name.equals("id")) {
			cargos = cargoService.findByCargoId(value);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", "1");
		map.put("rows", cargos);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 回显准备更新的数据
	@RequestMapping(value = "warehouse/cargo/toupdate.action")
	public String toUpdate(String cid, Model model) throws Exception {
		Cargo cargo = cargoService.findById(Integer.valueOf(cid));
		model.addAttribute(cargo);
		return "/warehouse/cargo/cargoUpdate.jsp";
	}

	// 更新数据
	@RequestMapping(value = "warehouse/cargo/doupdate.action")
	public String doUpdate(Cargo cargo) throws Exception {
		cargo = transCargo(cargo);
		cargoService.update(cargo);
		return "/warehouse/cargo/cargoList.jsp";
	}

	// 删除数据
	@RequestMapping(value = "warehouse/cargo/delete.action")
	public String delete(String id, String num) {
		int idnum = Integer.valueOf(num);
		if (idnum > 1) {
			Serializable[] ids = new Serializable[idnum];
			String[] sids = id.split(",");
			for (int i = 0; i < sids.length; i++) {
				ids[i] = Integer.valueOf(sids[i]);
			}
			cargoService.delete(sids);
		} else {
			cargoService.deleteById(Integer.valueOf(id));
		}
		return "/warehouse/cargo/cargoList.jsp";

	}

	// 获取数据
	@RequestMapping(value = "warehouse/cargo/list.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String list(String page, String rows, Model model)
			throws JsonProcessingException, UnsupportedEncodingException {
		if (page == null || page.length() == 0) {
			page = "1";
		}
		if (rows == null || rows.length() == 0) {
			rows = "10";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Cargo> cargos = cargoService.findByPage(page, rows);
		map.put("total", cargoService.findAll().size());
		map.put("rows", cargos);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 暂时表面解决乱码问题
	public Cargo transCargo(Cargo cargo) throws Exception {
		cargo.setName(ISOToUTF8(cargo.getName()));
		cargo.setId(ISOToUTF8(cargo.getId()));
		cargo.setStore_id(ISOToUTF8(cargo.getStore_id()));
		return cargo;
	}

	public String ISOToUTF8(String str) throws UnsupportedEncodingException {
		String trstr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return trstr;
	}
}
