
/**
 * Write a description of class MatrixLaengenException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatrixLaengenException extends RuntimeException
{
    // instance variables - replace the example below with your own
    private String s;

    /**
     * Constructor for objects of class MatrixLaengenException
     */
    public MatrixLaengenException(String s)
    {
       this.s = s;
    }

    public MatrixLaengenException()
    {
        this.s = ("MatrixLaengenException ausgelöst!");
    }
    
}