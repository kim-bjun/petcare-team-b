$(function() {
	init();
});

function init() {
	eventTrigger();
}

function eventTrigger() {
	$('#logout').on('click', function() {
		logout();
	});
}

function logout() {
	$.ajax({
		type: 'GET',
		url: '/user/logout',
		success: function(result) {
			window.location.href='http://localhost:8080/';
			console.log('Logout Success');
		},
		error: function(error) {
			console.log('Logout Error');
		}
	});
}