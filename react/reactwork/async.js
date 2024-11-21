setTimeout(function(){
    console.log("2 -- 비동기 함수입니다.")
}, 3000);
a();

function a() {
    console.log("1 --동기 함수입니다.");
}

function c() {
    console.log("동기 함수입니다.");
}