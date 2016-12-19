<%--
  Created by IntelliJ IDEA.
  User: fengyl
  Date: 2016/12/14
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal J_searchForm" action="${website}content" method="get">
    <div class="form-group">
        ${articleData}
    </div>
</form>
</body>
</html>
