	window.addEventListener("load", () => {
    // console.log(123)
    _prime("button.sign-in-up-button")[0].addEventListener("click", (e) => {
        console.log(_prime("#psd")[0].value)
        console.log(_prime("#psdCon")[0].value)
        
        let acc = _prime("#acc")[0].value;
        let psd = _prime("#psd")[0].value;
        let psdCon = _prime("#psdCon")[0].value;

        if (acc != "" && psd != "" && psdCon != "" && psd == psdCon) {
            _prime(".register-button")[0].click();
        }else{
        	alert("请检查密码是否一致或账号名是否为空")
        	_prime(".reset-button")[0].click();
        }
    })
})