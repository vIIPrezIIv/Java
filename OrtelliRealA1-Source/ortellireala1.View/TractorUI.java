/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortellireala1.View;

import ortellireala1.Model.*;
import java.util.*;

/**
 * This class is the UI of the program
 * @author Ray
 */
public class TractorUI {
    
    /**
     * This is the constructor for the TractorUI class and also contains
     * the user input commands and responses along with instances of the objects.
     * This is executed with a while loop that continues taking input until the 
     * user stops it.
     */
    public TractorUI(){
        
        Scanner keyboard = new Scanner(System.in);
        Tractor tractor = new Tractor();
        
	prompt();
        
        loop:
        
	while(keyboard.hasNext())
        {
                    String cmd = keyboard.nextLine();
                    
                    String[] cmds = cmd.trim().split(" ");
                    
                    switch (cmds[0])
                    {
                        case "start":
                            if(tractor.getGear() == 1)
                            {
                               if(tractor.getPTOStatus() == true)
                                {
                                    System.out.println("Engine can't start when PTO's engaged");
                                }
                                else
                                {
                                    tractor.startEngine();
                                    System.out.println(tractor);
                                } 
                            }
                            else
                            {
                                System.out.println("Engine can't start because it's not in neutral");
                            }
			
			    break;
                            
                        case "stop":
                                tractor.stopEngine();
                                System.out.println(tractor);
                                break;
                            
                        case "height":
                       
                            try
                            {
                                if(Integer.valueOf(cmds[1]) >= 1 && Integer.valueOf(cmds[1]) <= 10)
                                {
                                    tractor.setHeight(Float.valueOf(cmds[1]));
                                }
                                else
                                {
                                    System.out.println("Height set is to high or low");
                                }
                            }
                            
                            catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                                System.out.println("Must set a proper height number");
                            }
                        
                            break;
                            
                        case "gear":
                            
                                try
                                { 
                                    tractor.setGear(Tractor.Gear.valueOf(cmds[1]));
                                    System.out.println(tractor);
                                    break;
                                }
                                
                                catch(Exception e)
                                {
                                    System.out.println(e.getMessage());
                                    System.out.println("Must use gear name with gear");
                                }
                                
                                break;
                        
                        case "help":
                                System.out.println("                         Help Menu");
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("                          Commands");
                                System.out.println("1.start - (This turns the engine on)");
                                System.out.println("2.stop - (This stops the engine)");
                                System.out.println("3.throttle x - (This sets the throttle)");
                                System.out.println("4.gear (neutral, low, mid, high) - (This selects the gear)");
                                System.out.println("5.attach (auger, harrow, snowblower, mower, rake, blade)");
                                System.out.println("6.remove - (This removes the current attachment)");
                                System.out.println("7.drill - (This drills a hole using the auger)");
                                System.out.println("8.harrow - (This uses the harrow)");
                                System.out.println("9.quit - (Quits out of the program)");
                                System.out.println("10.use - (Uses the currently attached attachment)");
                                System.out.println("11.pto (on, off) - (This lets you turn the PTO off or on)");
                                System.out.println("12.height x (1-10) - (Sets the height for the tractor arm)");
                                System.out.println("-----------------------------------------------------------");
                                
                                break;
                            
                        case "drill":
                            if (tractor.getAttachment() == false)
                            {
                                Auger augerAuger = new Auger();
                                augerAuger.setHeight(10f);
                                tractor.attach( augerAuger );
                                tractor.setThrottle(20f);
                                tractor.startEngine();
                                tractor.engagePTO();
                                tractor.getAttachmentObject().setHeight(0f);
                                tractor.setThrottle(80f);
                                System.out.println("Time Passes");
                                tractor.setThrottle(20f);
                                tractor.getAttachmentObject().setHeight(10f);
                                tractor.disengagePTO();
                                tractor.stopEngine();
                                System.out.println(tractor);
                                tractor.remove();
                            }
                            else
                            {
                                System.out.println("Already have an Attachment");
                            }
                         
                            break;
                            
                        case "harrow":
                            if (tractor.getAttachment() == false)
                            {
                                Harrow harrowHarrow = new Harrow();
                                harrowHarrow.setHeight(0f);
                                tractor.attach( harrowHarrow );
                                tractor.startEngine();
                                tractor.setGear(Tractor.Gear.mid);
                                tractor.setThrottle(60f);
                                System.out.println("Time Passes");
                                tractor.setThrottle(20f);
                                tractor.stopEngine(); 
                                System.out.println(tractor);
                                tractor.remove();
                            }
                            else
                            {
                                System.out.println("Already have an Attachment");
                            }
                            
                            break;
                            
			case "quit":
				break loop;
                            
                        case "use":
                            if(tractor.getAttachment() == true)
                            {
                                switch(tractor.getAttachmentObject().toString())
                                {
                                    case "auger":
                                        if(tractor.getPTOStatus() == true)
                                        {
                                            if(tractor.getEngineOn() == true)
                                            {
                                                System.out.println("You used the " + tractor.getAttachmentObject().use());
                                            }
                                            else
                                            {
                                                System.out.println("The engine isn't on for the PTO to work");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("PTO isn't engaged");
                                        }
                                    
                                        break;
                                        
                                    case "harrow":
                                        System.out.println("You used the " + tractor.getAttachmentObject().use());
                                        break;
                                        
                                    case "rake":
                                        System.out.println("You used the " + tractor.getAttachmentObject().use());
                                        break;
                                        
                                    case "blade":
                                        System.out.println("You used the " + tractor.getAttachmentObject().use());
                                        break;
                                        
                                    case "mower":
                                        if(tractor.getPTOStatus() == true)
                                        {
                                            if(tractor.getEngineOn() == true)
                                            {
                                                System.out.println("You used the " + tractor.getAttachmentObject().use());
                                            }
                                            else
                                            {
                                                System.out.println("The engine isn't on for the PTO to work");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("PTO isn't engaged");
                                        }
                                    
                                        break;
                                        
                                    case "snowblower":
                                        if(tractor.getPTOStatus() == true)
                                        {
                                            if(tractor.getEngineOn() == true)
                                            {
                                                System.out.println("You used the " + tractor.getAttachmentObject().use());
                                            }
                                            else
                                            {
                                                System.out.println("The engine isn't on for the PTO to work");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("PTO isn't engaged");
                                        }
                                    
                                        break;
                                }
                            }
                            else
                            {
                                System.out.println("There is no attached attachment to use");
                            }
                        
                            break;
                              
                        case "pto":
                            
                            try
                            {
                               switch (cmds[1])
                                {
                                    case "on":
                                        tractor.engagePTO();
                                        System.out.println(tractor);
                                        break;
                                    
                                    case "off":
                                        tractor.disengagePTO();
                                        System.out.println(tractor);
                                        break;
                               } 
                            }
                            
                            catch(Exception e)
                            {
				System.out.println(e.getMessage());
				System.out.println("Must choose on/off for the pto");
                            }
                                
                                
                            break;
                            
                        case "attach":
                            try
                            {
                                if (tractor.getAttachment() == false)
                                {
                                    switch(cmds[1])
                                    {
                                        case "auger":
                                            if (tractor.getPTOStatus() == true)
                                            {
                                                System.out.println("Disengage PTO");
                                            }
                                            else
                                            {
                                                Auger newAuger = new Auger();
                                                tractor.attach(newAuger);
                                                System.out.println("Auger attached");
                                            }

                                            break;

                                        case "harrow":
                                            Harrow newHarrow = new Harrow();
                                            tractor.attach(newHarrow);
                                            System.out.println("Harrow attached");
                                            break;

                                        case "mower":
                                            if (tractor.getPTOStatus() == true)
                                            {
                                                System.out.println("Disengage PTO");
                                            }
                                            else
                                            {
                                                Mower newMower = new Mower();
                                                tractor.attach(newMower);
                                                System.out.println("Mower attached");
                                            }

                                            break;

                                        case "snowblower":
                                            if (tractor.getPTOStatus() == true)
                                            {
                                                System.out.println("Disengage PTO");
                                            }
                                            else
                                            {
                                                SnowBlower newBlower = new SnowBlower();
                                                tractor.attach(newBlower);
                                                System.out.println("Snow Blower attached");
                                            }

                                            break;

                                        case "rake":
                                            Rake newRake = new Rake();
                                            tractor.attach(newRake);
                                            System.out.println("Rake attached");
                                            break;

                                        case "blade":
                                            Blade newBlade = new Blade();
                                            tractor.attach(newBlade);
                                            System.out.println("Blade attached");
                                            break;
                                    }
                                }
                                else
                                {
                                     System.out.println("Already have an Attachment");
                                }
                            }
                            
                            catch(Exception e)
                            {
				System.out.println(e.getMessage());
				System.out.println("Must specify the attachment");
                            }
                             
                            break;
                            
                        case "remove":
                            if(tractor.getAttachment() == false)
                            {
                                System.out.println("There is no attachment attached");
                            }
                            else
                            {
                                switch(tractor.getAttachmentObject().toString())
                                {
                                    case "auger":
                                        if (tractor.getPTOStatus() == true)
                                        {
                                            System.out.println("Disenged PTO to remove attachment");
                                        }
                                        else
                                        {
                                            tractor.remove();
                                            System.out.println("Attachment removed");
                                        }
                                    
                                        break;
                                        
                                    case "harrow":
                                        tractor.remove();
                                        System.out.println("Attachment removed");
                                        
                                        break;
                                        
                                    case "rake":
                                        tractor.remove();
                                        System.out.println("Attachment removed");
                                        
                                        break;
                                        
                                    case "blade":
                                        tractor.remove();
                                        System.out.println("Attachment removed");
                                        
                                        break;
                                        
                                    case "mower":
                                        if (tractor.getPTOStatus() == true)
                                        {
                                            System.out.println("Disenged PTO to remove attachment");
                                        }
                                        else
                                        {
                                            tractor.remove();
                                            System.out.println("Attachment removed");
                                        }
                                    
                                        break;
                                     
                                    case "snowblower":
                                        if (tractor.getPTOStatus() == true)
                                        {
                                            System.out.println("Disenged PTO to remove attachment");
                                        }
                                        else
                                        {
                                            tractor.remove();
                                            System.out.println("Attachment removed");
                                        }
                                    
                                        break;
                                }
                                
                                System.out.println(tractor);
                            }
                                
                            break;      
                            
			case "throttle":
                        
				try
				{
                                    int throttle = Integer.parseInt(cmds[1]);
                                    tractor.setThrottle(throttle);
                                    System.out.println(tractor);
                                    break;
				}
				catch(Exception e)
				{
                                    System.out.println(e.getMessage());
                                    System.out.println("Must specify the throttle amount");
				}
                    }
        }
    }
    
    /**
     * This a a function that prompts the user
     */
    public static void prompt()
    {
       System.out.println("Please enter a command");     
    }

    
}
