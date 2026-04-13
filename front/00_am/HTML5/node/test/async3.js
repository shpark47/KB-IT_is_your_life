function wait3초() {
  return new Promise((resolve) => {
    setTimeout(() => resolve('완료!'), 3000);
  });
}
console.log('시작');
wait3초().then((결과) => {
  console.log(결과);
  console.log('다음 코드'); // ← 여기로 이동
});
