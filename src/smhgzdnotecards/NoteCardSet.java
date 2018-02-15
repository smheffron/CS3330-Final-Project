/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Shelby
 */
public class NoteCardSet implements Serializable
{
    //this ArrayList holds all of the notecards in its set
    private ArrayList<NoteCard> noteCardSet;
    
    private String setName;
    
    public NoteCardSet()
    {
        noteCardSet = new ArrayList<>();
    }
    
    public ArrayList<NoteCard> getNoteCardSet()
    {
        return this.noteCardSet;
    }   
    public void addNoteCardToSet(NoteCard noteCard)
    {
        noteCardSet.add(noteCard);
    }
    public void removeNoteCardFromSet(NoteCard noteCard)
    {
        noteCardSet.remove(noteCard);
    }
    
    public String getSetName()
    {
        return setName;
    }
    
    public void setSetName(String setName)
    {
        this.setName = setName;
    }
    
    @Override
    public String toString()
    {
        //https://stackoverflow.com/questions/20886795/populate-listview-from-listobject
        //I overrided the toString() method, becuase after reading this article, this is how my ListView 
        //gets the names to display on the listView. (credit to Raghunandan of stackoverflow for the idea)
        return setName;
    }
}
