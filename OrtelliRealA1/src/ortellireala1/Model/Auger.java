/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ortellireala1.Model;

/**
 *
 * @author Ray
 */
public class Auger extends PTOAttachment{
    
    @Override
    public void attach()
    {
        
    }
    
    @Override
    public void remove()
    {
        
    }
    
    @Override
    public String use()
    {
        return this.toString();
    }
    
    @Override
    public String toString(){
        return "auger";
    }
    
}
