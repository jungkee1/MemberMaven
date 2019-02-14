<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
검색 된 개수 :${count }
<table>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
		<td>메모</td>
	</tr>
<c:forEach items="${vo }" var="vo">
	<tr>
		<td>${vo.id }</td>
		<td>${vo.name }</td>
		<td>${vo.addr }</td>
		<td>${vo.memo }</td>
	</tr>
</c:forEach>
</table>

</body>
</html>