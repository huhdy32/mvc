<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: yoon
  Date: 2025. 4. 5.
  Time: 오후 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id = <%=((Member) request.getAttribute("member")).getId()%></li>
  <li>name = <%=((Member)request.getAttribute("member")).getUsername()%></li>
  <li>age = <%=((Member)request.getAttribute("member")).getAge()%></li>
</ul>
<a href="/index.html">main</a>
</body>
</html>
