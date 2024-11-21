let student1 = {
    name : "hong",
    score : 90
}

let student2 = student1 ;
let student3 = {...student1};
student2.age = 20;
student3.school = "kosta";

console.log(student1 == student2);
console.log(student2 == student3);
console.log(student1);
console.log(student2);
console.log(student3);