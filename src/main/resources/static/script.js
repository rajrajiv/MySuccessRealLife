const toggler = document.querySelector(".btn");
toggler.addEventListener("click",function(){
    document.querySelector("#sidebar").classList.toggle("collapsed");
});


const admin = document.getElementById("admin"); 
let type = element.getAttribute("type"); 
 if(type = 'admin'){
	 admin.style.diplsy="block";
 }
 else{
	 admin.style.display="none";
 }
