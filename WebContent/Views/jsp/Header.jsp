<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="View/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="View/js/jquerry.min.js"></script>
<script type="text/javascript" src="View/js/javascript.js"></script>
<title>Header</title>
</head>
<body>
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
</body>
</html>