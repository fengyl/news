/*<%@ include page contentType="text/html;charset=UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>*/
$(document).ready(function(){
	// 选项卡
	$(".nav li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
		var index0 = $(".nav li").index(this);
		$("div.tab-content > div").eq(index0).show().siblings().hide();
	});

	// -------------------------------------侧边栏ztree---------------------------------------------
	var setting = {
		data: {
			simpleData: {
				enable: true
			}
		},
		async: {
			enable: true,
			url:"../resources/json/sidebar.json",
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
