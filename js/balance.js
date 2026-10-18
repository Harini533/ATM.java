// Get the logged-in card number
let cardNumber = localStorage.getItem("cardNumber");

// Display Balance from Database
function checkBalance() {

    if (!cardNumber) {
        document.getElementById("balance").innerHTML =
            "Card number not found.";
        return;
    }

    fetch("balance?cardNumber=" + cardNumber)
        .then(response => response.text())
        .then(data => {

            document.getElementById("balance").innerHTML = data;

        })
        .catch(error => {

            console.error(error);

            document.getElementById("balance").innerHTML =
                "Unable to fetch balance.";

        });
}


// Show Current Date
const dateElement = document.getElementById("date");

if (dateElement) {

    dateElement.innerHTML =
        new Date().toLocaleDateString("en-IN");

}


// Show Current Time
function updateTime() {

    const timeElement =
        document.getElementById("time");

    if (timeElement) {

        timeElement.innerHTML =
            new Date().toLocaleTimeString("en-IN");

    }

}

updateTime();

setInterval(updateTime, 1000);