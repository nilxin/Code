seajs.config({
	"base": "./",
	"alias": { //简化模块名称 
		Base : "core/Base"
	},
	'paths': { //映射模块路径
		"js" : "src/js",
		"css" : "i18n/css",
		"img" : "i18n/img",
		"string" : "i18n/string",
		"public" : "src/public",
		"common" : "src/webapps/common", //公用页面
		"container" : "src/webapps/container",//主容器
		"driverEvaluate": "src/webapps/driverEvaluate"//驾驶人员评价
	},
	'charset': 'utf-8',
	'preload': [ // 在普通模块加载前加块此模块
		'core/public',
		'i18n/string/template.js',
		'lib/i18n.js',
		'js/Modes.js'
		//'lib/echarts3/echarts.js'
	]
});
var S = {
	debug : false,
	logstate : true,
	KEY4F : true // 是否启用F系列快捷键
} ; //全局容器
seajs.use('js/index');