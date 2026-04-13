const user = require('./user'); // user.js에서 user 가져오기

// 1. modules.exports에 함수를 할당하는 방식
const hello = require('./hello'); // hello.js에서 hello 가져오기

// 2. exports 객체에 속성으로 선언하는 방식
// const { hello } = require("./hello.js");

console.log(user);
console.log(hello);
hello(user); // 모듈에서 가져온 user 변수와 hello 함수 사용하기
