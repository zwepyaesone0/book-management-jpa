<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<style type="text/css">
.center {
	margin: auto;
}

h2, h3 {
	text-align: center;
	color: blue;
}
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<div style="color: red;">${Error}</div>
	<div><jsp:include page="header.jsp"></jsp:include></div>
	<s:form action="/BookManagementSpring_JPA/updatebook" method="post" modelAttribute="bean">

		<table class="center">
			<tr>
				<td>Book Code</td>
				<td><s:input type="text" path="bookCode" readonly="true" /></td>
				<td><s:errors path="bookCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book Title</td>
				<td><s:input type="text" path="bookTitle"/></td>
				<td><s:errors path="bookTitle" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book Author</td>
				<td><s:input type="text" path="bookAuthor"/></td>
				<td><s:errors path="bookAuthor" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book Price</td>
				<td><s:input type="text" path="bookPrice"/></td>
				<td><s:errors path="bookPrice" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>