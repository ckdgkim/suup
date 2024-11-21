async function f1() {
    return 1;
}

f1().then((value) => console.log(value));

function f2() {
    return 2;
}

let value = f2();
console.log(value);

async function f3() {
    let promise = new Promise((resolve, reject) => {
        setTimeout(() => (resolve("완료!!!")), 1000);
    })
    let result = await promise;
    console.log(result);
}