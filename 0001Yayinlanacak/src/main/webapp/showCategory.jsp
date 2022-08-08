<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<jsp:include page="header.jsp"/>

<h1>${ctgn} Kategorisinde ki Yazılar</h1>
<c:forEach items="${listofTexts}" var="i">
<h5><a href="showText.jsp?textPath=texts/${i.textPath}">${i.name}</a><br></h5>
</c:forEach>
<jsp:include page="footer.jsp"/>