<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title></title>
</head>
<script language="javascript">
	//-- ���Ʋ��ƶ�start of script -->
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

	//-- ���Ʋ��ƶ�end of script -->
	//��ý���;
	function getFocus(obj) {
		if (obj.style.zIndex != index) {
			index = index + 2;
			var idx = index;
			obj.style.zIndex = idx;
			//obj.nextSibling.style.zIndex=idx-1;
		}
	}

	//���δ���ĵġ�δ�ظ��ġ���������
	function msgrevoke(id) {
		if (confirm("�Ƿ�ȷ��Ҫ����������Ϣ?")) {
			//_Submit("/home/olmsgRevokeAction.do?flag=revoke&id="+id,null,"����");
		}
	}

	//��ظ�������
	function msgback(id) {
		//_Submit("/home/olmsgUpdateAction.do?flag=back&id="+id,null,"�ظ�");
	}

	function msgupdate(id, flag) {
		if (flag == "read") {
			if (!confirm("�Ƿ�ȷ�����Ĵ�����Ϣ?")) {
				return false;
			}
		} else if (flag == "accept") {
			if (!confirm("�Ƿ�ȷ�����ܴ�����?")) {
				return false;
			}
		} else if (flag == "fail") {
			if (!confirm("�Ƿ�ȷ��������δ���?")) {
				return false;
			}
		} else if (flag == "success") {
			if (!confirm("�Ƿ�ȷ�������������?")) {
				return false;
			}
		} else if (flag == "finished") {
			if (!confirm("�Ƿ�ȷ�����?")) {
				return false;
			}
		}
		//_Submit("/home/olmsgUpdateAction.do?flag="+flag+"&id="+id,null,"�޸�");

	}

	function msgdel(id) {
		if (confirm("�Ƿ�ȷ��Ҫɾ��������Ϣ?")) {
			//_Submit("/home/olmsgDeleteAction.do?delId="+id,null,"ɾ��");
		}
	}

	function msgstate(id, flag) {
		if (flag == "read") {
			if (!confirm("�Ƿ�ȷ�����Ĵ�����Ϣ?")) {
				return false;
			}
		} else if (flag == "accept") {
			if (!confirm("�Ƿ�ȷ�����ܴ�����?")) {
				return false;
			}
		} else if (flag == "fail") {
			if (!confirm("�Ƿ�ȷ��������δ���?")) {
				return false;
			}
		} else if (flag == "success") {
			if (!confirm("�Ƿ�ȷ�������������?")) {
				return false;
			}
		} else if (flag == "finished") {
			if (!confirm("�Ƿ�ȷ�����?")) {
				return false;
			}
		}
		//_Submit("/home/olmsgStateAction.do?flag="+flag+"&delId="+id,null,"����");
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
		<!-- ���������� ToolBar -->
		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<!-- <ul>
 
<li id="new"><a href="#">�½�</a></li>
<li id="save"><a href="#" title="�������Դ��ڵ�λ����Ϣ">λ��</a></li>
 
<li id="stat"><a href="#">��ʷ</a></li>
 
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
							<div class="msgcontent">��ӭʹ����·�ֿ����ϵͳ</div>
						</td>
					</tr>
					<tr>
						<td id="tagBPic" background="olmsg/images/C0FFE53.gif" height="63">
							<table border="0" width="100%" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50" align="center"><img border="0"
										src="olmsg/images/2.gif"></td>
									<td style="text-align:right;padding-right:8px;" nowrap>����
										<!-- [�ظ�] --> <!-- [��ִ] --> <!-- [����ԭ��] --> <!-- state==99[���] -->
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
								��ϵͳʵ�ֲֿ���ճ�����<br /> �����ֿ������Ա�Ĺ���������Ϣ������⼰�����ҵ��
							</div>
						</td>
					</tr>
					<tr>
						<td id="tagBPic" background="olmsg/images/FFE7E83.gif" height="63">
							<table border="0" width="100%" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50" align="center"><img border="0"
										src="olmsg/images/0.gif"></td>
									<td style="text-align:right;padding-right:8px;" nowrap>����
										<!-- [�ظ�] --> <!-- [��ִ] --> <!-- [����ԭ��] --> <!-- state==99[���] -->
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

