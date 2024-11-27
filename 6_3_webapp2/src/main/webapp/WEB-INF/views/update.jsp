<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>更新画面</title>
    <!-- search.jsp と同じ CSS ファイルをリンク -->
    <link href="css/commonssearch.css" rel="stylesheet">
</head>
<body class="search-page"> <!-- 'search-page' クラスを適用 -->

    <div class="form-container1"> <!-- 'form-container1' クラスを適用 -->
        <p>更新情報</p>

        <!-- エラーメッセージを表示 -->
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <form:form action="/updateItem" method="post" modelAttribute="updateForm">
            <div>
                <label class="required">ID</label>
                <form:input path="UpdateProductsId" />
                <form:errors path="UpdateProductsId" cssClass="error" />
            </div>
            <div>
                <label class="required">在庫数</label>
                <form:input path="UpdateProductsUnits" />
                <form:errors path="UpdateProductsUnits" cssClass="error" />
            </div>
            <div>
                <label class="required">商品名</label>
                <form:input path="UpdateProductsName" />
                <form:errors path="UpdateProductsName" cssClass="error" />
            </div>

            <button type="submit">更新</button>
        </form:form>

        <div>
            <button class="back-button" onclick="location.href='/menu'" type="button">戻る</button>
        </div>

    </div>

</body>
</html>
