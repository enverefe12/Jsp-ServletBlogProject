<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="header.jsp"/>
<h1>Giriş Alanı</h1>

<form action="checkUser" method="post">
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
			<td><input type="submit" value="Giriş" /></td>
		</tr>
	</table>
</form>
<hr>
<c:if test="${not empty msg}">
<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
    <span class="sr-only">Close</span>
  </button>
  <strong>${message}</strong>.
</div>
</c:if>

<jsp:include page="footer.jsp"/>