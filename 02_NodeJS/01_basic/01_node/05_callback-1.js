const order = (str, callback) => {
  console.log(`${str} 주문 접수`);
  setTimeout(() => {
    callback(str);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

order('아메리카노', display);
