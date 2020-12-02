<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="true" pageEncoding="utf-8"%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<script>
function fnInsert() {
	//document.getElementById("form1").action = "/sample/insertSample";
	document.getElementById("form1").submit();
}
</script>
</head>
<body>
	<form id="form1" name="form1" method="post" action = "/sample/insertSample">
		<table>
			<tr>
				<td>ID</td>
				<td>NAME</td>
			</tr>
			<tr>
				<td><input type="text" name="id" /></td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
		<br /> <a href="javascript:fnInsert()">insert</a>
	</form>
    </tiles:putAttribute>
</tiles:insertDefinition>