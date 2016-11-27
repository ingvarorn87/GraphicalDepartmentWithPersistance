/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.BLL;

import graphicaldepartmentwithpersistance.BE.Department;
import graphicaldepartmentwithpersistance.BE.FileType;
import graphicaldepartmentwithpersistance.DAL.DepartmentPersistanceManager;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppe
 */
public class DepartmentManager
{
    private static final String FILE_NAME = "Departments";
    private final DepartmentPersistanceManager dpm;

    public DepartmentManager()
    {
        dpm = new DepartmentPersistanceManager(FILE_NAME);
    }
    
    public void setFileType(FileType type)
    {
        dpm.setFileType(type);
    }
    public void clearAll()
    {
        try
        {
            dpm.clearAll();
        }
        catch (IOException ex)
        {
            Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addDepartment(Department d)
    {
        try
        {
            dpm.addDepartment(d);
        }
        catch (IOException ex)
        {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void addAll(List<Department> depts)
    {
        try
        {
            dpm.addAll(depts);
        }
        catch (IOException ex)
        {
            Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Department> getAll()
    {
        try
        {
            return dpm.getAll();
        }
        catch (IOException ex)
        {
            Logger.getLogger(DepartmentManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    public Department getById(int departmentId)
    {
        try
        {
            return dpm.getById(departmentId);
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to read department");
        }
    }

    public void delete(Department d)
    {

        try
        {
            dpm.deleteById(d.getId());
        } catch (IOException ex)
        {
            throw new RuntimeException("Unable to delete department");
        }

    }

}
