<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String id = (String)request.getAttribute("loginid");
%>

<div id="center">
	LOGIN OK<br>
	<%=id %> ȯ���մϴ�. <br>
	${loginid} ȯ�����մϴ�. <br> //auto
</div>