


//多语言切换
function tourl(lanname,hname){
	var lanurl;
	if(lanname == 'cn'){
		lanurl = "cn/"+hname+".html"
	}else if(lanname == 'tw'){
		lanurl = "tw/"+hname+".html"
	}else if(lanname == 'en'){
		lanurl = "en/"+hname+".html"
	}else if(lanname == 'es'){
		lanurl = "es/"+hname+".html"
	}else if(lanname == 'pl'){
		lanurl = "pl/"+hname+".html"
	}else if(lanname == 'ru'){
		lanurl = "ru/"+hname+".html"
	}else if(lanname == 'fr'){
		lanurl = "fr/"+hname+".html"
	}else if(lanname == 'ar-SA'){
		lanurl = "ar-SA/"+hname+".html"
	}else if(lanname == 'fa-IR'){
		lanurl = "fa-IR/"+hname+".html"
	}else if(lanname == 'it-IT'){
		lanurl = "it-IT/"+hname+".html"
	}
	else if(lanname == 'sk-SK'){
		lanurl = "sk-SK/"+hname+".html"
	}else if(lanname == 'th-TH'){
		lanurl = "th-TH/"+hname+".html"
	}
	else if(lanname == 'tr-TR'){
		lanurl = "tr-TR/"+hname+".html"
	}else if(lanname == 'uk-UA'){
		lanurl = "uk-UA/"+hname+".html"
	}else if(lanname == 'vi-VN'){
		lanurl = "vi-VN/"+hname+".html"
	}


	//修改链接页面地址
	parent.$("#FrameNav").attr("src", lanurl);
	//修改页面标题
	var $mainFrame=$('#FrameNav');
	setTimeout(function () { 
        console.log($mainFrame.contents().attr("title"));	
        lanName = $mainFrame.contents().attr("title");
        $(document).attr("title",lanName);
    }, 500);
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}