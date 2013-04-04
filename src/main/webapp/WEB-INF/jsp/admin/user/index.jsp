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
				{ field : "birthDay" },
				//{ command: ["edit", "destory"] }
				{ command : [ {text : "Edit", click : loadEditForm},
				              { text : "Delete", click : loadEditForm}]}
				],
			dataSource : {
				//type: "odata",
				transport : {
					read : function(options) {
						$.ajax( {
			                url: "${ctx}/admin/user!ajaxPageSearch.action",
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
							BirthDay : { type : "string" }, 
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

	});
	
	function loadCreateForm() {
		//var kw = $("#createForm").data("kendoWindow");
		
		$.ajax({
			  url: '${ctx}/admin/user!loadCreateForm.action',
			  type: 'POST',
			  dataType: 'html',
			  success: function(data, textStatus, xhr) {
				createDiv.content(data);
			  },
			  error: function(xhr, textStatus, errorThrown) {
				createDiv.content(xhr);
			  }
			});
		
		createDiv.center();
		createDiv.open();
	}
	
	function closeCreateForm(jsonMsg) {
		createDiv.close();
		showMsg("Create Success");
		mGrid.refresh();
	}
	
	function loadEditForm(e) {
		var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		$.ajax({
			  url: '${ctx}/admin/user!loadEditForm.action',
			  type: 'POST',
			  dataType: 'html',
			  data : {oid:dataItem.oid},
			  success: function(data, textStatus, xhr) {
				  editDiv.content(data);
			  },
			  error: function(xhr, textStatus, errorThrown) {
				  editDiv.content(xhr);
			  }
			});
		
		editDiv.center();
		editDiv.open();
	}
	
	function closeEditForm(jsonMsg) {
		editDiv.close();
		showMsg("Update Success");
		mGrid.refresh();
	}
	
	function reloadGrid() {
		alert("reload");
	}
</script>
<!-- Customize toolbar -->
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
					<button onclick="reloadGrid()">Search</button>
				</li>
			</ul>
		</form>
	</div>

	<div id="masterGrid"></div>

	<div id="createDiv" class="editForm">should not look this!!!!</div>
	<div id="editDiv" class="editForm">should not look this!!!!</div>
</div>