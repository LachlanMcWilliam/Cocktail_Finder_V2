// Firebase App (the core Firebase SDK) is always required and
// must be listed before other Firebase SDKs
var firebase = require("firebase/app");

// Add the Firebase products that you want to use
require("firebase/auth");

const firebaseConfig = {
  apiKey: "AIzaSyAeey345o6NPos5jINi60y07lNoWu-Trvc",
  authDomain: "cocktails-801b1.firebaseapp.com",
  databaseURL: "https://cocktails-801b1.firebaseio.com",
  projectId: "cocktails-801b1",
  storageBucket: "cocktails-801b1.appspot.com",
  messagingSenderId: "421183555393",
  appId: "1:421183555393:web:3c1557df487009322083c0",
  measurementId: "G-QY5MZ71YSY"
};

firebase.initializeApp(firebaseConfig);

const auth = firebase.auth();

module.exports = { auth };
