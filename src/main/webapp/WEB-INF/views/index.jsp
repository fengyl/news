<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<body>
<form action="${website}index" method="get" class="form-inline">
        <c:forEach var="list" items="${articleDtoList}">
            <tr>
                <td><span>${list.title}</span></td>
                <td><span>${list.name}</span></td>
                <td>
                    <a class="action" href="">修改</a>
                    <span class="action del" >删除</span>
                    <a class="action" href="${website}content/${list.id}">详情</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</body>
</html>
