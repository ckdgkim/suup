function show(imgName) {
  let img = document.getElementById("img");
  img.src="images/" + imgName;
}

function hide() {
  let img = document.getElementById("img");
  img.src="";
}