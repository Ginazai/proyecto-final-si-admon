$(document).ready(() => {
	console.log(document.readyState);
	if (document.readyState == "loading") {
		console.log("doc not ready");
		$(".content").addClass("visually-hidden");
		$("#load-icon").removeClass("visually-hidden");
	} else {
		console.log("doc ready");
		$(".content").removeClass("visually-hidden");
		$("#load-icon").addClass("visually-hidden");
	}
});