// 동기
const fs = require('fs');

const data = fs.readFileSync('./example.txt', 'utf-8');

fs.writeFileSync('./text-1.txt', data);

// 비동기
const fs = require('fs');

fs.readFile('./example.txt', 'utf-8', (error, data) => {
  if (error) {
    console.log(error);
  }
  fs.writeFile('./text-1.txt', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('파일 저장 완료');
  });
});
