/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
        
/**
 *
 * @author Jan Patrick Camaclang
 */

@Entity
public class Word implements Serializable{
   
    private int id;
    private String word;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getWord(){
        return word;
    }
    
    public void setWord(String word){
        this.word = word;
    }
    
}
