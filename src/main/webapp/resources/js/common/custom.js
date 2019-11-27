function parseQueryString(str) {

	str = str ? str : location.search;
//	console.log(str);
	var query = str.charAt(0) == '?' ? str.substring(1) : str;

	var args = new Object();

	if (query) {

		var fields = query.split('&');

		for (var f = 0; f < fields.length; f++) {

			var field = fields[f].split('=');

			args[unescape(field[0].replace(/\+/g, ' '))] = field[1].replace(/\+/g, ' ');

		}

	}

	return args;

}

$(function() {
	$('.pagination a').bind('click', function(e) {
		e.preventDefault();
		
		var args = parseQueryString();
		var items = [];
		
		if ($(this).attr('data-page') == undefined) return false;
		
		args['page'] = $(this).attr('data-page');

		for ( var arg in args) {
			items.push(arg + '=' + args[arg]);
		}
		var queryString = items.join('&');
		
//		console.log(window.location.pathname + '?' + queryString);
		
		window.location.href = window.location.pathname + '?' + queryString;
	});

	$('.dropdown-submenu>a').on('click', function() {
		$(this).parent().siblings().find('.dropdown-menu').hide();
		$(this).next().toggle();
		return false;
	});
	$('a.dropdown-toggle').on('click', function() {
		$('.dropdown-submenu .dropdown-menu').hide();
		// return false;
	});
});