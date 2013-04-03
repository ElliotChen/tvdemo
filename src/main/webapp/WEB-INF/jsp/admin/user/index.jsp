<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/base.jsp"%>
<script type="text/javascript">
<!--
$(document).ready(function () {
	$("#masterGrid").kendoGrid({
		columns: [
		          { field: "oid" },
		          { field: "name" },
		          { field: "birthDay" },
		          { command: ["edit", "destory"] }
		        ],
		dataSource: {
			type: "odata",
            transport: {
                read: {
                    url: "${ctx}/admin/user!ajaxPageSearch.action",
                    dataType: "json",
                    type: "POST"
                },
            },
            schema: {
                data: "data", // records are returned in the "data" field of the response
                total: "total", // total number of records is in the "total" field of the response
                model: {
                    id: "Oid",
                    fields: {
                    	Oid: {type:"string"},
                        Name: { type: "string"},
                        BirthDay: { type: "string" },
                        CreatedAccount: { type: "string" }
                    }
                }
            },
            pageSize: 5,
            serverPaging: true,
            serverFiltering: true,
            serverSorting: true,
            create : function() {
            	alert('New!!!');
            }
        },
        sortable: true,
        pageable: true,
        selectable: "row",
        editable: "popup",
        toolbar: ["create"]
	});
});
//-->
</script>
<div id="search">
	<form method="POST">
	<table>
		<tr><td>Name:</td><td><input type="text" name="example.name" /></td></tr>
	</table>
	</form>
</div>

<div id="masterGrid">
</div>