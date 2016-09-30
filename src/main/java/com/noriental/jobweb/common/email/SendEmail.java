package com.noriental.jobweb.common.email;

/**
 * 发送邮件服务
 *
 * @author wangzhj
 */
public interface SendEmail {

    /**
     * 发送邮件
     *
     * @param subject
     * @param message
     * @ return String
     */
    public String sendEmail(String subject, String message);
}
