<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page import="com.cdsf.webmvc.RuntimeContext"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Get Icon && Href</title>
    <script src="/static/public/plugIn/jquery-1.6.4.min.js"></script>
    <style type="text/css">
    	html,body,form{  
	        height:100%; 
	        margin: 0; 
	    } 

    	a{
    		color:#8D8D8D;
    		cursor: pointer;
    		text-decoration: none;
    	}
    	a:active{
    		color:#8D8D8D;
    	}

    	.pageStyle {
    		width: 100%;
    		height: auto;
    		position: absolute;
    		top: 0;
    		bottom: 0;
    		left: 0; 
    		right: 0;
    		background-color: #58c0ee;
    		background: url(/static/pages/images/bg_01.jpg) repeat-x center top #58c0ee;
    		overflow-x: hidden;
    	}

    	.main{
    		width: 994px;
    		height: auto;
    	    margin: 20px auto 0 auto;
    	    padding-top: 1px;
    	    background-color: white;
    	}

    	.main-top{
    		margin:6px;
    		width: 982px;
    		height: 183px;
    		background: url(/static/pages/images/title.png) no-repeat center center;
    	}

    	.main-middle{
		    text-align: center;
		    margin-top: 30px;
		    padding-top: 20px;
		    background: url(/static/pages/images/bg_02.png) repeat center center;
		    height: auto !important;
		    height: auto;
		    min-height: 418px;
		    overflow: auto;
    	}

    	.main-content{
    		text-align: left;
    		margin:0 110px;
    		display: block;
    	}

    	.main-codeBox{
    		width:768px;
    		height:227px;
    		background: url(/static/pages/images/table.png) no-repeat center center;
    	}

    	.main-codeDes{
    		text-align: left;
    		font-weight: 900;
    		font-size: 12px;
    		margin-top: 40px;
    		margin-bottom: 80px;
    	}

    	.main-codeBox-title{
    		font-size: 13px;
		    font-weight: 900;
		    color: black;
		    padding: 8px;
		    text-indent: 10px;
    	}


    	/*表格模式样式*/
    	.main-table{
    		display: none;
    		text-align: left;
    		margin:0 175px;
            width: 768px;
    	}

    	.main-lincenseTitle{
    		font-weight: 900;
    		width: 642px;
    		height: 36px;
    		line-height: 36px;
    		font-size: 13px;
    		color: #000000;
    		text-align: center;
    		background: url(/static/pages/images/table-title.png) no-repeat center center;
    	}

    	.info-table{
    		margin-top: 10px;
    		width: 642px;
    		border-collapse:collapse;
    		font-family: "微软雅黑";
    	}

        .lincenseTable{
            height: 242px;
            background: url(/static/pages/images/table-big.png) no-repeat center center;
        }

        .siteTable{
            height: 62px;
            background: url(/static/pages/images/table-small.png) no-repeat center center;
        }

        .unitTable{
        	height: 62px;
        	background: url(/static/pages/images/table-small.png) no-repeat center center;
        	margin-bottom: 50px;
        }

        .table-title{
            font-size:14px;
            padding-left: 20px;
        }

        .table-bolidTitle{
            color: black;
            font-size: 13px;
            text-align: center;
            font-weight: 900;
        }

        .table-des{
            padding-left: 10px;
            font-size: 12px;
        }

    	.checkCodeForm{
    		margin-left: 30px;
		    font-size: 13px;
		    font-weight: 500;
		    color: black;
		    font-family: "微软雅黑";
    	}

    	.inputArea{
    		width: 120px;
    		border: 1px solid #c5c5c5;
		    border-radius: 6px;
		    display: inline;
		    float: left;
		    margin-left: 10px
    	}

    	/*.clearBtn{
    		float: right;
    		width: 12px;
		    height: 12px;
		    margin: 8px;
    		background: url(error.png) no-repeat center center;
    		cursor: pointer;
    	}*/

    	.imgRefresh{
    		font-size: 11px;
		    cursor: pointer;
		    float: left;
		    margin: 6px 0;
    	}

    	.inputDes{
    		float: left;
    		margin: 6px 0px;
    	}

    	.codeInput{
		    height: 26px;
		    width: 80px;
		    margin-left: 5px;
		    *margin-left: -28px;
		    border:none;
		    float: left;
		    line-height: 26px;
		    text-indent: 15px;
		    outline: none;
		    letter-spacing: 5px;
    	}

    	.codeImage{
    	    cursor: pointer;
    		float: left;
    		margin: 2px 6px;
    	}

    	.doCheck{
    		background-color: #32B16C;
    		height: 26px;
    		line-height: 26px;
    		width: 120px;
    		border-radius: 6px;
    		color: white;
    		font-weight: 900;
    		border:none;
    		outline: none;
    		cursor: pointer;
    		margin: 10px 140px
    	}

    	.errorMsg{
    		color: red;
    		font-weight: 900;
    		margin-left: 132px;
    		margin-top: 10px;
    		visibility: hidden;
    		width: 500px;
    		float: left;
    	}

    	/*页脚*/
    	.main-bottom{
    		border-top: 1px solid #D5D5D5;
    		text-align: center;
    		font-size: 12px;
    		color:#8D8D8D;
    		font-family: "微软雅黑";
    		height: 119px;
    		position: relative;
    	}

    	.footInfo{
    		width: 100%;
    		float: left;
    		text-align: center;
    		line-height: 14px;
    	}

    	.footLogo{
    		width: 100px;
    		position: absolute;
    		right: 20px;
    		top: 20px;
    	}

    </style>
