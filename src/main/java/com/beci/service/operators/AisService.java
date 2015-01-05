package com.beci.service.operators;

import com.beci.model.dao.ProfileDAO;
import com.beci.service.xml.truemove.MessageReply;
import com.beci.service.xml.truemove.reply.Rsr;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional(propagation= Propagation.REQUIRED)
public class AisService {
    @Value("#{config['mo.priority.ais']}")
    private int priority;
    @Resource
    private ProfileDAO profileDAO;
    public String process(final String xml){
//        MessageReply messageReply = new MessageReply();
////        messageReply.setId("routerpbifh_MR=>SMSGW1@pbifh_MR => SMSGW1:379066894");
//        Rsr rsr = new Rsr();
////        rsr.setServiceId("0101102156");
////        rsr.setType(RsrType.REPLY.getType());
////        messageReply.setRsr(rsr);
//        System.out.println(profileDAO.findAll().size());
//
//        XStream stream = new XStream();
//        stream.processAnnotations(MessageReply.class);
//
        return "";
    }

//    public int getCount(){
//        test();
//        return profileDAO.findAll().size();
//    }
//
//    public void test(){
//        List<ProfileModel> profileModelList = new ArrayList<ProfileModel>();
//        ProfileModel profileModel;
//        for (int i = 0; i < 20001; i++) {
//            profileModel = new ProfileModel();
//            profileModel.setFirstName(i+"");
//            profileModel.setLastName(i+"");
//            profileModelList.add(profileModel);
//        }
//        profileDAO.persist(profileModelList);
//    }
}
