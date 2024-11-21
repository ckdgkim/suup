window.addEventListener('scroll', function () {
  let favTexts = document.querySelectorAll(".fav-text");
  let value = scrollY;
  console.log(value);
  if(value > 400) {
   favTexts.forEach((item) => item.style.animation = "slideBackward 3s ease-in-out forwards");
  } else {
    favTexts.forEach((item) => item.style.animation = "slideForward 3s ease-in-out");
  }
})