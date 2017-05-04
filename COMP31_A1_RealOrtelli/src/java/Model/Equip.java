/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "SingleEquip", propOrder = {
//    "equipName"
//})
@XmlRootElement(name = "SingleEquip", namespace = "AssignmentOne")

/**
 *
 * @author Ray
 */
public class Equip implements Serializable {
    
    /**
     * Constructor for the Equip Class
     */
    public Equip() {
 
    }
    
    private String equipName;
    /**
     * Get the value of equipName
     *
     * @return the value of equipName
     */
    public String getName()
    {
        return equipName;
    }
    /**
     * Set the value of equipName
     *
     * @param newEquipName new value of equipName
     */
    public void setName(String newEquipName)
    {
        this.equipName = newEquipName;
    }
    /**
     * toString for equipName
     * @return 
     */
    @Override
    public String toString() {
        return this.equipName;
    }
    
}
