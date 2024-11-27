<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザ登録更新結果画面</title>
    <link href="css/commons2.css" rel="stylesheet">  <!-- 共通のCSSファイルを使用 -->
</head>
<body>

    <div>
        <!-- ユーザ登録・更新結果を表示するテーブル -->
        <table>
            <caption>以下のユーザを登録・更新しました</caption>
            <thead>
                <tr>
                    <th>管理番号</th>
                    <th>名前</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="resultRegister" items="${userIdList}">
                    <tr>
                        <td>${fn:escapeXml(resultRegister.getNumber())}</td>
                        <td>${fn:escapeXml(resultRegister.getName())}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 戻るボタン -->
        <button onclick="location.href='/menu'" type="button">戻る</button>
    </div>

</body>
</html>
