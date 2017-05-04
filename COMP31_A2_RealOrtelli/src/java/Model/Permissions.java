/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ray
 */
public class Permissions {
    
    int permissionId;
    
    /**
     * Constructor
     */
    public Permissions()
    {
        permissionId = -1;
    }
    
    /**
     * Returns Permission
     * @return 
     */
    public int getPermission()
    {
        return permissionId;
    }
    
    /**
     * Sets Permission
     * @param newPermissionId 
     */
    public void setPermission(int newPermissionId)
    {
        this.permissionId = newPermissionId;
    }
}

