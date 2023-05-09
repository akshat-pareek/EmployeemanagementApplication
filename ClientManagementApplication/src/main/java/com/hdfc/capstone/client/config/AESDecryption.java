package com.hdfc.capstone.client.config;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.util.Base64Utils;

public class AESDecryption {
	
	private static final String KEY = "32313029282726252423222120191817";
    
    public static String decrypt(String encryptedDate) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64Utils.decodeFromString(encryptedDate));
        return new String(decrypted);
    }
}