</head>
<body>
	<div class="pageStyle">
		<div class="main">
			<div class="main-top"></div>
			<div class="main-middle">
				<div class="main-content">
					<div class="main-codeBox">
						<div class="main-codeBox-title">
							成都市工商行政管理局电子营业执照信息公示
						</div>
						<div id="checkCodeForm" class="checkCodeForm">
							<p>成都市工商行政管理局电子营业执照信息公示</p>
							<p>根据国家工商总局《网络交易管理办法》要求对电子营业执照信息公示如下：</p>
							<div class="holeLine">
								<span class="inputDes">请先输入查阅验证码：</span>
								<div class="inputArea">
									<input class="codeInput" type="text" name="verifyCode" id="codeInput" onfocus="changeErrorMsg('')" maxlength="4" />		
									<!-- <div class="clearBtn" onclick="clearCode()" ></div>	 -->								
								</div>
								<img width="86px" id="verifyCodeImg" height="26px" alt="验证码" title="验证码" class="codeImage" />
								<span id="imgRefresh" class="imgRefresh">点我刷新</span>
							</div>
							<div id="errorMsg" class="errorMsg">&nbsp;请输入正确的验证码</div>
							<button value="确 定" onclick="verificationCode()" class="doCheck">确 定</button>
						</div>
					</div>
					<div class="main-codeDes">
						<p>亮标亮照系统须知：</p>
						<p>本系统以进一步加强网络交易监管，提高网络交易诚信度和透明度为目的，为网络商品交易监管提供真实可靠的依据。</p>
						<p>为消费者识别和查证网络交易经营主体真实身份提供方便，有效维护消费者合法权益。</p>
					</div>
				</div>
				<div class="main-table">
					<div class="main-lincenseTitle">
                        网络经营者基本信息
                    </div>
                    <div class="main-lincenseTable">
                        <table class="lincenseTable info-table" align="left">
                            <tr>
                                <td colspan="2">
                                    <div class="table-title">营业执照照面信息</div> 
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">企业主体名称</div></td>
                                <td>
                                    <div class="table-des compName">
                                        双流恒达房地产代理有限公司
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">注册号</div></td>
                                <td>
                                    <div class="table-des compRegCode">
                                        510664787821
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">法定代表人</div></td>
                                <td>
                                    <div class="table-des represeMan">
                                        张三
                                    </div>
                                </td>
                            </tr>
                            <tr>
                               <td width="120px">
                                    <div class="table-bolidTitle">住所</div></td>
                                <td>
                                    <div class="table-des compAddress">
                                        成都市双流县华阳镇伏龙村
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">注册资本</div></td>
                                <td>
                                    <div class="table-des capital">
                                        6 万元
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">成立日期</div></td>
                                <td>
                                    <div class="table-des compBirth">
                                        2007-08-18
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">经营范围</div></td>
                                <td>
                                    <div class="table-des compRange">
                                        房地产经纪；以及其他无需许可和审批的合法项目
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="siteTable info-table" align="left">
                            <tr>
                                <td colspan="2">
                                    <div class="table-title">主要涉网信息</div> 
                                </td>
                            </tr>
                            <!-- <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">网站名称</div></td>
                                <td>
                                    <div class="table-des siteName">
                                        肯德基宅急送
                                    </div>
                                </td>
                            </tr> -->
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">域名地址</div></td>
                                <td>
                                    <div class="table-des siteAddress">
                                        www.KFC.com
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table class="unitTable info-table" align="left">
                            <tr>
                                <td colspan="2">
                                    <div class="table-title">电子标识发放单位</div> 
                                </td>
                            </tr>
                            <tr>
                                <td width="120px">
                                    <div class="table-bolidTitle">电子标识编号</div></td>
                                <td>
                                    <div class="table-des elecCode">
                                        51048871167
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
				</div>
			</div>
			<div class="main-bottom">
				<div class="footInfo">
					<p></p>
					<a class="alink" target="_blank" href="http://www.cdgs.gov.cn/list/20/27223142.html">关于我们</a> ┆ <a href="http://www.cdgs.gov.cn/gsmh/advert.jsp" target="_blank">广告法</a> ┆ <a class="alink" target="_blank" href="http://www.cdgs.gov.cn/list/20/27223002.html">联系方式</a> 
					<br>
					<p></p>
					主办单位：成都市工商行政管理局 备案号：蜀ICP备05031015号<p></p>注册咨询电话：028-86917516  技术支持电话：85394410<p></p>
	通信地址：成都市致民东路6号  邮编：610061
				</div>
				<div class="footLogo">
					<span id="_ideConac"><a href="http://bszs.conac.cn/sitename?method=show&amp;id=0AD837AD43795E5EE053012819AC666D" target="_blank"><img id="imgConac" vspace="0" hspace="0" border="0" src="http://dcs.conac.cn/image/red.png" data-bd-imgshare-binded="1"></a></span>
				</div>
			</div>
			<script type="text/javascript">
				(function() {
				    var currentHref = window.location.hostname,
				        imgSrc = "logo.png",
				        creatHtml = new Array();
				    gotoCheck = function() {
				        window.open('http://www.sefonsoft.com?id=aaa&frompage=' + currentHref);
				    };
				    document.write(unescape("%3Cspan id='_licenseCheck' style='z-index:9999;' %3E%3C/span%3E"));
				    var span_msg = document.getElementById("_licenseCheck");
				    creatHtml.push('<img style="cursor: pointer;" id="imgLicense" vspace="0" hspace="0" border="0" alt="成都工商" onclick="gotoCheck()" title="成都工商" ');
				    creatHtml.push(' src="' + imgSrc + '" >');
				    span_msg.innerHTML = creatHtml.join("");
				})();
			</script>
		</div>
	</div>
