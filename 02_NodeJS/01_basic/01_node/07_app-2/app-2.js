const users = require('./users-1');
const hello = require('../06_app-1/hello');

for (const user in users) {
  hello(users[user]);
}
