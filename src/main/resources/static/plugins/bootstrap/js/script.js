 document.onreadystatechange = function () {
	if (document.readyState !== "complete") {
	    document.querySelector(
	        ".content").style.visibility = "hidden";
	    document.querySelector(
	        "#load-icon").style.visibility = "visible";
	} else {
	    document.querySelector(
	        "#load-icon").style.display = "none";
	    document.querySelector(
	        ".content").style.visibility = "visible";
	}
	};