<template>
  <v-dialog v-model="dialog" width="1100">
    <template v-slot:activator="{ on }">
      <v-btn block v-on="on">More Info</v-btn>
    </template>

    <v-card>
      <v-container>
        <v-row no-gutters>
          <v-col>
            <!-- Cocktail Thumbnail -->
            <slot name="thumbnail" />
          </v-col>
          <v-col>
            <div class="d-flex">
              <!-- Cocktail Title -->
              <slot name="title">
                <v-card-title>{{ errorText }}</v-card-title>
              </slot>
              <v-spacer></v-spacer>
              <v-btn icon color="primary" text @click="dialog = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
            </div>
            <v-card-subtitle class="pb-0 pt-3">Instructions:</v-card-subtitle>
            <!-- Instructions how to make the cocktail -->
            <slot name="instructions"
              ><v-card-text>{{ errorText }}</v-card-text></slot
            >
            <v-card-subtitle class="pb-0">Ingredients:</v-card-subtitle>
            <!-- Cocktail ingredients and measures -->
            <slot name="ingredients"
              ><v-card-text>{{ errorText }}</v-card-text></slot
            >
            <v-card-actions bottom></v-card-actions>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "CocktailInfoDisplay",
  data() {
    return {
      dialog: false,
      errorText: "Oops! Something seems to have gone wrong :("
    };
  }
};
</script>

<style scoped></style>
