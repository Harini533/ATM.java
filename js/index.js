function login() {

    let cardNumber =
        document.getElementById("cardNumber").value.trim();

    let pin =
        document.getElementById("pin").value.trim();

    if (cardNumber === "" || pin === "") {
        alert("Please enter Card Number and PIN.");
        return;
    }

    fetch("login", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body:
            "cardNumber=" + encodeURIComponent(cardNumber) +
            "&pin=" + encodeURIComponent(pin)
    })
    .then(response => response.text())
    .then(data => {

        if (data.includes("Login Successful!")) {

            localStorage.setItem("cardNumber", cardNumber);

            alert("Login Successful!");

            window.location.href = "dashboard.html";

        } else {

            alert("Invalid Card Number or PIN.");

        }

    })
    .catch(error => {

        console.error("Error:", error);

        alert("Unable to connect to server.");

    });
}