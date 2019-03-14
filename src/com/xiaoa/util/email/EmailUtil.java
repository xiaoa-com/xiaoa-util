package com.xiaoa.util.email;

import java.io.UnsupportedEncodingException;
import java.util.List;


import javax.mail.internet.MimeUtility;

import com.xiaoa.util.prop.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @ClassName EmailUtil
 * @Description 发送邮件工具类
 * @Author wanmeng
 * @Date 2019/3/14 17:08
 * @Version 1.0
 **/
public class EmailUtil {

    /**
     * 发送邮件
     *
     * @param toAddresses 目标邮箱
     * @param subject     主题
     * @param content     内容
     * @param directory   附件路径
     * @param fileName    附件名
     * @return
     */
    public static boolean send(List<String> toAddresses, String subject, String content, String directory, String fileName) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName(PropertiesUtil.getValueByKey("email.hostName"));
            email.setAuthentication(PropertiesUtil.getValueByKey("email.username"), PropertiesUtil.getValueByKey("email.password"));
            email.setDebug(true);
            // google
            // email.setSmtpPort(465);
            // email.setSSLOnConnect(true);
            // email.setStartTLSEnabled(true);
            email.setCharset("UTF-8");
            email.setFrom(PropertiesUtil.getValueByKey("email.username"));
            for (String toAddress : toAddresses) {
                email.addTo(toAddress);
            }
            email.setSubject(subject);
            email.setHtmlMsg(content);

            if (StringUtils.isNotBlank(directory) && StringUtils.isNotBlank(fileName)) {
                EmailAttachment attachment = new EmailAttachment();
                // 对附件名称进行编码, 防止乱码
                attachment.setName(MimeUtility.encodeText(fileName));
                attachment.setPath(directory + "/" + fileName);
                email.attach(attachment);
            }
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
