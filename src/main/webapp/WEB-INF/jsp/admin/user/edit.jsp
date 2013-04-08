<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script>
	$(document).ready(function() {
		$("#editForm").validate({
			rules : {
				'name' : {required:true},
				'birthday' : {required:true}
			},
			submitHandler : function(form) {
				$(form).ajaxSubmit({success : ajaxEditSuccess});
			}
		});
		
		$(".date").kendoDatePicker({format: "yyyy/MM/dd"});
	});
	
	function ajaxEditSuccess(responseText, statusText, xhr, $form) {
		closeEditForm(responseText); //defined by index.jsp
	}
</script>
<s:form id="editForm" name="editForm" action="/admin/user!update">
	<s:hidden name="oid" />
<h3>Edit User</h3>
<ul>
	<li>
		<label for="e_name">Name</label>
		<s:textfield name="name" id="e_name" />
	</li>
	<li>
		<label for="e_birthday">Birthday</label>
		<s:textfield name="birthday" id="e_birthday" cssClass="date"/>
	</li>
	<li>
		<label for="e_gender">Gender</label>
		<s:select id="e_gender" name="gender" list="@tw.com.tradevan.domain.Gender@values()" listValue="%{getText('enum.Gender.'+toString())}"/>
	</li>
	<li>
		<label for="e_admin">Admin</label>
		<s:radio id="e_admin" name="admin" list="#{'true':'Yes','false':'No'}"/>
	</li>
	<li>
		<input type="submit" class="k-button" value="SEND"/>
		<input type="reset" class="k-button" value="RESET"/>
	</li>
</ul>
</s:form>