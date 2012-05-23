function changeLinks(tableId, divID, action)
{
    done=true;
    selector = '#' + divID + ' span.pagelinks>a';
    changeUsingSelector(selector, tableId, divID, action);
    selector = 'table#' + tableId + '>thead>tr>th>a';
    changeUsingSelector(selector, tableId, divID, action);
    updatePreElement();
}

function changeUsingSelector(selector, tableId, divID, action)
{
	var linkData, queryArr, qryStr;
    $(selector).each(function()
    {
        linkData = $(this).attr("href");
        queryArr = linkData.split("?");
        
        if(action == null) action = queryArr[0];
        qryStr = queryArr[1];
        if(qryStr == null) qryStr = "";
        
        if($(this).attr("href").indexOf('JavaScript:doAjax(') == -1) 
        	newStr = "JavaScript:doAjax('" + action + "','" + qryStr + "','content','" + tableId + "','" + divID + "');";
        
        $(this).attr("href", newStr);
        $(this).attr("onMouseOver", "window.status='Pagination Links have been Ajaxified!!';return false;");
        $(this).attr("onMouseOut", "window.status='';return false;");
    });    

}

function updatePreElement(){
	var contentRowCount = $("pre#rowCount").html();
	$("pre#rowCount").replaceWith($("<script type=\"text/javascript\">" + contentRowCount + "</script>"));
}

function doAjax(url, data, eleId, tableId, divID, action)
{
    $.ajax
    ({
        url: url,
        data:  data,
        async: false,
        success: function(resp){
        	if(resp.indexOf("<body>") != -1){
        		var jScripts = $("#" + divID + " script");
                $('#' + divID).html($(resp).find("#" + divID).html());
                if(jScripts != null){
                	var scripts = "";
                	jScripts.each(function() {
    					scripts += $(this).html();
    				});
                	$('#' + tableId).append("<script>" + scripts + "</script>");
                }
        	}
        	else {
        		$("#" + divID).replaceWith(resp);
        	}
            changeLinks(tableId, divID, action);
        }

    });
}