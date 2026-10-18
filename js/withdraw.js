// Available Balance

let balance = 25000;

// Withdraw Function

function withdrawCash(){

    let cardNumber =
    document.getElementById("card_number").value.trim();

    let amount =
    Number(document.getElementById("amount").value);
    
    const VALID_CARD = "1234567890123456";

if(cardNumber !== VALID_CARD){

    document.getElementById("message").innerHTML =
    "Invalid Card Number.";

    document.getElementById("message").style.color =
    "red";

    return;

}

    if(cardNumber===""){

        alert("Please enter Card Number.");

        return;

    }

    if(amount<=0 || isNaN(amount)){

        alert("Enter a valid amount.");

        return;

    }

    if(amount>balance){

        document.getElementById("message").innerHTML=
        "Insufficient Balance.";

        document.getElementById("message").style.color="red";

        return;

    }

    balance=balance-amount;

    document.getElementById("message").innerHTML=

    "₹"+amount.toLocaleString("en-IN")+
    " withdrawn successfully.<br><br>" +

    "Remaining Balance : ₹"+
    balance.toLocaleString("en-IN");

    document.getElementById("message").style.color="green";

}