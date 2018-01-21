//验证手机号码
function isMobile(mobile){
    var re = /(^1[3|4|5|6|7|8|9][0-9]{9}$)/;
    return re.test(mobile);
}

// 验证邮箱
function isEmail(email){
	// 验证邮箱
	var flag = false;
	var re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(re.test(email)==false){
	}else{
	   flag = true;
	}
	return flag;
}

// 验证座机号
function isPhone(phone) {
	var re = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
	return re.test(phone);
}
// 验证是否为Null  或空字符串
function isNotNull(id){
	var value = $("#"+id).val();
	if (value ==null || value ==""){
		$("#"+id).focus();
		return false;
	}
	return true;
}
//长度在min-max个字符 
function isLength(id,min,max){
	var value = $("#"+id).val();
	if (value.length < min || value.length > max){
		$("#"+id).focus();
		return false;
	}
	return true;
}
//两个表单值是否相等如确认密码
function isEquals(id1,id2){
	var value1 = $("#"+id1).val();
	var value2 = $("#"+id2).val();
	if (value1 != value2){
		$("#"+id2).focus();
		return false;
	}
	return true;
}
