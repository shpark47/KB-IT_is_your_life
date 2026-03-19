const fs = require('fs');

fs.readdir('./test2', (err, data) => {
  if (err) {
    fs.mkdirSync('./test2/test3/test4', { recursive: true });
    return;
  }
  console.log('폴더가 있습니다');
});
