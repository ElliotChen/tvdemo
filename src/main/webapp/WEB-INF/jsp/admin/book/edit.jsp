<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script>
	$(document).ready(function() {
		$("#editForm").validate({
			rules : {
				'note' : {required:true}
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
<s:form id="editForm" name="editForm" action="/admin/book!update">
	<s:hidden name="oid.name" />
	<s:hidden name="oid.year" />
<h3>Edit User</h3>
<ul>
	<li>
		Name:${oid.name}, Year:${oid.year}
	</li>
	<li>
		<label for="e_note">Note</label>
		<s:textfield name="note" id="e_note" />
	</li>
	<li>
		<input type="submit" class="k-button" value="SEND"/>
		<input type="reset" class="k-button" value="RESET"/>
	</li>
</ul>
</s:form>