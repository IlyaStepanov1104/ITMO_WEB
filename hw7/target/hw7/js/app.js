window.notify = function (message) {
    $.notify(message, {
        position: "right bottom",
        className: "success"
    });
}

window.makerequest = function (data, $error = null,suc =  function (response) {
    if (response["error"]) {
        $error.text(response["error"]);
    } else {
        location.href = response["redirect"];
    }
}) {
    $.ajax({
        type: "POST",
        url: "",
        dataType: "json",
        data: data,
        success: suc
    });
}
