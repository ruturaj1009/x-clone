package com.rutu.twitter.mediams.utility;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Utility {

    public static byte[] getResizedImage(MultipartFile file, int width, int height) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(file.getInputStream())
                .size(width, height)
                .outputFormat("png")
                .toOutputStream(outputStream);
        return outputStream.toByteArray();
    }

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
