$(document).ready(function(){
	 // 侧边栏的收放
    $(".nav-header").click(function(){
    	$(this).next().toggle();
    });
    // 删除
    $(".del").click(function(){
    	$(this).parents("tr:first").css("display","none");
    });

	$.ajax({
		type:"GET",
		url:"../json/list.json",
		dateType:"json",
		success:function(data){
			$("#content").empty();
			var html="";
			$.each(data,function(rowIndex,row){
				html += "<tr><td>"+row['lanmu']+"</td>";
	            html += "<td>"+row['title']+"</td>";
	            html += "<td><a class='action' href=''>修改</a>";
	            html += "<span class='action del'>删除</span>";
	            html += "<a class='action' href=''>详情</a>";	        
	            html += "</td>";
	            html += "</tr>";
			});
			$("#content").html(html);
			$(".del").click(function(){
		    	$(this).parents("tr:first").css("display","none");
		    });
		},
		error:function(){
			alert(1);
		}
	})
})