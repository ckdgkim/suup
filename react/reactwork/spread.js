let a = [1,2];
let b = [...a];
let c = a;
let d = [3,4];
c.concat(b);

console.log(a == c);
console.log(a == b);

console.log(c);
console.log(b);
console.log(a);
console.log(e);
