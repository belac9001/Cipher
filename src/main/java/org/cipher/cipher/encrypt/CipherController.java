package org.cipher.cipher.encrypt;

import org.cipher.cipher.model.Message;
import org.cipher.cipher.utility.Cipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cipher")
public class CipherController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    private final Cipher CIPHER = new Cipher();

    @RequestMapping(method = RequestMethod.GET)
    public String cipherInput(Model model)
    {
        model.addAttribute("message", new Message());
        return "cipher";
    }

    @RequestMapping(params="encrypt", method = RequestMethod.POST)
    public String encryptMessage(@ModelAttribute Message message, Model model)
    {
        Cipher cipher = new Cipher();
        model.addAttribute("message", message);
        String[] words = message.getContent().split("\\s+");
        StringBuilder encrypted = new StringBuilder();

        for(int i = 0; i < words.length; ++i)
            encrypted.append(cipher.encode(words[i]) + " ");

        message.setContent(encrypted.toString());
        log.info("encrypted: " + message.getContent());
        return "encrypt";
    }

    @RequestMapping(params="decrypt", method = RequestMethod.POST)
    public String decryptMessage(@ModelAttribute Message message, Model model)
    {
        Cipher cipher = new Cipher();
        model.addAttribute("message", message);
        String[] words = message.getContent().split("\\s+");
        StringBuilder decrypted = new StringBuilder();

        for(int i = 0; i < words.length; ++i)
            decrypted.append(cipher.decode(words[i]) + " ");

        message.setContent(decrypted.toString());
        log.info("decrypted: " + message.getContent());
        return "decrypt";
    }
}