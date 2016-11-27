/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.DAL;

import graphicaldepartmentwithpersistance.DAL.filetypes.*;
import graphicaldepartmentwithpersistance.BE.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jeppe
 */
public final class DepartmentPersistanceManager
{
    private AbstractDepartmentPersistanceFile fileHandler;
    private String fileName;
    
    
    public void setFileType(FileType type)
    {
        switch(type)
        {
            case TEXTFILE:
                fileHandler = new DepartmentPersistanceTextFile(fileName);
                break;
            case RANDOM_BINARY:
                fileHandler = new DepartmentPersistanceRandomTextFile(fileName);
                break;
            case SERIALIZED:
                fileHandler = new DepartmentPersistanceSerializedFile(fileName);
                break;
        }
    }
    
    public DepartmentPersistanceManager(String fileName)
    {
        this(fileName, FileType.SERIALIZED);
    }
    
    public DepartmentPersistanceManager(String fileName, FileType type)
    {
        this.fileName = fileName;
        setFileType(type);
    }

    public void addDepartment(Department d) throws IOException
    {
        fileHandler.addDepartment(d);
    }

    public List<Department> getAll() throws IOException
    {
        return fileHandler.getAll();
    }

    public Department getById(int departmentId) throws IOException
    {
        return fileHandler.getById(departmentId);
    }

    public void deleteById(int id) throws IOException
    {
        fileHandler.deleteById(id);
    }
    public void clearAll() throws IOException
    {
        fileHandler.clearAll();
    }

    public void addAll(List<Department> depts) throws IOException
    {
        fileHandler.saveAll(depts);
    }
    
}
