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
		<label for="c_birthday">Birthday</label>
		<s:textfield name="birthday" id="e_birthday" cssClass="date"/>
	</li>
	<li>
		<input type="submit" class="k-button" value="SEND"/>
		<input type="reset" class="k-button" value="RESET"/>
	</li>
</ul>
</s:form>