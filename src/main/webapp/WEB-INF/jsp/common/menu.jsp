<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tvmenu").kendoMenu();
	});
	
	function loadContent(divName, url) {
		jQuery.ajax({
			  url: url,
			  type: 'POST',
			  dataType: 'html',
			  success: function(data, textStatus, xhr) {
			    $("#"+divName).html(data);
			  },
			  error: function(xhr, textStatus, errorThrown) {
			    alert(xhr);
			  }
			});
	}
</script>

<ul id="tvmenu">
	<li>Admin
		<ul>
			<li><a href="javascript:loadContent('main', '${ctx}/admin/user!index.action');">User</a></li>
			<li><a href="javascript:loadContent('main', '${ctx}/admin/book!index.action');">Book</a></li>
		</ul>
	</li>
</ul>