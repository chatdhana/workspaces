(function($){
	
	
	/////////////// bgIframe plug-in /////////////////
	$.fn.bgiframe = ($.browser.msie && /msie 6\.0/i.test(navigator.userAgent) ? function(s) {
	    s = $.extend({
	        top     : 'auto', // auto == .currentStyle.borderTopWidth
	        left    : 'auto', // auto == .currentStyle.borderLeftWidth
	        width   : 'auto', // auto == offsetWidth
	        height  : 'auto', // auto == offsetHeight
	        opacity : true,
	        src     : 'javascript:false;'
	    }, s);
	    var html = '<iframe class="bgiframe"frameborder="0"tabindex="-1"src="'+s.src+'"'+
	                   'style="display:block;position:absolute;z-index:-1;'+
	                       (s.opacity !== false?'filter:Alpha(Opacity=\'0\');':'')+
	                       'top:'+(s.top=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+\'px\')':prop(s.top))+';'+
	                       'left:'+(s.left=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+\'px\')':prop(s.left))+';'+
	                       'width:'+(s.width=='auto'?'expression(this.parentNode.offsetWidth+\'px\')':prop(s.width))+';'+
	                       'height:'+(s.height=='auto'?'expression(this.parentNode.offsetHeight+\'px\')':prop(s.height))+';'+
	                '"/>';
	    return this.each(function() {
	        if ( $(this).children('iframe.bgiframe').length === 0 )
	            this.insertBefore( document.createElement(html), this.firstChild );
	    });
	} : function() { return this; });

	// old alias
	$.fn.bgIframe = $.fn.bgiframe;

	function prop(n) {
	    return n && n.constructor === Number ? n + 'px' : n;
	}
	/////////////// bgIframe plug-in ends /////////////////
	
	
	// Global within this jQuery Object
		
		var noDataFoundValue = '-NO DATA FOUND-';
		var globalOptions = {};
		
	   $.fn.instantSearchFn = function(options){
		  return this.each(function(){
	    	var instantSearch = true;
			var waitTimePeriod = 1000; // in milliseconds
			var timeOutObj = null;
			var minNoOfCharsForSrch = 3;
			
			globalOptions[options.fieldName]={
					'instantSearchURL':			options.instantSearchURL ,
					'suggestionsHolderDivId': 	options.suggestionsHolderDivId, 
					'fieldName': 				options.fieldName, 
					'formName': 				options.formName,
					'queryFieldNameJQuery':		"#"+options.fieldName,
					'instSrchQryFldOldValue':	new Object()
			
			};
			
			specialKeys = {
				/*8: "backspace",*/ 9: "tab", /*13: "return",*/ 16: "shift", 17: "ctrl", 18: "alt", 19: "pause",
				20: "capslock", /*27: "esc", 32: "space",*/ 33: "pageup", 34: "pagedown", /*35: "end", 36: "home",*/
				37: "left",/* 38: "up",*/ 39: "right",/* 40: "down",*/ 45: "insert", /*46: "del",*/ 
				/*96: "0", 97: "1", 98: "2", 99: "3", 100: "4", 101: "5", 102: "6", 103: "7",
				104: "8", 105: "9", 106: "*", 107: "+", 109: "-", 110: ".", 111 : "/", */
				112: "f1", 113: "f2", 114: "f3", 115: "f4", 116: "f5", 117: "f6", 118: "f7", 119: "f8", 
				120: "f9", 121: "f10", 122: "f11", 123: "f12", 144: "numlock", 145: "scroll", 191: "/", 224: "meta"
			};
			
			timeOutObj = setTimeout(function() {}, 10);
			
			 //Listener for losing focus
			  
			 $(this).blur(function() {
				clearTimeout(timeOutObj);
				var localOptions =globalOptions[this.id]; 
				$(localOptions.suggestionsHolderDivId).css('display', 'none');
				$(localOptions.suggestionsHolderDivId).html('');
			 });
			 
			 //Listener key press (down event)on search box.
			
			 $(this).keydown(function(e) {
				 var localOptions =globalOptions[this.id];
				 var searchQuery = $(this).val();
				 var code = (e.keyCode ? e.keyCode : e.which);
				 var listItem = '';
				 if(code === 13) { //'return key' is pressed
					 $(localOptions.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
					 clearTimeout(timeOutObj);
					 $(localOptions.queryFieldNameJQuery).blur();
					 return false;
				 }
			 });
			 
			//Listener key press (up event) on search box.
			 $(this).keyup(function(e) {
				 
				 var localOptions = globalOptions[this.id];
				 
				 var searchQuery = $(this).val();
				 var code = (e.keyCode ? e.keyCode : e.which);
				 var listItem = '';
				 if(specialKeys[code]){
					 return false;
				 }
				 if(code === 13 || code === 35 ||code === 36 ||code === 37 ||code === 38 ||code === 39 ||code === 40){
					if(code === 13) { //'return key' is pressed
						 $(localOptions.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
						 clearTimeout(timeOutObj);
						 $(localOptions.queryFieldNameJQuery).blur();
					 } else if(code === 37 || code === 39) { //'left' or 'right' arrow
						 // ignore
					 } else if(code === 36 || code === 35) { //'Home' or 'End' is pressed 
						 listItem = $('tr.suggestionRow td.selected');
						 listItem.removeClass('selected');
						 
						 if(code === 36) // 'Home' key
						 $("tr.suggestionRow:first td").addClass('selected');
						 if(code === 35) // 'End' key
						 $("tr.suggestionRow:last td").addClass('selected');
						 
						 if($("tr.suggestionRow td.selected").text().length > 0) {
							if($("tr.suggestionRow td.selected").text() != noDataFoundValue){
								 	$(localOptions.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
							}
						 }
						 
					 } else if(code === 40) { //'down arrow' is pressed
						 if($('tr.suggestionRow td.selected').length === 0) { // Go to first item
							 $("tr.suggestionRow:first td").addClass('selected');
						 } else { //move down
							 listItem = $('tr.suggestionRow td.selected');
							 listItem.parent().next().find('td').addClass('selected');
							 listItem.removeClass('selected');
						 }
						 
						 if($("tr.suggestionRow td.selected").text().length > 0){
							 if($("tr.suggestionRow td.selected").text() != noDataFoundValue){
							 	$(localOptions.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
							 }
						 }
					 } else if(code === 38) {//'up arrow' is pressed
						 if($("tr.suggestionRow td.selected").length === 0) { // Go to last item
							 $("tr.suggestionRow:last td").addClass('selected');
						 } else { //move up
							 listItem = $("tr.suggestionRow td.selected");
							 listItem.parent().prev().find('td').addClass('selected');
							 listItem.removeClass('selected');
						 }
						 
						 if($("tr.suggestionRow td.selected").text().length > 0) {
							if($("tr.suggestionRow td.selected").text() != noDataFoundValue){
								 	$(localOptions.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
							}
						 }
					 } 
				 } else {

					if(searchQuery == '' || searchQuery.length < minNoOfCharsForSrch) {
						$(localOptions.suggestionsHolderDivId).html('');
						//$(localOptions.suggestionsHolderDivId).css('display', 'none');
						return;
					}
					/*
					if(localOptions.instSrchQryFldOldValue[localOptions.formName+'.'+localOptions.fieldName] != null && ((localOptions.instSrchQryFldOldValue[localOptions.formName+'.'+localOptions.fieldName]).toUpperCase() ==  searchQuery.toUpperCase())){
						$(localOptions.suggestionsHolderDivId).css('display', 'block');
						return;
					}
					*/
					 
					if(instantSearch) {
						localOptions.instSrchQryFldOldValue[localOptions.formName+'.'+localOptions.fieldName]= searchQuery;
						clearTimeout(timeOutObj);
						timeOutObj = setTimeout(function() {
							instantSearchServerProxy(localOptions,searchQuery,localOptions.formName+'.'+localOptions.fieldName);
						 }, waitTimePeriod);
					}
				 }
			 }); // end of keyup
			 
	      }); // end of each
	   };
	   
	   /*
	    * Function that is called to contact server /  search engine and retrieve the result.
	    * -> Ajax call: options(Server URL and Div Id), Query, Field Unique Identifier(FormName.fieldName)
		*/
	   function instantSearchServerProxy(options,searchQuery,fieldId){
		   var resDataArry = new Array();
		   var resultHtml = '';
		   
		   $.ajax({
				  type: "POST",
				  url: options.instantSearchURL,
				  data: encodeURI('queryString='+searchQuery+'&fieldId='+fieldId),
				  cache : false,
//				  timeout: 10000,
				  success: function(resData) {
					//alert(resData);
					resDataArry = eval('['+resData+']');
					$(options.suggestionsHolderDivId).html('');
					if(resDataArry.length > 0) {//border-collapse: collapse;  width:'+$(options.queryFieldNameJQuery).css("width")+'"
						resultHtml = resultHtml.concat('<table style="border:solid thin; border-color: silver; width:'+(parseInt($(options.queryFieldNameJQuery).css("width").replace("px", ""),10)+10)+'px;">');
						$.each(resDataArry, function(index,value){
							if(value != ''){
							resultHtml = resultHtml.concat('<tr class="suggestionRow" id="suggestion'+index+'">');
							resultHtml = resultHtml.concat('<td class="suggestionTd">'+value+'</td>');
							resultHtml = resultHtml.concat('</tr>');
							}
						});
						resultHtml = resultHtml.concat('</table>');
						$(options.suggestionsHolderDivId).html(resultHtml);
						$(options.suggestionsHolderDivId).css('display', 'block');
						$(options.suggestionsHolderDivId).css('position', 'absolute');
						$(options.suggestionsHolderDivId).css('z-index', '999');
						$(options.suggestionsHolderDivId).css('left', $(options.queryFieldNameJQuery).css('left'));
						$(options.suggestionsHolderDivId).css('top', $(options.queryFieldNameJQuery).css('top'));
						//$(options.suggestionsHolderDivId).css('opacity', '5.0');
						//$(options.suggestionsHolderDivId).css('filter', 'alpha(opacity=500)');
						
						$('.suggestionTd').css('font-size', $(options.queryFieldNameJQuery).css('font-size'));
						$('.suggestionTd').css('font-family', $(options.queryFieldNameJQuery).css('font-family'));
						$('.suggestionTd').css('height', '10pt');

						$('tr.suggestionRow').css('size', $(options.queryFieldNameJQuery).size);

						// Select Box Overlapping issue.
						$(options.suggestionsHolderDivId).bgiframe();
						
						// Binding Hover event
						$(".suggestionRow").hover(
							function handIn() {
								if($(this).text() != noDataFoundValue) {
									$(options.queryFieldNameJQuery).val($(this).text());
								}
								$('tr.suggestionRow td.selected').removeClass('selected');
								$(this).find('td').addClass('selected');
							},
							function handOut() {
								$(this).find('td').removeClass('selected');
						});
						
						$(".suggestionRow").click(function(){
							if($("tr.suggestionRow td.selected").text().length > 0) {
								if($("tr.suggestionRow td.selected").text() != noDataFoundValue){
								 	$(options.queryFieldNameJQuery).val($("tr.suggestionRow td.selected").text());
								 }
							}
							$(options.queryFieldNameJQuery).blur();
						});
					}
				  }
			 });
	   }
	   
	   
})(jQuery); // End of jQuery Object
