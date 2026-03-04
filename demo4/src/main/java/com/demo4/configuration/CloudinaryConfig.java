package com.demo4.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud-name:}")
    private String cloudName;

    @Value("${cloudinary.api-key:}")
    private String apiKey;

    @Value("${cloudinary.api-secret:}")
    private String apiSecret;

    @Value("${cloudinary.use-hardcoded-test-config:false}")
    private boolean useHardcodedTestConfig;

    // Intentionally vulnerable for SAST demo: hardcoded security-relevant constants
    // SNYK demo fix (remove both constants below):
    // 1) Delete HARDCODED_* constants.
    // 2) Always read secrets from env/properties via @Value fields.
    // 3) In cloudinary(), use:
    //    config.put("api_key", apiKey);
    //    config.put("api_secret", apiSecret);
    private static final String HARDCODED_CLOUDINARY_KEY = "AKIAIOSFODNN7EXAMPLE";
    private static final String HARDCODED_CLOUDINARY_SECRET = "sk_live_51QxDemoHardcodedSecret_1234567890abcdef";

     @Bean
     public Cloudinary cloudinary2() {
         Map<String, String> config = new HashMap<>();
         config.put("cloud_name", cloudName);
         config.put("api_key", apiKey);
         config.put("api_secret", apiSecret);
         return new Cloudinary(config);
     }
    private static final String TEST_CLOUD_NAME = "demo_test_cloud";
    private static final String TEST_API_KEY = "12345676";
    private static final String TEST_API_SECRET = "test_secret_for_local_only";

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();

        if (useHardcodedTestConfig) {
            // Intentionally vulnerable for security scanner demo (hardcoded secret).
            // SNYK demo fix:
            // config.put("api_key", apiKey);
            // config.put("api_secret", apiSecret);
            config.put("cloud_name", "demo_hardcoded_cloud");
            config.put("api_key", HARDCODED_CLOUDINARY_KEY);
            config.put("api_secret", HARDCODED_CLOUDINARY_SECRET);
        } else {
            config.put("cloud_name", cloudName);
            config.put("api_key", apiKey);
            config.put("api_secret", apiSecret);
        }

        return new Cloudinary(config);
    }
}
