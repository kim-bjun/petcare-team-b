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
			window.location.reload();
		},
		error: function(error) {
			console.log('Logout Error');
		}
	});
}