const fs = require('fs');

let files = fs.readdirSync('./');
for (let i = 0; i < files.length; i++) {
  if (files[i] == 'text-1.txt') {
    console.log('파일이 존재합니다.');
    return;
  }
}

const data = fs.readFileSync('./example.txt', 'utf-8');
fs.writeFileSync('./text-1.txt', data);
console.log('파일 저장 완료');
