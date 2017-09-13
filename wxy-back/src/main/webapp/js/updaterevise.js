/**
 * Created by yankai on 2017/4/26.
 */
$(function() {

	// 验证管理员姓名
	function nickname() {
		var isok = false;
		var nickname = $.trim($("#glname").val());
		if (nickname == "") {
			$("#glname").css('border-color', '#f00');
			$("#glname").css('background-color', '#FFF');
			$("#glname_input").html("不能为空！").addClass("error");
		} else {
			$("#glname").css('border-color', '#dcdcdc');
			$("#glname_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;

	}
	// 验证身份证
	function glshid() {
		var isok = false;
		var pwd = $.trim($("#nameid").val());
		var reg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
		if (pwd == "") {
			$("#nameid").css('border-color', '#f00');
			$("#nameid_input").html("请填写管理员身份证！").addClass("error");
		} else if (reg.test(pwd) == false) {
			$("#nameid").css('border-color', '#f00');
			$("#nameid_input").html("请输入正确的身份证号!").addClass("error");
		} else {
			$("#nameid").css('border-color', '#dcdcdc');
			$("#nameid_input").html("").removeClass();
			isok = true;
		}
		return isok;
	}

	// 邮箱
	function email() {
		var isok = false;
		var email = $.trim($("#email").val());
		var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if (email == "") {
			$("#email").css('border-color', '#f00');
			$("#email_input").html("请填写企业号注册时的邮箱地址！").addClass("error");
		} else if (reg.test(email) == false) {
			$("#email").css('border-color', '#f00');
			$("#email_input").html("请填写正确的邮箱地址").addClass("error");
		} else {
			$("#email").css('border-color', '#dcdcdc');
			$("#email_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 企业号密码
	function password() {
		var isok = false;
		var reg = /^(\w){8,20}$/;
		var pwd = $.trim($("#password").val());
		if (pwd == "") {
			$("#password").css('border-color', '#f00');
			$("#password_input").html("请填写企业号密码！").addClass("error");
		} else if (reg.test(pwd) == false) {
			$("#password").css('border-color', '#f00');
			$("#password_input").html("请输入不少于8位的字符，包含字母、数字或者英文符号，区分大小写")
					.addClass("error");
		} else {
			$("#password").css('border-color', '#dcdcdc');
			$("#password_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 姓名
	function name() {
		var isok = false;
		var nickname = $.trim($("#name").val());
		if (nickname == "") {
			$("#name").css('border-color', '#f00');
			$("#name_input").html("请填写管理员姓名！").addClass("error");
		} else if (isNaN(nickname) == false) {
			$("#name").css('border-color', '#f00');
			$("#name_input").html("格式错误，请重新填写").addClass("error");
		} else {
			$("#name").css('border-color', '#dcdcdc');
			$("#name_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 管理员手机号
	function glytel() {

		var reg = /^[1][3|4|5|7|8][0-9]{9}$/;
		var tel = $.trim($("#phone").val());
		if (tel == "") {
			$("#phone").css('border-color', '#f00');
			$("#phone_input").html("请填写管理员手机！").addClass("error");
		} else if (reg.test(tel) == false) {
			$("#phone").css('border-color', '#f00');
			$("#phone_input").html("请输入正确的手机号").addClass("error")
			return false;
		} else {
			$("#phone").css('border-color', '#dcdcdc');
			$("#phone_input").html("").removeClass().addClass("ok")
		}
	}

	// 管理员微信
	function glywx() {
		var isok = false;
		var pwd = $.trim($("#admin_wx").val());
		if (pwd == "") {
			$("#admin_wx").css('border-color', '#f00');
			$("#admin_wx_input").html("请填写管理员微信！").addClass("error");
		} else {
			$("#admin_wx").css('border-color', '#dcdcdc');
			$("#admin_wx_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 机构名称
	function jgmc() {
		var isok = false;
		var pwd = $.trim($("#jg_name").val());
		if (pwd == "") {
			$("#jg_name").css('border-color', '#f00');
			$("#jg_name_input").html("请填写机构名称！").addClass("error");
		} else {
			$("#jg_name").css('border-color', '#dcdcdc');
			$("#jg_name_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 机构域名
	function jgym() {
		var isok = false;
		var pwd = $.trim($("#jg_ym").val());
		if (pwd == "") {
			$("#jg_ym").css('border-color', '#f00');
			$("#jg_ym_input").html("请输入域名！").addClass("error");
		} else {
			$("#jg_ym").css('border-color', '#dcdcdc');
			$("#jg_ym_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 企业号人数
	function num() {
		var isok = false;
		var reg = /^^-?\d+$/;
		var pwd = $.trim($("#num").val());
		if (pwd == "") {
			$("#num").css('border-color', '#f00');
			$("#num_input").html("请输入企业号人数！").addClass("error");
		} else if (reg.test(pwd) == false) {
			$("#num").css('border-color', '#f00');
			$("#num_input").html("请输入正确的企业号人数!").addClass("error")
			return false;
		} else {
			$("#num").css('border-color', '#dcdcdc');
			$("#num_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 法人代表
	function frdb() {
		var isok = false;
		var pwd = $.trim($("#fr_name").val());
		if (pwd == "") {
			$("#fr_name").css('border-color', '#f00');
			$("#fr_name_input").html("请填写法定代表人！").addClass("error");
		} else {
			$("#fr_name").css('border-color', '#dcdcdc');
			$("#fr_name_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 认证地址
	function rzdz() {
		var isok = false;
		var pwd = $.trim($("#address").val());
		if (pwd == "") {
			$("#address").css('border-color', '#f00');
			$("#address_input").html("请填写机构地址！").addClass("error");
		} else {
			$("#address").css('border-color', '#dcdcdc');
			$("#address_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 认证时间
	function rztime() {
		var isok = false;
		var pwd1 = $.trim($("#rz_time1").val());
		var pwd2 = $.trim($("#rz_time2").val());
		if (pwd1 == "" || pwd2 == "") {
			$("#rz_time1，rz_time2").css('border-color', '#f00');
			$("#rz_time_input").html("请填写认证时间！").addClass("error");
		} else {
			$("#rz_time1，rz_time2").css('border-color', '#dcdcdc');
			$("#rz_time_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 办公电话
	function bgtel() {

		var reg = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
		var tel = $.trim($("#tel").val());
		if (tel == "") {
			$("#tel").css('border-color', '#f00');
			$("#tel_input").html("请填写办公电话！").addClass("error");
		} else if (reg.test(tel) == false) {
			$("#tel").css('border-color', '#f00');
			$("#tel_input").html("请输入正确的电话号码！").addClass("error")
			return false;
		} else {
			$("#tel").css('border-color', '#dcdcdc');
			$("#tel_input").html("").removeClass().addClass("ok")
		}
	}

	// 组织信用代码
	function daima() {
		var isok = false;
		var pwd = $.trim($("#daima").val());
		if (pwd == "") {
			$("#daima").css('border-color', '#f00');
			$("#daima_input").html("请填写组织机构代码/统一社会信用代码！").addClass("error");
		} else {
			$("#daima").css('border-color', '#dcdcdc');
			$("#daima_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 部门
	function bumen() {
		var isok = false;
		var pwd = $.trim($("#bumen").val());
		if (pwd == "") {
			$("#bumen").css('border-color', '#f00');
			$("#bumen_input").html("请填写运营者部门！").addClass("error");
		} else {
			$("#bumen").css('border-color', '#dcdcdc');
			$("#bumen_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营者手机号
	function yyphone() {

		var reg = /^[1][3|4|5|7|8][0-9]{9}$/;
		var tel = $.trim($("#yy_phone").val());
		if (tel == "") {
			$("#yy_phone").css('border-color', '#f00');
			$("#yy_phone_input").html("请填写运营者手机！").addClass("error");
		} else if (reg.test(tel) == false) {
			$("#yy_phone").css('border-color', '#f00');
			$("#yy_phone_input").html("请输入正确的手机号").addClass("error")
			return false;
		} else {
			$("#yy_phone").css('border-color', '#dcdcdc');
			$("#yy_phone_input").html("").removeClass().addClass("ok")
		}
	}

	// 运营者邮箱
	function yyemail() {
		var isok = false;
		var email = $.trim($("#yy_email").val());
		var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if (email == "") {
			$("#yy_email").css('border-color', '#f00');
			$("#yy_email_input").html("请填写运营者邮箱！").addClass("error");
		} else if (reg.test(email) == false) {
			$("#yy_email").css('border-color', '#f00');
			$("#yy_email_input").html("请输入正确的运营者邮箱").addClass("error");
		} else {
			$("#yy_email").css('border-color', '#dcdcdc');
			$("#yy_email_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营者名称
	function yyname() {
		var isok = false;
		var pwd = $.trim($("#yy_name").val());
		if (pwd == "") {
			$("#yy_name").css('border-color', '#f00');
			$("#yy_name_input").html("请填写运营者姓名！").addClass("error");
		} else {
			$("#yy_name").css('border-color', '#dcdcdc');
			$("#yy_name_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营者职位
	function yyzw() {
		var isok = false;
		var pwd = $.trim($("#yy_zw").val());
		if (pwd == "") {
			$("#yy_zw").css('border-color', '#f00');
			$("#yy_zw_input").html("请填写运营者职位！").addClass("error");
		} else {
			$("#yy_zw").css('border-color', '#dcdcdc');
			$("#yy_zw_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营座机
	function yytel() {

		var reg = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
		var tel = $.trim($("#yy_tel").val());
		if (tel == "") {
			$("#yy_tel").css('border-color', '#f00');
			$("#yy_tel_input").html("请填写运营者座机！").addClass("error");
		} else if (reg.test(tel) == false) {
			$("#yy_tel").css('border-color', '#f00');
			$("#yy_tel_input").html("请输入正确的座机号码！").addClass("error")
			return false;
		} else {
			$("#yy_tel").css('border-color', '#dcdcdc');
			$("#yy_tel_input").html("").removeClass().addClass("ok")
		}
	}

	// 验证身份证
	function yyid() {
		var isok = false;
		var pwd = $.trim($("#yy_nameid").val());
		var reg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
		if (pwd == "") {
			$("#yy_nameid").css('border-color', '#f00');
			$("#yy_nameid_input").html("请填写运营者身份证！").addClass("error");
		} else if (reg.test(pwd) == false) {
			$("#yy_nameid").css('border-color', '#f00');
			$("#yy_nameid_input").html("请输入正确的身份证号").addClass("error");
		} else {
			$("#yy_nameid").css('border-color', '#dcdcdc');
			$("#yy_nameid_input").html("").removeClass();
			isok = true;
		}
		return isok;
	}

	// 开户名称
	function khmc() {
		var isok = false;
		var pwd = $.trim($("#kh_name").val());
		if (pwd == "") {
			$("#kh_name").css('border-color', '#f00');
			$("#kh_name_input").html("请填写开户名称！").addClass("error");
		} else {
			$("#kh_name").css('border-color', '#dcdcdc');
			$("#kh_name_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 对公账户
	function dgzh() {
		var isok = false;
		var reg = /^^-?\d+$/;
		var pwd = $.trim($("#dg_zh").val());
		if (pwd == "") {
			$("#dg_zh").css('border-color', '#f00');
			$("#dg_zh_input").html("请填写对公账户！").addClass("error");
		} else {
			$("#dg_zh").css('border-color', '#dcdcdc');
			$("#dg_zh_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 开户银行
	function khyh() {
		var isok = false;
		var pwd = $.trim($("#kh_yh").val());
		if (pwd == "") {
			$("#kh_yh").css('border-color', '#f00');
			$("#kh_yh_input").html("请填写开户银行！").addClass("error");
		} else {
			$("#kh_yh").css('border-color', '#dcdcdc');
			$("#kh_yh_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 开户地址
	function khdz() {
		var isok = false;
		var pwd = $.trim($("#kh_address").val());
		if (pwd == "") {
			$("#kh_address").css('border-color', '#f00');
			$("#kh_address_input").html("请填写开户地点！").addClass("error");
		} else {
			$("#kh_address").css('border-color', '#dcdcdc');
			$("#kh_address_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 联系人
	function lxr() {
		var isok = false;
		var pwd = $.trim($("#lxr").val());
		if (pwd == "") {
			$("#lxr").css('border-color', '#f00');
			$("#lxr_input").html("请填写联系人！").addClass("error");
		} else {
			$("#lxr").css('border-color', '#dcdcdc');
			$("#lxr_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 详细地址
	function xxdz() {
		var isok = false;
		var pwd = $.trim($("#xxdz").val());
		if (pwd == "") {
			$("#xxdz").css('border-color', '#f00');
			$("#xxdz_input").html("请填写详细街道地址！").addClass("error");
		} else {
			$("#xxdz").css('border-color', '#dcdcdc');
			$("#xxdz_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 发票抬头
	function fphead() {
		var isok = false;
		var pwd = $.trim($("#fp_head").val());
		if (pwd == "") {
			$("#fp_head").css('border-color', '#f00');
			$("#fp_head_input").html("请填写发票抬头！").addClass("error");
		} else {
			$("#fp_head").css('border-color', '#dcdcdc');
			$("#fp_head_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 联系人手机
	function lxrphone() {
		var isok = false;
		var reg = /^[1][3|4|5|7|8][0-9]{9}$/;
		var tel = $.trim($("#lxr_phone").val());
		if (tel == "") {
			$("#lxr_phone").css('border-color', '#f00');
			$("#lxr_phone_input").html("请填写联系人手机！").addClass("error");
		} else if (reg.test(tel) == false) {
			$("#lxr_phone").css('border-color', '#f00');
			$("#lxr_phone_input").html("请输入正确的手机号").addClass("error")
			return false;
		} else {
			$("#lxr_phone").css('border-color', '#dcdcdc');
			$("#lxr_phone_input").html("").removeClass().addClass("ok")
			isok = true;
		}
		return isok;
	}

	// 邮政编码
	function yzbm() {
		var isok = false;
		var pwd = $.trim($("#yzbm").val());
		var reg = /^[1-9][0-9]{5}$/;
		if (pwd == "") {
			$("#yzbm").css('border-color', '#f00');
			$("#yzbm_input").html("请填写邮政编码！").addClass("error");
		} else if (reg.test(pwd) == false) {
			$("#yzbm").css('border-color', '#f00');
			$("#yzbm_input").html("请输入正确的邮政编码").addClass("error")
			return false;
		} else {
			$("#yzbm").css('border-color', '#dcdcdc');
			$("#yzbm_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}
	
	//	注册类型判断不能为空
	$(function(){
		$("#regtype").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#regtype").css('border-color', '#f00');
			$("#zc_type_input").html("请选择注册类型！").addClass("error");
		}else{
			$("#regtype").css('border-color', '#dcdcdc');
			$("#zc_type_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
//	认证类型判断不能为空
	$(function(){
		$("#rz_type").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#rz_type").css('border-color', '#f00');
			$("#rz_type_input").html("请选择认证类型！").addClass("error");
		}else{
			$("#rz_type").css('border-color', '#dcdcdc');
			$("#rz_type_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
//	运营者类型判断不能为空
	$(function(){
		$("#yy_type").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#yy_type").css('border-color', '#f00');
			$("#yy_type_input").html("请选择运营者类型！").addClass("error");
		}else{
			$("#yy_type").css('border-color', '#dcdcdc');
			$("#yy_type_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
//	发票类型判断不能为空
	$(function(){
		$("#fp_type").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#fp_type").css('border-color', '#f00');
			$("#fp_type_input").html("请选择发票类型！").addClass("error");
		}else{
			$("#fp_type").css('border-color', '#dcdcdc');
			$("#fp_type_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
//	省市区判断不能为空
	$(function(){
		$("#province").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#province").css('border-color', '#f00');
			$("#province_input").html("请选择省级！").addClass("error");
		}else{
			$("#province").css('border-color', '#dcdcdc');
			$("#province_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
	$(function(){
		$("#city").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#city").css('border-color', '#f00');
			$("#city_input").html("请选择省级！").addClass("error");
		}else{
			$("#city").css('border-color', '#dcdcdc');
			$("#city_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
	$(function(){
		$("#districtAndCounty").click(function(){
		// 1、当前选中的option的value属性
		var sel=$(this).val();
		if(sel == "0" ||sel == null || sel == ""){
			$("#districtAndCounty").css('border-color', '#f00');
			$("#districtAndCounty_input").html("请选择省级！").addClass("error");
		}else{
			$("#districtAndCounty").css('border-color', '#dcdcdc');
			$("#districtAndCounty_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
		});
		});
	
	// 申请公函
	function sqgh() {
		var isok = false;
		var pwd = $.trim($("#sq_gh").val());
		if (pwd == "") {
			$("#sq_gh").css('border-color', '#f00');
			$("#sq_gh_input").html("请上传申请公函！").addClass("error");
		} else {
			$("#sq_gh").css('border-color', '#dcdcdc');
			$("#sq_gh_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营身份证正面验证
	function rztime() {
		var isok = false;
		var pwd1 = $.trim($("#yy_nameid_z").val());
		if (pwd1 == "" ) {
			$("#yy_nameid_z").css('border-color', '#f00');
			$("#yy_id_input").html("请上传运营者身份证正面照片！").addClass("error");
		} else {
			$("#yy_nameid_z").css('border-color', '#dcdcdc');
			$("#yy_id_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}
	
	
	// 运营身份证反面验证
	function rzsftime() {
		var isok = false;
		var pwd2 = $.trim($("#yy_nameid_f").val());
		if (pwd2 == "") {
			$("#yy_nameid_f").css('border-color', '#f00');
			$("#yy_id_input").html("请上传运营者身份证反面照片！").addClass("error");
		} else {
			$("#yy_nameid_f").css('border-color', '#dcdcdc');
			$("#yy_id_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营者职位
	function txydm() {
		var isok = false;
		var pwd = $.trim($("#xydm").val());
		if (pwd == "") {
			$("#xydm").css('border-color', '#f00');
			$("#xydm_input").html("请上传统一的社会信用代码证！").addClass("error");
		} else {
			$("#xydm").css('border-color', '#dcdcdc');
			$("#xydm_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	// 运营者职位
	function xkz() {
		var isok = false;
		var pwd = $.trim($("#xkz").val());
		if (pwd == "") {
			$("#xkz").css('border-color', '#f00');
			$("#xkz_input").html("请上传相关许可证！").addClass("error");
		} else {
			$("#xkz").css('border-color', '#dcdcdc');
			$("#xkz_input").html("").removeClass().addClass("ok");
			isok = true;
		}
		return isok;
	}

	$("#glname").blur(nickname);
	$("#nameid").blur(glshid);
	$("#email").blur(email);
	$("#password").blur(password);
	$("#name").blur(name);
	$("#phone").blur(glytel);
	$("#admin_wx").blur(glywx);
	$("#jg_name").blur(jgmc);
	$("#jg_ym").blur(jgym);
	$("#num").blur(num);
	$("#fr_name").blur(frdb);
	$("#address").blur(rzdz);
	$("#rz_time1").blur(rztime);
	$("#rz_time2").blur(rztime);
	$("#tel").blur(bgtel);
	$("#daima").blur(daima);
	$("#bumen").blur(bumen);
	$("#yy_phone").blur(yyphone);
	$("#yy_email").blur(yyemail);
	$("#yy_name").blur(yyname);
	$("#yy_zw").blur(yyzw);
	$("#yy_tel").blur(yytel);
	$("#yy_nameid").blur(yyid);
	$("#kh_name").blur(khmc);
	$("#dg_zh").blur(dgzh);
	$("#kh_yh").blur(khyh);
	$("#kh_address").blur(khdz);
	$("#lxr").blur(lxr);
	$("#xxdz").blur(xxdz);
	$("#fp_head").blur(fphead);
	$("#lxr_phone").blur(lxrphone);
	$("#yzbm").blur(yzbm);
	$("#sq_gh").blur(sqgh);
	$("#yy_nameid_z").blur(rztime);
	$("#yy_nameid_f").blur(rztime);
	$("#xydm").blur(txydm);
	$("#xkz").blur(xkz);
	$("#regtype").blur(regtype);

	// 注册
	$("#update_btn").click(
			function() {
				var isok = true;
				if (nickname() == false || glshid() == false
						|| email() == false || password() == false
						|| glytel() == false || glywx() == false
						|| jgmc() == false || jgym() == false || num() == false
						|| frdb() == false || rzdz() == false
						|| rztime() == false || bgtel() == false
						|| daima() == false || bumen() == false
						|| yyphone() == false || yyemail() == false
						|| yyname() == false || yyzw() == false
						|| yytel() == false || yyid() == false
						|| khmc() == false || dgzh() == false
						|| khyh() == false || khdz() == false || lxr() == false
						|| xxdz() == false || fphead() == false
						|| lxrphone() == false || yzbm() == false
						|| sqgh() == false || rztime() == false
						|| txydm() == false || xkz() == false) {
					isok = false;
					alert("修改保存失败！~");
				} else {
					var saveStatus = {
						reg_basic_msg : false,
						bank_open_msg : false,
						reg_credentials : false,
						certification_basic_msg : false,
						operation_msg : false,
						invoice_msg : false,
						certific_rela_certs : false,
					}

					// 统一保存处理方法
					var saves = function(key) {
						saveStatus[key] = true;
						console.log(saveStatus);
						// 判断是否全部为true
						for ( var k in saveStatus) {
							if (!saveStatus[k]) {
								return;
							}
						}
						// 全部保存成功后调用统一保存处理方法
						$.get(ctx + "/saves/revises.do", {}, function(result) {
							if ("1" == result) {
								alert("修改保存成功");
							}
							console.log(result);
						});
					}
					// reg_basic_msg : 注册相关 基本信息 -> t_wechat和t_reg
					// bank_open_msg : 银行开户信息 -> t_reg
					// reg_credentials : 注册相关证件 -> t_reg 上传文件

					// certification_basic_msg : 认证相关 基本信息 -> t_authentication
					// operation_msg : 运营者信息 -> t_operator
					// invoice_msg : 发票信息 -> t_invoice
					// certific_rela_certs : 认证相关证件 -> t_authentication 上传文件

					// reg_basic_msg : 注册相关 基本信息 -> t_wechat和t_reg
					$("#reg_basic_msg").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/regbasicmsg.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("reg_basic_msg");
							}
						},
						error : function(e) {
							alert("reg_basic_msg " + e);
						}
					});
					// bank_open_msg : 银行开户信息 -> t_reg
					$("#bank_open_msg").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/bankopenmsg.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("bank_open_msg");
							}
						},
						error : function(e) {
							alert("bank_open_msg " + e);
						}

					});
					// reg_credentials : 注册相关证件 -> t_reg 上传文件
					$("#reg_credentials").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/regcredentials.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("reg_credentials");
							}
						},
						error : function(e) {
							alert("reg_credentials " + e);
						}
					});
					// certification_basic_msg : 认证相关 基本信息 -> t_authentication
					$("#certification_basic_msg").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/certificationbasicmsg.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("certification_basic_msg");
							}
						},
						error : function(e) {
							alert("certification_basic_msg " + e);
						}
					});
					// operation_msg : 运营者信息 -> t_operator
					$("#operation_msg").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/operationmsg.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("operation_msg");
							}
						},
						error : function(e) {
							alert("operation_msg " + e);
						}
					});
					// invoice_msg : 发票信息 -> t_invoice
					$("#invoice_msg").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/invoicemsg.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("invoice_msg");
							}
						},
						error : function(e) {
							alert("invoice_msg " + e);
						}
					});
					// certific_rela_certs : 认证相关证件 -> t_authentication 上传文件
					$("#certific_rela_certs").ajaxSubmit({
						dataType : "json",
						url : ctx + "/save/revise/certificrelacerts.do",
						async : false,
						success : function(result) {
							if (result == "1") {
								saves("certific_rela_certs");
							}
						},
						error : function(e) {
							alert("certific_rela_certs " + e);
						}
					});
				}
			});
	var getFileName=function(val){
		var i=-1;
		if(val.lastIndexOf("/")>0){
			i=val.lastIndexOf("/");
		}else if(val.lastIndexOf("\\")>0){
			i=val.lastIndexOf("\\");
		}
		if(i>0){
			val=val.substr(i+1,val.length);	
			return val;
		}
		return "";
	}
	$("input[type='file']").change(function(){
		var val=$(this).val();
		$(this).parent().prev().val(getFileName(val));
	});
	$("input[filename]").each(function(){
		var val=$(this).attr("filename");
		$(this).val(getFileName(val));
	});
	
})