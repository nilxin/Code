define(function(){
	var menu = {
	    "slideBar":[
	        {
	            "name": "稽查业务管理",
	            "cName" : 'leave1',
	            "url" : "",
	            "show" : "true",
	            "ico" : "cogs",
	            "children": [
	                {
	                    "name": "稽查复核",
	                    "cName" : "leave2",
	                    "url" : "2.html",
	                    "show" : "true",
	                    "ico" : "calendar-o",
	                },
	                {
	                    "name": "黑灰名单",
	                    "cName" : "leave2",
	                    "url" : "3.html",
	                    "show" : "true",
	                    "ico" : "file-text-o",
	                }
	            ]
	        },
	        {
	            "name": "稽查数据分析",
	            "cName" : 'leave1',
	            "url" : "",
	            "show" : "true",
	            "ico" : "bar-chart",
	            "children": [
	                {
	                    "name": "打逃金额",
	                    "cName" : "leave2",
	                    "url" : "4.html",
	                    "show" : "true",
	                    "ico" : "database",
	                },
	                {
	                    "name": "违规车辆",
	                    "cName" : "leave2",
	                    "url" : "5.html",
	                    "show" : "true",
	                    "ico" : "bus",
	                },
	                {
	                    "name": "稽查时段",
	                    "cName" : "leave2",
	                    "url" : "6.html",
	                    "show" : "true",
	                    "ico" : "clock-o",
	                },
	                {
	                    "name": "人员绩效",
	                    "cName" : "leave2",
	                    "url" : "personalAbility.html",
	                    "show" : "true",
	                    "ico" : "calendar-o",
	                },
	            ]
	        },
	        {
	            "name": "鲜活绿通分析",
	            "cName" : 'leave1',
	            "url" : "",
	            "show" : "true",
	            "ico" : "car",
	            "children": [
	                {
	                    "name": "鲜活品类",
	                    "cName" : "leave2",
	                    "url" : "8.html",
	                    "show" : "true",
	                    "ico" : "line-chart",
	                },
	                {
	                    "name": "站点通行",
	                    "cName" : "leave2",
	                    "url" : "9.html",
	                    "show" : "true",
	                    "ico" : "bank (alias)"
	                }
	            ]
	        },
	        //加的模块
	        {
	        	"name": "稽查报表",
	        	"cName":"leave1",
	        	"url": "",
	        	"show": "true",
	        	"ico": "calendar-o",
	        	"children": [
	        		{
	        			"name":"站点稽查报表",
	        			"cName": "leave2",
	        			"url":"stationInspect.html",
	        			"show":"true",
	        			"ico": "bank (alias)"

	        		},{
	        			"name":"路公司稽查报表",
	        			"cName": "leave2",
	        			"url":"companyInspect.html",
	        			"show":"true",
	        			"ico": "bank (alias)"
	        		},{
	        			"name":"集团稽查报表",
	        			"cName": "leave2",
	        			"url":"groupInspect.html",
	        			"show":"true",
	        			"ico": "bank (alias)"
	        		}

	        	]
	        },{
	        	"name": "驾驶人员能力",
	        	"cName":"leave1",
	        	"url": "",
	        	"show": "true",
	        	"ico": "database",
	        	"children": [
	        		{
	        			"name":"驾驶人员评价",
	        			"cName": "leave2",
	        			"url":"driverEvaluate/driverEvaluate.html",
	        			"show":"true",
	        			"ico": "car"
	        		}
	        	]
	        }
	    ]
	};
	return menu;
})