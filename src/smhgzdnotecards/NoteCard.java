/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.io.Serializable;

/**
 *
 * @author Shelby
 */
public class NoteCard implements Serializable
{
    //simply holds the front and back of each notecard
    
    private String front;
    private String back;
    
    public NoteCard()
    {
        
    }
    
    public String getFront()
    {
        return this.front;
    }
    
    public String getBack()
    {
        return this.back;
    }
    
    public void setFront(String front)
    {
        this.front = front;
    }
    
    public void setBack(String back)
    {
        this.back = back;
    }
}
