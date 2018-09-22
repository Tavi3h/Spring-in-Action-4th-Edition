package spittr.email;

import javax.mail.MessagingException;

import spittr.domain.Spittle;

public interface SpitterMailService {

    void sendSimpleSpittleEmail(String to, Spittle spittle);

    void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException;

    void sendRichSpittleEmail(String to, Spittle spittle) throws MessagingException;
}