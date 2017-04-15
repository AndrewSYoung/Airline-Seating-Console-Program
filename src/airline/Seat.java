/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

/**
 *
 * @author Andrew
 */
public class Seat {
    private String section;
    private int row, 
                col;
    private boolean is_reserved;  

    public Seat(String section, int row, int col, boolean is_reserved) {
        this.section = section;
        this.row = row;
        this.col = col;
        this.is_reserved = is_reserved;
    }

    public boolean getIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(boolean is_reserved) {
        this.is_reserved = is_reserved;
    } 

    @Override
    public String toString() {
        return "Seat{" + "section=" + section + ", row=" + row + ", col=" + col + ", is_reserved=" + is_reserved + '}';
    }
    
    
    
    
    
}
