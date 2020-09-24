const axios = require("axios");

const getIngredients = async () => {
  try {
    return await axios.get(`http://lvh.me:8080/getIngredients`);
  } catch (error) {
    //eslint-disable-next-line
    console.log(error);
  }
};

const getRankedCocktails = async ing => {
  try {
    return await axios.post("http://lvh.me:8080/getRankedCocktails", {
      ingredients: ing
    });
  } catch (error) {
    //eslint-disable-next-line
    console.log(error);
  }
};

const getCompleteCocktails = async ing => {
  try {
    return await axios.post("http://lvh.me:8080/getCheckedCocktails", {
      ingredients: ing
    });
  } catch (error) {
    //eslint-disable-next-line
    console.log(error);
  }
};

module.exports = { getIngredients, getRankedCocktails, getCompleteCocktails };
