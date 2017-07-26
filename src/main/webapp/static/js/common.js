
/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function toggleResposive() {
    var x = document.getElementById('myTopnav');
    if (x.className === 'topnav') {
        x.className += 'responsive';
    } else {
        x.className = 'topnav';
    }
}


//get selected Make
function selectedMake(s) {

    console.log(s[s.selectedIndex].value); // get value
    console.log(s[s.selectedIndex].id); // get id


    var makeInput = document.getElementById('inputNewVehicleMake');
    var makeId = document.getElementById('selectedMakeId');

    makeInput.value = s[s.selectedIndex].value;
    makeId.value = s[s.selectedIndex].id;

    //reset selected option
    document.getElementById('model_0').selected = 'selected';

    displayOnOff(s[s.selectedIndex].id);
}

//onclick of clear/reset turn off disable
function hideModelSelect(){

    hideAllModelSelects();

    //if in edit display block orginal
//    var orginalSelection = document.getElementsByClassName('modelClassOrgianl')[0];
//
//    if(orginalSelection !== null) {
//        orginalSelection.style.display = 'none';
//    }

}

//get selected model
function selectedModel(m) {

    console.log('model: ' + m[m.selectedIndex].value); //get value
    console.log('model id: ' + m[m.selectedIndex].id); //get id

    var modelInput = document.getElementById('inputNewVehicleModel');
    var modelId = document.getElementById('selectedModelId');

    modelInput.value = m[m.selectedIndex].value;
    modelId.value = m[m.selectedIndex].id;
}


//show models pased on make id
function displayOnOff(id) {

    var element = document.getElementById('model_' + id);

    hideAllModelSelects();

    //display selected
    element.style.display = 'block';

}


//helper function hide all model Selects
function hideAllModelSelects(){

    var elementList = document.getElementsByClassName('modelClass');

    //first clear and hide any dropdowns displaying
    for(i=1;i<=elementList.length;i++){
        var n = i;
        document.getElementById('model_' + n.toString()).style.display = 'none';
    }


}




