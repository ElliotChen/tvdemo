<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<html>
	<head>
		<tiles:insertAttribute name="header" />
		<link rel="stylesheet" href="${ctx}/styles/kendo.common.min.css" />
		<link rel="stylesheet" href="${ctx}/styles/kendo.default.min.css" />
		<style>
			.editForm ul {
				list-style-type: none;
			}
		</style>
		<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/kendo.web.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/additional-methods.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.form.js"></script>
		<script type="text/javascript">
			var msgDiv;
			$(document).ready(function() {
				msgDiv = $("#msg").kendoWindow({
					draggable : false,
					modal: true,
					visible : false
				}).data("kendoWindow");
			});
			
			function showMsg(msg) {
				msgDiv.content(msg);
				msgDiv.center();
				msgDiv.open();
			}
			
			function reloadKendoGrid(grid) {
				grid.dataSource.read();
			}
		</script>
	</head>
	<body>
		<div id="menu" class="k-content"><tiles:insertAttribute name="menu" /></div>
		<div id="main" class="k-content"><tiles:insertAttribute name="main" /></div>
		<div id="msg" class="k-content"></div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>