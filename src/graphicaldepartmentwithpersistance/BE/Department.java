/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.BE;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jeppe
 */
public class Department implements Serializable
{

    private final IntegerProperty id; 
    private final StringProperty name; 

    public Department()
    {
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
    }

    public Department(int id, String name)
    {
        this();
        this.id.set(id);
        this.name.set(name);
    }
    
    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }
    
    public int getId()
    {
        return id.get();
    }

    public void setId(int value)
    {
        id.set(value);
    }

    public IntegerProperty idProperty()
    {
        return id;
    }
    

    @Override
    public String toString()
    {
        return String.format("%4d %-50s", id, name);
    }
}
