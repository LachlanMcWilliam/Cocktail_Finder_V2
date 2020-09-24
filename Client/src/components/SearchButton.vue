<template>
  <v-tooltip top>
    <template v-slot:activator="{ on, attrs }">
      <v-btn block v-bind="attrs" v-on="on">{{ this.buttonData.text }}</v-btn>
    </template>
    <span>{{ this.buttonData.tooltip }}</span>
  </v-tooltip>
</template>

<script>
export default {
  props: {
    buttonData: {
      type: Object,
      required: true
    }
  }
};
</script>
