<template>
  <v-content>
    <v-container>
      <v-row>
        <IngredientInput
          v-bind:loading="loading"
          v-on:searchComplete="getCompleteDrinks($event)"
          v-on:searchRanked="getRankedDrinks($event)"
        />
      </v-row>
      <v-row justify="center">
        <div v-for="(cocktail, i) in cocktails" :key="i">
          <CocktailDisplay :cocktail="cocktail" class="cocktailDisplay" />
        </div>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import CocktailDisplay from "@/components/CocktailDisplay.vue";
import IngredientInput from "@/components/IngredientInput.vue";

export default {
  name: "Home",
  components: {
    CocktailDisplay,
    IngredientInput
  },
  data() {
    return {
      cocktails: [],
      ingredients: [],
      loading: false
    };
  },
  methods: {
    /**
     * @vuese
     * used to itterate through a list of ingredients and find the cocktails that can be made for them, it also has the functionality to filter out cocktails the program already has in memory out of the search
     * @arg The argument for this method is an Array of Strings consisting of the ingredients you want scanned
     */
    getCompleteDrinks: async function(ing) {
      this.loading = true;
      this.cocktails = await this.$dao.getCompleteDrinks(ing);
      this.loading = false;
    },
    getRankedDrinks: async function(ing) {
      this.loading = true;
      this.cocktails = await this.$dao.getRankedDrinks(ing);
      this.loading = false;
    }
  }
};
</script>

<style scoped>
.cocktailDisplay {
  margin: 20px;
}
</style>
