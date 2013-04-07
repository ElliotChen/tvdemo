<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script type="text/javascript">
	var createDiv;
	var editDiv;
	var mGrid;
	$(document).ready(function() {
		createDiv = $("#createDiv").kendoWindow({
			draggable : false,
			modal: true,
			visible : false
		}).data("kendoWindow");
		editDiv = $("#editDiv").kendoWindow({
			draggable : false,
			modal: true,
			visible : false
		}).data("kendoWindow");
		mGrid = $("#masterGrid").kendoGrid({
			columns : [ 
				{ field : "oid" }, 
				{ field : "name" }, 
				{ field : "birthday" },
				//{ command: ["edit", "destory"] }
				{ command : [ {text : "Edit", click : loadEditForm},
				              {text : "Delete", click : deleteEntity}]}
				],
			dataSource : {
				//type: "odata",
				transport : {
					read : function(options) {
						$.ajax( {
			                url: "${ctx}/admin/user!ajaxPageSearch.action",
			                type: "POST",
			                data: $.param(options.data)+"&"+$("#searchForm").serialize(), // the "data" field contains paging, sorting, filtering and grouping data
			                success: function(result) {
			                    options.success(result);
			                }
			            });
					}
					/*
					read : {
						url : "${ctx}/admin/user!ajaxPageSearch.action",
						dataType : "json",
						type : "POST"
					}
					*/
				},
				schema : {
					data : "data", // records are returned in the "data" field of the response
					total : "total", // total number of records is in the "total" field of the response
					model : {
						id : "Oid",
						fields : {
							Oid : { type : "string" },
							Name : { type : "string" },
							Birthday : { type : "string" }, 
							CreatedAccount : { type : "string" }
						}
					}
				},
				pageSize : 5,
				serverPaging : true,
				serverFiltering : true,
				serverSorting : true
			},
			sortable : false,
			pageable : true,
			selectable : "row",
			toolbar : kendo.template($("#template").html())
		}).data("kendoGrid");
		
		$("#createForm").validate({
			rules : {
				'name' : {required:true},
				'birthday' : {required:true}
			},
			submitHandler : function(form) {
				$(form).ajaxSubmit({success:ajaxCreateSuccess});
			}
		});
		
		$("#editForm").validate({
			rules : {
				'name' : {required:true},
				'birthday' : {required:true}
			},
			submitHandler : function(form) {
				$(form).ajaxSubmit({success : ajaxEditSuccess});
			}
		});

		/* Date Column */
		$(".date").kendoDatePicker({format: "yyyy/MM/dd"});
	});
	
	/* Create related. */
	function loadCreateForm() {
		//var kw = $("#createForm").data("kendoWindow");
		
		$.ajax({
			  url: '${ctx}/admin/user!ajaxLoadCreateForm.action',
			  type: 'POST',
			  dataType: 'json',
			  success: function(data, textStatus, xhr) {
				  fillCreateForm(data);
			  },
			  error: function(xhr, textStatus, errorThrown) {
				  alert(xhr);
			  }
			});
	}
	
	function fillCreateForm(entity) {
		//$("#createForm").reset();
		
		$("#c_name").val(entity.name);
		$("#c_birthday").val(entity.birthday);
		
		createDiv.center();
		createDiv.open();
	}
	function ajaxCreateSuccess(responseText, statusText, xhr, $form) {
		closeCreateForm(responseText); //defined by index.jsp
	}
	
	function closeCreateForm(jsonMsg) {
		createDiv.close();
		alert(jsonMsg);
		reloadKendoGrid(mGrid);
	}
	
	function loadEditForm(e) {
		var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		$.ajax({
			  url: '${ctx}/admin/user!ajaxLoadEditForm.action',
			  type: 'POST',
			  dataType: 'json',
			  data : {oid:dataItem.oid},
			  success: function(data, textStatus, xhr) {
				  fillEditForm(data);
			  },
			  error: function(xhr, textStatus, errorThrown) {
				  alert(xhr);
			  }
			});
		
		editDiv.center();
		editDiv.open();
	}
	
	function fillEditForm(entity) {
		$("#e_oid").val(entity.oid);
		$("#e_name").val(entity.name);
		$("#e_birthday").val(entity.birthday);
		
		editDiv.center();
		editDiv.open();
	}
	
	function ajaxEditSuccess(responseText, statusText, xhr, $form) {
		closeEditForm(responseText); //defined by index.jsp
	}
	
	function closeEditForm(jsonMsg) {
		editDiv.close();
		alert(jsonMsg);
		reloadKendoGrid(mGrid);
	}
	
	function deleteEntity(e) {
		var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		$.ajax({
			  url: '${ctx}/admin/user!delete.action',
			  type: 'POST',
			  dataType: 'json',
			  data : {oid:dataItem.oid},
			  success: function(data, textStatus, xhr) {
				  showMsg(data);
				  reloadKendoGrid(mGrid);
			  },
			  error: function(xhr, textStatus, errorThrown) {
				  showMsg(xhr);
			  }
			});
	}
	
	function reloadGrid() {
		reloadKendoGrid(mGrid);
	}
</script>
<!-- Customize kendo toolbar -->
<script type="text/x-kendo-template" id="template">
	<div class="toolbar">
		<a id="b_create" class="k-button k-button-icontext" onclick="loadCreateForm()">NEW</a>
	</div>
</script>
<div class="k-content">
	<div id="search" class="editForm">
		<form method="POST" id="searchForm">
			<h3>Search User:</h3>
			<ul>
				<li><label for="name">Name:</label> <input type="text"
					id="name" name="example.name" class="k-textbox" /></li>
				<li>
					<a href="#" class="k-button" onclick="reloadGrid()">Search</a>
				</li>
			</ul>
		</form>
	</div>

	<div id="masterGrid"></div>

	<div id="createDiv" class="editForm">
		<form id="createForm" method="POST" name="createForm" action="${ctx}/admin/user!create.action">
			<h3>Ajax Create User</h3>
			<ul>
				<li>
					<label for="c_name">Name</label>
					<input type="text" name="name" id="c_name"/>
				</li>
				<li>
					<label for="c_birthday">Birthday</label>
					<input type="text" name="birthday" id="c_birthday" class="date"/>
				</li>
				<li>
					<input type="submit" class="k-button" value="SEND"/>
					<input type="reset" class="k-button" value="RESET"/>
				</li>
			</ul>
		</form>
	</div>
	<div id="editDiv" class="editForm">
		<form id="editForm" method="POST" name="editForm" action="${ctx}/admin/user!update.action">
			<input type="hidden" id="e_oid" name="oid" />
			<h3>Ajax Edit User</h3>
			<ul>
				<li>
					<label for="e_name">Name</label>
					<input type="text" name="name" id="e_name" />
				</li>
				<li>
					<label for="e_birthday">Birthday</label>
					<input type="text" name="birthday" id="e_birthday" class="date"/>
				</li>
				<li>
					<input type="submit" class="k-button" value="SEND"/>
					<input type="reset" class="k-button" value="RESET"/>
				</li>
			</ul>
		</form>
	</div>
</div>