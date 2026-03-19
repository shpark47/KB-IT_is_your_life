const { user1, user2 } = require('./users-1');
const hello = require('../06_app-1/hello');
// ../  : 상위
// ./   : 현재 위치
// /    : 하위

hello(user1);
hello(user2);
