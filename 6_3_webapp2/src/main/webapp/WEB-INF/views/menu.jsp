
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メニュー</title>
    <!-- 外部CSSファイルをリンク -->
    <link href="css/commonsmenu.css" rel="stylesheet">
</head>
<body id="menu-page">

    <div class="button-container">
        <!-- roleIdが1の場合、すべてのボタンを表示 -->
        <c:if test="${sessionScope.roleId == 1}">
            <button onclick="location.href='/search'">検索</button>
            <button onclick="location.href='/register'">登録</button>
            <button onclick="location.href='/update'">更新</button>
            <button onclick="location.href='/delete'">削除</button>
            <button onclick="location.href='/userSettings'">ユーザ設定</button>
            <button onclick="location.href='/logout'">ログアウト</button>
        </c:if>

        <!-- roleIdが2の場合、検索ボタンとログアウトボタンのみを表示 -->
        <c:if test="${sessionScope.roleId == 2}">
            <button onclick="location.href='/search'">検索</button>
            <button onclick="location.href='/logout'">ログアウト</button>
        </c:if>
    </div>

</body>
</html>


