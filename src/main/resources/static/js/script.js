// change theme work
let currentTheme = getTheme();

//initial -->
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page
  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", event => {
    let oldTheme = currentTheme;
    // change the current theme
    if (currentTheme === "dark") {
      //set to light
      currentTheme = "light";
    } else {
      //set to dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localStorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localStorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  // Update the localStorage
  setTheme(currentTheme);
  //remove the current theme
  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);
  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}

//end change page theme
