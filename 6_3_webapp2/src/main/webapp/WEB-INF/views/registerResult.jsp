<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録結果</title>
    <link rel="stylesheet" href="css/commons2.css">  <!-- 共通のCSSファイルを使用 -->
</head>
<body>

    <div>
        <!-- 登録結果を表示するテーブル -->
        <table>
            <caption>以下の商品を登録しました</caption>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>商品名</th>
                    <th>個数</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="resultRegister" items="${registerProductsList}">
                    <tr>
                        <td>${fn:escapeXml(resultRegister.getId())}</td>
                        <td>${fn:escapeXml(resultRegister.getName())}</td>
                        <td>${fn:escapeXml(resultRegister.getUnits())}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 戻るボタン -->
        <button onclick="location.href='/menu'" type="button">戻る</button>
    </div>

</body>
</html>
