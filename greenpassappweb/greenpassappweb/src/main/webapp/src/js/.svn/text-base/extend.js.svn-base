(function(window,undefined){
	
	//jquery param
	var r20 = /%20/g,
		rbracket = /\[\]$/;

	function buildParams(prefix, obj, add){
		if (jQuery.isArray(obj)){
			jQuery.each(obj, function (i, v){
				if(rbracket.test(prefix)){
					add(prefix, v);
				}else{
					buildParams(prefix + "[" + i + "]", v, add);
				}
			});
		}else if(jQuery.type(obj) === "object") {
			for(var name in obj) {
				buildParams(prefix + "." + name, obj[ name ], add);
			}
		}else{
			add(prefix, obj);
		}
	}
	
	$.extend({
		param:function (a) {
			var s = [], add = function (key, value) {
				value = jQuery.isFunction(value) ? value() : (value == null ? "" : value);
				s[s.length] = encodeURIComponent(key) + "=" + encodeURIComponent(value);
			};
			if (jQuery.isArray(a) || ( a.jquery && !jQuery.isPlainObject(a) )) {
				jQuery.each(a, function (i, v) {
					buildParams('[' + i + ']', v, add);
				});
			} else {
				for (var prefix in a) {
					buildParams(prefix, a[ prefix ], add);
				}
			}
			return s.join("&").replace(r20, "+");
		}
	});

	$.fn.cpie = function(option){

			var $this = $(this),
				cwidth = $this.width(),
				cheight = $this.height();

			option = option || {};
			if(!option.percent){
				option.percent = $this.attr('percent');
			}

			option = $.extend({
				laterColor : 'rgb(227, 227, 227)', //后置颜色
				frontColor : 'rgb(101, 185, 107)', //前置颜色
				percent    : 1, //百分比，小数
				rotate     : -90 //旋转角度， canvas默认从三点钟方向开始画，如果希望从其他位置开始画需要调整旋转角度。
			}, option);

			var size = cwidth <= cheight ? cwidth : cheight,
				radius = size / 2;
			var $canvas = $('<canvas width="' + size + '" height="' + size + '"></canvas>'),
				ctx     = $canvas[0].getContext('2d');

			$this.html($canvas);
			ctx.save();
			ctx.beginPath();
			ctx.fillStyle = option.laterColor;
			ctx.arc(radius, radius, radius, 0, 2 * Math.PI, false);
			ctx.closePath();
			ctx.fill();

			ctx.restore();

			ctx.beginPath();
			ctx.moveTo(radius, radius);
			ctx.fillStyle = option.frontColor;
			ctx.arc(radius, radius, radius, option.rotate * Math.PI / 180, (option.rotate / 360 - option.percent ) * 2 * Math.PI, true);
			ctx.closePath();
			ctx.fill();

			ctx   = null;
			$this = null;
	};
	
	//加载滚动条
    $.fn.loadScroll = function(option){
        if(!this.hasClass(".mCustomScrollbar")){
            this.mCustomScrollbar({  
                theme:"minimal-dark", //主题颜色  
                scrollButtons:{  
                    enable:false //是否使用上下滚动按钮  
                },  
                autoHideScrollbar: true, //是否自动隐藏滚动条  
                scrollInertia :0,//滚动延迟  
                horizontalScroll : false,//水平滚动条  
                callbacks:{  
                    
                }  
            });
        }else{
            if(option&&S.isString(option)){
                this.mCustomScrollbar(option);
            };
        }
    }

	//初始化日期控件
    $.fn.buildDatePicker = function () {
        var container = this;     
        var guid = new Date().getTime();
        $("[calendar]", container).each(function () {
            var calendar = $(this).attr("calendar");
            var minDate = $(this).attr("minDate");
            var maxDate = $(this).attr("maxDate");
            var timeGroupReg = /(startTime|endTime)(\d*)/i;
            var dateStr = $(this).attr("date") || "";
            if ($(this).hasClass("read-only")) return;
            $(this).addClass("calendar").attr("readonly", true);

            if (dateStr && timeGroupReg.test(dateStr)) {
                var match = dateStr.match(timeGroupReg);
                var dataType = match[1];
                var dateGroupNum = match[2] ? (match[2] + "_") : "";
                if (dataType == "startTime") {
                    $(this).attr("id", "calendar_startTime_" + dateGroupNum + guid);
                    $(this).on("focus",function(){
                        var $endTime = $("#" + "calendar_endTime_" + dateGroupNum + guid);
                        if ($endTime.val() == "" && $endTime.attr("maxDate") != undefined) {
                            maxDate = $endTime.attr("maxDate");
                        } else {
                            maxDate = '#F{$dp.$D(\'calendar_endTime_' + dateGroupNum + guid + '\');}'
                        }
                        var options = {
                            dateFmt:calendar,
                            maxDate:maxDate
                        };
                        if (minDate != undefined) options["minDate"] = minDate;
                        WdatePicker(options);
                    });
                } else if (dataType == "endTime") {
                    $(this).attr("id", "calendar_endTime_" + dateGroupNum + guid);
                    $(this).on("focus",function(){
                        var $startTime = $("#" + "calendar_startTime_" + dateGroupNum + guid);
                        if ($startTime.val() == "" && $startTime.attr("minDate") != undefined) {
                            minDate = $startTime.attr("minDate");
                        } else {
                            minDate = '#F{$dp.$D(\'calendar_startTime_' + dateGroupNum + guid + '\');}'
                        }
                        var options = {
                            dateFmt:calendar,
                            minDate:minDate
                        };
                        if (maxDate != undefined) options["maxDate"] = maxDate;
                        WdatePicker(options);
                    });
                }
            } else {
                $(this).on("focus",function(){
                    var options = {
                        dateFmt:calendar
                    };
                    if (minDate != undefined) options["minDate"] = minDate;
                    if (maxDate != undefined) options["maxDate"] = maxDate;
                    WdatePicker(options);
                });
            }
        });
    };
	
	//初始化查询条件
	$.fn.buildQuery = function(option){
		var _this = $(this);
		_this.empty();
		if(!option) return;
		$.each(option.item,function(k,v){
			var item = "";
			switch(v.type){
				case "input" :
					item = $("<div type=\"input\" class=\"query-item-input form-group\" keyName=\""+v.keyName+"\"><label class=\"control-label\">"+v.text+"：</label><input type=\"text\" class=\"form-control\" "+((v.placeholder)?"placeholder='"+v.placeholder+"'":"")+"></div>");
					break;
				case "tab" : 
					item = $("<div type=\"tab\" class=\"query-item-tab form-group\" keyName=\""+v.keyName+"\"></div>");
					if(v.list){
						$.each(v.list,function(j,h){
							var tabItem = $("<span value=\""+h.value+"\">"+h.text+"</span>");
							if(j==0) tabItem.addClass("checked");
							tabItem.data(h);
							item.append(tabItem);
							tabItem.on("click",function(){
								item.find("span.checked").removeClass("checked");
								$(this).addClass("checked");
								if(v.click&&typeof v.click == "function"){v.click($(this).data())}
							})
						})
					}
					break;
				case "checkbox" :
					item = $("<div type=\"checkbox\" class=\"query-item-checkbox form-group\" keyName=\""+v.keyName+"\"><label class=\"query-checkbox-label\">"+v.text+"</label></div>");
					//$(".query-checkbox-label",item).on("click",function(){
					item.on("click",function(){
						$(this).toggleClass("checked");
					})
					break;
				case "select" : 
					var optionData = v.list;
					if(v.addDefault!=false){
						optionData.splice(0,0,{"text":"-请选择-","value":""});
					}
					item = $("<div type=\"select\" class=\"query-item-select form-group\" keyName=\""+v.keyName+"\">"+((v.text)?"<label class=\"control-label\">"+v.text+"：</label>":'')+"<span class=\"query-select-current form-control\">"+optionData[0].text+"</span></div>");
					var optionList = $("<ul></ul>");
					$.each(optionData,function(j,h){
						var option = $("<li>"+h.text+"</li>");
						if(j==0) option.addClass("checked");
						option.data(h);
						optionList.append(option);
					})
					item.append(optionList);
					
					/*if((optionData.length*25)>300){
						optionList.height(300);
						//optionList.loadScroll();
					}*/
					item.on("click",".query-select-current",function(){
						_this.find(".query-item-select ul").hide();
						//$(this).next().toggle();
						//debugger;
						if($(this).next().is(":hidden")) {
							$(this).next().show();
						}else{
							$(this).next().hide();
						}
						var maxHeight = _this.find(".query-item-select ul li").size()*25;
						if(maxHeight>300){
							optionList.height(300);
							optionList.loadScroll();
						}
						return false;
					}).on("click","li",function(){
						$(".query-select-current",item).data($(this).data()).text($(this).text());
						$("li.checked",item).removeClass("checked");
						$(this).addClass("checked");
						$("ul",item).hide();
					})
					break;
				case "date" :
					item = $("<div type=\"date\" class=\"query-item-date form-group\"><label class=\"control-label\">"+v.text+"：</label></div>");
					var dateFormat = v.format || "yyyy-MM-dd";
					var defaultVaule = "";
					if(v.addDefault!=false){
						defaultVaule = S.dateFormat(new Date(),dateFormat);
					}
					if(v.range==true){
						item.append("<input type=\"text\" class=\"form-control\" keyName=\""+v.keyName+"\" calendar=\""+dateFormat+"\" date=\"startTime\" value=\""+defaultVaule+"\" /><label class=\"control-label\">至</label><input type=\"text\" class=\"form-control\" keyName=\""+v.keyName2+"\" calendar=\""+dateFormat+"\" date=\"endTime\" value=\""+defaultVaule+"\" />");
					}else{
						item.append("<input type=\"text\" class=\"form-control\" keyName=\""+v.keyName+"\" calendar=\""+dateFormat+"\" value=\""+defaultVaule+"\" />");
					}
					item.buildDatePicker();
					break;
				case "divider" : 
					item = "<div class=\"divider\"></div>";
					break;
				case "button" : 
					item = $("<button type=\"button\" class=\"btn btn-sm btn-primary\">"+v.text+"</button>");
					item.on("click",function(){
						var formData = getQueryData();
						v.click(formData);
					})
					break;
			}
			_this.addClass("custom-query-list").append(item);
		})
		
		function getQueryData(){
			var result = {};
			$("#menu .queryList .form-group").each(function(){
				var type = $(this).attr("type"),
					key = $(this).attr("keyName");
				switch(type){
					case "input" : 
						result[key] = $(this).find(".form-control").val();
						break;
					case "tab" : 
						result[key] = $(this).find("span.checked").attr("value");
						break;
					case "select" : 
						result[key] = $(this).find("li.checked").data();
						break;
					case "date" :
						$(this).find("[calendar]").each(function(j,k){
							key = $(k).attr("keyName");
							result[key] = $(k).val();
						})
						break;
					case "checkbox" : 
						//result[key] = 
						break;
						
				}
			});
			return result;
		}
		/*if(option.url){
			var postData = {};
			S.request({
				url : option.url,
				data : postData,
				success : function(data){
					if(option.callBack&&option.callBack=="function"){
						option.callBack(data);
					}	
				}
			})
		}*/
		$("body").on("click",function(){
			$(".query-item-select ul").hide();
		})
	}
	
	S.navigation = function(menuData){
		/*var childMenuList = function(target,childData){
			
		}*/
		function buildMenuList(menuList,target,isChild){
			var result = "";
			if(isChild==true){
				$(menuList).each(function(k,v){
					var item = $("<li><a "+((v.url)?"url=\""+v.url+"\"":"")+">"+v.name+"</a></li>");
					if(v.children){
						var childList = $("<ul>"+buildMenuList(v.children)+"</ul>");
						item.addClass("hasChild").append(childList);
					}
					target.find("ul").append(item);
				});
			}else{
				$(menuList).each(function(k,v){
					result += "<li><a "+((v.url)?"url=\""+v.url+"\"":"")+">"+v.name+"</a></li>";
				});
			}
			return result;
		}
		
		$(S.sysMenu).each(function(i,v){
			var item = $("<li "+((v.current==true)?"class=\"current\"":"")+">"+v.name+"</li>");
			if(v.url!=""){
				item.attr("url",v.url);
			};
			item.data(v);
			if(v.children){
				var childData = v.children;
				var menuList = $("<div index=\""+i+"\"><div class=\"category\">"+childData[0].name+"</div><ul class=\"categoryList\"></ul></div>");
				$("#menu>.menuList").append(menuList);
				buildMenuList(v.children,menuList,true);
			}
			$("#header>ul.clearfix").append(item);
		})
		
	}
	
	
})(window);