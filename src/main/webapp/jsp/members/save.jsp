<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: yoon
  Date: 2025. 4. 5.
  Time: 오전 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("MemberSaveServlet.service");

  final String userName = request.getParameter("username");
  final Integer age = Integer.parseInt(request.getParameter("age"));

  final Member member = new Member(userName, age);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id = <%=member.getId()%></li>
  <li>name = <%=member.getUsername()%></li>
  <li>age = <%=member.getAge()%></li>
</ul>
<a href="/index.html">main</a>
</body>
</html>
