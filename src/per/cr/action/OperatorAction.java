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

import per.cr.entity.Operator;
import per.cr.service.OperatorService;

/*
 * 控制层
 */
@Controller
public class OperatorAction  extends BaseController{

	@Resource
	OperatorService operatorService;
	// 增加
	@RequestMapping(value = "warehouse/operator/add.action")
	public String add(Operator operator) throws Exception {
		operator = transoperator(operator);
		operatorService.add(operator);
		return "/warehouse/operator/operatorList.jsp";
	}
	
	//查询
	@RequestMapping(value = "warehouse/operator/search.action")
	public @ResponseBody String search(String name, String value)
			throws Exception {
		List<Operator> operator = null;
		if (name.equals("id")) {
			operator = operatorService.findByoperatorId(value);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", "1");
		map.put("rows", operator);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	//回显准备更新的数据
	@RequestMapping(value = "warehouse/operator/toupdate.action")
	public String toUpdate(String oid, Model model) throws Exception {
		Operator operator = operatorService.findById(Integer.valueOf(oid));
		model.addAttribute("operator", operator);
		return "/warehouse/operator/operatorUpdate.jsp";
	}
	
	//更新数据
	@RequestMapping(value = "warehouse/operator/doupdate.action")
	public String doUpdate(Operator operator) throws Exception {
		operator = transoperator(operator);
		operatorService.update(operator);
		return "/warehouse/operator/operatorList.jsp";
	}

	//删除数据
	@RequestMapping(value = "warehouse/operator/delete.action")
	public String delete(String id, String num) {
		int idnum = Integer.valueOf(num);
		if (idnum > 1) {
			Serializable[] ids = new Serializable[idnum];
			String[] sids = id.split(",");
			for (int i = 0; i < sids.length; i++) {
				ids[i] = Integer.valueOf(sids[i]);
			}
			operatorService.delete(sids);
		} else {
			operatorService.deleteById(Integer.valueOf(id));
		}
		return "/warehouse/operator/operatorList.jsp";

	}

	// 获取数据
	@RequestMapping(value = "warehouse/operator/list.action", produces = "application/json; charset=utf-8")
	public @ResponseBody String list(String page, String rows, Model model)
			throws JsonProcessingException, UnsupportedEncodingException {
		if (page == null || page.length() == 0) {
			page = "1";
		}
		if (rows == null || rows.length() == 0) {
			rows = "10";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Operator> operators = operatorService.findByPage(page, rows);
		map.put("total", operatorService.findAll().size());
		map.put("rows", operators);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(map);
		return json;
	}

	// 暂时表面解决乱码问题
	public Operator transoperator(Operator operator) throws Exception {
		operator.setName(ISOToUTF8(operator.getName()));
		operator.setId(ISOToUTF8(operator.getId()));
		operator.setPwd(ISOToUTF8(operator.getPwd()));
		return operator;
	}

	public String ISOToUTF8(String str) throws UnsupportedEncodingException {
		String trstr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		return trstr;
	}
}
