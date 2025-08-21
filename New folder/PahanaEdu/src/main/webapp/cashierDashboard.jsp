<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->
<%@ page import="jakarta.servlet.http.*" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !role.equals("Cashier")) {
        response.sendRedirect("login.jsp");
    }
%>
<h2>Welcome Cashier!</h2>
