<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finance Home</title>
</head>
<style>
*
{
    box-sizing: border-box;
    padding: 0;
    margin: 0;
}
body
{
    overflow-x: hidden;
}
#navbar
{
   border: 2px solid #00008B ; 
   height: 75px;
   width: 100%;
   display: flex;
   box-shadow: 2px 2px 2px 2px rgba(0,0,0,0.2);
   position: fixed;
   top: 0;
   z-index: 1;
  background-color: #00008B;
} 
.dropdown 
{
      padding: 20px;
      display: none;
      position: absolute;
      min-width: 100px;
      box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
 }
.dropdown li
 {
      padding: 12px 3px;
      text-decoration: none;
      display: block;
 }
 li:hover .dropdown 
  {
      display: block;
  }
h1
{
    color:	#AA336A;
	position:relative;
	top:220px;
	left:100px;
	font-size:65px;
}
h3
{
   font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
	color:Green;
	position:relative;
	top:250px;
	left:100px;
	font-size:23px;
}
#left_nav
{
   width: 30%;
   height: 100%; 
}
#right_nav
{
    width: 70%;
    height: 100%;  
    display: flex;
    justify-content: flex-end;
    align-items: center; 
    gap: 30px;
}
.sec
{
	width:50%;
}
#image1
{
	border-radius:50%;
	width:55px;
	height:55px;
	position:relative;
	top:10px;
	left:10px;
}
#image2
{
	position:relative;
	left:700px;
	width:400px;
	height:400px;
}
</style>
<body>
   <nav id="navbar">
            <section id="left_nav">
			<img src="ProofImages/flogo.jpg" alt="image" id="image1">
		</section>
            <section id="right_nav">
             <aside><a href="#" style="color: transparent;"><p style="color:white; font-size:22px;">Home</p></a></aside>
             <aside><a href="" style="color: transparent;"><p style="color:white; font-size:22px;">About</p></a></aside>
           <aside>
                  <a href="login.jsp" style="color: transparent;"><p style="color:white; font-size:22px;">Login</p></a>
            </aside>
              <aside><a href="#contact" style="color: transparent;"><p>Contact Us</p></a></aside> 
 </nav>
<div>
	<section class="sec">
	<h1>Royal Finance</h1>
		<h3>Money is numbers and numbers never end.</h3>
		<h3>If it takes money to be happy. </h3>
	</section>
	<section class="sec"><img alt="image" src="ProofImages/home.jpg" id="image2"></section>
</div>
</body>
</html>