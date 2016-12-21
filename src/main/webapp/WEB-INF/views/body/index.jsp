<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title>test</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../resources/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/index.css" type="text/css">
    <link rel="stylesheet" href="../resources/pagination/pagination.css" />

</head>
<body style="font-family: "Microsoft Yahei";">
<div class="header">
    <div class="navbar-inner">
        <p>信息与软件工程学院</p>
    </div>
</div>
<div class="middle">
    <!-- 侧边栏 -->
    <div class="sidebar">
        <div class="sidebarWrapper">
            <h3>栏目列表</h3>
            <div class="ulWrapper">
                <ul id="tree" class="ztree">

                </ul>
            </div>
        </div>
    </div>
    <div class="content">
        <div>
            <!-- 选项卡组件（菜单项nav-tabs）-->
            <div class="nav-tabs">
                <ul class="nav" role="tablist">
                    <li class="active">文章列表</li>
                    <li>文章添加</li>
                </ul>
            </div>
            <!-- 选项卡面板 -->
            <div class="tab-content">
                <!-- 文章列表 -->
                <div class="articleList">
                    <form name="form" action="${website}index" method="get" class="form-inline">
                        <div class="btn-group">
                            <label>栏目：</label>
                            <input type="text" name="name" class="form-control"placeholder="学院简介">
                        </div>

                        <div class="btn-group">
                            <label>标题：</label>
                            <input type="text" name="title" class="form-control">
                        </div>
                        <input type="submit" name="ask" value="查询" class="btn btn-default">
                    <table name="form" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="span2">栏目</th>
                            <th class="span2">标题</th>
                            <th class="span2">操作</th>
                        </tr>
                        </thead>
                        <tbody id="content">
                        <c:forEach var="articleDto" items="${articleDtoList}">
                        <tr>
                                <td name="name">${articleDto.name}</td>
                                <td name="title">${articleDto.title}</td>
                            <td>
                                <a name="update" class="action" href=''>修改</a>
                                <a name="del" class="action del" href="${website}delete/${articleDto.id}">删除</a>
                                <a name="detail" class="action" href="${website}content/${articleDto.id}">详情</a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </form>
                    <div id="Pagination" class="pagination"></div>

                </div>
                <div class="articleAdd hide">
                    <form class="addArticle">
                        <div class="rowWrapper">
                            <label>栏目：</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="rowWrapper">
                            <label>标题：</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="rowWrapper">
                            <label>内容：</label><textarea rows="15" cols="60" value="请写入文章内容..."></textarea>
                        </div>
                        <input type="submit" name="add" class="btn btn-default" value="添加文章">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <hr>
    <p class="pull-right" align="center"></p>
    <p align="center">&copy; 2016 <a href="#">web课开发 张美云（2014012247） 冯艳丽（）</a></p>
</footer>
<script type="text/javascript" src="../resources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../resources/js/index.js"></script>
<script type="text/javascript" src="../resources/js/jquery.ztree.all.js"></script>
<script type="text/javascript" src="../resources/pagination/jquery.pagination.js"></script>
<script type="text/javascript" src="../resources/pagination/jquery.twbsPagination.js"></script>
</body>

