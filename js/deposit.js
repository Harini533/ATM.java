// Current Balance (Demo)

let balance = 25000;

// Deposit Function

function depositCash(){
     
    alert("Deposit button clicked!");

    let amount =
    Number(document.getElementById("amount").value);

    if(isNaN(amount) || amount <= 0){

        document.getElementById("message").innerHTML =
        "Please enter a valid deposit amount.";

        document.getElementById("message").style.color =
        "red";

        return;
    }
     
if(amount < 100){

    document.getElementById("message").innerHTML =
    "Minimum deposit amount is ₹100.";

    document.getElementById("message").style.color =
    "red";

    return;
 }

 

    balance = balance + amount;
     document.getElementById("amount").value = "";

    document.getElementById("message").innerHTML =

    "₹" + amount.toLocaleString("en-IN") +
    " deposited successfully.<br><br>" +

    "Current Balance : ₹" +
    balance.toLocaleString("en-IN");

    document.getElementById("message").style.color =
    "green";


}

// Display Current Date

const dateElement =
document.getElementById("date");

if(dateElement){

    dateElement.innerHTML =
    new Date().toLocaleDateString("en-IN");

}

// Display Current Time

function updateTime(){

    const timeElement =
    document.getElementById("time");

    if(timeElement){

        timeElement.innerHTML =
        new Date().toLocaleTimeString("en-IN");

    }

}

updateTime();

setInterval(updateTime,1000);