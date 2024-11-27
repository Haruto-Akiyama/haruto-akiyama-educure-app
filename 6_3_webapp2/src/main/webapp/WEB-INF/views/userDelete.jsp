<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー削除</title>
    <!-- 統一したCSSファイルをリンク -->
    <link href="css/commonssearch.css" rel="stylesheet">
</head>
<body class="search-page"> <!-- 'search-page' クラスを追加 -->

    <div class="form-container1"> <!-- 'form-container1' クラスを追加 -->
        <p>削除するユーザの管理番号</p>

        <!-- エラーメッセージを表示 -->
        <c:if test="${not empty errorMessage}">
             <p style="color: red;">${errorMessage}</p>
        </c:if>

        <form:form action="/userDelNumber" method="post" modelAttribute="userDeleteForm">
            <fieldset class="label-60">
                <div>
                    <label class="required">管理番号</label>
                    <form:input path="userDelNumber" />
                    <form:errors path="userDelNumber" cssClass="error" />
                </div>
            </fieldset>
            <button type="submit">削除</button>
        </form:form>

        <div>
            <button class="back-button" onclick="location.href='/userMenu'" type="button">戻る</button>
        </div>
    </div>

</body>
</html>
