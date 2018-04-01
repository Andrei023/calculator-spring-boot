//addValue
$(document).ready(function(){
    $(".operand").click(function(){
        var number=$(this).text();
        $("#display").val(function () {
            return $(this).val() + number;
        });
    });
});

//clearValue
$(document).ready(function(){
    $("#clearButton").click(function(){
        $("#display").val(" ");
    });
});

//deleteFunction
$(document).ready(function () {
    $("#deleteButton").click(function () {
        $("#display").val(function () {
            return $(this).val().slice(0,-1);
        });
    });
});

//plusMinusToggle
$(document).ready(function () {
    $("#plusMinus").click(function () {
        $("#display").val(function () {
             if($(this).val().charAt(0)==="-"){
                 return "+".concat($(this).val().slice(1));
             }
             else if($(this).val().charAt(0)==="+"){
                 return "-".concat($(this).val().slice(1));
            }
            else if($(this).val().length>0){
                return "+".concat($(this).val());
            }
        });
    });
});

// ensure that only one '.' is added in the display
$(document).ready(function () {
    $("#dotButton").click(function () {
        $("#display").val(function () {
            if($(this).val().indexOf(".")=== -1){
                return $(this).val().concat(".");
            }
            else{
                return $(this).val();
            }
        });
    });
});