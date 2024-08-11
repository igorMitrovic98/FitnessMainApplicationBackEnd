package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.MessageDTO;
import unibl.etf.ip.fitnessappbackend.models.Message;
import unibl.etf.ip.fitnessappbackend.repositories.MessageRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public String save(MessageDTO messageDTO) {
        Message message = new Message();
        message.setDateTime(LocalDate.now());
        BeanUtils.copyProperties(messageDTO, message);
        message = messageRepository.save(message);
        return message.getId().toString();
    }


    public void update(String id,String id2, Integer n) {

        messageRepository.updateSeenMessages(id,id2);
    }

    public List<Message> getBySenderAndReceiver(String id) {
        List<Message> list =messageRepository.findAllBySenderNameOrReceiverName(id,id);
        list.removeIf(msg -> msg.getReceiverName().equals("support"));
        return list;
    }

}
