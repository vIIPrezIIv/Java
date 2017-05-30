/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
//@XmlType(propOrder={"employeeList"})
//@XmlAccessorType(XmlAccessType.FIELD)
/**
 *
 * @author Ray
 */
public class EmployeeList /*implements Serializable*/ extends ArrayList<Employee> {
    
    /**
     * get for the EmployeeList
     * @return 
     */
    @XmlElement(name="employee") 
    public ArrayList<Employee> getList()
    {
        return this;
    }
    
    /*@XmlElementWrapper(name="employeeList")
    @XmlElement(name="employee") 
    private ArrayList<Employee> employeeList;
    
    public EmployeeList() {
        employeeList = new ArrayList<>();
    }
    
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public void setEmployeeList(ArrayList<Employee> newEmployeeList) {
        this.employeeList = newEmployeeList;
    }*/
    
}
