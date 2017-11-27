define(function(require){
	require("lib/bootstrap-3.3.5/js/bootstrap.min.js");
	require("src/public/fontAwesome/css/font-awesome.min.css");
	require("src/public/zDialog/zDialog.css");
	require("src/public/zDialog/zDialog.js");
	require("src/public/zNavigation/zNavigation.css");
	require("src/public/zNavigation/zNavigation.js");
	require("src/public/eTable/eTable.js");
	require("src/public/eTable/eTable.css");
	require("lib/echarts3/echarts.js");
	require("lib/scrollBars/jquery.mCustomScrollbar.min.css");
	require("lib/scrollBars/jquery.mousewheel.min.js");
	require("lib/scrollBars/jquery.mCustomScrollbar.min.js");
	require("lib/datePicker/WdatePicker.js");
	require("js/extend.js");
	require("src/style/table.css");
	require("src/style/Inspection.css");
	require("src/public/drag.js");
	new (require('Base').extend({
		onInit : function(option){
			this.loadpage({
				url:"./container.html",
				callback:function(){
				}
			});
		},
        loadhandle : function(name,handle){
			
		},
        handleEvent:function(event){
        	return 1;
		},
        //此处需要获取当前登录的用户信息，保存为一个全局的信息，供后续业务使用
        getUserInfo : function(){
			
        },
		getMenuData : function(){
			// var self = this;
			// var data = {
			// 	"menu": [
			// 		{
			// 			"name": "企业多维画像",
			// 			"children": [
			// 				{
			// 					"name": "企业个体画像",
			// 					"url": "src/webapps/individualPortrait/page/individualPortrait.html"
			// 				},
			// 				{
			// 					"name": "企业群体画像",
			// 					"url": "src/webapps/groupPortrait/page/groupPortrait.html"
			// 				},
			// 				{
			// 					"name": "地图API测试",
			// 					"url": "src/webapps/common/page/viewMaps.html"
			// 				},
			// 				{
			// 					"name": "企业商谱分析",
			// 					"url": "src/webapps/compBusinessMap/compBusinessMap.html"
			// 				},
			// 				{
			// 					"name": "企业商圈分析",
			// 					"children": [
			// 						{
			// 							"name": "企业影响力分析",
			// 							"url": "src/webapps/compInfluence/compInfluence.html"
			// 						},
			// 						{
			// 							"name": "企业上下游分析",
			// 							"url": "src/webapps/compRelationship/compRelationship.html"
			// 						},
			// 						{
			// 							"name": "关联交易分析",
			// 							"url": "src/webapps/compTrade/compTrade.html"
			// 						},
			// 						{
			// 							"name": "商群分析",
			// 							"url": "src/webapps/compBusinessAnalysis/compBusinessAnalysis.html"
			// 						}
			// 					]
			// 				}
			// 			]
			// 		},
			// 		{
			// 			"name": "信用信息公示与监管应用",
			// 			"children": [
			// 				{
			// 					"name": "企业年报服务与监管",
			// 					"children": [
			// 						{
			// 							"name": "企业年报统计分析",
			// 							"url": "src/webapps/annualReportAnalysis/annualReportAnalysis.html"
			// 						},
			// 						{
			// 							"name": "企业年报查询",
			// 							"url": "src/webapps/annualReport/annualReport.html"
			// 						},
			// 						{
			// 							"name": "企业年报异常名录公示",
			// 							"url": "src/webapps/exceptionList/exceptionList.html"
			// 						},
			// 						{
			// 							"name": "全市企业年报情况",
			// 							"url": "src/webapps/corporateAnnualReports/corporateAnnualReports.html"
			// 						},
			// 						{
			// 							"name": "未年报企业分析",
			// 							"url": "src/webapps/notAnnualEntAnalysis/notAnnualEntAnalysis.html"
			// 						}
			// 					]
			// 				},
			// 				{
			// 					"name": "即时信息公示服务与监管",
			// 					"children": [
			// 						{
			// 							"name": "企业整体信用分布",
			// 							"url": "src/webapps/credit/page/allPublic.html"
			// 						},
			// 						{
			// 							"name": "公示情况分析",
			// 							"url": "src/webapps/credit/page/publicAnalysis.html"
			// 						},
			// 						{
			// 							"name": "应公示未公示情况分析",
			// 							"url": "src/webapps/credit/page/noPublic.html"
			// 						},
			// 						{
			// 							"name": "企业公示行为分析",
			// 							"url": "src/webapps/credit/page/publicInfo.html"
			// 						}
			// 					]
			// 				}
			// 			]
			// 		},
			// 		{
			// 			"name": "系统管理",
			// 			"children": [
			// 				{
			// 					"name": "部门管理",
			// 					"url" : "src/webapps/systemManage/page/departmentManagement.html"
			// 				},
			// 				{
			// 					"name": "角色管理",
			// 					"url" : "src/webapps/systemManage/page/roleManage.html"
			// 				},
			// 				{
			// 					"name": "日志管理",
			// 					"url" : "src/webapps/systemManage/page/logManage.html"
			// 				},
			// 				{
			// 					"name": "用户管理",
			// 					"url" : "src/webapps/systemManage/page/userManage.html"
			// 				}
			// 			]
			// 		}
			// 	]
			// }
			// // S.request({
			// // 	url:"src/demoData/menu.json",
			// // 	success:function(data){
			// 		if(data&&data.menu){
			// 			S.sysMenu = data.menu;
			// 			self.loadpage({
			// 				url:"../../container.html",
			// 				callback:function(){
			// 				}
			// 			});
			// 		}
			// // 	}
			// // })
		}
	}))();
});