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
<title>検索結果</title>
<link rel="stylesheet" href="css/commons2.css">


</head>
<body>

  <div>
    <!-- 検索結果をテーブルに表示 -->
    <table>
      <caption>検索結果</caption>
      <thead>
        <tr>
          <th>ID</th>
          <th>商品名</th>
          <th>個数</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="products" items="${productsList}">
          <tr>
            <td>${fn:escapeXml(products.getId())}</td>
            <td>${fn:escapeXml(products.getName())}</td>
            <td>${fn:escapeXml(products.getUnits())}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>

    <!-- 戻るボタン -->
    <button onclick="location.href='/menu'" type="button">戻る</button>
  </div>

</body>
</html>
