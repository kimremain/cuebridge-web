<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" pageEncoding="utf-8"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<script>
function fnUpdate() {
    document.getElementById("form1").action = "/sample/updateSample";
    document.getElementById("form1").submit();
}

function fnDelte() {
    document.getElementById("form1").action = "/sample/deleteSample";
    document.getElementById("form1").submit();
}
</script>
</head>
<body>
	<form id="form1" name="form1" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>NAME</td>
			</tr>
			<tr>
				<td><input type="text" name="id" value="${response.id}" /></td>
				<td><input type="text" name="name" value="${response.name}" /></td>
			</tr>
		</table>
		<br /> <a href="javascript:fnUpdate()">update</a> <a
			href="javascript:fnDelte()">delete</a>
	</form>
    </tiles:putAttribute>
</tiles:insertDefinition>