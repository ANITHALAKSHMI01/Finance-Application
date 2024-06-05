<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
overflow-x:hidden;
}
#navbar
{
   border: 2px solid; 
   height: 75px;
   width: 100%;
   display: flex;
   box-shadow: 1px 1px 1px 1px;
   position: fixed;
   top: 0;
   z-index: 1;
  /*  background-color: #00008B; */
} 
.dropdown {
      padding: 0px;
      display: none;
      position: absolute;
      min-width: 100px;
      box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
    }

    .dropdown li {
      padding: 12px 3px;
      text-decoration: none;
      display: block;
    }
    
    li:hover .dropdown {
      display: block;
    }
h1
{
	position:relative;
	top:300px;
	left:500px;
	font-size:50px;
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
/* aside
{
	display:flex;
	gap:40px;
	position:relative;
	left:500px;
} */
</style>
<body>
   <nav id="navbar">
            <section id="left_nav"><img src="./Images/images.png" alt="image" id="image1"></section>
            <section id="right_nav">
             <aside><a href="#">Home</a></aside>
             <aside><a href="">About</a></aside>
             <aside><a href="">Loans</a></aside>
            <!--  <aside><a href="#scroll_container" style="color: transparent;"><p>Achievements</p></a></aside> -->
           <!--   <aside><i class="fa-solid fa-magnifying-glass"></i><input type="search" placeholder="Search" ></aside></section>  -->
      <aside><ul  class="nav-ul" type="none">
              <li>
                Register
                <ul class="dropdown">
                  <li><a  href="adminRegistration.jsp" style="text-decoration:none; color:#000000">Admin</a></li>
                  <li><a href="borrowerRegistration.jsp" style="text-decoration:none; color:#000000">Borrower</a></li>
                </ul>
              </li>
            </ul>
            <ul  class="nav-ul"></aside>
           <aside><ul  class="nav-ul" type="none">
              <li>
                Login
                <ul class="dropdown">
                  <li><a  href="adminLogin.jsp" style="text-decoration:none; color:#000000">Admin</a></li>
                  <li><a href="borrowerLogin.jsp" style="text-decoration:none; color:#000000">Borrower</a></li>
                </ul>
              </li>
            </ul>
            <ul  class="nav-ul"></aside>
              <aside><a href="#contact" style="color: transparent;"><p>Contact Us</p></a></aside> 
 </nav>
<h1>Royal Finance</h1>
</body>
</html>