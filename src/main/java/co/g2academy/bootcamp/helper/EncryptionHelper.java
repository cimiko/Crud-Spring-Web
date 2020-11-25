/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author cimiko
 */
public class EncryptionHelper {
    
    public static String encrypt(String plainText){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(
                plainText.getBytes(StandardCharsets.UTF_8));
            return new String(Hex.encode(hash));
        }catch(NoSuchAlgorithmException ex){
            ex.printStackTrace();
        }
        return null;    
    }
    
    public static Boolean match(String plainText, String encrypted){
        String encryptedPlainText = encrypt(plainText);
        return encryptedPlainText!=null && 
                encryptedPlainText.equals(encrypted);
    }
}
