$(document).ready(function(){
	$(".address_btn").on("click",function(e){
		e.preventDefault();
		DaumPostcode();
	});
});//end document ready function


//다음 주소 api
function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = '';
            var extraAddr = '';
            if (data.userSelectedType === 'R') {
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address1").value = addr + extraAddr;
            document.getElementById("address2").focus();
        }
    }).open();
}//end postcode function