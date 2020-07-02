package io.tmesh.decrypt.test;

import io.tmesh.decrypt.TMeshAES;
import org.junit.Assert;
import org.junit.Test;

public class DecryptTest {
    private static final String SOURCE_CONTENT = "{\n" +
            "  \"secret\" : \"HDatTQJ_IqGvbFb\",\n" +
            "  \"timestamp\" : 1593657394475\n" +
            "}";

    @Test
    public void decrypt() {
        String source = "gUnMdEYTf20AvlaD+DE+ZWcTLyz1CFcDoBdL5R/lTz0uJKi1M081SDKwL5HdpbH0XXc3wPw9l/R59eFsRHD4glKshW86KYvJV3WpkuDAJFU=",
                password = "7995650942245126";
        Assert.assertEquals(TMeshAES.doDecrypt(source, password), SOURCE_CONTENT);
    }
}
