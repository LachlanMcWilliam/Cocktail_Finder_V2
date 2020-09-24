<template>
  <v-card max-width="400" ma-5>
    <v-img height="400px" v-bind:src="cocktail.thumbnail"></v-img>
    <v-card-title v-if="hasAccuracy" class="black--text align-center"
      >{{ cocktail.name }}: {{ cocktail.accuracy }}%</v-card-title
    >
    <v-card-title v-else class="black--text align-center">{{
      cocktail.name
    }}</v-card-title>
    <v-card-actions class="text-center">
      <CocktailInfoDisplay>
        <v-img
          slot="thumbnail"
          lazy-src="src\assets\preview.jpg"
          min-height="700"
          min-width="700"
          :src="cocktail.thumbnail"
        >
          <template v-slot:placeholder>
            <v-row class="fill-height ma-0" align="center" justify="center">
              <v-progress-circular
                indeterminate
                color="grey lighten-5"
              ></v-progress-circular>
            </v-row>
          </template>
        </v-img>
        <v-card-title slot="title" primary-title>{{
          cocktail.name
        }}</v-card-title>
        <v-card-text slot="instructions" class="pt-0 pb-0">{{
          cocktail.instructions
        }}</v-card-text>
        <div
          slot="ingredients"
          v-for="ingredient in cocktail.ingredients"
          :key="ingredient.name"
        >
          <v-card-text v-if="!hasAccuracy" class="pt-0 pb-0"
            >{{ ingredient.name }}: {{ ingredient.measure }}</v-card-text
          >
          <v-card-text v-else class="pt-0 pb-0">
            <v-icon v-if="ingredient.has"
              >mdi-checkbox-blank-circle-outline</v-icon
            >
            <v-icon v-else>mdi-checkbox-marked-circle-outline</v-icon>
            {{ ingredient.name }}: {{ ingredient.measure }}
          </v-card-text>
        </div>
      </CocktailInfoDisplay>
    </v-card-actions>
  </v-card>
</template>

<script>
import CocktailInfoDisplay from "./CocktailInfoDialog";
//This component displays the thumbnail and name of the cocktail and contains a "CocktailInfoDisplay" componant as a child componant
export default {
  name: "CocktailDisplay",
  components: {
    CocktailInfoDisplay
  },
  props: {
    //The cocktail object that is to be displayed
    cocktail: {
      type: Object,
      required: true
    }
  },
  computed: {
    hasAccuracy: function() {
      return this.cocktail.accuracy < 1000;
    }
  }
};
</script>
