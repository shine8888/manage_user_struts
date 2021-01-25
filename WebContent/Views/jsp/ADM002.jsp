<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Views/css/style.css" rel="stylesheet" type="text/css" />
<title><s:text name="ADM002.title" /></title>
</head>
<body>
	<!-- Begin vung header -->
	<jsp:include page="Header.jsp"></jsp:include>

	<!-- End vung header -->

	<!-- Begin vung dieu kien tim kiem -->
	<form action="listUserAction" method="get" name="mainform">
		<table class="tbl_input" border="0" width="90%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td><s:text name="ADM002.header" /></td>
			</tr>
			<tr>
				<td width="100%">
					<table class="tbl_input" cellpadding="4" cellspacing="0">
						<tr>
							<td class="lbl_left"><s:text name="ADM002.fullName" />:</td>
							<td align="left"><s:textfield class="txBox" name="fullName"
									size="20" onfocus="this.style.borderColor='#0066ff';"
									value="%{#session.fullName}"
									onblur="this.style.borderColor='#aaaaaa';" theme="simple" /></td>
							<td></td>
						</tr>
						<tr>
							<td class="lbl_left"><s:text name="ADM002.group" />:</td>
							<td align="left" width="80px"><s:select name="groupId"
									theme="simple" headerKey="0" headerValue="全て"
									list="#attr.listGroup" value="#session.groupId"
									listValue="groupName" listKey="groupId">
								</s:select></td>
							<td align="left"><s:hidden name="action" value="search"
									theme="simple" /> <s:submit class="btn" type="submit"
									name="action:listUserAction" key="ADM002.search" theme="simple" />
								<input class="btn" type="button"
								value="<s:text name="ADM002.add" />" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- End vung dieu kien tim kiem -->
	</form>
	<!-- Begin vung hien thi danh sach user -->
	<s:if test="#attr.listUser.size() !=0">
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0"
		width="80%">
		<s:url action="listUserAction" id="urlSort" var="sort">
			<s:param name="action">sort</s:param>
		</s:url>
		<tr class="tr2">
			<th align="center" width="20px">ID</th>
			<th align="left">氏名 <s:if
					test="sortValue == 'DESC' && sortType == 'full_name'">
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=full_name&sortValue=ASC">△▼</a>
				</s:if> <s:else>
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=full_name&sortValue=DESC">▲▽</a>
				</s:else>
			</th>
			<th align="left">生年月日</th>
			<th align="left">グループ</th>
			<th align="left">メールアドレス</th>
			<th align="left" width="70px">電話番号</th>
			<th align="left">日本語能力 <s:if
					test="sortValue == 'DESC' && sortType == 'code_level'">
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=code_level&sortValue=ASC">△▼</a>
				</s:if> 
				<s:else>
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=code_level&sortValue=DESC">▲▽</a>
				</s:else>
			</th>
			<th align="left">失効日 <s:if
					test="sortValue == 'DESC' && sortType == 'end_date'">
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=end_date&sortValue=ASC">△▼</a>
				</s:if> 
				<s:else>
					<a
						href="<s:property value="#sort"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${currentPage}&sortType=end_date&sortValue=DESC">▲▽</a>
				</s:else>
			</th>
			<th align="left">点数</th>
		</tr>
		
		
		<s:iterator value="#attr.listUser" var="user">
			<tr>
				<td align="right"><a href="ADM005.html"><s:property
							value="#user.userId" /></a></td>
				<td><s:property value="#user.fullName" /></td>
				<td align="center"><s:property value="#user.birthday" /></td>
				<td><s:property value="#user.groupName" /></td>
				<td><s:property value="#user.email" /></td>
				<td><s:property value="#user.tel" /></td>
				<td><s:property value="#user.nameLevel" /></td>
				<td align="center"><s:property value="#user.endDate" /></td>
				<td align="right"><s:property value="#user.total" /></td>
			</tr>
		</s:iterator>
	</table>
	</s:if> 
	<s:else>
		<p>No users found</p>
		</s:else>
	<!-- End vung hien thi danh sach user -->

	<!-- Begin vung paging -->
	<table>
		<s:url action="listUserAction" id="urlPaging" var="ctPage" forceAddSchemeHostAndPort="true" includeParams="all">
			<s:param name="action">paging</s:param>
			</s:url>
			<tr>
				<td class="lbl_paging"><s:if test="PRE != 0">
						<a
							href="<s:property value="#ctPage"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${PRE}&sortType=${sortType}&sortValue=${sortValue}">
							<< </a>&nbsp; 
					</s:if> <s:iterator value="#attr.listPaging" var="page">
						<s:param name="currentPage">
							<s:property value="#page" />
						</s:param>
						<a
							href="<s:property value="#ctPage"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${page}&sortType=${sortType}&sortValue=${sortValue}">
							<s:property value="#page" />
						</a>&nbsp;
				</s:iterator> <s:if test="NEXT != 0">
						<a
							href="<s:property value="#ctPage"/>&fullName=${fullName}&groupId=${groupId}
						&currentPage=${NEXT}&sortType=${sortType}&sortValue=${sortValue}">
							>> </a>&nbsp;
					</s:if></td>
			</tr>
				</table>
			<!-- End vung paging -->

			<!-- Begin vung footer -->
			<jsp:include page="Footer.jsp"></jsp:include>
			<!-- End vung footer -->
</body>
</html>