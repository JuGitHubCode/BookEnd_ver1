<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_mypage_info_update_validation</title>
</head>
<body>
	<c:if test="${not empty emailValidation}">
		중복된 이메일입니다. 확인 후 다시 입력해주세요.
	</c:if>
	<c:if test="${not empty phoneValidation }">
		중복된 휴대폰 번호입니다. 확인 후 다시 입력해주세요.
	</c:if>
</body>
</html>