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

    private static final String TEST_CLOUD_NAME = "demo_test_cloud";
    private static final String TEST_API_KEY = "123456789012345";
    private static final String TEST_API_SECRET = "test_secret_for_local_only";

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();

        if (useHardcodedTestConfig) {
            config.put("cloud_name", TEST_CLOUD_NAME);
            config.put("api_key", TEST_API_KEY);
            config.put("api_secret", TEST_API_SECRET);
        } else {
            config.put("cloud_name", cloudName);
            config.put("api_key", apiKey);
            config.put("api_secret", apiSecret);
        }

        return new Cloudinary(config);
    }
}
