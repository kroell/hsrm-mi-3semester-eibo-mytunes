package exceptions;

/**
 *
 * TrackNotFoundEx.java
 * 
 * Klasse zum Erstellen von Exceptions sofern ein Track nicht gefunden wurde
 * 
 * 
 * @author Soeren Kroell, Anika Hasselbach, Nicole Emmel
 * @version 27.01.2012
 * 
 */
public class TrackNotFoundEx extends Exception{
    
    //Default-Konstruktor
    public TrackNotFoundEx(){
    }    
    
    //Angepasster Konstruktor
    public TrackNotFoundEx(String s){
        super(s);
    }
    
}
