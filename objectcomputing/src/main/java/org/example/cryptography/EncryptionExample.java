package org.example.cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;

/**
 * A simple example of encrypting some data
 */
public class EncryptionExample implements Constants {

    public static void main(String[] args) throws Exception {

        // Create the secret/symmetric key
        KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");

        // Create the cipher for encrypting
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        // Encrypt the data
        byte[] encrypted = cipher.doFinal(DATA);

        // Save the encrypted data
        FileOutputStream fos = new FileOutputStream(DATA_FILE);
        fos.write(encrypted);
        fos.close();

        // Save the cipher settings
        byte[] encodedKeySpec = skeySpec.getEncoded();
        FileOutputStream eksos = new FileOutputStream(KEY_FILE);
        eksos.write(encodedKeySpec);
        eksos.close();
    }
}
