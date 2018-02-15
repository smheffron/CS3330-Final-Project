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
public class AllNoteCardSets extends Set implements Serializable
{
    //This ArrayList holds all of the notecard sets
    private ArrayList<NoteCardSet> allNoteCardSets;
    
    public AllNoteCardSets()
    {
        allNoteCardSets = new ArrayList<>();
    }
    
    public ArrayList<NoteCardSet> getAllNoteCardSets()
    {
        return this.allNoteCardSets;
    }
    @Override
    public void addNoteCardSetToAllSets(NoteCardSet noteCardSet)
    {
        allNoteCardSets.add(noteCardSet);
    }
    
    @Override
    public void removeNoteCardSet(NoteCardSet noteCardSet)
    {
        allNoteCardSets.remove(noteCardSet);
    }
}
