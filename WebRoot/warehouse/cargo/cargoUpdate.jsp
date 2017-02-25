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
	<div class="easyui-panel" title="更新货物信息"
		style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="cargo" method="post">
		<input type="hidden" value="${cargo.cid}" name="cid">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" value="${ cargo.id}" name="id" style="width:100%"
					data-options="label:'货物编号：',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" value="${ cargo.name}" name="name" style="width:100%"
					data-options="label:'货物名称：',required:true,">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="cargoprice" value="${ cargo.price}" name="price" style="width:100%"
					data-options="label:'货物价格',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="cargonum" value="${ cargo.num}" name="num" style="width:100%"
					data-options="label:'货物数量',required:true" >
			</div>
			<div style="margin-bottom:20px">
				<select id="storeid" class="easyui-combobox" name="store_id"
					data-options="label:'仓库',required:true" style="width:100%">
					<option selected="selected">${ cargo.store_id}</option>
					</select>
			</div>
			<div style="text-align:center;padding:5px 0">
				<a href="#" class="easyui-linkbutton" onclick="submitForm()"
					style="width:80px">提交</a> <a href="#" class="easyui-linkbutton"
					onclick="clearForm()" style="width:80px">清除</a><a
					class="easyui-linkbutton"
					href="${pageContext.request.contextPath}/warehouse/cargo/cargoList.jsp"
					style="width:80px">返回</a>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$('#cargoprice').textbox({
		onChange : function() {
			var num = $('#cargoprice').textbox('getValue');
			if (num)
				if (!(num > 0)) {
					alert("输入有误");
					$('#cargoprice').textbox('clear');
				}
		}
	});
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
						url : '${pageContext.request.contextPath}/warehouse/cargo/storeList.action',
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
		$('#cargo')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/warehouse/cargo/doupdate.action',
							success : function() {
								alert("更新成功");
								window.location.href='${pageContext.request.contextPath}/warehouse/cargo/cargoList.jsp';
							}

						})
	}
	function clearForm() {
		$('#cargo').form('clear');
	}
</script>

</html>

