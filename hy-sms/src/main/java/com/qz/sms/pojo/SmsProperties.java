package com.qz.sms.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 齐桢
 * @site www.qz.com
 */
@Data
@ConfigurationProperties(prefix = "wlkg.sms")
public class SmsProperties {
    private String accessKeyId;

    private String accessKeySecret;

    private String signName;

    private String verifyCodeTemplate;
}
