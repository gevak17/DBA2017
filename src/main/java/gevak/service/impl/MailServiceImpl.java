package gevak.service.impl;

import gevak.entity.User;
import gevak.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void send(User user) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress("gevakproject@gmail.com"));
            System.out.println("----------------------------!!!!!!!!");
            helper.setTo(user.getEmail());
            helper.setText("Thank you to registration ", true);
            System.out.println("----------------------------!!!!!!!!+++++++++++");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------!!!!!!!!///////////////");
        javaMailSender.send(mimeMessage);
        System.out.println("----------------------------!!!!!!!!*************");
//        "Thank you to registration " + "<strong>" +user.getSurName()+" "+ user.getName()+ "</strong> "+"  , you cool!"

    }
}
