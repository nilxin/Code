/**
 * 省份 名称 id转换Api
 */
define(function(require){
	
	var map = [
		{
			id : 0,
			name : '锦江区'
		},{
			id : 1,
			name : '武侯区'
		},{
			id : 2,
			name : '青羊区'
		},{
			id : 3,
			name : '成华区'
		},{
			id : 4,
			name : '金牛区'
		},{
			id : 5,
			name : '彭州市'
		},{
			id : 6,
			name : '都江堰县'
		},{
			id : 7,
			name : '郫县'
		},{
			id : 8,
			name : '新都区'
		},{
			id : 9,
			name : '青白江区'
		},{
			id : 10,
			name : '金堂县'
		},{
			id : 11,
			name : '温江区'
		},{
			id : 12,
			name : '大邑县'
		},{
			id : 13,
			name : '崇州市'
		},{
			id : 14,
			name : '双流县'
		},{
			id : 15,
			name : '龙泉驿区'
		},{
			id : 16,
			name : '邛崃市'
		},{
			id : 17,
			name : '新津县'
		},{
			id : 18,
			name : '简阳'
		},{
			id : 19,
			name : '高新区'
		},{
			id : 20,
			name : '蒲江县'
		},{
			id : 21,
			name : '天府新区'
		}
	];
	
	var Area =  {

		getId : function(name){
			var id = void(0);
			$(map).each(function(i,v){
				if (v.name == name) {
					id = v.id
				}
			})
			return id;
		},
		
		getName : function(id){
			var name = void(0);
			$(map).each(function(i,v){
				if (v.id == id) {
					name = v.name
				}
			})
			return name;
		},

		getNameByIds : function(ids){
			var type = Object.prototype.toString.call(ids);
			if(type == '[object String]'){
				ids = ids.split(',');
			} else if(type != '[object Array]'){
				return [];
			}
			if(S.isArray(ids) && ids.length > 0){
				var result = [];
				$.each(ids, function(i,v){
					var mapId = v; 

					/*var area = _.find(map, function(item){
						return item.id == mapId;
					});*/
					var area = $.map(map,function(item){
						if (mapId == item.id) {
							result.push(item.name);
						}					
					})
				});
				return result;
			}

			return [];
		}
	};
	
	return Area;
});