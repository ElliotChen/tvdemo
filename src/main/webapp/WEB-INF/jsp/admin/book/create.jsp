<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script>
	$(document).ready(function() {
		$("#createForm").validate({
			rules : {
				'name' : {required:true},
				'year' : {required:true},
				'note' : {required:true}
			},
			submitHandler : function(form) {
				$(form).ajaxSubmit({success:ajaxCreateSuccess});
			}
		});
		
		$(".date").kendoDatePicker({format: "yyyy/MM/dd"});
	});
	
	function ajaxCreateSuccess(responseText, statusText, xhr, $form) {
		closeCreateForm(responseText); //defined by index.jsp
	}
</script>
<s:form id="createForm" method="POST" name="createForm" action="/admin/book!create">
<h3>Create User</h3>
<ul>
	<li>
		<label for="c_name">Name</label>
		<s:textfield name="oid.name" id="c_name"/>
	</li>
	<li>
		<label for="c_year">Year</label>
		<s:textfield name="oid.year" id="c_year"/>
	</li>
	<li>
		<label for="c_note">Note</label>
		<s:textfield name="note" id="c_note"/>
	</li>
	<li>
		<input type="submit" class="k-button" value="SEND"/>
		<input type="reset" class="k-button" value="RESET"/>
	</li>
</ul>
</s:form>