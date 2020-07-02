package io.tmesh.decrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TMeshAES {
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String doDecrypt(String source, String password) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            byte[] insecureKey = InsecureSHA1PRNGKeyDerivator.deriveInsecureKey(password.getBytes(StandardCharsets.UTF_8), 32);
            SecretKeySpec secretKeySpec = new SecretKeySpec(insecureKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] result = cipher.doFinal(Base64.getDecoder().decode(source));
            return new String(result, StandardCharsets.UTF_8);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("decrypt error: " + e.getMessage());
        }
    }
}
