/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Gary
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.commons.codec.binary.Base64;
 
public class ManipulateImage {
 
    // Decode String into an Image
    public static void convertStringtoImage(Imagen entity) {
 
        try {
            // ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            // Decode String using Base64 Class
            byte[] imageByteArray = Base64.decodeBase64(entity.getEncodedString());
           
            // Write Image into File system - Make sure you update the path
            FileOutputStream imageOutFile = 
                    new FileOutputStream("C:\\Users\\Public\\Documents\\Documents\\NetBeansProjects\\FdTrcksArg\\web\\resources\\" + entity.getFilename());
            
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
 
            System.out.println("Image Successfully Stored");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Image Path not found" + fnfe);
        } catch (IOException ioe) {
            System.out.println("Exception while converting the Image " + ioe);
        }
 
    }
 
}
