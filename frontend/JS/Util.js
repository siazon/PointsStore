function copyToClip(content) {
    var aux = document.createElement("input");
    aux.setAttribute("value", content);
    document.body.appendChild(aux);
    aux.select();
    document.execCommand("copy");
    document.body.removeChild(aux);
    // if (message == null) {
    //     alert("ε€εΆζε");
    // } else {
    //     alert(message);
    // }
}