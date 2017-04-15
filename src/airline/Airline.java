/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.util.Scanner;


public class Airline {
    private final int fRow = 5;
    private final int fCol = 4;
    private final int eRow = 15;
    private final int eCol = 6;
    private Seat[][]first_class = new Seat[fRow][fCol];
    private Seat[][]economy = new Seat[eRow][eCol];
    
    public Airline() {
    
    }
    
    public void create_seating()
    {
        // Create first class seats
        for(int i = 0; i < fRow; i++)
        {
            for(int j = 0; j < fCol; j++)
            {
                Seat seat = new Seat("first class", i, j, false);
                first_class[i][j] = seat;
            }
        }
        
        // Create economy seats
        for(int i = 0; i < eRow; i++)
        {
            for(int j = 0; j < eCol; j++)
            {
                Seat seat = new Seat("economy", i, j, false);
                economy[i][j] = seat;
            }
        }
    }
    
    public int general_available_seats_f()
    {
        int count = 0;
        for(int i = 0; i < fRow; i++)
        {
            for(int j = 0; j < fCol; j++)
            {
                if(!first_class[i][j].getIs_reserved())
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public int general_available_seats_e()
    {
        int count = 0;
        for(int i = 0; i < eRow; i++)
        {
            for(int j = 0; j < eCol; j++)
            {
                if(!economy[i][j].getIs_reserved())
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public int general_available_seats_all()
    {
        return general_available_seats_f() + general_available_seats_e();
    }
    
    public void book_first_class(int groupNum, String seatChoice)
    {
        int count = 0;
        
        if(groupNum == 1 && seatChoice.equalsIgnoreCase("W"))
        {

                for(int i = 0; i < fRow; i++)
                {
                    for(int j = 0; j < fCol; j = j + 3)
                    {
                        if(!first_class[i][j].getIs_reserved() && count < groupNum)
                        {
                            first_class[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                } 
            
            System.out.println(count + " passengers added.");
        }
        else if(groupNum == 1 && seatChoice.equalsIgnoreCase("A"))
        {

                for(int i = 0; i < fRow; i++)
                {
                    for(int j = 1; j < 3; j++)
                    {
                        if(!first_class[i][j].getIs_reserved() && count < groupNum)
                        {
                            first_class[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                }

            System.out.println(count + " passengers added.");
        }
        if(groupNum == 2 && seatChoice.equalsIgnoreCase("W"))
        {

                for(int i = 0; i < fRow; i++)
                {
                    for(int j = 0; j < fCol; j = j + 3)
                    {
                        if(!first_class[i][j].getIs_reserved() && count < groupNum)
                        {
                            first_class[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                }
            System.out.println(count + " passengers added.");
        }
        else if(groupNum == 2 && seatChoice.equalsIgnoreCase("A"))
        {

                for(int i = 0; i < fRow; i++)
                {
                    for(int j = 1; j < 3; j++)
                    {
                        if(!first_class[i][j].getIs_reserved() && count < groupNum)
                        {
                            first_class[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                }
            System.out.println(count + " passengers added.");
        }
  
    }
    
    public void book_economy(int groupNum, String seatChoice)
    {
        int count = 0;
        
        if(seatChoice.equalsIgnoreCase("W"))
        {

                for(int i = 0; i < eRow; i++)
                {
                    for(int j = 0; j < eCol; j = j + 5)
                    {
                        if(!economy[i][j].getIs_reserved() && count < groupNum)
                        {
                            economy[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                } 
            
            System.out.println(count + " passengers added.");
        }
        
        if(seatChoice.equalsIgnoreCase("C"))
        {

                for(int i = 0; i < eRow; i++)
                {
                    for(int j = 1; j < eCol; j = j + 3)
                    {
                        if(!economy[i][j].getIs_reserved() && count < groupNum)
                        {
                            economy[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                } 
            
            System.out.println(count + " passengers added.");
        }
        
        if(seatChoice.equalsIgnoreCase("A"))
        {

                for(int i = 0; i < eRow; i++)
                {
                    for(int j = 2; j < 4; j++)
                    {
                        if(!economy[i][j].getIs_reserved() && count < groupNum)
                        {
                            economy[i][j].setIs_reserved(true);
                            count++;
                        }
                    }
                } 
            
            System.out.println(count + " passengers added.");
        }
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airline plane = new Airline();
        plane.create_seating();
        
        String runProgram = "",
               availableSeating = "", 
               addPassengerChoice = "",
               sectionChoice = "",
               fSeatChoice = "",
               eSeatChoice = "";
        
        int fGroupNum = 0, 
            eGroupNum = 0;
        
        do{
            System.out.println("\nWould you like to run the Airline Seating Program(Y/N)?");
            runProgram = scanner.nextLine();
            
            if(!runProgram.equalsIgnoreCase("N"))
            {
                System.out.println("\nWould you like to see available passenger seating(Y/N)?");
                availableSeating = scanner.nextLine();
                
                if(availableSeating.equalsIgnoreCase("Y"))
                {
                    System.out.println("\n-------General Seating Information -------");
                    System.out.println("Total Seats: All = 110, First Class = 20, Economy = 90");
                    System.out.println("Available Seats: All = " + plane.general_available_seats_all() +
                                       ", First Class = " + plane.general_available_seats_f() + 
                                       ", Economy = " + plane.general_available_seats_e());
                    System.out.println("Filled Seats: All = " + (110 - plane.general_available_seats_all()) +
                                       ", First Class = " + (20 - plane.general_available_seats_f()) + 
                                       ", Economy = " + (90 - plane.general_available_seats_e()));
                    
                    System.out.println("\n-------Detailed First Class Seating Information -------");
                    for(int i = 0; i < plane.fRow; i++)
                    {
                        for(int j = 0; j < plane.fCol; j++)
                        {
                            System.out.print(plane.first_class[i][j].toString() + " ");
                            
                        }
                    }
                    System.out.println("\n-------Detailed Economy Seating Information -------");
                    for(int i = 0; i < plane.eRow; i++)
                    {
                        for(int j = 0; j < plane.eCol; j++)
                        {
                            System.out.print(plane.economy[i][j].toString() + " ");
                            
                        }
                    }
                    
                    
                }
            
                System.out.println("\nWould you like to add passengers(Y/N)?");
                addPassengerChoice = scanner.nextLine();
                
                if(addPassengerChoice.equalsIgnoreCase("Y"))
                {
                    System.out.println("\nWould you like First Class or Economy (F/E)?");
                    sectionChoice = scanner.nextLine();
                
                    if(sectionChoice.equalsIgnoreCase("F"))
                    {
                        System.out.println("\nFirst Class is limited to two people in a group.");
                        System.out.println("How many people are in your group?");
                        fGroupNum = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("\nWould you like the window or aisle (W/A)?");
                        fSeatChoice = scanner.nextLine();
                        
                        plane.book_first_class(fGroupNum, fSeatChoice);
                    }
                    else
                    {
                        System.out.println("\nEconomy is limited to three people in a group.");
                        System.out.println("How many people are in your group?");
                        eGroupNum = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("\nWould you like the window, center, or aisle (W/C/A)?");
                        eSeatChoice = scanner.nextLine();
                        
                        plane.book_economy(eGroupNum, eSeatChoice);
                    }
                    
                    
                }
            }

            
        }while(!runProgram.equalsIgnoreCase("N"));
        
        
        
    }
    
}
