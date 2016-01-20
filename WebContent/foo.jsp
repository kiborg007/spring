<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript"></script>
</head>
<body>
		<input type="text" id="name" value=""/>
		<input type="button"  id="superButton" value="Show Persons"/> 
		<div id="personsList"></div>
		
		<script type="text/javascript">
		jQuery("#superButton").click(function(){
				alert(jQuery("#name").val());
			});
		</script>
		
		<c:set var="my" value="${param.my}"></c:set>
		<c:if test="${my eq 'aaa' }">
			<c:out value="hello world !"></c:out>
		</c:if>
		<c:if test="${my eq 'bbb' }">
			<c:out value="how are you ?"></c:out>
		</c:if>
</body>
</html>
<!-- 
Example :

http://localhost:8080/springmvc/foo.jsp?my=aaa

-->