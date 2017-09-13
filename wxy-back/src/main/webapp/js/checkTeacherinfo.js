
function img(){
	var nickname =$.trim($("#showimg").val());
	if(nickname==""){
		$("#img_input").hidden();
    }else{
        $("#img_input").show();
    }
}

function add() {
    $("#Dao").window("open");
}
$(function(){
$("#Dao").window({
    title:'模板导入',
    width:400,
    modal:true,
    shadow:true,
    minimizable:false,
    closed:true,
    height:300,
    resizable:false
});
})