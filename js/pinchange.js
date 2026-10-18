// Show / Hide PIN

function togglePinVisibility(){

    let oldPin =
document.getElementById("oldPin");

    let newPin =
    document.getElementById("newPin");

    let confirmPin =
    document.getElementById("confirmPin");

    if(newPin.type==="password"){

        oldPin.type="text";
        newPin.type="text";
        confirmPin.type="text";

    }

    else{

        oldPin.type="password";
        newPin.type="password";
        confirmPin.type="password";

    }

}

// Change PIN

function changePIN(){

    let oldPin =
document.getElementById("oldPin").value;    

    const currentPIN = "9228";

if(oldPin !== currentPIN){

    document.getElementById("message").innerHTML =
    "Old PIN is incorrect.";

    document.getElementById("message").style.color =
    "red";

    return;

}
    let newPin =
    document.getElementById("newPin").value;

    let confirmPin =
    document.getElementById("confirmPin").value;

    if(newPin.length !== 4 || confirmPin.length !== 4){

        document.getElementById("message").innerHTML =
        "New PIN must be 4 digits ONLY.";

        document.getElementById("message").style.color =
        "red";

        return;

    }

    if(newPin !== confirmPin){

        document.getElementById("message").innerHTML =
        "New PIN and Confirm PIN do not match.";

        document.getElementById("message").style.color =
        "red";
      
        return;

    }

    document.getElementById("message").innerHTML =
    "PIN changed successfully!";

    document.getElementById("message").style.color =
    "green";

}