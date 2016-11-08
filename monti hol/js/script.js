function getRandomInt(min, max) {
	return Math.floor(Math.random() * (max - min)) + min;
}

var k = getRandomInt(1,4);
var l = 0;
var n = 0;
var statik = 0;
$("div#"+k).attr('id','winner');

function restart() {
	location.reload();
}




$("div.closed").click(function() {
	if (l == 0) {
		$(this).removeClass('closed').addClass('selected');
		l=l+1;
		statik++;
		if (k==1 && $('div.main div#'+(k+1)).attr('class')!='selected') {
			$('div.main div#'+(k+1)).addClass('opened_lose').removeClass('closed');
		}
		else if (k==1 && $('div.main div#'+(k+2)).attr('class')!='selected') {
			$('div.main div#'+(k+2)).addClass('opened_lose').removeClass('closed');
		}
		if (k==2 && $('div.main div#'+(k+1)).attr('class')!='selected') {
			$('div.main div#'+(k+1)).addClass('opened_lose').removeClass('closed');
		}
		else if (k==2 && $('div.main div#'+(k-1)).attr('class')!='selected') {
			$('div.main div#'+(k-1)).addClass('opened_lose').removeClass('closed');
		}
		if (k==3 && $('div.main div#'+(k-1)).attr('class')!='selected') {
			$('div.main div#'+(k-1)).addClass('opened_lose').removeClass('closed');
		}
		else if (k==3 && $('div.main div#'+(k-2)).attr('class')!='selected') {
			$('div.main div#'+(k-2)).addClass('opened_lose').removeClass('closed');
		}
	} 
})

function changeDoor() {
	if (statik==1) {
		$('div.selected').addClass('closed_c').removeClass('selected');
		$('div.closed').addClass('selected').removeClass('closed')
		$('button#change').addClass('hidden');
		statik++;
	}
}

function openDoor() {
	if (statik==2) {
		if ($('div.selected').attr('id')=='winner') {
			$('div.selected').addClass('opened_win').removeClass('selected');
		} else {
			$('div.selected').addClass('opened_lose').removeClass('selected');
		}
		$('button#open').addClass('hidden');
	}
	if (statik==1) {
		if ($('div.selected').attr('id')=='winner') {
			$('div.selected').addClass('opened_win').removeClass('selected');
		} else {
			$('div.selected').addClass('opened_lose').removeClass('selected');
		}
		$('button#open').addClass('hidden');
		$('button#change').addClass('hidden');
	}
}





