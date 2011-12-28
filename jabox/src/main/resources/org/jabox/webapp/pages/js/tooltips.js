// execute your scripts when the DOM is ready. this is a good habit
$(function() {


// select all desired input fields and attach tooltips to them
$("#myform :input").tooltip({

	// place tooltip on the right edge
	position: "center right",

	// a little tweaking of the position
	offset: [-2, 10],

	// use the built-in fadeIn/fadeOut effect
	effect: "fade",

	// custom opacity setting
	opacity: 0.7

});
});

