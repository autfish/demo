<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../shared/taglib.jsp"%>
<html>
<head>
    <title>angular</title>
    <script type="text/javascript" src="<c:url value='/js/angular.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/angular-cookies.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/angular-controller.js'/>"></script>
</head>
<body>
<div ng-app="demoApp" ng-controller="firstController">
    <input ng-model="name">
    <button ng-click="save()">保存</button>
</div>
</body>
</html>
