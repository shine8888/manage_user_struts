<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Views/css/style.css" rel="stylesheet" type="text/css" />
<title><s:text name="ADM001.title" /></title>
</head>
<body>
		<center>
	<form action="loginaction" method="post">

			<table class="tbl_input" cellpadding="4" cellspacing="0"
				width="400px">
				<tr>
					<th width="120px">&nbsp;</th>
					<th></th>
				</tr>
				<tr>
					<th colspan="2" align="left"><s:text name="ADM001.header" /></th>
				</tr>

				<td class="errorDiv" colspan="2"><s:actionerror
						style="list-style: none;" /> &nbsp;</td>
						
				<tr align="left">
					<td class="lbl_left"><s:text name="ADM001.loginId" />:</td>
					<td align="left"><s:textfield class="txBox" theme="simple"
						name="user" size="20"
						onfocus="this.style.borderColor='#0066ff';"
						onblur="this.style.borderColor='#aaaaaa';" /></td>
				</tr>
				<tr>
					<td class="lbl_left"><s:text name="ADM001.password" />:</td>
					<td align="left"><s:password class="txBox" theme="simple"
						name="password" value="" size="22"
						onfocus="this.style.borderColor='#0066ff';"
						onblur="this.style.borderColor='#aaaaaa';" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="left"><input class="btn btn_wider" type="submit"
						value="<s:property value="getText('ADM001.login')" />" /></td>
				</tr>
			</table>
	
	</form>
		</center>
</body>
</html>