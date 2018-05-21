<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../shared/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="<c:url value='/css/main.css'/>" rel="stylesheet" />
<script type="text/javascript" src="<c:url value='/js/jquery-1.10.2.min.js'/>"></script>
<style>
.error {
    color: #ff0000;
    font-weight: bold;
}
</style> 
</head>
<body>
	<%@ include file="../authority/welcome.jsp"%>
	<form:form action="${pageContext.request.contextPath}/goods/addOrUpdate" method="POST" modelAttribute="goodsModel">
	<c:if test="${goodsModel.id==0}">
	添加新商品
	</c:if>
	<c:if test="${goodsModel.id!=0}">
	修改商品信息, 商品ID: ${goodsModel.id}
	</c:if>
	<br />
	<form:hidden path="id" />
	商品名称: <form:input path="name" autocomplete="off" placeholder="商品名称" /><form:errors path="name" cssClass="error" /><br />
	商品价格: <form:input path="price" autocomplete="off" placeholder="商品价格" /><form:errors path="price" cssClass="error" /><br />
	<button type="submit">提交</button>
	</form:form>
</body>
</html>