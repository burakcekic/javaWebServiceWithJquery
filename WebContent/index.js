var browsers=["Chrome","Firefox","Opera","Trident","Edge","Safari","SamsungBrowser"];

$(document).ready(function()
{
	getBtnParam();

});

function getBtnParam()
{
	$("button").click(function(){
		
		var url=window.location.href;  
		var name = $(this).attr("name") == undefined ? "isimsiz":$(this).attr("name");
		var dateTime = currentlyDateTime();
		var browser = browserControl();
		var btnId = createId(dateTime,$(this),browser);
		
		createJSON(url,name,dateTime,browser,btnId);
	});
}

function currentlyDateTime() 
{
	var returnVal="";
	var date = new Date;
	
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();
	
	var hours = date.getHours();
	hours = hours < 10 ? '0' + hours : hours;
	var minutes = date.getMinutes();
	minutes = minutes < 10 ? '0' + minutes : minutes;
	var seconds = date.getSeconds();
	seconds = seconds < 10 ? '0' + seconds : seconds;
	var strTime = hours + ':' + minutes + ':' +seconds;

    returnVal = day + '.' + month + '.' + year + ' ' + strTime;
    
    
    return returnVal;
}

function browserControl()
{

	var sBrowser, sUsrAg = navigator.userAgent;


	if (sUsrAg.indexOf(browsers[0]) > -1) 
	{
		sBrowser = browsers[0];
	} 
	else if (sUsrAg.indexOf(browsers[1]) > -1)
	{
		sBrowser = browsers[1];
	} 
	else if (sUsrAg.indexOf(browsers[2]) > -1 || sUsrAg.indexOf("OPR") > -1) 
	{
	    sBrowser = browsers[2];
	} 
	else if (sUsrAg.indexOf(browsers[3]) > -1) 
	{
		sBrowser = browsers[3];
	} 
	else if (sUsrAg.indexOf(browsers[4]) > -1) 
	{
		sBrowser = browsers[4];
	} 
	else if (sUsrAg.indexOf(browsers[5]) > -1) 
	{
		sBrowser = browsers[5]; 
	} 
	else if (sUsrAg.indexOf(browsers[6]) > -1) 
	{
		sBrowser = browsers[6];
	} 
	else 
	{
		sBrowser = "unknown";
	}
	
	return sBrowser;
}

function createId(currentlyDate,element,browserName)
{
	var dateTime=parseDateTime(currentlyDate);
	var browser= getbrowserId(browserName);
	var elementId = element.index() < 10 ? '0' + element.index() : element.index();
	
	return dateTime+browser+elementId;
	
}

function getbrowserId(browserName) //createId için
{
	var browserId;
	browsers.forEach(function(element){
		if(element == browserName)
		{
			browserId= "0" + jQuery.inArray( browserName, browsers );
		}
			
	});
	return browserId;
}

function parseDateTime(currentlyDate)//createId için
{
	var newDateTime="";
	if(currentlyDate != null &&  currentlyDate != "" )
	{
		var arr =currentlyDate.split(" ");
		var dt = arr[0];
		var tm = arr[1];
		
		
		if(dt != "" && dt != null && tm != "" && tm != null)
		{
			var dtArr=dt.split(".");
			var tmArr=tm.split(":");
			
			dtArr[0] = dtArr[0] < 10 ? "0" + dtArr[0] : dtArr[0];
			
			dtArr.forEach(function(element){

				newDateTime+=element;
				
			});
			tmArr.forEach(function(element){
				newDateTime+=element;
			});
		}
	}
	return newDateTime;
}

function createJSON(url,name,dateTime,browser,btnId)
{
	var dataSet={"data":[{"buttonId":btnId,"name":name,"url":url,"dateTime":dateTime,"browser":browser}]};
	console.log(dataSet.data[0]);
	
	return dataSet;
}