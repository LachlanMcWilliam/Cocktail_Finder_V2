import Vue from "vue";
import "./plugins/axios";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";

const dao = require("./dao");
//import "material-design-icons-iconfont/dist/material-design-icons.css";

Vue.config.productionTip = false;
Vue.prototype.$dao = dao;

new Vue({
  router,
  store,
  dao,
  vuetify,

  render: function(h) {
    return h(App);
  }
}).$mount("#app");
