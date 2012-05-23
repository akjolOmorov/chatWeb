jQuery.fn.inputValue = function(options)
{
	var settings = jQuery.extend({allow:'', disallow:''}, options);
	return jQuery(this).keypress
		(
			function (e)
				{
					var code;
					if (!e.charCode)
						code = String.fromCharCode(e.which);
					else
						code = String.fromCharCode(e.charCode);							
					if(code && (typeof(e.keyCode) == 'undefined' || (e.keyCode != 8 && e.keyCode != 46)))
					{										
						if(settings.allow.length != 0 && settings.disallow.length != 0)
						{
							if(settings.allow.indexOf(code) == -1)
							{
								e.preventDefault();
							}else if(settings.disallow.indexOf(code) != -1)
							{
								e.preventDefault();
							}
						}else if(settings.allow.length != 0)
						{
							if(settings.allow.indexOf(code) == -1)
							{
								e.preventDefault();
							}						
						}else if(settings.disallow.length != 0)
						{
							if(settings.disallow.indexOf(code) != -1)
							{
								e.preventDefault();
							}
						}						
					}
					if (e.ctrlKey && code=='v')
						e.preventDefault();	
					$(this).bind('contextmenu',function () {return false;});					
				}				
		);		
		
};
/**
*	input fields will accept valid email address
*/
jQuery.fn.inputEmail = function()
{
		return this.each (function()
			{
				jQuery(this).inputValue({allow:'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@.0123456789'});
			}
		);		
};
/**
*	input fields will accept digits only
*/
jQuery.fn.inputInteger = function()
{
		return this.each (function()
			{
				jQuery(this).inputValue({allow:'9876543210'});
			}
		);	
};
/**
*	input fields will accept digits and dots.
*/
jQuery.fn.inputFloat = function()
{
		return this.each (function()
			{
				jQuery(this).inputValue({allow:'0123456789.'});
			}
		);		
};
/**
*	input fields will accept all letters (case insensitive)
*/
jQuery.fn.inputLetter = function()
{
		return this.each (function()
			{
				jQuery(this).inputValue({allow:'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'});
			}
		);		
};