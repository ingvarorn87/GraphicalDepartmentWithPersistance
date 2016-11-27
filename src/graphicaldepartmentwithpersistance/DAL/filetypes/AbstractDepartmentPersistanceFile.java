/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.DAL.filetypes;

import graphicaldepartmentwithpersistance.BE.Department;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author jeppjleemoritzled
 */
public abstract class AbstractDepartmentPersistanceFile
{
    protected final String fileName;

    public AbstractDepartmentPersistanceFile(String fileName)
    {
        this.fileName = fileName;
    }
    
    public void clearAll() throws IOException
    {
        // Ereases the content of the file without deleting it.
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.setLength(0);
    }
    
    public abstract void saveAll(List<Department> depts) throws IOException;
    public abstract void addDepartment(Department d) throws IOException;
    public abstract void deleteById(int id) throws IOException;
    public abstract Department getById(int departmentId) throws IOException;
    public abstract List<Department> getAll() throws IOException;
}
