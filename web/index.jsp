<%-- 
    Document   : index
    Created on : May 29, 2017, 10:16:48 PM
    Author     : Jan Patrick Camaclang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangman Game</title>
    </head>
    <body>
        <h2>Welcome to Hangman!</h2>
        <img src= h1.gif>
        <form action="WordsServlet" method="get"> 
            <p>Guess the correct letter for the given word. <br> You have up to 6 incorrect tries.  <br> Good Luck! </p>
            <br><input type="submit" value = "Click here to continue!">
        </form>
    </body>
</html>
