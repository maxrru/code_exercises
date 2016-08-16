import java.lang.*;
/**
 * Die Klasse Matrix modelliert eine 2-dimensionale
 * Anordung von Zahlen (eine Matrix).
 * 
 * @author *** 
 * @version 04/2013
 */
public class Matrix
{
    // Instanzvariable - speichert ein 2-dimensionales Array ganzer Zahlen.
   
    private int matrix[][];

    /**
     * Ein Bequemlichkeitskonstruktor für Objekte der Klasse Matrix
     */
    public Matrix()
    {
        
       matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        
    }
    
    /**
     * Ein Konstruktor mit einem 2-dimensionalen Array 
     * mit Initialisierungswerten.
     */
    public Matrix(int [][] initV)
    {
        
        matrix=new int[initV.length][];
        for(int i = 0; i<initV.length; i++)
        {
            matrix[i]=new int[initV[i].length];
            for(int j=0; j<initV[i].length; j++)
            {
                matrix[i][j]=initV[i][j];
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
    
            if(matrix[i].length != matrix[0].length){
                throw new MatrixLaengenException("Die Spaltenlängen stimmen nicht überein!");
    
            }
        }
    }
    /**
     * Ein Kopierkonstruktor für eine neue Matrix
     */
     public Matrix(Matrix initMatrix)
     {
        matrix=new int[initMatrix.matrix.length][];
        
        for(int i = 0; i<initMatrix.matrix.length; i++)
        {
            matrix[i]=new int[initMatrix.matrix[i].length];
            for(int j=0; j<initMatrix.matrix[i].length; j++)
            {
                matrix[i][j]=initMatrix.matrix[i][j];
            }
        }
        
         for(int i = 0; i < matrix.length; i++){
    
            if(matrix[i].length != matrix[0].length){
                throw new MatrixLaengenException("Die Spaltenlängen stimmen nicht überein!");
    
            }
        }
         
     }
   
    /**
     * Gibt das Elemente der angegebenen Zeile und Spalte zurück.
     * @param zeile Der Zeilenindex des gesuchten Elements.
     * @param spalte Der Spaltenindes des gesuchten Elements.
     * @return Der Wert des gesuchten Elements.
     */
     public int gibElement(int zeile, int spalte)
     {  
         int wert = 0;
         
         if(zeile < matrix.length && spalte < matrix[zeile].length && zeile >= 0 && spalte >= 0)
         {
             wert = matrix[zeile][spalte];
             
         }
         else
         {
             throw new IndexOutOfBoundsException("Das angegebene Element ist nicht teil dieser Matrix.");
         }
     
        return wert;   
        
        }
    
    /**
     * Vergleicht diese Matrix mit einer anderen Matrix.
     * @param m Die andere Matrix.
     * @return true, falls alle Elemente der anderen Matrix 
     *               mit denen dieser Matrix übereinstimmen,
     *         false sonst.
     */
     public boolean equals(Object m)
     {
        if(m instanceof Matrix)
        {
            Matrix matrix2 = (Matrix) m;
            boolean rueckgabe = true;
            if(matrix.length==matrix2.matrix.length&&matrix[0].length==matrix2.matrix[0].length)
            {
                for(int i = 0; i < matrix2.matrix.length ; i++)
                {
                    for( int j = 0; j < matrix2.matrix[i].length; j++)
                    {
                        if(matrix[i][j] != matrix2.matrix[i][j])
                        {
                            return  false;
                        }
                    }
                }
            }
            return true;
        }
        else
        {
            return false;
        } 
     }

    /**
     * Addiert eine Matrix zu dieser Matrix. Speichert das Ergebnis 
     * in dieser Matrix.
     * @param matrix2 Die Matrix, die zu dieser Matrix addiert werden soll.
     */
    public void addiere(Matrix matrix2)
    {
        if(matrix.length==matrix2.matrix.length)
        {
            for(int i = 0; i<matrix.length; i++)
            {
                for(int j = 0; j<matrix[i].length; j++)
                {
                    if(matrix[i].length!=matrix2.matrix[i].length)
                    {
                        throw new MatrixLaengenException("Die Spaltenlaengen der Matrizen sind nicht kompatibel!\nVorgang wird Abgebrochen!");
                      //  j=matrix[i].length;
                      //  i=matrix.length;
                    }
                    else if(matrix[i].length==matrix2.matrix[i].length)
                    {
                        matrix[i][j]+=matrix2.matrix[i][j];
                    }
                }
            }
        }      
        else
        {
            throw new MatrixLaengenException("Die Zeilenanzahl der Matrizen sind nicht kompatibel! Vorgang wird abgebrochen!");
    }
}
    
    /**
     * Addiert 2 Matrizen und gibt die Ergebnismatrix zurück. 
     * @param matrix1 Die erste der beiden Matrizen.
     * @param matrix2 Die zweite der beiden Matrizen.
     * @reutn Die Ergbnismatrix der Matrizenaddition.
     */
//     public static Matrix addiere(Matrix matrix1, Matrix matrix2)
//     {
// 
//     }

    /**
     * Multipliziert diese Matrix mit einem Vektor.
     * @param v der Vektor, mit dem diese Matrix multipliziert wird.
     * @return Der Ergebnisvektor
     */
     public int[] multipliziere(int [] v)
     {
         int zwischenmatrix[][]=new int[matrix.length][matrix[0].length];
         int ergebnisvektor[] = new int[zwischenmatrix.length];
         
         if(v.length != zwischenmatrix[0].length)
         {
            throw new MatrixLaengenException("Vektor passt nicht zur Matrix!");
         }
         else
         {
            for(int i = 0; i < zwischenmatrix.length; i++)
            {
                for(int j = 0; j < zwischenmatrix[i].length; j++)
                {
                    zwischenmatrix[i][j] = matrix[i][j]*v[j];
                }
            }
            
             for(int i = 0; i < zwischenmatrix.length; i++)
            {
                for(int j = 0; j < zwischenmatrix[i].length; j++)
                {
                   ergebnisvektor[i] += zwischenmatrix[i][j];
                }
            }
         } 
            
            
            return ergebnisvektor;
     }
    
    /**
     * Multipliziert die übergebene Matrix mit einem Vektor.
     * @param Die Matrix, die multipliziert wird
     * @param v der Vektor, mit dem die Matrix multipliziert wird.
     * @return Der reultierende Vektor
     */
//     public static int[] multipliziere(Matrix matrix1, int [] v)
//     {
// 
//     }
    
    
    /**
     * Multipliziert diese Matrix mit einer anderen Matrix.
     * @param Die Matrix, mit der diese Matrix multipliziert wird.
     * @return Die Ergebnismatrix der Matrixmultiplikation (Produktmatrix).
     */
//     public Matrix multipliziere(Matrix matrix2)
//     {
//     }
    
    /**
     * Multipliziert die beiden übergebenen Matrizen.
     * @param Die erste Matrix für die Matrixmultiplikation.
     * @param Die zweite Matrix für die Matrixmultiplikation.
     * @return Die Ergebnismatrix der Matrixmultiplikation (Produktmatrix).
     */
//     public static Matrix multipliziere(Matrix matrix1, Matrix matrix2)
//     {
// 
//     }


    /**
     * Überschreibt toString()
     */
    public String toString()
    {
        String dasObjekt = "";
        
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j <matrix[i].length; j++)
            {
                dasObjekt += "(" + i + "/" + j + ") : " + matrix[i][j]+"\n";
            }
            
        }
        
        
        return dasObjekt;
    }
    
    /**
     * Gibt diese Matrix aus.
     */
    public void ausgeben()
    {
        System.out.println(toString());
    }
}






