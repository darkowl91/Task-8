var pageRegexp = new RegExp("^\[0-9]{1,7}$");

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
            } else if(strLenght != 0 && !pageRegexp.test(element.value)) {
                message= incorrectFormat;
                hasError = true;
            } else if (value == 0) {
                message = incorrectFormat;
                hasError = true;
            }
            break;
            
        case "pageNumber":
            if (strLenght == 0) {
                message = emptyField;
                hasError = true;
            } else if(strLenght != 0 && !pageRegexp.test(element.value)) {
                message= incorrectFormat;
                hasError = true;
            } else if (value == 0) {
                message = incorrectFormat;
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