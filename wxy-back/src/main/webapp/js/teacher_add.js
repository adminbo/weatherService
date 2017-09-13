
// reg_credentials : 注册相关证件 -> t_reg 上传
      $("#t_fileUp").ajaxSubmit({
			dataType : "json",
			url : ctx + "/teacher/t_fileUp.do",
			async : false,
			success : function(result) {
				if (result == "1") {
					 saves("t_fileUp");
					}
					 },
				 error : function(e) {
					 alert("t_fileUp " + e);
				 }
			 });
 
      
//下拉加复选
//参数：id  控件id   code 字典编码  
function initCombobox(id,code){  
       var value = "";  
       //加载下拉框复选框  
       $('#'+id).combobox({  
       url:'${base}/ht/getComboboxData.action?dictionaryCode='+code, //后台获取下拉框数据的url  
       method:'post',  
       panelHeight:200,//设置为固定高度，combobox出现竖直滚动条  
       valueField:'CODE',  
       textField:'NAME',  
       multiple:true,  
       formatter: function (row) { //formatter方法就是实现了在每个下拉选项前面增加checkbox框的方法  
       var opts = $(this).combobox('options');  
       return '<input type="checkbox" class="combobox-checkbox">' + row[opts.textField]  
       },  
       onLoadSuccess: function () {  //下拉框数据加载成功调用  
       var opts = $(this).combobox('options');  
       var target = this;  
       var values = $(target).combobox('getValues');//获取选中的值的values  
       $.map(values, function (value) {  
       var el = opts.finder.getEl(target, value);  
        el.find('input.combobox-checkbox')._propAttr('checked', true);   
        })  
        },  
        onSelect: function (row) { //选中一个选项时调用  
        var opts = $(this).combobox('options');  
        //获取选中的值的values  
        $("#"+id).val($(this).combobox('getValues'));  
                           
        //设置选中值所对应的复选框为选中状态  
        var el = opts.finder.getEl(this, row[opts.valueField]);  
        el.find('input.combobox-checkbox')._propAttr('checked', true);  
        },  
        onUnselect: function (row) {//不选中一个选项时调用  
        var opts = $(this).combobox('options');  
         //获取选中的值的values  
        $("#"+id).val($(this).combobox('getValues'));  
      
        var el = opts.finder.getEl(this, row[opts.valueField]);  
        el.find('input.combobox-checkbox')._propAttr('checked', false);  
       }  
     });
}