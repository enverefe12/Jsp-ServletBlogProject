<%@page import="Model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataAccess.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yes</title>
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
body {
background-repeat: repeat;
background-attachment: fixed;
background-color: #f1df98;
background-position: top-left;
}

</style>
<body>

  


<%    
    CategoryDao kg=new CategoryDao();
    ArrayList<Category> list=kg.getCategories();
    request.setAttribute("list", list);
    String index=request.getServletContext().getContextPath() +"/index.jsp";
    request.setAttribute("index", index);
 
    %>
        <a href="${index}">Anasayfaya Dön</a><hr>
    
<form action="addBlog.jsp" method="post">
Görünecek Yazı Adı: <input type="text" name="textName" /><br>
		Uzantı ile beraber yüklenen adı: <input type="text" name="textPath" /><br>
		Yazı Kategorisi: <select name="category" id="">
			<c:forEach items="${list}" var="i">
				<option value="${i.categoryId}">${i.categoryName}</option>
			</c:forEach>
		</select>
      <input type="submit" value="Gönder">
 </form>

<font color="red"><h1>Lütfen Türkçe Karakter Girişi Yapmayınız. Sitemizin Hala Çözülemeyen Küçük Bir Encoding Problemi Vardır :)</h1></font>

    
<hr>
<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
    <span class="sr-only">Close</span>
  </button>
  <strong>${message }</strong>.
</div>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script><!--Slim= Sadece bootstrap için çalışan jquery kütüphanesi-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
</body>
</html>