<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal J_searchForm" action="${website}content/${id}" method="get">
    <div class="form-group">
        ${articleData}
    </div>
</form>
</body>
</html>
