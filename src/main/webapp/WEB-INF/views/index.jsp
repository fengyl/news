<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>列表</title>
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../css/list.css" rel="stylesheet">
</head>
<body>
<div class="">
    <!-- 头部 -->
    <div class="header">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <h3>信息与软件工程学院</h3>
                </div>
            </div>
        </div>
    </div>
    <!-- 中间部位 -->
    <div class="row-fluid">
        <!-- 侧边栏 -->
        <div class="span3">
            <div class="sidebar-nav">
                <!-- 学院概况 -->
                <div class="nav-header">
							<span class="glyphicon glyphicon-file">学院概况</span>
                </div>
                <ul class="nav nav-list collapse in">
                    <li><a href="">学院简介</a></li>
                    <li><a href="">院长致辞</a></li>
                    <li><a href="">学院领导</a></li>
                </ul>

                <div style="height:10px;"></div>

                <ul id="link-menu" class="nav nav-list collapse in">
                    <li><a href="">百度一下</a></li>
                    <li><a href="">全文检索</a></li>
                    <li><a href="">公共留言</a></li>
                </ul>

            </div>
        </div>
        <!-- 中间列表 -->
        <div class="span9">
            <div class="block">
                <!-- 选项卡组件（菜单项nav-tabs）-->
                <ul id="articleTab" class="nav nav-tabs" role="tablist">
                    <li class="active">
                        <a href="#articleList" role="tab" data-toggle="tab">文章列表</a>
                    </li>
                    <li>
                        <a href="#articleAdd" role="tab" data-toggle="tab">文章添加</a>
                    </li>
                </ul>
                <!-- 选项卡面板 -->
                <div id="articleTabContent" class="tab-content">
                    <!-- 文章列表 -->
                    <div class="tab-pane active" id="articleList">
                        <form action="" method="get" class="form-inline">
                            <div class="btn-group">
                                <label>栏目：</label>
                                <input type="text" class="form-control"placeholder="学校简介">
                            </div>
                            <button class="btn btn-default">
                                <span class="glyphicon glyphicon-search search"></span>
                            </button>
                            <div class="btn-group">
                                <label>标题：</label>
                                <input type="text" class="form-control">
                            </div>
                            <button type="submit"  onclick="callBackPagination();"  class="btn btn-default">查询</button>
                        </form>
                        <div id="mainContent"></div>
                        <div id="callBackPager"></div>
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>栏目</th>
                                <th>标题</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="content">
                            <c:forEach var="list" items="${articleDtoList}">
                                <tr>
                                    <td><span>${list.title}</span></td>
                                    <td><span>${list.name}</span></td>
                                    <td>
                                        <a class="action" href="">修改</a>
                                        <span class="action del" >删除</span>
                                        <a class="action" href="${website}to/content">详情</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- <tr>
                                  <td></td>
                                  <td></td>
                                  <td>
                                      <a class="action" href="">修改</a>
                                      <span class="action del" >删除</span>
                                      <a class="action" href="">详情</a>
                                  </td>
                           </tr> -->

                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane" id="articleAdd">
                        <button type="submit" class="btn btn-default">添加文章</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 脚部 -->
    <footer>
        <hr>
        <p class="pull-right"></p>
        <p>&copy; 2016 <a href="#">web课开发 张美云（2014012247） 冯艳丽（） 王亚楠（）</a></p>
    </footer>
</div>


<!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
<script src="../js/jquery-3.1.1.js"></script>
<script src="../js/list.js"></script>
<!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../js/extendPagination.js"></script>
<script type="text/javascript">
    // 分页
    // function callBackPagination() {
    //     var totalCount = Number($('#totalCount').val()) || 51, //数据总数
    //         showCount = $('#showCount').val(),            //
    //         limit = Number($('#limit').val()) || 10;         //每页显示数目
    //     createTable(1, limit, totalCount);
    //     $('#callBackPager').extendPagination({
    //         totalCount: totalCount,
    //         showCount: showCount,
    //         limit: limit,
    //         callback: function (curr, limit, totalCount) {	                createTable(curr, limit, totalCount);
    //         }
    //     });
    // }
    // function createTable(currPage, limit, total) {
    //     var html = [], showNum = limit;
    //     if (total - (currPage * limit) < 0) showNum = total - ((currPage - 1) * limit);
    //     html.push(' <table class="table table-hover table-bordered piece" style="margin-left: 0;">');
    //     html.push(' <caption>栏目表格(' + total + ')</caption>');
    //     html.push(' <thead><tr><th>栏目</th><th>标题</th><th>操作</th></tr></thead><tbody>');
    //     for (var i = 1; i <= showNum; i++) {
    //         html.push('<tr><td></td>');
    //         html.push('<td></td>');
    //         html.push('<td><a class="action" href="">修改</a>');
    //         html.push('<span class="action del">删除</span>');
    //         html.push('<a class="action" href="">详情</a>')
    //         html.push('</td>');
    //         html.push('</tr>');
    //     }
    //     html.push('</tbody></table>');
    //     var mainObj = $('#mainContent');
    //     mainObj.empty();
    //     mainObj.html(html.join(''));
    // }
</script>
</body>
</html>
