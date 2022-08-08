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
    String fileUploadPath=request.getServletContext().getContextPath() +"/fileService.upload";
    request.setAttribute("fup", fileUploadPath);
    
    String textName=request.getParameter("textName");
    String textPath=request.getParameter("textPath");
    int catId=Integer.valueOf(request.getParameter("category"));
    
    session.setAttribute("textName", textName);
    session.setAttribute("textPath", textPath);
    session.setAttribute("catId", catId);

    String index=request.getServletContext().getContextPath() +"/index.jsp";
    request.setAttribute("index", index);
    
    %>
        <a href="${index}">Anasayfaya Dön</a><hr>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="newBlogDatas.jsp">Bir Önceki Sayfaya Dön</a>
    
<div>
	<h3>Sunucuya yüklenecek dosyayı seçiniz.</h3>
	<form action="${fup}" method="post" enctype="multipart/form-data">
		 <input type="file" name="file" /> <input type="submit" value="upload" />
	</form>
</div><hr>
<p>
	<font color="red" size=14>Yüklenecek Dosyalar *.jsp olmalıdır.
		Dosyalar içerisinde herhangi bir action olmamalıdır sadece yazı
		olmalıdır. Örnek yazı dosyası:</font> <br> page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"<br> h1
	/h1<br> p<br> Gerekli yazı içeriği<br> /p<br>

</p>
    
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