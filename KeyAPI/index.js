const express = require("express");
let keys = "";

try {
  keys = require("./keys");
} catch (err) {
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
