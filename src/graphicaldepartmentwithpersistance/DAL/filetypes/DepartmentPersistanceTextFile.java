/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.DAL.filetypes;

import graphicaldepartmentwithpersistance.BE.Department;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeppjleemoritzled
 */
public class DepartmentPersistanceTextFile extends AbstractDepartmentPersistanceFile
{

    public DepartmentPersistanceTextFile(String fileName)
    {
        super(fileName + ".txtdat");
    }

    @Override
    public void addDepartment(Department d) throws IOException
    {
        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName, true)))
        {
            bw.append(d.getId() + "," + d.getName());
            bw.newLine();
        }
        catch (IOException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(int departmentId) throws IOException
    {
        String newFileString = "";
        List<Department> depList = getAll();
        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                if (id != departmentId)
                {
                    newFileString += line;
                }
            }
        }

        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName)))
        {
            bw.write(newFileString);
        }
        catch (IOException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Department getById(int departmentId) throws IOException
    {
        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                if (id == departmentId)
                {
                    return new Department(id, fields[1].trim());
                }
            }
        }
        catch (IOException ioe)
        {
            throw ioe;
        }
        return null;
    }

    @Override
    public List<Department> getAll() throws IOException
    {
        List<Department> depList = new ArrayList();

        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                depList.add(
                        new Department(
                                Integer.parseInt(fields[0].trim()),
                                fields[1].trim()
                        ));
            }
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
        }
        return depList;
    }

    @Override
    public void saveAll(List<Department> depts) throws IOException
    {
        super.clearAll(); // deletes contents of file
        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName, true)))
        {
            for (Department dept : depts)
            {

                bw.append(dept.getId() + "," + dept.getName());
                bw.newLine();
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

}
