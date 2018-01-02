<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
	<table border="0" width="600px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">部门添加</td>
		</tr>
		<tr>
			<td align="right"><a
				href="javascript:document.getElementById('saveForm').submit()"><button
						name="save">保存</button></a> &nbsp;&nbsp; <a
				href="javascript:history.go(-1)"><button name="return">退回</button> </a></td>
		</tr>
	</table>
	<br />
	<br>
	<s:form id="saveForm" action="department_save" method="post"
		namespace="/" theme="simple">
		<table style="font-size: :16px">
			<tr>
				<td>部门名称：</td>
				<td><s:textfield name="dname" /></td>
			</tr>
			<tr>
				<td>部门介绍：</td>
				<td></td>
			</tr>
			<tr>
				<td width="10%"></td>
				<td><s:textarea name="ddesc" cols="50" rows="5"></s:textarea></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
