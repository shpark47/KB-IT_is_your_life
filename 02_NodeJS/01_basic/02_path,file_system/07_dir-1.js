const fs = require('fs');

const files = fs.readdirSync('./');
for (let i = 0; i < files.length; i++) {
  if (files[i] == 'test') {
    console.log('이미 폴더가 있습니다.');
    return;
  }
}

fs.mkdirSync('./test');
