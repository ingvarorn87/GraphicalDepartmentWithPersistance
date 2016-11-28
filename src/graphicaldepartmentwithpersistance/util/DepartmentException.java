/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicaldepartmentwithpersistance.util;

/**
 *
 * @author jeppjleemoritzled
 */
public class DepartmentException extends Exception
{
    // All constructors are copied from super for full compliance
    // No implementation here. Message used for messages to GUI
    
    public DepartmentException()
    {
    }

    public DepartmentException(String message)
    {
        super(message);
    }

    public DepartmentException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DepartmentException(Throwable cause)
    {
        super(cause);
    }

    public DepartmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
