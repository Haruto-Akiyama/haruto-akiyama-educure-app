<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー情報更新</title>
    <!-- 統一したCSSファイルをリンク -->
    <link href="css/commonssearch.css" rel="stylesheet">
</head>
<body class="search-page"> <!-- 'search-page' クラスを追加 -->

    <div class="form-container1"> <!-- 'form-container1' クラスを追加 -->
        <p>登録情報</p>

        <!-- エラーメッセージを表示 -->
        <c:if test="${not empty errorMessage}">
            <p class="error">${errorMessage}</p>
        </c:if>

        <form:form action="/userUpdate" method="post" modelAttribute="userUpdateForm">
            <fieldset class="label-60">
                <div>
                    <label class="required">管理番号</label>
                    <form:input path="usersNumber" />
                    <form:errors path="usersNumber" cssClass="error" />
                </div>
                <div>
                    <label class="required">名前</label>
                    <form:input path="usersName" />
                    <form:errors path="usersName" cssClass="error" />
                </div>
                <div>
                    <label class="required">役職</label>
                    <!-- プルダウン形式で管理者と一般を選択できるようにする -->
                    <form:select path="usersRole">
                        <form:option value="1">管理者</form:option>
                        <form:option value="2">一般</form:option>
                    </form:select>
                    <form:errors path="usersRole" cssClass="error" />
                </div>
                <div>
                    <label class="required">ログインID</label>
                    <form:input path="usersLogin" />
                    <form:errors path="usersLogin" cssClass="error" />
                </div>
                <div>
                    <label class="required">パスワード</label>
                    <form:input path="usersPass" />
                    <form:errors path="usersPass" cssClass="error" />
                </div>
            </fieldset>

            <button type="submit">登録・更新</button>
        </form:form>

        <div>
            <button class="back-button" onclick="location.href='/userMenu'" type="button">戻る</button>
        </div>
    </div>

</body>
</html>
