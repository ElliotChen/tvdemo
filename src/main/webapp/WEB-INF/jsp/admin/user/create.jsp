<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script>
	$(document).ready(function() {
		$("#createForm").validate({
			rules : {
				'name' : {required:true},
				'birthday' : {required:true}
			},
			submitHandler : function(form) {
				$(form).ajaxSubmit({success:ajaxCreateSuccess});
			}
		});
		
		$(".date").kendoDatePicker({format: "yyyy/MM/dd"});
	});
	
	function ajaxCreateSuccess(responseText, statusText, xhr, $form) {
		closeCreateForm(responseText);
	}
</script>
<s:form id="createForm" method="POST" name="createForm" action="/admin/user!create">
<h3>Create User</h3>
<ul>
	<li>
		<label for="c_name">Name</label>
		<s:textfield name="name" id="c_name"/>
	</li>
	<li>
		<label for="c_birthday">Birthday</label>
		<s:textfield name="birthday" id="c_birthday" cssClass="date"/>
	</li>
	<li>
		<input type="submit" class="k-button" value="SEND"/>
		<input type="reset" class="k-button" value="RESET"/>
	</li>
</ul>
</s:form>