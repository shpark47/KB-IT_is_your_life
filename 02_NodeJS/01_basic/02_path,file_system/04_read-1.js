// 동기
const fs = require('fs');

const data = fs.readFileSync('./example.txt', 'utf-8');
console.log(data);

// 비동기
const fs = require('fs');

fs.readFile('./example.txt', 'utf-8', (error, data) => {
  if (error) {
    console.log(error);
  }
  console.log(data);
});
