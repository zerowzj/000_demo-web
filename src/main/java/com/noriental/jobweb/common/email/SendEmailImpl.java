package com.noriental.jobweb.common.email;

import org.apache.commons.mail.SimpleEmail;

public class SendEmailImpl implements SendEmail {

    /** 主机名 */
    private String hostName = null;
    /** 用户名 */
    private String userName = null;
    /** 密码 */
    private String password = null;

    /** 发件人 */
    private String from = null;
    /** 收件人 */
    private String to = null;

    @Override
    public String sendEmail(String subject, String msg) {
        String result = null;
        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName(hostName);                  //服务器
            email.setAuthentication(userName, password); //用户名和密码
            email.setFrom(from); //发信人
            email.addTo(to);     //收信人
            email.setSubject(subject); //主题
            email.setMsg(msg);         //内容
            //发送
            result = email.send();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.print(result);
        return result;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
