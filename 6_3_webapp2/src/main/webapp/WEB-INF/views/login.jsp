<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理アプリ</title>
<!-- 新しいCSSファイルをリンク -->
<link href="css/commons.css" rel="stylesheet">
</head>
<body id="login-page">

  <!-- アプリ名の表示（画面上部） -->
  <p class="app-title">在庫管理アプリ</p>
  
  <!-- エラーメッセージの表示 -->
  <c:if test="${not empty errorMessage}">
    <p class="error">${errorMessage}</p>
  </c:if>
  
  <!-- ログインフォーム -->
  <form:form action="/login" method="post" modelAttribute="loginForm">
    
      <div class="input-container">
        <label for="loginId">ログインID：</label>
        <form:input path="loginId" id="loginId" />
        <form:errors path="loginId" cssStyle="color: red"/>
      </div>

      <div class="input-container">
        <label for="pass">パスワード：</label>
        <form:input path="pass" id="pass" type="password"/>
        <form:errors path="pass" cssStyle="color: red"/>
      </div>
  
    <button type="submit">ログイン</button>
  </form:form>

</body>
</html>
