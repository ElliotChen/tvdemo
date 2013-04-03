<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<html>
	<head>
		<tiles:insertAttribute name="header" />
		<link rel="stylesheet" href="${ctx}/styles/kendo.common.min.css" />
		<link rel="stylesheet" href="${ctx}/styles/kendo.default.min.css" />
		
		<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/kendo.web.min.js"></script>
	</head>
	<body>
		<div id="menu" class="k-content"><tiles:insertAttribute name="menu" /></div>
		<div id="main" class="k-content"><tiles:insertAttribute name="main" /></div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>