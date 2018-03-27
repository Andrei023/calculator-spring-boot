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
    document.getElementById("display").value = " ";
}

function deleteFunction()
{
    var v = document.getElementById("display").value;
    document.getElementById("display").value = v.slice(0,-1);
}

function plusMinusToggle()
{
    var v = document.getElementById("display").value;

    if(v.charAt(0)==="-"){
        document.getElementById("display").value="+".concat(v.slice(1));
    }
    else if((v.charAt(0)==="+")){
        document.getElementById("display").value="-".concat(v.slice(1));
    }
    else if(v.length>0){
        document.getElementById("display").value="+".concat(v);
    }
}

// ensure that only one '.' is added in the display
function dotFunction()
{
    var v = document.getElementById("display").value;

    if(v.indexOf(".") === -1){
        addValue(".");
    }
}
