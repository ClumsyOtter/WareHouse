<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- easyUI CSS -->
<link rel="stylesheet" type="text/css"
	href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<!-- easyui js -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
</head>
<body style="padding-left: 30%">
	<div class="easyui-panel" title="修改货单信息"
		style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="manifest" method="post">
			<input type="hidden" value="${manifest.mid}" name="mid"><input
				type="hidden" value="${manifest.type}" name="type">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" value="${ manifest.id}" name="id"
					style="width:100%" data-options="label:'货单编号：',required:true,">
			</div>
			<div style="margin-bottom:20px">
				<select id="cargoid" class="easyui-combobox" name="cargo_id"
					data-options="label:'货物编号',required:true" style="width:100%">
					<option selected="selected">${ manifest.cargo_id}</option>
				</select>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="cargonum" value="${ manifest.num}" name="num"
					style="width:100%" data-options="label:'货物数量：',required:true,">
			</div>
			<div style="margin-bottom:20px">
				<select id="storeid" class="easyui-combobox" name="store_id"
					data-options="label:'仓库编号',required:true" style="width:100%">
					<option selected="selected">${ manifest.store_id}</option>
				</select>
			</div>
			<div style="margin-bottom:20px">
				<select id="operatorid" class="easyui-combobox" name="operator"
					data-options="label:'操作员编号',required:true" style="width:100%">
					<option selected="selected">${ manifest.operator}</option>
				</select>
			</div>
			<div style="text-align:center;padding:5px 0">
				<a href="#" class="easyui-linkbutton" onclick="submitForm()"
					style="width:80px">提交</a> <a href="#" class="easyui-linkbutton"
					onclick="clearForm()" style="width:80px">清除</a><a
					class="easyui-linkbutton"
					href="${pageContext.request.contextPath}/warehouse/manifest/ImanifestList.jsp"
					style="width:80px">返回</a>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$('#cargonum').textbox({
		onChange : function() {
			var num = $('#cargonum').textbox('getValue');
			if (num)
				if (!(num > 0)) {
					alert("输入有误");
					$('#cargonum').textbox('clear');
				}
		}
	});
	$('#storeid')
			.combobox(
					{
						url : '${pageContext.request.contextPath}/warehouse/manifest/storeAll.action',
						method : 'get',
						valueField : 'text',
						textField : 'text',
						formatter : function(row) {
							var s = '<span style="font-weight:bold">'
									+ row.text + '</span><br/>'
									+ '<span style="color:#888">' + row.desc
									+ '</span>';
							return s;
						}
					});
	$('#cargoid')
			.combobox(
					{
						url : '${pageContext.request.contextPath}/warehouse/manifest/cargo.action',
						method : 'get',
						valueField : 'text',
						textField : 'text',
						formatter : function(row) {
							var s = '<span style="font-weight:bold">'
									+ row.text + '</span><br/>'
									+ '<span style="color:#888">' + row.desc
									+ '</span>';
							return s;
						}
					});
	$('#operatorid')
			.combobox(
					{
						url : '${pageContext.request.contextPath}/warehouse/manifest/operator.action',
						method : 'get',
						valueField : 'text',
						textField : 'text',
						formatter : function(row) {
							var s = '<span style="font-weight:bold">'
									+ row.text + '</span><br/>'
									+ '<span style="color:#888">' + row.desc
									+ '</span>';
							return s;
						}
					});
</script>
<script type="text/javascript">
	function submitForm() {
		$('#manifest')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/warehouse/manifest/doupdate.action',
							success : function() {
								alert("更新成功");
								window.location.href = '${pageContext.request.contextPath}/warehouse/manifest/ImanifestList.jsp';
							}

						})
	}
	function clearForm() {
		$('#manifest').form('clear');
	}
</script>

</html>

