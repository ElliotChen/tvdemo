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
				{ field : "name" }, 
				{ field : "year" }, 
				{ field : "note" },
				//{ command: ["edit", "destory"] }
				{ command : [ {text : "Edit", click : loadEditForm},
				              {text : "Delete", click : deleteEntity}]}
				],
			dataSource : {
				//type: "odata",
				transport : {
					read : function(options) {
						$.ajax( {
			                url: "${ctx}/admin/book!ajaxPageSearch.action",
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
							Name : { type : "string" },
							Year : { type : "string" },
							Note : { type : "string" }
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
			  url: '${ctx}/admin/book!loadCreateForm.action',
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
		showMsg(jsonMsg);
		reloadKendoGrid(mGrid);
	}
	
	function loadEditForm(e) {
		var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		$.ajax({
			  url: '${ctx}/admin/book!loadEditForm.action',
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
		showMsg(jsonMsg);
		reloadKendoGrid(mGrid);
	}
	
	function deleteEntity(e) {
		var dataItem = this.dataItem($(e.currentTarget).closest("tr"));
		$.ajax({
			  url: '${ctx}/admin/book!delete.action',
			  type: 'POST',
			  dataType: 'json',
			  data : {oid:dataItem.oid},
			  success: function(data, textStatus, xhr) {
				  showMsg(jsonMsg);
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
			<h3>Search Book:</h3>
			<ul>
				<li>
					<label for="name">Name:</label>
					<input type="text" id="name" name="example.oid.name" class="k-textbox" />
				</li>
				<li>
					<label for="year">Year:</label>
					<input type="text" id="year" name="example.oid.year" class="k-textbox" />
				</li>
				<li>
					<a href="#" class="k-button" onclick="reloadGrid()">Search</a>
				</li>
			</ul>
		</form>
	</div>

	<div id="masterGrid"></div>

	<div id="createDiv" class="editForm">should not look this!!!!</div>
	<div id="editDiv" class="editForm">should not look this!!!!</div>
</div>