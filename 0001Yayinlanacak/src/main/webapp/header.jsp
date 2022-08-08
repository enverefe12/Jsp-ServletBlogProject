<%@page import="com.Listener.SessionListener"%>
<%@page import="Model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataAccess.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
CategoryDao kg = new CategoryDao();
ArrayList<Category> list = kg.getCategories();
request.setAttribute("list", list);

pageContext.setAttribute("as",SessionListener.activeSessions);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Enver Pasha Cok Yasha</title>
<link rel="stylesheet" href="st.css">
</head>
<body>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<div id="main">
		<div id="header">
			<h2>
				<font color="white">Welcome, Welcome to the City 17<br>${userToken}</font>
			</h2>
			
		</div>
		<div>
			<a href="index.jsp">Anasayfa</a>&nbsp;&nbsp;&nbsp; <a
				href="about.jsp">Hakkımda</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${empty userToken}">
				<a href="login.jsp">Giriş Yap</a>&nbsp;&nbsp;&nbsp;
  <a href="register.jsp">Kayıt Ol</a>&nbsp;&nbsp;&nbsp;
  </c:if>
			<c:if test="${not empty userToken}">
				<a href="logOut">Çıkış Yap</a>&nbsp;&nbsp;&nbsp;
     <c:if test="${role eq 'admin'}">
     <font color="green">Akitflik: <c:out value="${as}"/></font>
     
					<div class="dropdown">
						

						<button class="btn dropdown-toggle btn-outline-success" data-toggle="dropdown">Admin
							komutları</button>

						<div class="dropdown-menu">
							<a href="secrutiy/newBlogDatas.jsp" class="dropdown-item">Yazı
								Ekle</a> <a href="secrutiy/deleteBlog.jsp" class="dropdown-item">Yazı Sil</a>
						</div>
					</div>

				</c:if>


			</c:if>

		</div>
		<div id="contentMain">
			<font color="white">
				<div id="menu">
					MENU<br>
					<hr>
					--------Kategoriler:
			</font>
			<hr>
			<c:forEach items="${list}" var="i">
			---<a
					href="getCategories?categoryId=${i.categoryId}&categoryName=${i.categoryName}">${i.categoryName}</a>
				<br>
			</c:forEach>
			<hr>
			<c:if test="${not empty userToken}">
			-------Kullanıcılar İçin:
			</c:if>

		</div>
		<div id="content">