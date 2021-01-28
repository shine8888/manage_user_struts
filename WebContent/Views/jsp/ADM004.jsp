<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/Views/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/javascript.js"></script>
<title>ユーザ管理</title>
</head>
<body>
	<!-- Begin vung header -->
	<div>
		<div>
			<table>
				<tr>
					<td width="80%"><img src="../images/logo-manager-user.gif"
						alt="Luvina" />
					<td>
					<td align="left"><s:a action="Logout">ログアウト</s:a> &nbsp; <a
						href="<%=request.getContextPath()%>/ListUser.do?mode=default">トップ</a>
					<td>
				</tr>
			</table>
		</div>
	</div>
	<!-- End vung header -->

	<!-- Begin vung input-->
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${type == 'edit'}"> --%>
<%-- 			<c:set var="destination" scope="request" --%>
<%-- 				value="EditUserOk.do?key=${key }" /> --%>
<%-- 				<form action="${destination }" method="post" name="inputform" /> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<c:set var="destination" scope="request" --%>
<%-- 				value="AddUserOk.do?key=${key }" /> --%>
<%-- 				<form action="${destination }" method="post" name="inputform" /> --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
	
	<table class="tbl_input" border="0" width="75%" cellpadding="0"
		cellspacing="0">
		<tr>
			<th align="left">
				<div style="padding-left: 100px;">
					情報確認<br> 入力された情報をＯＫボタンクリックでＤＢへ保存してください 
				</div>
				<div style="padding-left: 100px;">&nbsp;</div>
			</th>
		</tr>
		<tr>
			<td align="left">
				<div style="padding-left: 100px;">
					<table>
						<table border="1" width="70%" class="tbl_input" cellpadding="4"
							cellspacing="0">
							<tr>
								<td class="lbl_left">アカウント名:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].loginName}"/></td>
							</tr>
							<tr>
								<td class="lbl_left">グループ:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].groupName}"/></td>
							</tr>
							<tr>
								<td class="lbl_left">氏名:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].fullName}"/></td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].fullNameKana}"/></td>
							</tr>
							<tr>
								<td class="lbl_left">生年月日:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].listTime[0]}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">メールアドレス:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].email}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">電話番号:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].tel}"/>
								</td>
							</tr>
							<tr>
								<th colspan="2"><a href="#" onclick="show()">日本語能力</a></th>
							</tr>
						</table>
						<table id="showLevelJapan" style="display: inline-table" border="1"
							width="70%" class="tbl_input" cellpadding="4" cellspacing="0">
							<tr>
								<td class="lbl_left">資格:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].nameLevel}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">資格交付日:</td>
								<td align="left">
								<s:property escape="false" value="%{#session['user'].listTime[1]}"/>
								</td>
							</tr>
							<tr>
								<td class="lbl_left">失効日:</td>
								<td align="left"><s:property escape="false" value="%{#session['user'].listTime[2]}"/></td>
							</tr>
							<tr>
								<td class="lbl_left">点数:</td>
								<td align="left"><s:property escape="false" value="%{#session['user'].score}"/></td>
							</tr>
						</table>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<div style="padding-left: 100px;">&nbsp;</div>
	<!-- Begin vung button -->
	<div style="padding-left: 45px;">
		<table border="0" cellpadding="4" cellspacing="0" width="300px">
			<tr>
				<th width="200px" align="center">&nbsp;</th>
				<td><s:a action="InsertUser"><input class="btn" type="button"
								value="<s:text name="OK" />"/></s:a></td>
						<td><input class="btn" type="button" value="戻る"
							onclick="window.location.href = 'EditDetailUser.do?mode=Edit_04&id=${user.getUserId() }&key=${key }'" />
							
							</td>

						<td><input class="btn" type="button" value="戻る"
							onclick="window.location.href = 'AddUserValidate.do?mode=back&type=add&key=${key }'" /></td>
			</tr>
		</table>
		<!-- End vung button -->
		</div>
		<!-- End vung input -->

		<!-- Begin vung footer -->
		<%@ include file="Footer.jsp"%>
		<!-- End vung footer -->
</body>
</html>