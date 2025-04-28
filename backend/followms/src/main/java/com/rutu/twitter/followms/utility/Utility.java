package com.rutu.twitter.followms.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utility {
    public static String generateToken(String userName, String email) throws NoSuchAlgorithmException {
        String combinedData = userName + email;
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Use SHA-256
        byte[] hash = digest.digest(combinedData.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyToken(String token, String userName, String email) throws NoSuchAlgorithmException {
        return token.equals(generateToken(userName, email));
    }
}
