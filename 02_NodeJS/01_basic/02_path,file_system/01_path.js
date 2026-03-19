const path = require('path');
const fullpath = path.join('some', 'work', 'ex.txt');
console.log(fullpath);

const dir = path.dirname(__filename);
console.log(`파일 절대 경로 : ${__filename}`);
console.log(`경로만 : ${dir}`);

const fn1 = path.basename(__filename);
const fn2 = path.basename(__filename, '.js');
console.log(`파일이름 : ${fn1}`);
console.log(`파일 이름(확장자 제외) : ${fn2}`);

const ext = path.extname(__filename);
console.log(`파일 확장자 : ${ext}`);

const parsePath = path.parse(__filename);
console.log(parsePath);
