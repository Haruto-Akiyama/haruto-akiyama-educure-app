<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザ管理</title>
    <!-- 外部CSSファイルをリンク -->
    <link href="css/commonsuserMenu.css" rel="stylesheet">
</head>
<body id="user-management-page">

  <div class="button-container">
      <!-- 登録・更新ボタン -->
      <button onclick="location.href='/userUp'">登録・更新</button>
      <!-- 削除ボタン -->
      <button onclick="location.href='/userDel'">削除</button>
      <!-- 戻るボタン -->
      <button onclick="location.href='/menu'" type="button">戻る</button>
  </div>
  
</body>
</html>
