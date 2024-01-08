package com.transaction.demo.util;

// ESAPISanitizerUtil.java
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.errors.ValidationException;

public class ESAPISanitizerUtil {

    private static final Codec codec = ESAPI.encoder();

    public static String sanitizeInput(String input) throws ValidationException {
        return codec.encodeForHTML(input);
    }

    // You can add more sanitization methods based on your requirements

}
