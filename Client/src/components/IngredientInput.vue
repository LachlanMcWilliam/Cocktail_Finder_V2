<template>
  <v-container>
    <v-row>
      <v-autocomplete
        v-model="userIngredients"
        :items="possibleIngredients"
        :loading="loadingIngredients"
        outlined
        chips
        deletable-chips
        label="Ingredients"
        multiple
      ></v-autocomplete>
    </v-row>
    <v-row>
      <v-col v-for="(button, index) in btns" :key="index">
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              block
              v-bind="attrs"
              v-on="on"
              @click="search(button)"
              :loading="loading"
              >{{ button.text }}</v-btn
            >
          </template>
          <span>{{ button.tooltip }}</span>
        </v-tooltip>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  props: {
    loading: Boolean
  },
  data: () => ({
    possibleIngredients: [],
    userIngredients: [],
    loadingIngredients: false,
    btns: [
      {
        text: "Search Complete Cocktails",
        tooltip:
          "This takes a list of ingredients and provides a list of cocktails you can make using them",
        searchType: "searchComplete"
      },
      {
        text: "Search For Best Fit Cocktails",
        tooltip:
          "This takes a list of ingredients and provides a list of cocktails ranked by how many of those ingredients they possess",
        searchType: "searchRanked"
      }
    ]
  }),
  mounted() {
    this.getIngredients();
  },
  methods: {
    search: function(button) {
      button.loading = true;
      this.$emit(button.searchType, this.userIngredients);
    },
    completedLoading(button) {
      button.loading = false;
    },
    getIngredients: async function() {
      this.loadingIngredients = true;
      this.possibleIngredients = await this.$dao.getIngredients();
      this.loadingIngredients = false;
    }
  }
};
</script>

<style></style>
