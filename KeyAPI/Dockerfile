FROM node:12

WORKDIR /app/user_service

COPY package*.json ./

RUN npm install

COPY . .

CMD [ "npm", "run", "start" ]