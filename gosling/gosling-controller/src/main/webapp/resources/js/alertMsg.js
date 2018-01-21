toastr.options={
			closeButton: false,//是否显示关闭按钮
			progressBar: true,//是否显示进度条
			positionClass : 'toast-top-center',
			onclick: null,  //点击消息框自定义事件 
		    showDuration: "300",  //显示动作时间 
		    hideDuration: "1000",  //隐藏动作时间 
		    timeOut: "2000",  //自动关闭超时时间 
		    extendedTimeOut: "1000",  
		    showEasing: "swing",  
		    hideEasing: "linear",  
		    showMethod: "fadeIn",  // 显示的方式，和jquery相同 
		    hideMethod: "fadeOut" //隐藏的方式，和jquery相同 	
		}
function sAlert(msg){
	 toastr.success(msg, '成功');
}
function eAlert(msg){
	toastr.error(msg, '错误');
}
function iAlert(msg){
	toastr.info(msg, '提示');
}
function wAlert(msg){
	toastr.warning(msg, '警告');
}