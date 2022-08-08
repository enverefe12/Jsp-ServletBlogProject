<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<h1>Kayıt Alanı</h1>

<form action="addUser" method="post">
	<table>
		<tr>
			<td>Kullanıcı Adı:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Şifre:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Kayıt Ol" /></td>
		</tr>
	</table>
</form>
<hr>
<p>${msg}</p>

<jsp:include page="footer.jsp"/>