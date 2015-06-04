/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Gary
 */
public class Imagen {
    
    private String encodedString;
    private String filename;

    public Imagen() {
    }

    public Imagen(String encodedString, String filename) {
        this.encodedString = encodedString;
        this.filename = filename;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }

    public String getFilename() {
        return filename;
    }

    public void setFile_name(String filename) {
        this.filename = filename;
    }
    
    
    
}
