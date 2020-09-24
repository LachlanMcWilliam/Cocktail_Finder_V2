# Cocktail Finder V2

### Table of Contents

- [About The Project](#about-the-project)
- [Description](#description)
- [TODO](#todo)
- [How To Use](#how-to-use)
- [License](#license)
- [Author Info](#author-info)

---

## About The Project

So if you want to know why I'm doing this project then you can have a look at the repo for V1 of this project, found here: [Version 1](https://github.com/LachlanMcWilliam/Cocktail-Finder)

The reason for the new project is a change of focus from myself, I wanted to move and create something slightly different and stick to what I knew better (Java over Golang in this case) but didn't want to erase or overwrite all I had done for that project, so it shall remain a relic of this project's past.

---

## TODO:

- [x] Basic web front end (take in ingredients and display drinks)
- [x] Basic api functionality (Able to get the possible drinks)
- [x] Api concurrency
- [x] App Dockerization
- [ ] Firebase authentication
- [ ] User logins and drink saving
- [ ] Able to ignore certain ingredients as conditions (eg. water, ice)
- [ ] Able to search for a specific drink and view ingredients
- [ ] (Maybe) Some web session functionality, alt just save user ingredients to browser storage
- [ ] Fix whatever mess this project will become so it makes at least some sense

[Back To The Top](#table-of-contents)

---

## Description

The webapp in its current form takes a list of ingredients from the user, it then sends them on to an intermediary API to process the ingredients and pull the drinks they can make from [thecocktaildb](https://www.thecocktaildb.com/) API

[Back To The Top](#table-of-contents)

#### Technologies

Everything is run inside of docker

Client built with:

- JavaScript
- VueJS
- Axios
- Vuetify

API built with:

- Java
- Spring

Key API built with:

- JavaScript
- Express

[Back To The Top](#table-of-contents)

---

## How To Use

You will need Docker installed (yes technically you _can_ do it without, but docker makes it easier). From the root directory of the project run `docker-compose up` and it should spin up (it may need to download some images to your system).

The above will run the project with a default API key of '1' this is the development key for the cocktaildb API and it puts limits on the functionality of the app, to get a key you can visit their [patreon](https://www.patreon.com/thedatadb).

To add your key there are 2 options:

- Create a file in the root directory of the KeyAPI called 'keys.js' and export an object from said file using this signature: `{key: "YOUR_KEY_HERE"}`

- Add the key as an environment variable in the key service as the following: `KEY: "YOUR_KEY_HERE"`

[Back To The Top](#table-of-contents)

---

## License

MIT License

Copyright (c) 2020 Lachlan McWilliam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[Back To The Top](#table-of-contents)

---

## Author Info

- Linkedin - [Lachlan McWilliam](https://www.linkedin.com/in/lachlan-mcwilliam/)

[Back To The Top](#table-of-contents)
