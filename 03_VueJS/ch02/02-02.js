/* ### let
  - 블록 단위로 유효범위가 지정되는 변수
  - 중복으로 선언 불가
*/

let msg = 'GLOBAL';
function outer() {
  let msg = 'OUTER';
  console.log(msg);
  if (true) {
    let msg = 'BLACK';
    console.log(msg);
  }
}
outer();
