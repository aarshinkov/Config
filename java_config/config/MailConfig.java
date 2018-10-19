package <some_package>

import java.util.*;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MailConfig
{
  @Bean
  public JavaMailSender getJavaMailSender()
  {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);

    mailSender.setUsername("pureshotssupp@gmail.com"); //mail which you send mail from
    mailSender.setPassword("Changeisgood1234"); //password for above mail

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }
}
