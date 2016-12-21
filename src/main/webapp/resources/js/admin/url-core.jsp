    /*-----------------------------------------------------------------------------
* @Description: 配置url地址 (url-core.jsp)
* @Version: V2.0.0
* @author: cuiy(361151713@qq.com)
* @date 2015.11.02
* ==NOTES:=============================================
* v1.0.0(2015.11.02):
* 经项目实践,发现目前项目架构不适合调试使用,需要不断修改IO层,这样会对前\后端的开发带来不便,故决定使用此插件来解决问题
* ---------------------------------------------------------------------------*/
(function () {
    var
    site = {
        website: '${website}', //站点地址
        staticWebsite: '${staticWebsite}', // 前端服务器地址
    };


    _pw_apiData = {
        // 后台登录
        Login: [
            ['getSignIn', site.website + 'admin/ajax/login', 'post', '后台单独登录']
        ],
        List: [
        ['getList', site.website + 'load/category/list', 'get', '获取列表']
        ],
        // 公共模块
        Module: [
            ['mulSelectSearch', site.staticWebsite + 'mock/admin/search-item-list.json', 'get', '多选']
        ]

    };
})();