(function(window, $){
	function Drag(){
		this.obj = null;
		this.disX = 0;
		this.disY = 0;
		this.settings = {   //默认参数
			toDown : function(){},
			toUp : function(){}
		};
	}
	Drag.prototype.init = function(opt){
		
		var This = this;
		
		this.obj = document.getElementById(opt.id);
		
		extend( this.settings , opt );
		
		this.obj.onmousedown = function(ev){
			var ev = ev || window.event;
			This.fnDown(ev);
			
			This.settings.toDown();
			
			document.onmousemove = function(ev){
				var ev = ev || window.event;
				This.fnMove(ev);
			};
			document.onmouseup = function(ev){
				var ev = ev || window.event;
				This.fnUp(ev);
				This.settings.toUp();
			};
			return false;
		};
	};
	Drag.prototype.fnDown = function(ev){
		this.disX = ev.clientX - this.obj.offsetLeft;
		this.disY = ev.clientY - this.obj.offsetTop;
	};
	Drag.prototype.fnMove = function(ev){
		var Dwidth = getWinth() - this.obj.offsetWidth,
			Dheight = getHeight() - this.obj.offsetHeight,
			evLeft = ev.clientX - this.disX ,
			evTop = ev.clientY - this.disY ;
			evLeft = Math.max(Math.min(evLeft, Dwidth),0);
			evTop = Math.max(Math.min(evTop, Dheight),0);
		this.obj.style.left = evLeft+ "px",
		this.obj.style.top = evTop+ "px";
	};
	Drag.prototype.fnUp = function(ev){
		document.onmousemove = null;
		document.onmouseup = null;
	};
	function extend(obj1,obj2){
		for(var attr in obj2){
			obj1[attr] = obj2[attr];
		}
	}
	function getWinth(){
		return document.documentElement.clientWidth ? document.documentElement.clientWidth : document.body.clientWidth;
	};
	function getHeight(){
		return document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
	};
	window.Drag = Drag;
})(window,jQuery);