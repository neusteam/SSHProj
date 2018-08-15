window.addEventListener('load', () => {
	let movieData = "";
	let username = getCookie("username");
	if(username != ""){
		let rootUl = _prime(".index-right-nav")[0];
		rootUl.innerHTML = username;
		
		let button = getDomElement("button","clear","退出");
		rootUl.appendChild(button);
		
		_prime(".clear")[0].addEventListener("click",()=>{
			delCookie("username");
		})
		
	}
	
	
     $.ajax({
         type: "post",
         url: "http://localhost:8080/ssh01/findAllMovie",
         dataType:"JSON",
         contentType:"application/json;charset=utf-8",
         data: JSON.stringify({
             count: 20
         }),
         success: function(str) {
        	 movieData = JSON.parse(str);
        	 console.log(movieData)
             initIndexContentItems(movieData)
         },
         error: function() {
             console.log("error");
         }
     })
     
//    initIndexContentItems(movieData);

    _prime(".index-content")[0].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(e.target.getAttribute("movieId"));
        }
    })
    _prime(".index-content")[1].addEventListener("click", (e) => {
        if (e.target.nodeName == "IMG") {
            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");

            initModalContent(e.target.getAttribute("movieId"));
        }
    })
    
//    _prime(".index-content")[2].addEventListener("click", (e) => {
//        if (e.target.nodeName == "IMG") {
//            _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, .5);z-index:1");
//            _prime(".alert-content")[0].setAttribute("style", "opacity:1;z-index:1");
//
//            initModalContent(e.target.getAttribute("movieId"));
//        }
//    })



    _prime(".close-button")[0].addEventListener("click", () => {
        _prime(".alert-box")[0].setAttribute("style", "background-color:rgba(0, 0, 0, 0);z-index:-1");
        _prime(".alert-content")[0].setAttribute("style", "z-index:-1;opacity:0");

        _prime(".alert-content")[0].innerHTML = "";
    })

})

const getCookie = (c_name)=>
{
	if (document.cookie.length>0)
	{
		c_start=document.cookie.indexOf(c_name + "=")
    if (c_start!=-1)
    { 
    	c_start=c_start + c_name.length+1 
    	c_end=document.cookie.indexOf(";",c_start)
    if (c_end==-1) c_end=document.cookie.length
    return unescape(document.cookie.substring(c_start,c_end))
    } 
  }
	return ""
}

const deleteCookie = (name)=> {
	document.cookie = name + '=;  expires=Thu, 01 Jan 1970 00:00:01 GMT;'
}

const getDomElement = (type, className, text) => {
    let domNode = document.createElement(type);
    let textNode = document.createTextNode(text);

    domNode.appendChild(textNode);
    domNode.className = className;

    return domNode;
}

const initIndexContentItems = (movieData) => {

    let liArray = [];

    for (let i = 0; i < 20; i++) {
        let rootLi = getDomElement("li", "", "");
        let ulNode = getDomElement("ul", "index-movies-item", ""),
            imageLiNode = getDomElement('li', "image", ""),
            imageANode = getDomElement('a',"",""),
            imageNode = getDomElement("img", "", ""),
            nameLiNode = getDomElement("li", "", movieData[i].moviename),
            scoreLiNode = getDomElement("li", "", ""),
            scoreSpanNode = getDomElement("span", "score", movieData[i].average + "分"),
            buttonLiNode = getDomElement("li", "", ""),
            buttonNode = getDomElement("button", "purchase", "选座购票");
        
        imageANode.setAttribute("href","./selectmovie?movieInfo.moviename=" + movieData[i].moviename);
        imageNode.setAttribute("src", "./" + movieData[i].picture);
        imageNode.setAttribute("movieId", movieData[i].movieId - 1);

        // console.log(movieData[i].movieId)

        imageANode.appendChild(imageNode);
        imageLiNode.appendChild(imageANode);

        scoreLiNode.appendChild(scoreSpanNode);
        buttonLiNode.appendChild(buttonNode);

        ulNode.appendChild(imageLiNode);
        ulNode.appendChild(nameLiNode);
        ulNode.appendChild(scoreLiNode);
        ulNode.appendChild(buttonLiNode);

        rootLi.appendChild(ulNode);

        liArray.push(rootLi);
    }

    for (let i = 0; i < 5; i++) {
        // console.log("第一栏")
        _prime(".index-movies-silders")[0].appendChild(liArray[i]);
    }
    for (let i = 5; i < 10; i++) {
        // console.log("第二栏")
        _prime(".index-movies-silders")[1].appendChild(liArray[i]);
    }
    for (let i = 10; i < 15; i++) {
        // console.log("第三栏")
        _prime(".index-movies-silders")[2].appendChild(liArray[i]);
    }
}


const initModalContent = (movieId) => {
    let h1Node = getDomElement("h1", "", movieData[movieId].moviename + " " + movieData[movieId].type),
        imgNode = getDomElement("img", "", ""),
        directorPNode = getDomElement("p", "", "导演 ： " + movieData[movieId].director),
        actorPNode = getDomElement("p", "", "演员 ： " + movieData[movieId].actor),
        typePNode = getDomElement("p", "", "类型 ： " + movieData[movieId].type),
        datePNode = getDomElement("p", "", "日期 ： " + movieData[movieId].date),
        countryPNode = getDomElement("p", "", "地区 ： " + movieData[movieId].country),
        lanPNode = getDomElement("p", "", "语言 ： " + movieData[movieId].language),
        scoreSpanNode = getDomElement("span", "score", movieData[movieId].average + "分"),
        scorePNode = getDomElement("p", "", "评分 ： ");
        describePNode = getDomElement("p", "describe", "电影描述 ： " + movieData[movieId].moviedescribe);

    imgNode.setAttribute("src", "./" + movieData[movieId].picture);
    scorePNode.appendChild(scoreSpanNode);

    let rootDiv = _prime(".alert-content")[0];
    rootDiv.appendChild(h1Node);
    rootDiv.appendChild(imgNode);
    rootDiv.appendChild(directorPNode);
    rootDiv.appendChild(actorPNode);
    rootDiv.appendChild(typePNode);
    rootDiv.appendChild(datePNode);
    rootDiv.appendChild(countryPNode);
    rootDiv.appendChild(lanPNode);
    rootDiv.appendChild(scorePNode);
    rootDiv.appendChild(describePNode);
}