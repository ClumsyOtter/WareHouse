<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<!-- easyUI CSS -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- easyui js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.panel-body {
	background: #f0f0f0;
}

.panel-header {
	background: #fff url('images/panel_header_bg.gif') no-repeat top right;
}

.panel-tool-collapse {
	background: url('images/arrow_up.gif') no-repeat 0px -3px;
}

.panel-tool-expand {
	background: url('images/arrow_down.gif') no-repeat 0px -3px;
}

.title-font-style {
	font-family: "���Ĳ���";
}
</style>
</head>

<body style="margin: 10px">
	<!-- ��ģ�� -->
	<div class="easyui-panel"
		style="width:180px;height:auto;padding:10px;background:#B9D3EE;"
		data-options="border:false">
		<div class="easyui-panel" title="����/�ֿ����"
			style="width:160px;padding:5px;background:#B9D3EE;margin-top: 5px"
			data-options="iconCls:'icon-man',border:false,collapsible:true">

			<a href="#" style="color:#00688B;padding-left: 20px;"
				onclick="parent.window.cargolist();">�������</a><br><br>
			<a href="#" style="color:#00688B;padding-left: 20px;"
				onclick="parent.window.storelist();">�ֿ����</a>
		</div>
	</div>

</body>
</html>