</body>
<script type="text/javascript">
	window.onload = function(){
		//初始化时，获取验证码图片动作由上面script 完成

		function getPageSize(){            //检测浏览器的渲染模式         
			var body = (document.compatMode&&document.compatMode.toLowerCase() == "css1compat")?document.documentElement:document.body;
	        var bodyOffsetWidth = 0;         
	        var bodyOffsetHeight = 0;         
	        var bodyScrollWidth = 0;         
	        var bodyScrollHeight = 0;         
	        var pageDimensions = [0,0];                 
	        pageDimensions[0]=body.clientHeight;         
	        pageDimensions[1]=body.clientWidth;                  
	        bodyOffsetWidth=body.offsetWidth;         
	        bodyOffsetHeight=body.offsetHeight;         
	        bodyScrollWidth=body.scrollWidth;         
	        bodyScrollHeight=body.scrollHeight;
	        if(bodyOffsetHeight > pageDimensions[0]){             
	        	pageDimensions[0]=bodyOffsetHeight;         
	        }                     
	        if(bodyOffsetWidth > pageDimensions[1]){             
	        	pageDimensions[1]=bodyOffsetWidth;         
	        }                     
	        if(bodyScrollHeight > pageDimensions[0]){             
	        	pageDimensions[0]=bodyScrollHeight;          
	        }                      
	        if(bodyScrollWidth > pageDimensions[1]){             
	        	pageDimensions[1]=bodyScrollWidth;         
	        }  
	        return pageDimensions;  
    	}
    	var bodyHeight = getPageSize()[0];
    	var middleHeight = bodyHeight-380;
    	$(".main-middle").css("height",middleHeight);

    	//获取顶部url的企业id
    	var compCodeArray = window.location.search.substr(1).match(new RegExp("(^|&)id=([^&]*)(&|$)", "i")),compCode="";
    	if (compCodeArray != null) {
    		compCode = unescape(compCodeArray[2]);
    		console.log("当前页面接收到的公司ID ： "+compCode);
    	}else{
    		//这里需要做容错，来验证如果传递过来的参数非法或者无效时，页面出现错误提示

    	}

		// clearCode = function(){
		// 	var codeInput = document.getElementById("codeInput");
		// 	codeInput.value = "";
		// 	document.getElementById("errorMsg").style.visibility = "hidden";
		// };

		//基础JS验证 验证码是否正确
		verificationCode =function(){
			var codeInputVal = document.getElementById("codeInput").value;
			if (codeInputVal == "") {
				changeErrorMsg("请输入正确的验证码！");
				return false;
			}else if (codeInputVal.length != 4) {
				changeErrorMsg("验证码长度有误，请重新输入");
				return false;
			}
			submitData(codeInputVal);
		};

		//执行切换
		changeCode = function(){
			console.log("切换验证码图片，清空当前input的内容");
			jQuery("#codeInput").val("");
			var url = "createVerifyCode.html?random=" + Math.random();
	        jQuery("#verifyCodeImg").attr('src', url);
		};

		//显隐 错误提示
		changeErrorMsg = function(title){
			// console.log(title);
			var errorMsgDom = document.getElementById("errorMsg");
			if (title == "") {
				errorMsgDom.innerHTML = "&nbsp;";
				errorMsgDom.style.visibility = "hidden";
			}else{
				errorMsgDom.innerHTML = title;
				errorMsgDom.style.visibility = "visible";
			}
		};

		//执行提交
		submitData = function(inputCode){
			var self= this;
			var postData = {
				"verifyCode" : inputCode,
				"id":compCode
			};
			$.ajax({
				type:'POST',
				url:'1111111&random=" +Math.random();',   
				data:postData,
				dataType:"json",
				cache : false,
				success: function (result) {
	                    console.log("成功");
	                    if (result.status == 1) {
	                    	//请求成功、可以展示table
	                    	$(".main-table").show();
							$(".main-content").remove();
		                    $(".main-table").html(result.content);
	                    }else{
	                    	//请求失败，展示 错误原因并刷新验证码
	                    	console.log("服务端验证失败 ,切换验证码内容，提示错误： " + result.msg);
			                self.changeErrorMsg(result.msg || "信息错误，请联系管理员！");
			                self.changeCode();
	                    }
	                },
	            error: function(data) {
	                console.log("ajax请求失败 ,切换验证码内容，提示错误： ");
	                self.changeErrorMsg("信息错误，请联系管理员！");
	                self.changeCode();
	                }                 
			});
		};

	    $('#verifyCodeImg').click(function() {
	        var url = "createVerifyCode.html?random=" + Math.random();
	        console.log(url);

	        console.log($(this).attr("src"));
	        $(this).attr('src', url);
	        $('#codeInput').val('').focus();
	    });

	    $('#imgRefresh').click(function() {
	        var url = "createVerifyCode.html?random=" + Math.random();
	        console.log(url);
	        $(this).prev().attr('src', url);
	        $('#codeInput').val('').focus();
	    });

	    $('#verifyCodeImg').attr('src', "createVerifyCode.html?random=" + Math.random());

		//初始化用户体验  兼容ie绘制慢的写法
		setTimeout("jQuery('#codeInput').val('').focus()",50);
	}
</script>
</html>