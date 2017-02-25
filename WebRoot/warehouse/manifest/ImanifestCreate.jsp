<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
	<div class="easyui-panel" title="填写货单信息"
		style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="manifest" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="id" style="width:100%"
					data-options="label:'货单编号：',required:true">
			</div>
			<div style="margin-bottom:20px">
				<select id="cargoId" class="easyui-combobox" name="cargo_id"
					style="width:100%" data-options="label:'货物编号',required:true">
				</select>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="cargonum" name="num" style="width:100%"
					data-options="label:'货物数量',required:true">
			</div>
			<div style="margin-bottom:20px">
				<select id="storeId" class="easyui-combobox" name="store_id"
					style="width:100%" data-options="label:'仓库编号',required:true">
				</select>
			</div>
			<div style="margin-bottom:20px">
				<select id="operatorId" class="easyui-combobox" name="operator"
					style="width:100%" data-options="label:'操作员编号',required:true">
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
	$('#cargoId')
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
	/* $('#cargoId')
			.combobox(
					{
						onChange : function() {
							var cargoid = $('#cargoId').combo('getValue');
							cargoid = $('#cargoId').combo('getValue');
							var str = '${pageContext.request.contextPath}/warehouse/manifest/store.action?cargoid='
									+ cargoid;
							$('#storeId')
									.combobox(
											{
												url : str,
												method : 'get',
												valueField : 'text',
												textField : 'text',
												formatter : function(row) {
													var s = '<span style="font-weight:bold">'
															+ row.text
															+ '</span><br/>'
															+ '<span style="color:#888">'
															+ row.desc
															+ '</span>';
													return s;
												}
											});
						}

					}); */

	$('#storeId')
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
	$('#operatorId')
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
							url : '${pageContext.request.contextPath}/warehouse/manifest/add.action',
							success : function() {
								$('#manifest').form('clear');
								alert("入库成功")
							}
						})
	}
	function clearForm() {
		$('#manifest').form('clear');
	}
</script>


</html>

