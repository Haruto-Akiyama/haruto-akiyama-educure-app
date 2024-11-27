<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <!-- search.css をリンク -->
    <link href="css/commonssearch.css" rel="stylesheet">
</head>
<body class="search-page"> <!-- search-page クラスを追加 -->

  <div class="form-container1">
    <p>商品検索条件</p>

    <!-- エラーメッセージを表示 -->
    <c:if test="${not empty errorMessage}">
      <p class="error">${errorMessage}</p>
    </c:if>

    <form:form action="/list" method="post" modelAttribute="searchForm">
      <div>
        <label>商品ID</label>
        <form:input path="productsId" />
      </div>
      <div>
        <label>商品名</label>
        <form:input path="productsName" />
        
      </div>

      <button type="submit">検索</button>
    </form:form>

    <!-- 戻るボタン -->
    <button class="back-button" onclick="location.href='/menu'" type="button">戻る</button>
  </div>

</body>
</html>
