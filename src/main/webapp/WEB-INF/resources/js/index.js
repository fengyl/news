$(document).ready(function(){
	// 选项卡
	$(".nav li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		var index0 = $(".nav li").index(this);
		$("div.tab-content > div").eq(index0).show().siblings().hide();
	});
	// -----------------分页----------------------------------------------------------
	var items_per_page = 10;  //每页有多少集记录 
	var page_index = 0;  //页面索引值
		  
	function getDataList(index){  
	    var pageIndex = index; 
	    $.ajax({  
	        type: "get",  
	        url: "../json/list.json",  
	        data: "pageIndex="+pageIndex+'&items_per_page='+items_per_page,  
	        dataType: 'json',  
	        success: function(data){  
	            var total = data.length*1;
	            // alert(total);  
	            success(data);
	            //分页-只初始化一次  
	            if($("#Pagination").html().length == ''){  
	                $("#Pagination").pagination(total, {  
	                    'items_per_page'      : items_per_page, //每页有多少集记录  
	                    'num_display_entries' : 10, //可见的页码数量.  
	                    'num_edge_entries'    : 5,  
	                    'prev_text'           : "prev",  
	                    'next_text'           : "next",  
	                    'callback'            : pageselectCallback  
	                });  
	            }  
	        }  
	    });  
	}
	function success(data){
		$("#content").empty();
		var html="";
		$.each(data,function(rowIndex,row){
			html += "<tr><td name='lanmu2'>"+row.lanmu+"</td>";
            html += "<td name='title2'>"+row.title+"</td>";
            html += "<td><a name='update' class='action' href=''>修改</a>";
            html += "<button name='del' class='action del'>删除</button>";
            html += "<a name='detail' class='action' href=''>详情</a>";	        
            html += "</td>";
            html += "</tr>";
		});
		$("#content").html(html);
		$(".del").click(function(){
			var msg=confirm("是否删除");
			if(msg==true){
				$(this).parents("tr:first").css("display","none");
			}else{
				return false;
			}
    	});  
	}  
	function pageselectCallback(page_index, jq){  
	    getDataList(page_index);  
	}  
	$(document).ready(function(){  
	    getDataList(page_index);  
	});

 	// var $pagination = $('#Pagination');
 	// var currentPage;
  //   var defaultOpts = {
  //       totalPages: 19,
  //   };
  //   $pagination.twbsPagination(defaultOpts);
  //   $.ajax({
  //       type: "get",  
  //       url: "../json/list.json",
  //       data:"pageIndex="+currentPage,
  //       dataType:"json",
  //       success: function (data) {
  //           var totalPages = data.length;
  //           alert(totalPages);
  //           success(data);
  //           var currentPage = $pagination.twbsPagination('getCurrentPage');
  //           alert(currentPage);
  //           $pagination.twbsPagination('destroy');
  //           $pagination.twbsPagination($.extend({}, defaultOpts, {
  //               startPage: currentPage,
  //               totalPages: totalPages
  //           }));
  //       }
  //   });
	// -------------------------------------侧边栏ztree---------------------------------------------
	var setting = {
    		data: {
				simpleData: {
					enable: true
				}
			},
			async: {
				enable: true,
				url:"../json/sidebar.json",
				type:"get",
				dataType:"json",
				autoParam:["id", "name=n", "level=lv"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
				dataFilter: filter
			}
			
		};
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		$(document).ready(function(){
			$.fn.zTree.init($("#tree"), setting);
		})
	
});

// $(document).ready(function() {
//         $.ajax({
//             type: "get",
//             data: "page='' &S=" + S + "&domain=" + domain + "&pagesize="+dopagesize,
//             url: "../json/list.json",
//             dataType: "jsonp",
//             jsonp: "callback",
//             jsonpCallback: "jsonpNewsList",
//             success: function(data) {
//                 if (data.result == 200) {
//                     $('#aresult').empty();
//                     if (!$.isEmptyObject(data.data.list)) {

//                         $.each(data.data.list, function(a, list) { //装载对应分页的内容 
//                             $("#aresult").append('<li><span><a href=" detail-' + list.id + '.html"><div>' + list.title + '</div></a></span></li>');
//                         });
//                     } else {
//                         $("#aresult").append('<li><span class="s_check">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无数据</span></li>');
//                     }
//                 }
//                 /**
//                  * 初始化完成 显示分页   
//                  */
//                 initPagination(data.data.pages.itemCount, dopagesize);   

//             },
//             error: function() {
//                 alert('参数错误');
//             }
//         });
//     });

// function initPagination(count, pagesize) {

//         // 创建分页
//         $("#Pagination").pagination(count, {//共24条
//             num_edge_entries: 1, //边缘页数 隐藏之前或之后个数
//             num_display_entries: 4, //主体页数显示8个多出隐藏
//             callback: pageselectCallback,
//             items_per_page: pagesize, //每页显示的3条目数   $this->pagesize
//             prev_text: "前一页",
//             next_text: "后一页"
//         });
//     }

//   function pageselectCallback(page_index, jq) {   //page_index 前一个表示您当前点击的那个分页的页数索引值
//         /**
//          * 扩展: 查询客户的关键字搜索
//          */
//         var search_type = $("#search_type").val();
//         var orderby = $("#orderby").val();
//         var keywords = '';
//         var search = {};
//         var online_ajax = $("#online_ajax").val();

//         if (online_ajax != 1) {
//             $.ajax({
//                 type: "get",
//                 data: "page=" + (page_index + 1) + " &S=" + S + "&domain=" + domain + "&pagesize=3",
//                 url: "../json/list.json",
//                 dataType: "jsonp",
//                 jsonp: "callback",
//                 jsonpCallback: "jsonpNewsList",
//                 success: function(data) {
//                     if (data.result == 200) {
//                         $('#aresult').empty();
//                         if (!$.isEmptyObject(data.data.list)) {

//                             $.each(data.data.list, function(a, list) { //装载对应分页的内容 
//                                 $("#aresult").append('<li><span><a href=" detail-' + list.id + '.html"><div>' + list.title + '</div></a></span></li>');
//                             });
//                         } else {
//                             $("#aresult").append('<li><span class="s_check">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无数据</span></li>');
//                         }
//                     }
//                 },
//                 error: function() {
//                     alert('参数错误');
//                 }
//             });
//         } else { 
//             $("#online_ajax").val('2');
//         }

//         return false;
//     }