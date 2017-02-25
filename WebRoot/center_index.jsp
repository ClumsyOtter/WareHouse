<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title></title>
</head>
<script language="javascript">
	//-- 控制层移动start of script -->
	var Obj = '';
	var index = 10000;//z-index;
	var color = '';
	var str = '';
	document.onmouseup = MUp
	document.onmousemove = MMove

	function MMove() {
		if (Obj != '') {
			document.all(Obj).style.left = event.x - pX;
			document.all(Obj).style.top = event.y - pY;
		}
	}

	function MUp() {
		if (Obj != '') {
			document.all(Obj).releaseCapture();
			Obj = '';
		}
		var srcEle = event.srcElement;

		var children = srcEle.children;
		if (children.length > 0) {
			children[1].value = "1"; //isChange
			children[2].value = event.x - pX;
			children[3].value = event.y - pY;
		}
	}

	function MDown(objtd, id) {
		Obj = id
		document.all(Obj).setCapture()
		pX = event.x - document.all(Obj).style.pixelLeft;
		pY = event.y - document.all(Obj).style.pixelTop;
	}

	//-- 控制层移动end of script -->
	//获得焦点;
	function getFocus(obj) {
		if (obj.style.zIndex != index) {
			index = index + 2;
			var idx = index;
			obj.style.zIndex = idx;
			//obj.nextSibling.style.zIndex=idx-1;
		}
	}

	//针对未已阅的、未回复的、工作任务
	function msgrevoke(id) {
		if (confirm("是否确定要撤销此条信息?")) {
			//_Submit("/home/olmsgRevokeAction.do?flag=revoke&id="+id,null,"撤销");
		}
	}

	//需回复的留言
	function msgback(id) {
		//_Submit("/home/olmsgUpdateAction.do?flag=back&id="+id,null,"回复");
	}

	function msgupdate(id, flag) {
		if (flag == "read") {
			if (!confirm("是否确定已阅此条信息?")) {
				return false;
			}
		} else if (flag == "accept") {
			if (!confirm("是否确定接受此任务?")) {
				return false;
			}
		} else if (flag == "fail") {
			if (!confirm("是否确定此任务未完成?")) {
				return false;
			}
		} else if (flag == "success") {
			if (!confirm("是否确定此任务已完成?")) {
				return false;
			}
		} else if (flag == "finished") {
			if (!confirm("是否确定完成?")) {
				return false;
			}
		}
		//_Submit("/home/olmsgUpdateAction.do?flag="+flag+"&id="+id,null,"修改");

	}

	function msgdel(id) {
		if (confirm("是否确定要删除此条信息?")) {
			//_Submit("/home/olmsgDeleteAction.do?delId="+id,null,"删除");
		}
	}

	function msgstate(id, flag) {
		if (flag == "read") {
			if (!confirm("是否确定已阅此条信息?")) {
				return false;
			}
		} else if (flag == "accept") {
			if (!confirm("是否确定接受此任务?")) {
				return false;
			}
		} else if (flag == "fail") {
			if (!confirm("是否确定此任务未完成?")) {
				return false;
			}
		} else if (flag == "success") {
			if (!confirm("是否确定此任务已完成?")) {
				return false;
			}
		} else if (flag == "finished") {
			if (!confirm("是否确定完成?")) {
				return false;
			}
		}
		//_Submit("/home/olmsgStateAction.do?flag="+flag+"&delId="+id,null,"已阅");
	}

	function changRowColor(obj) {
		//obj.removeAttribute("className");
		//alert(obj.className);
		//obj.setAttribute("bgcolor","#FFECB0");
		//obj.sytle.backgroundColor = "#FFECB0";
	}

	function removeOverRowColor(obj) {
		//alert(obj.getAttribute("style"));
	}

	function killErrors() {
		return true;
	}

	window.onerror = killErrors;
</script>

<body
	style="background-image: url('olmsg/images/pic738x571.jpg');background-repeat: repeat;">

	<form name="form2">
		<!-- 工具栏部分 ToolBar -->
		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<!-- <ul>
 
<li id="new"><a href="#">新建</a></li>
<li id="save"><a href="#" title="保存留言窗口的位置信息">位置</a></li>
 
<li id="stat"><a href="#">历史</a></li>
 
</ul> -->

					</div>
				</div>
			</div>
		</div>

		<logic:notEmpty name="olmsgList">
			<div id='ff8080813d00613e013d0067909e0009'
				style='position:absolute;left:122px;top:97px;z-index:1001; height:164px;background:none;'
				onmousedown='getFocus(this)'>
				<table border=0 cellspacing="0" cellpadding="0" width="220">
					<tr>
						<td style='cursor:move;'
							onmousedown="MDown(this,'ff8080813d00613e013d0067909e0009')"
							background="olmsg/images/C0FFE51.gif" height="45"><input
							type="hidden" name="id" class="input"
							value="ff8080813d00613e013d0067909e0009" /> <input type="hidden"
							name="isChange" class="input" value="0" /> <input type="hidden"
							name="posX" class="input" value="122" /> <input type="hidden"
							name="posY" class="input" value="97" /> &nbsp;</td>
					</tr>

					<tr>
						<td background="olmsg/images/C0FFE52.gif">
							<div class="msgcontent">欢迎使用铁路仓库管理系统</div>
						</td>
					</tr>
					<tr>
						<td id="tagBPic" background="olmsg/images/C0FFE53.gif" height="63">
							<table border="0" width="100%" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50" align="center"><img border="0"
										src="olmsg/images/2.gif"></td>
									<td style="text-align:right;padding-right:8px;" nowrap>极客
										<!-- [回复] --> <!-- [回执] --> <!-- [撤销原因] --> <!-- state==99[完成] -->
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div id='ff8080813d00613e013d00681494000a'
				style='position:absolute;left:442px;top:91px;z-index:1002; height:164px;background:none;'
				onmousedown='getFocus(this)'>
				<table border=0 cellspacing="0" cellpadding="0" width="220">
					<tr>
						<td style='cursor:move;'
							onmousedown="MDown(this,'ff8080813d00613e013d00681494000a')"
							background="olmsg/images/FFE7E81.gif" height="45"><input
							type="hidden" name="id" class="input"
							value="ff8080813d00613e013d00681494000a" /> <input type="hidden"
							name="isChange" class="input" value="0" /> <input type="hidden"
							name="posX" class="input" value="442" /> <input type="hidden"
							name="posY" class="input" value="91" /> &nbsp;</td>
					</tr>

					<tr>
						<td background="olmsg/images/FFE7E82.gif">
							<div class="msgcontent">
								本系统实现仓库的日常管理<br /> 包括仓库管理人员的管理、货物信息管理、入库及出库等业务
							</div>
						</td>
					</tr>
					<tr>
						<td id="tagBPic" background="olmsg/images/FFE7E83.gif" height="63">
							<table border="0" width="100%" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50" align="center"><img border="0"
										src="olmsg/images/0.gif"></td>
									<td style="text-align:right;padding-right:8px;" nowrap>极客
										<!-- [回复] --> <!-- [回执] --> <!-- [撤销原因] --> <!-- state==99[完成] -->
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</logic:notEmpty>
	</form>
</body>
</html>

