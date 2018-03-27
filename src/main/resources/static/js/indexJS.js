function addValue(value)
{
    if(document.getElementById("display").value.length<7)
    {
        document.getElementById("display").value += value;
    }
}

// workaround to bypass NotNull validation
function clearValue()
{
    document.getElementById("display").value = "";
}

function deleteFunction()
{
    var v = document.getElementById("display").value;
    document.getElementById("display").value = v.slice(0,-1);
}

// function testMethod()
// {
//     document.getElementById("displayForm").submit();
// }

function validate() {
    // //var x, text;
    //
    // // Get the value of the input field with id="numb"
    // var x = document.getElementById("display").value;
    // //document.getElementById("demo").innerHTML = "Am intrat in validate()";
    //
    // // If x is Not a Number or less than one or greater than 10
    // if (x=="") {
    //     //text = "Input not valid";
    //     //document.getElementById("demo").innerHTML = text;
    //     return false;
    // } else {
    //     //text = "Input OK";
    //    // document.getElementById("demo").innerHTML = text;
    //     return false;
    // }
    return false;

}