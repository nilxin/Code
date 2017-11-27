/*******************************************************************************
* zTable.css -  eTable Style
* Copyright (C) 2016
*
* @Author scott
* @Email scottcoder@163.com
* @UpdateTime (2016-11-25)
*******************************************************************************/

(function($){
    'use strict';
	var methods = {
		init : function(options){
			return this.each(function(){
				var $this = $(this);
				
				var settings = $.extend({
					id:"",
					type:"table",
					columns:[],
					dataApi:"",
					sortUpdateApi:"",
					query:{},
					requestParamName:{
						dataSize:"page.rows",
						currentPage:"page.index"
					},
					postData:{},
					borderTop:false,
					isNeedmergeTd:false,
					newPager:false,
					borderBottom:false,
					loadingShow:false,
					loading:false,
					pagerShow:true,
					cache:true,
					async:true,
					editBlurAutoSelect:true,
					autoWidth:true,
					autoHeight:true,
					dataSize:5,
					pageShowLimit:5,
					pageEndLimit:2,
					totalData:0,
					totalPage:0,
					currentPage:1,
					data:[],
					tableSelected:[],
					tableData:[],
					idKey:"id",
					rowDisabledBy:function(){return false;},
					sortKey:"sort",
					noData:"暂无数据",
					topPager:false,
					topPagerDom:'',
					tbodyClass:'',
					init:function(){},
					rowBeforeBuild:function(){},
					beforeRequest:function(object){},
					afterRequest : function(data){
						return data;
					},
					complete:function(){},
					onListComplete:function(){},
					editStatusChange:function(){},
					error:function(){},
				},options);
			})
		}

	};
		
	
	
	$.fn.zTable = function(method){
		debugger;
		if (methods[method]) {
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
		} else {
			$.error('方法 ' + method + ' 在$.zTable中不存在 ');
		}
	}
})($);