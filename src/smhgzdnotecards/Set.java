/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

/**
 *
 * @author Shelby
 */
public abstract class Set 
{
    // this abstract class allows classes that extend it to implement these methods that apply to sets
    
    public abstract void addNoteCardSetToAllSets(NoteCardSet noteCardSet);
    
    public abstract void removeNoteCardSet(NoteCardSet noteCardSet); 
}
