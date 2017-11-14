function showProgress(data) {    
    if (data.status === "begin") {
        document.getElementById('loading_wrapper').style.display = "block";
    } else if (data.status === "success") {
        document.getElementById('loading_wrapper').style.display = "none";
    }
}

function socketListener(message, channel, event) {
    console.log(message);
    alert(message);
}
