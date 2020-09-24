const express = require("express");
const fs = require("fs");

let keys = "";

if (fs.existsSync("./keys.js")) {
  keys = require("./keys");
} else {
  keys = { key: process.env.API_KEY } || { key: "1" };
}

const app = express();
const PORT = process.env.PORT || 5001;

app.get("/cocktail_key", (req, res) => {
  res.json(keys);
});

app.listen(PORT, () => {
  console.log(`User service listening at http://localhost:${PORT}`);
});
