<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path=request.getParameter("textPath");
    request.setAttribute("path", path);
    %>
<jsp:include page="header.jsp"/>

<jsp:include page="${path}"/>



<jsp:include page="footer.jsp"/>