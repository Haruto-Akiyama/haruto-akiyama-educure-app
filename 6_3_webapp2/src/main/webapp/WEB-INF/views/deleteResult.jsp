<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>削除結果</title>
    <link href="css/commons2.css" rel="stylesheet">  <!-- 共通のCSSファイルを使用 -->
</head>
<body>

    <div>
        <!-- 削除結果を表示するテーブル -->
        <table>
            <caption>以下の商品を削除しました</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>商品名</th>
                    <th>個数</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="products" items="${deleteProductsList}">
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
