$(function() {
	var transData = function(a, idStr, pidStr, chindrenStr) {
		var r = [], hash = {}, id = idStr, pid = pidStr, children = chindrenStr, i = 0, j = 0, len = a.length;
		for (; i < len; i++) {
			hash[a[i][id]] = a[i];
		}
		for (; j < len; j++) {
			var aVal = a[j], hashVP = hash[aVal[pid]];
			if (hashVP) {
				!hashVP[children] && (hashVP[children] = []);
				hashVP[children].push(aVal);
			} else {
				r.push(aVal);
			}
		}
		return r;
	}
	var teacher_app = "teacher_app", family_app = "family_app";
	// 初始化，获取app和模块
	$('#searchSelect')[0].selectedIndex = -1;
	var init = function(name) {
		$.get(ctx + "/getAppMenu.do", {
			name : encodeURI(name)
		}, function(result) {
			genModule(result.module);
			genApp(result.menu);
			$("#searchInput").val(result.name);
		});
	}
	// 生成apps列表
	var genApp = function(menu) {
		var apps = $("#apps");
		apps.html("");
		for (var i = 0; i < menu.length; i++) {
			var data = menu[i];
			// 属性说明: id 数据id, add 是否添加过, ptype 数据类型 -> 1通用,2 教师端,3家长端
			var app = $(genAppBtn(data));
			app.find("button").css("background-color", "#bcbcbc");
			app.find("button").click(function() {
				var o = $(this);
				var id = o.attr("id");
				var ptype = o.attr("ptype");
				var oto = o.attr("oto");// 一 一对应
				var activity = $("p[activity='true']");
				var activityType = activity.attr("type");// 获得是哪一端
				var activityComm;// 通用，一一对应。两端
				var type = ptype;
				if (oto != "" && oto != null && oto != "null") {
					type = 1;
				}
				if (type == 1) {
					var comm = activity.attr("bt");
					activityComm = $("p[bt='" + comm + "']");
				}
				var balert = false;
				if (type != 1 && activity.length > 0) {
					var app = $(addModuleApp(o.parent().html()));
					if (!_$addApp(o, activity, app)) {
						balert = true;
					}
				}
				if (activityComm != "" && activityComm != undefined) {
					var tapp;
					var fapp;
					if (oto != "" && oto != null && oto != "null") {// 一一对应,得到两端应用
						if (ptype == 2) {// 当前点击app是教师端
							tapp = o;
							fapp = $("#apps").find("#" + oto);
						} else if (ptype == 3) {// 当前点击app是家长端
							fapp = o;
							tapp = $("#apps").find("#" + oto);
						}
					}
					activityComm.each(function() {
						var at = $(this).attr("type");// 应用端类型
						if (oto != "" && oto != null && oto != "null") {// 一 一对应
							if (at == "10001") {// 教师端
								var app = $(addModuleApp(tapp.parent().html()));
								_$addApp(tapp, $(this), app)
							} else if (at == "10002") {// 家长端
								var app = $(addModuleApp(fapp.parent().html()));
								_$addApp(fapp, $(this), app)
							}
						} else {// 通用
							var app = $(addModuleApp(o.parent().html()));
							if (!_$addApp(o, $(this), app)) {
								balert = true;
							}
						}
					});
				}
				if (balert) {
					alert("最多只能添加5个应用。");
				}
			});
			apps.append(app);
		}
		for (var i = 0; i < menu.length; i++) {
			var data = menu[i];
			// 属性说明: id 数据id, add 是否添加过, ptype 数据类型 -> 1通用,2 教师端,3家长端
			var app = $(genAppBtn(data));
			app.find("button").css("background-color", "#bcbcbc");
			var isAdd = genModuleAddApp(data, app);
			if (isAdd) {
				app.find("button").attr("add", "true");
			}
		}
		var _$addApp = function(btn, $this, app) {
			if ($this.find("span").length >= 5) {
				return false;
			}
			var id = app.find("button").attr("id");
			if ($this.closest("div").find("#" + id).length == 0) {
				$this.append(app);
				btn.attr("add", "true").attr("disabled", "true").css("background-color", "#bcbcbc");
			}
			return true;
		}
	}
	var genAppBtn = function(data) {
		var html = "<li>";
		// 属性说明: id 数据id, add 是否添加过, ptype 数据类型 -> 1通用,2 教师端,3家长端
		html += '<button type="button" class="yy_btn" id="' + data.id + '" oto="' + data.oto + '" add="false" ptype="' + data.type + '" disabled="true">' + data.name + '</button>';
		html += "</li>";
		return html;
	}
	// 生成模块，添加处理事件
	var genModule = function(module) {
		var tree = transData(module, 'id', 'parentid', 'chindren');
		var moduleApp = $("#moduleApp");
		moduleApp.html("");
		for (var i = 0; i < tree.length; i++) {
			var data = tree[i];
			var div;
			if (data.type == "10001") {// 教师端应用
				div = $("<div></div>").addClass("teacher_app").attr("id", teacher_app);
			} else if (data.type == "10002") {// 家长端应用
				div = $("<div></div>").addClass("family_app").attr("id", family_app);
			}
			div.append("<h2>" + data.name + "</h2>");
			for (var j = 0; j < data.chindren.length; j++) {
				var cd = data.chindren[j];
				var html = '<a class="campus"><p id="' + cd.id + '" bt="comm' + j + '" type="' + data.type + '" activity="false"></p><h3>' + cd.name + '</h3></a>';
				div.append(html);
			}
			moduleApp.append(div);
		}
		// 教师端应用
		$("#" + teacher_app + " p").each(function() {
			$(this).click(function() {
				resetBackColor();
				$(this).attr("activity", "true");
				$(this).css("background-color", "#E1FFFF");
				$(this).next().css("background-color", "#6499ff");
				moduleClick(this);
			});
		});
		// 家长端应用
		$("#" + family_app + " p").each(function() {
			$(this).click(function() {
				resetBackColor();
				$(this).attr("activity", "true");
				$(this).css("background-color", "#E1FFFF");
				$(this).next().css("background-color", "#6499ff");
				moduleClick(this);
			});
		});
		// 模块点击事件
		var moduleClick = function(o) {
			// 重置应用
			$("#apps button").each(function() {
				$(this).removeAttr("disabled").css("background-color", "#6499ff").attr("add", "false");
			});
			var type = $(o).attr("type");// 端类型
			$(o).closest("div").find("button").each(function() {
				var id = $(this).attr("id");
				var ptype = $(this).attr("ptype");
				var oto = $(this).attr("oto");
				if (oto != "" && oto != null && oto != "null") {// 一 一对应
					// 禁用已经存在的应用
					$("#apps").find("#" + oto).attr("add", "true").attr("disabled", "disabled").css("background-color", "#bcbcbc");
				}
				// 禁用已经存在的应用
				$("#apps").find("button[id='" + id + "']").attr("add", "true").attr("disabled", "disabled").css("background-color", "#bcbcbc");
			});
			// 将不是属于自己应用类型的应用禁用
			$("#apps").find("button").each(function() {
				var ptype = $(this).attr("ptype");
				// 2 教师端，3家长端,10001 教师端应用，10002 家长端应用
				if (type == "10001" && ptype == 3) {
					$(this).attr("add", "true").attr("disabled", "disabled").css("background-color", "#bcbcbc");
				} else if (type == "10002" && ptype == 2) {
					$(this).attr("add", "true").attr("disabled", "disabled").css("background-color", "#bcbcbc");
				}
			});
		}
	}
	// 模块中添加app
	var genModuleAddApp = function(data, app) {
		if (data.parentid != "" && data.parentid != null && data.parentid != "null") {
			var ispar = data.ispar;
			var istea = data.istea;
			var pid = data.parentid;
			if (istea == 1 && ispar == 1) {
				var app = $(addModuleApp(app.html()));
				$("#moduleApp").find("#" + pid).append(app);
				var bt = app.closest("p").attr("bt");
				var type = app.closest("p").attr("type");
				var oto = app.find("button").attr("oto");
				var appsBtn = $("#apps").find("#" + oto);
				if (appsBtn.length == 0 && (oto == "" || oto == "null" || oto == null)) {// 判断 一
					// 一对应是空，并且得不到对应的值时，认为是通用
					appsBtn = app.find("button");
				}
				var p;
				if (type == "10001") {// 教师端应用
					p = $("#" + family_app).find("p[bt='" + bt + "']");
				} else if (type == "10002") {// 家长端应用
					p = $("#" + teacher_app).find("p[bt='" + bt + "']");
				}
				p.append($(addModuleApp(appsBtn.parent().html())));
			} else if (ispar == 1 && (istea == "" || istea == "null" || istea == null)) {// 家长端
				var family = $("#" + family_app);
				family.find("p[id='" + pid + "']").append($(addModuleApp(app.html())));
			} else if (istea == 1 && (ispar == "" || ispar == "null" || ispar == null)) {// 教师端
				var teacher = $("#" + teacher_app);
				teacher.find("p[id='" + pid + "']").append($(addModuleApp(app.html())));
			}
			return true;
		}
		return false;
	}
	// 添加应用时获取
	var addModuleApp = function(text) {
		var html = "<span><ul><li>";
		html += text;
		html += "</li></ul></span>";
		html = $(html);
		html.find("button").removeAttr("disabled").css("background-color", "#6499ff");
		var app = $(html);
		var parent;
		app.find("button").click(function() {// 删除操作
			parent = $(this).closest("p");
			$("#apps").find("button[id='" + $(this).attr("id") + "']").attr("add", "false");
			var oto = $(this).attr("oto");
			if (oto != "" && oto != null && oto != "null") {
				var type = parent.attr("type");
				var bt = parent.attr("bt");
				var p;
				if (type == "10001") {// 教师端应用
					p = $("#" + family_app).find("p[bt='" + bt + "']");
				} else if (type == "10002") {// 家长端应用
					p = $("#" + teacher_app).find("p[bt='" + bt + "']");
				}
				p = p.find("#" + oto);
				$("#apps").find("button[id='" + p.attr("id") + "']").attr("add", "false");
				p.closest("span").remove();
			}
			$(this).closest("span").remove();
			resetBackColor();
			parent.click();
		});
		return app;
	}
	// 重置颜色，和app禁用颜色
	var resetBackColor = function() {
		$("#teacher_app p").each(function() {
			$(this).attr("activity", "false");
			$(this).css("background-color", "#fff");
			$(this).next().css("background-color", "#f2f2f2");
		});
		$("#family_app p").each(function() {
			$(this).attr("activity", "false");
			$(this).css("background-color", "#fff");
			$(this).next().css("background-color", "#f2f2f2");
		});
		$(".yy_btn").each(function() {
			var o = $(this);
			var add = o.attr("add");
			if (add == "false") {
				o.removeAttr("disabled");
				o.css("background-color", "#6499ff");
			}
		});
	}
	// 初始化
	init("");
	// 保存
	$("#saveBtn").click(function() {
		var teacher = $("#" + teacher_app);
		var family = $("#" + family_app);
		var datas = {
			teacher : {},
			family : {},
		};
		// 教师数据
		teacher.find("p").each(function(i, o) {
			var pid = $(this).attr("id");
			datas.teacher[i] = {
				pid : pid,
				chi : new Array()
			};
			var data = datas.teacher[i];
			$(this).find("button").each(function() {
				var id = $(this).attr("id");
				data.chi.push(id);
			});
		});
		// 教师数据
		family.find("p").each(function(i, o) {
			var pid = $(this).attr("id");
			datas.family[i] = {
				pid : pid,
				chi : new Array()
			};
			var data = datas.family[i];
			$(this).find("button").each(function() {
				var id = $(this).attr("id");
				data.chi.push(id);
			});
		});
		$.ajax({
			url : ctx + "/saveAppMenu.do",
			type : "POST",
			dataType : "json",
			data : {
				jsonData : JSON.stringify(datas)
			},
			success : function(result) {
				alert("保存成功");
			}
		});
	});
	$('#name').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			var name = $('#name').val();
			init(name)
		}
	});
	$("#searchSelect").change(function(){
		init($("#searchSelect").val())
	})
})