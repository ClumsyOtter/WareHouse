package per.cr.action;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import per.cr.entity.Manifest;
import per.cr.entity.Json;
import per.cr.service.ManifestService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 控制层
 */
@Controller
public class ManifestAction extends BaseController {

	@Resource
	ManifestService manifestService;

	// 增加
	@RequestMapping(value = "warehouse/manifest/add.action")
	public String add(Manifest manifest) throws Exception {
		manifest = transManifest(manifest);
		manifest.setType("0");
		manifest.setTime(new Date());
		manifestService.add(manifest);
		return "/warehouse/manifest/ImanifestList.jsp";
	}

	@RequestMapping(value = "warehouse/manifest/addOut.action")
	public String addOut(Manifest manifest) throws Exception {
		manifest = transManifest(manifest);
		manifest.setType("1");
		manifest.setTime(new Date());
		manifestService.addOut(manifest);
		return "/warehouse/manifest/OmanifestList.jsp";
	}

	// 校验
	@RequestMapping(value = "warehouse/manifest/checknum.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String checknum(String cargo_id, String store_id,
			String num) {
		return manifestService.checkNum(cargo_id, store_id, num);
	}

	// 仓库编号按条件数据回显
	@RequestMapping(value = "warehouse/manifest/store.action")
	public @ResponseBody String store(String cargoid, Model model)
			throws Exception {
		List<Json> jsons = manifestService.findStoreIds(cargoid);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(jsons);
		return json;
	}

	// 所有的仓库编号数据回显
	@RequestMapping(value = "warehouse/manifest/storeAll.action")
	public @ResponseBody String storeAll(Model model) throws Exception {
		List<Json> jsons = manifestService.findStoreIds();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(jsons);
		return json;
	}

	// 员工编号数据回显
	@RequestMapping(value = "warehouse/manifest/operator.action")
	public @ResponseBody String operator(Model model) throws Exception {
		List<Json> jsons = manifestService.findOperatorIds();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(jsons);
		return json;
	}

	// 货物编号数据回显
	@RequestMapping(value = "warehouse/manifest/cargo.action")
	public @ResponseBody String cargo(Model model) throws Exception {
		List<Json> jsons = manifestService.findCargoIds();
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(jsons);
		return json;
	}

	// 查询
	@RequestMapping(value = "warehouse/manifest/search.action")
	public @ResponseBody String search(String name, String value)
			throws Exception {
		List<Manifest> manifests = null;
		if (name.equals("id")) {
			manifests = manifestService.findByManifestId(value);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", "1");
		map.put("rows", manifests);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 回显准备更新的数据
	@RequestMapping(value = "warehouse/manifest/toupdate.action")
	public String toUpdate(String mid, Model model) throws Exception {
		Manifest manifest = manifestService.findById(Integer.valueOf(mid));
		manifest.setNum(0 - manifest.getNum());
		manifestService.updateCargo(manifest);
		manifest.setNum(0 - manifest.getNum());
		model.addAttribute("manifest", manifest);
		return "/warehouse/manifest/ImanifestUpdate.jsp";
	}

	// 回显准备更新的数据
	@RequestMapping(value = "warehouse/manifest/toupdateOut.action")
	public String toupdateOut(String mid, Model model) throws Exception {
		Manifest manifest = manifestService.findById(Integer.valueOf(mid));
		manifestService.updateCargo(manifest);
		model.addAttribute("manifest", manifest);
		return "/warehouse/manifest/OmanifestUpdate.jsp";
	}

	// 更新数据
	@RequestMapping(value = "warehouse/manifest/doupdate.action")
	public String doUpdate(Manifest manifest) throws Exception {
		manifestService.update(manifest);
		return "/warehouse/manifest/OmanifestUpdate.jsp";
	}

	// 删除数据
	@RequestMapping(value = "warehouse/manifest/delete.action")
	public String delete(String id, String num) {
		int idnum = Integer.valueOf(num);
		if (idnum > 1) {
			Serializable[] ids = new Serializable[idnum];
			String[] sids = id.split(",");
			for (int i = 0; i < sids.length; i++) {
				ids[i] = Integer.valueOf(sids[i]);
			}
			manifestService.delete(sids);
		} else {
			manifestService.deleteById(Integer.valueOf(id));
		}
		return "/warehouse/manifest/ImanifestList.jsp";
	}

	// 删除数据
	@RequestMapping(value = "warehouse/manifest/deleteOut.action")
	public String deleteOut(String id, String num) {
		int idnum = Integer.valueOf(num);
		if (idnum > 1) {
			Serializable[] ids = new Serializable[idnum];
			String[] sids = id.split(",");
			for (int i = 0; i < sids.length; i++) {
				ids[i] = Integer.valueOf(sids[i]);
			}
			manifestService.delete(sids);
		} else {
			manifestService.deleteById(Integer.valueOf(id));
		}
		return "/warehouse/manifest/OmanifestList.jsp";
	}
	
	// 获取入货单数据
	@RequestMapping(value = "warehouse/manifest/list.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String list(String page, String rows, Model model)
			throws JsonProcessingException, UnsupportedEncodingException {
		if (page == null || page.length() == 0) {
			page = "1";
		}
		if (rows == null || rows.length() == 0) {
			rows = "10";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Manifest> manifests = manifestService.findByTypePage(page, rows,
				"0");
		map.put("total", manifestService.findAll().size());
		map.put("rows", manifests);
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(data);
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 获取出库单数据
	@RequestMapping(value = "warehouse/manifest/listOut.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String listOut(String page, String rows, Model model)
			throws JsonProcessingException, UnsupportedEncodingException {
		if (page == null || page.length() == 0) {
			page = "1";
		}
		if (rows == null || rows.length() == 0) {
			rows = "10";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Manifest> manifests = manifestService.findByTypePage(page, rows,
				"1");
		map.put("total", manifestService.findAll().size());
		map.put("rows", manifests);
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(data);
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 暂时表面解决乱码问题
	public Manifest transManifest(Manifest manifest) throws Exception {
		return manifest;
	}

	public String ISOToUTF8(String str) throws UnsupportedEncodingException {
		String trstr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return trstr;
	}
}
