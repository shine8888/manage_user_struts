<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<title><s:text name="ADM002.title" /></title>
</head>
<body>
	<!-- 	 Begin vung header  -->
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

	<!-- 	 End vung header  -->

	<!-- 	 Begin vung input -->
	<form action="validateUser" method="post" name="inputform">
		<table class="tbl_input" border="0" width="75%" cellpadding="0"
			cellspacing="0">

			<tr>
				<th align="left">
					<div style="padding-left: 100px;">
						<s:text name="ADM003.headTitle"></s:text>
					</div>
				</th>
			</tr>
			<tr>
				<td class="errMsg">
					<div style="padding-left: 120px">
						<s:actionerror style="list-style: none;" />
						&nbsp;
					</div>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div style="padding-left: 100px;">
						<table border="0" width="100%" class="tbl_input" cellpadding="4"
							cellspacing="0">
							<s:set var="userInfor" value="userInfor" />
							<table>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.username"></s:text></td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.loginName"
										value="<s:property value="#userInfor.loginName"/>" size="15"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.groupId"></s:text></td>
									<td align="left"><s:select name="userInfor.groupName"
											theme="simple" headerKey="0" headerValue="選択してください"
											list="%{#session['groupId']}" listValue="groupName"
											listKey="groupName" value="#userInfor.groupName" key="groupName">
										</s:select></td>

								</tr>

								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.name"></s:text></td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.fullName"
										value="<s:property value="#userInfor.fullName"/>" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><s:text name="ADM003.nameKana"></s:text></td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.fullNameKana"
										value="<s:property value="#userInfor.fullNameKana"/>"
										size="30" onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.birthday"></s:text></td>
									<td align="left"><s:select name="userInfor.year"
											theme="simple" headerKey="0"
											headerValue="%{#session.datenow[0]}" list="#session.year"
											value="#userInfor.year">
										</s:select>年 <s:select name="userInfor.month" theme="simple"
											headerKey="0" headerValue="%{#attr.datenow[1]}"
											list="#session.listMonth"
											value="#userInfor.month>">
										</s:select>月 <s:select name="userInfor.day" theme="simple" headerKey="0"
											headerValue="%{#session.datenow[2]}" list="#attr.listDay"
											value="#userInfor.day">
										</s:select>日</td>
								</tr>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.email"></s:text></td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.email"
										value="<s:property value="#userInfor.email"/>" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.tel"></s:text></td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.tel"
										value="<s:property value="#userInfor.tel"/>" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><font color="red">*</font> <s:text
											name="ADM003.password"></s:text></td>
									<td align="left"><input class="txBox" type="password"
										name="userInfor.password"
										value="<s:property value="#userInfor.password"/>" size="30"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>
								<tr>
									<td class="lbl_left"><s:text name="ADM003.rePassword"></s:text></td>
									<td align="left"><input class="txBox" type="password"
										name="userInfor.confirmPassword"
										value="<s:property value="#userInfor.confirmPassword"/>"
										size="30" onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';" /></td>
								</tr>


								<tr>
									<th align="left" colspan="2"><a href="#" onclick="show()"><s:text
												name="ADM003.japaneseAbility"></s:text></a></th>
								</tr>
							</table>
							<table id="showLevelJapan" style="display: inline-table">
								<tr>
									<td class="lbl_left"><s:text name="ADM003.certificate"></s:text></td>
									<td align="left">
										
										<s:select name="userInfor.codeLevel"
											theme="simple" headerKey="N0" headerValue="選択してください"
											list="%{#session['listMstJapan']}" listValue="nameLevel"
											listKey="codeLevel" value="#userInfor.codeLevel" key="codeLevel">
										</s:select>
										</td>
								</tr>
								<tr>
									<td class="lbl_left"><s:text name="ADM003.startDate"></s:text>
									</td>
									<td align="left"><s:select name="userInfor.yearStart"
											theme="simple" headerKey="0"
											headerValue="%{#attr.datenow[0]}" list="#attr.year"
											value="#userInfor.yearStart">
										</s:select>年 <s:select name="userInfor.monthStart" theme="simple"
											headerKey="0" headerValue="%{#attr.datenow[1]}"
											list="#attr.listMonth"
											value="#userInfor.monthStart">
										</s:select>月 <s:select name="userInfor.dayStart" theme="simple"
											headerKey="0" headerValue="%{#attr.datenow[2]}"
											list="#attr.listDay"
											value="#userInfor.dayStart">
										</s:select>日</td>
								</tr>
								<tr>
									<td class="lbl_left"><s:text name="ADM003.endDate"></s:text>
									</td>
									<td align="left"><s:select name="userInfor.yearEnd"
											theme="simple" headerKey="0"
											headerValue="%{#attr.datenow[0]+1}" list="#attr.listYear"
											value="#userInfor.yearEnd">
										</s:select>年 <s:select name="userInfor.monthEnd" theme="simple"
											headerKey="0" headerValue="%{#attr.datenow[1]}"
											list="#attr.listMonth"
											value="#userInfor.monthEnd">
										</s:select>月 <s:select name="userInfor.dayEnd" theme="simple"
											headerKey="0" headerValue="%{#attr.datenow[2]}"
											list="#attr.listDay"
											value="#userInfor.dayEnd">
										</s:select>日</td>
								</tr>
								<tr>
									<td class="lbl_left"><s:text name="ADM003.score"></s:text>
									</td>
									<td align="left"><input class="txBox" type="text"
										name="userInfor.score" value="" size="5"
										onfocus="this.style.borderColor='#0066ff';"
										onblur="this.style.borderColor='#aaaaaa';"
										value="<s:property value="#userInfor.score"/>" /></td>
								</tr>
							</table>
						</table>
					</div>
				</td>
			</tr>

		</table>
		<div style="padding-left: 100px;">&nbsp;</div>
		<!-- 						 Begin vung button  -->
		<div style="padding-left: 45px;">
			<table border="0" cellpadding="4" cellspacing="0" width="300px">
				<tr>
					<th width="200px" align="center">&nbsp;</th>
					<td><input class="btn" type="submit" value="確認" /></td>
					<td><input class="btn" type="button" value="戻る" /></td>
				</tr>
			</table>
			<!-- 							 End vung button  -->
	</form>
	<!-- 	 End vung input  -->

	<!-- 	 Begin vung footer  -->
	<div class="lbl_footer">
		<br> <br> <br> <br> Copyright © 2010
		ルビナソフトウエア株式会社. All rights reserved.
	</div>
	<!-- 	 End vung footer  -->

	<script src="../js/javascript.js"></script>
</body>

</html>