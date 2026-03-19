// 1. modules.exports에 함수를 할당하는 방식
const hello = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};

module.exports = hello;

// 2. exports 객체에 속성으로 선언하는 방식
// exports.hello = (name) => {
//   console.log(`${name}님, 안녕하세요?`);
// };
