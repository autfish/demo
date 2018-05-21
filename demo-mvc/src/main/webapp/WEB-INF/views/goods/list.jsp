<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../shared/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="<c:url value='/css/main.css'/>" rel="stylesheet" />
<script type="text/javascript" src="<c:url value='/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript">
function delGoods(id) {
	if(!window.confirm("确定要删除吗?")) {
		return false;
	}
	
	$.ajax({
        data:"id=" + id,
        type:"GET",
        dataType: 'json',
        url:"<c:url value='/goods/delete'/>",
        error:function(data){
            alert("删除失败");
        },
        success:function(data){
        	if(data.code > 0) {
	            alert("删除成功");
	            document.forms[0].submit();
        	} else {
        		alert("删除失败");
        	}
        }
	});
}
</script>
</head>
<body>
	<%@ include file="../authority/welcome.jsp"%>
	<form:form action="${pageContext.request.contextPath}/goods/list" method="GET" modelAttribute="goodsSearchModel">
		<form:input path="id" autocomplete="off" placeholder="商品编号" />
		<form:input path="name" autocomplete="off" placeholder="商品名称" />
		<form:input path="fromPrice" autocomplete="off" placeholder="最低价格" />
		<form:input path="toPrice" autocomplete="off" placeholder="最高价格" />
		<button type="submit">搜索</button>&nbsp;&nbsp;<a href="<c:url value='/goods/addOrUpdate'/>">添加新商品</a>
		<br />
		<br />
		<c:if test="${empty contentModel.items}">
			<table id="empty-table">
				<tr>
					<td class="check_cell">没有符合条件的数据</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${not empty contentModel.items}">
			<table id="data-table">
				<tr>
					<td style="width: 100px;">商品编号</td>
					<td style="width: 200px;">商品名称</td>
					<td style="width: 100px;">商品价格</td>
					<td style="width: 100px;">操作</td>
					<td style="width: 100px;">操作</td>
				</tr>
				<c:forEach items="${contentModel.items}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.price}</td>
						<td><a href="<c:url value='/goods/addOrUpdate'/>?id=${item.id}">修改</a></td>
						<td><a href="javascript:void(0);" onclick="javascript:delGoods(${item.id});">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<my:pagingTag pageIndex="${contentModel.pageIndex}" pageSize="${contentModel.pageSize}" pageCount="${contentModel.pageCount}" itemCount="${contentModel.itemCount}" />
		</c:if>
	</form:form>
</body>
</html>