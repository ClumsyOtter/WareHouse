<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- easyUI CSS -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- easyui js -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<!-- additional js or css -->
<style>
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


<body>
<body class="easyui-layout" id="cc" onload="systemTime()"
	style="width: 100%">
	<div data-options="region:'north',split:false"
		style="height:120px;width: 100%">
		<img alt="head" src="images/head.jpg" height="100%" width="100%">
		<div class="title-font-style"
			style="position:absolute;z-indent:2;left:610px;top:35px;color:#ffcc00;font-size: 35px;">
			���˹���ƽ̨</div>
	</div>


	<div id="west" data-options="region:'west',title:'',split:false"
		style="width:215px;background-image: url('olmsg/images/pic738x571.jpg') ">
		<!-- ��ʾʱ������ -->
		<div id="time" style="text-align: center;padding-top: 7px;"></div>
		<iframe frameborder="0" id="westItem" src="west_index.jsp"
			width="200px" height="600px" style="margin: 0px"></iframe>
		<!--  -->

	</div>
	<br />
	<div data-options="region:'center',title:''" style="padding:0px;">
		<div data-options="fit:true" style="background: #3366ff">
			<a href="#" class="easyui-linkbutton c4" onclick="toIndex()"
				style="width:120px;background:  #3366ff;color: white;">��ҳ</a> <a href="#" class="easyui-linkbutton c1"
				style="width:100px;background:  #3366ff;color: white;"
				onclick="people()">��Ա����</a><a href="#" class="easyui-linkbutton c3"
				id="baseMsg" style="width:120px;background:  #3366ff;color: white;"
				onclick="store()">����/�ֿ����</a> <a href="#" class="easyui-linkbutton c4"
				onclick="toStore()"
				style="width:120px;background:  #3366ff;color: white;">������</a><a
				onclick="outStore()" href="#" class="easyui-linkbutton c2"
				style="width:120px;background:  #3366ff;color: white;">�������</a>
		</div>
		<div id="tt" style="background:#fafafa; width: auto;height: 200px;">
			<iframe frameborder="0" id="centerItem" src="center_index.jsp"
				width=1320px height=580px></iframe>
		</div>
	</div>
</body>
</body>

<script type="text/javascript">
	//��ҳ
	function toIndex() {
		var baseItem = document.getElementById('westItem');
		baseItem.src = "west_index.jsp";
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "center_index.jsp";
	}
	//��Ա
	function people() {
		var baseItem = document.getElementById('westItem');
		baseItem.src = "west_people.jsp";
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "center_people_index.jsp";
	}

	//�ֿ�
	function store() {
		var baseItem = document.getElementById('westItem');
		baseItem.src = "west_store.jsp";
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "center_store_index.jsp";
	}
	//���
	function toStore() {
		var baseItem = document.getElementById('westItem');
		baseItem.src = "west_toStore.jsp";
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "center_toStore_index.jsp";
	}
	//����
	function outStore() {
		var baseItem = document.getElementById('westItem');
		baseItem.src = "west_outStore.jsp";
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "center_outStore_index.jsp";
	}
	//
</script>
<script type="text/javascript">
	function storelist() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/store/storeList.jsp";
	}
		function peoplelist() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/operator/operatorList.jsp";
	}
		function cargolist() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/cargo/cargoList.jsp";
	}
	function manifestlist() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/manifest/ImanifestList.jsp";
	}
	function manifestAdd() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/manifest/ImanifestCreate.jsp";
	}
	function manifestlistOut() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/manifest/OmanifestList.jsp";
	}
	function manifestAddOut() {
		var centerItem = document.getElementById('centerItem');
		centerItem.src = "warehouse/manifest/OmanifestCreate.jsp";
	}
</script>
<script type="text/javascript">
	//��ȡϵͳʱ�䣬��ʱ����ָ����ʽ��ʾ��ҳ�档  
	function systemTime() {
		//��ȡϵͳʱ�䡣  
		var dateTime = new Date();
		var yy = dateTime.getFullYear();
		var MM = dateTime.getMonth();
		var dd = dateTime.getDate();
		var hh = dateTime.getHours();
		var mm = dateTime.getMinutes();
		var ss = dateTime.getSeconds();

		//����ʱ����һλ���֣�������ǰ��0��  
		mm = extra(mm);
		ss = extra(ss);
		MM = extra(MM) + 1;
		dd = extra(dd);
		//��ʱ����ʾ��IDΪtime��λ�ã�ʱ���ʽ���磺19:18:02  
		document.getElementById("time").innerHTML = yy + "��" + MM + "��" + dd
				+ "�� " + hh + ":" + mm + ":" + ss;

		//ÿ��1000msִ�з���systemTime()��  
		setTimeout("systemTime()", 1000);
	}

	//��λ������  
	function extra(x) {
		//�����������С��10������ǰ��һλ0��  
		if (x < 10) {
			return "0" + x;
		} else {
			return x;
		}
	}
</script>
</html>
