function dalert(content, callback) {
	top.artDialog({
		id : 'Alert',
		icon : 'succeed',
		title : false,
		cancel : false,
		fixed : true,
		content : content,
		lock : true,
		close : callback
	}).time(2);
}

function yalert(content, callback) {
	top.artDialog({
		id : 'Info',
		icon : 'succeed',
		title : false,
		cancel : true,
		fixed : true,
		content : content,
		lock : true,
		close : callback
	});
}


function openWindowWithPost(url, name, keys, values) {
	var newWindow = window.open("", name);
	if (!newWindow)
		return false;
	var html = "";
	html += "<form id='formid' method='post' action='" + url + "'>";
	if(keys != null){
		for ( var i = 0; i < keys.length; i++) {
			html += "<input type='hidden' name='" + keys[i] + "' value='" + values[i] + "'/>";
		}
	}
	html += "</form>";
	html += "<scr";
		html+="ipt type='text/javascript'>document.getElementById(\"formid\").submit()";
	html += "</sc"+"ript>";
	newWindow.document.write(html);
	return newWindow;
}
