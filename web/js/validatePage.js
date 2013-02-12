var dateRegexp = new RegExp("((0[1-9])|([1-2][0-9])|30|31)-((0[1-9])|(1[0-2]))-(19|20)[0-9]{2}");
var modelRegexp = new RegExp("[A-Za-zÀ-ßà-ÿ¨¸]{2}\\d{3}");
var priceRegexp = new RegExp("[0-9]+(?:\.[0-9]+)?");

function validate(element) {
    var hasError = false;
    var message = "";
    var value = element.value;
    var strLenght = value.length;
    var elName = element.name;
    
    switch (elName) {
        case "pageSize":
            if (strLenght == 0) {
                message = emptyField;  	
                hasError = true;
            }
            break;
        case "pageNumber":
            if (strLenght == 0) {
                message = emptyField;
                hasError = true;
            }
            break;
    } 
    
    if (hasError) {
        element.focus();
        element.style.borderColor="red";
        element.style.color = "red";
        alert(message);			
    } else {
        element.style.borderColor = "gray";
        element.style.color = "black";
    }
}