var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'EmailSender', 'coolMethod', [arg0]);
};

module.exports.send = function (arg0, success, error) {
    exec(success, error, 'EmailSender', 'send', [arg0]);
};

