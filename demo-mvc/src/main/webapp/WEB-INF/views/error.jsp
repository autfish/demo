<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="shared/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${ex.message }"></c:out>
<c:out value="${ex.stackTrace }"></c:out>
</body>
</html>
