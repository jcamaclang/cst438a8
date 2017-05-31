/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.admin;

/**
 *
 * @author janpa
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="WordsServlet", urlPatterns = {"/WordsServlet"})
public class WordsServlet extends HttpServlet{
    
    private Game game = new Game();
    private String cookie="0";
    static Random generator = new Random();
    
    private String generateCookie() {
        return Long.toString(generator.nextLong());
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{ 
        String uri = request.getRequestURI().toString();
        System.out.println("URI=" + uri);
        String guess = request.getParameter("guess");
        response.setContentType("text/html; charset =UTF-8");
        PrintWriter out = response.getWriter();
  	// if there is no cookie, or it is "0" or differfent from the current value, then start a new game
        if (cookie.equals("0")) {
            game.startNewGame();
            cookie=generateCookie();
            try{
                out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                    + "<img src=\"" + "h" + game.getState() + ".gif" + "\">"
                    + "<h2 style=\"font-family:'Lucida Console', monospace\"> " + game.getDisplayWord() + "</h2>"
                    + "<form action=\"WordsServlet\" method=\"get\"> "
                    + "Guess a character <input type=\"text\" name=\"guess\"><br>"
                    + "<input type=\"submit\" value=\"Submit\">" + "</form></body></html>");
                    out.close();
            }finally{
             
            }
        } else if (game.isValid(guess)){
            // continue with current game
            char ch = Character.toLowerCase(guess.charAt(0));  // letter that user has guessed
            int result = game.playGame(ch);
            switch(result) {
                case 0: // good guess, continue game
                    try{
                        out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                        + "<img src=\"" + "h" + game.getState() + ".gif" + "\">"
                        + "<h2 style=\"font-family:'Lucida Console', monospace\"> " + game.getDisplayWord() + "</h2>"
                        + "<form action=\"WordsServlet\" method=\"get\"> "
                        + "Guess a character <input type=\"text\" name=\"guess\"><br>"
                        + "<input type=\"submit\" value=\"Submit\">" + "</form></body></html>");
                        out.close();
                        break;
                    }finally{
                        
                    }
                case 1: // good guess, win game
                    try{
                        out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                        + "<img src=\"" + "h" + game.getState() + ".gif" + "\">"
                        + "<h2 style=\"font-family:'Lucida Console', monospace\"> " + "</h2>"
                        + "<h2>Congratulations you win!</h2>" + "</body></html>");
                        cookie="0";
                        out.close();
                        break;
                    }finally{
                        
                    }
                case 2: // bad guess, continue game
                    try{
                        out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                        + "<img src=\"" + "h" + game.getState() + ".gif" + "\">"
                        + "<h2 style=\"font-family:'Lucida Console', monospace\"> " + game.getDisplayWord() + "</h2>"
                        + "<form action=\"WordsServlet\" method=\"get\"> "
                        + "Guess a character <input type=\"text\" name=\"guess\"><br>"
                        + "<input type=\"submit\" value=\"Submit\">" + "</form></body></html>");
                        out.close();
                        break;
                    }finally{
                        
                    }
                case 3: // bad guess, lost game
                    try{
                        out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                        + "<img src=\"" + "h7.gif" + "\">" + "<h2>You lost!  The word is " + game.getWord() + "</h2>"
                        + "</body></html>");
                        cookie="0";
                        out.close();
                        break;
                    }finally{
                        
                    }
            }
        } else {
            try{
                out.println("<!DOCTYPE html><html><head><title>MyHttpServer</title></head><body><h2>Hangman</h2>"
                + "<img src=\"" + "h" + game.getState() + ".gif" + "\">"
                + "<h2 style=\"font-family:'Lucida Console', monospace\"> " + game.getDisplayWord() + "</h2>"
                + "<form action=\"WordsServlet\" method=\"get\"> "
                + "Guess a character <input type=\"text\" name=\"guess\"><br>"
                + "<input type=\"submit\" value=\"Submit\">" + "</form></body></html>"
                + "<h2 style=\"color:red;\">Please enter only one letter!</h2>"); 
                out.close();
            }finally{
                
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
}
