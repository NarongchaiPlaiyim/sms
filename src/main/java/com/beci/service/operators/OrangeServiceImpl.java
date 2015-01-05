package com.beci.service.operators;

import com.beci.ContentType;
import com.beci.Encoding;
import com.beci.internaltest.TestLombok;
import com.beci.model.ProfileModel;
import com.beci.model.dao.ProfileDAO;
import com.beci.service.response.RequestResponseService;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.IntStream;

@Service("orangeServiceImpl")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class OrangeServiceImpl extends RequestResponseService implements OperatorService {
    @Resource private ProfileDAO profileDAO;

    @Value("#{config['mo.priority.orange']}") private int priority;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) {
        try {
            normalLogger.debug("SIZE : {}", profileDAO.findAll().size());
            normalLogger.debug("asdfasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
            normalLogger.debug("--orange : {}", priority);

            TestLombok testLombok = new TestLombok();
            testLombok.setName("TEST NA JA");
            normalLogger.debug("TEST LOMBOK : {}", testLombok.getName());

//            profileDAO.delete(profileDAO.findAll());


            IntStream.rangeClosed(1, 10)
                    .forEach((n) -> {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setFirstName("test"+n);
                        profileModel.setLastName("test"+n);
                        try {
                            profileDAO.persist(profileModel);
                            normalLogger.debug("Inserted");
                        } catch (Exception e) {

                        }
                    });

            profileDAO.delete(profileDAO.findAll());
        } catch (Exception e) {
            System.err.println(e);
        }
        response.setStatus(HttpStatus.SC_OK);
        response.setContentType(ContentType.TEXT_HTML.getType());
        response.setContentLength(Encoding.ISO_8859_1.getEncodingHeadTag().length());
        flushResponse(response, Encoding.ISO_8859_1.getEncodingHeadTag(), Encoding.ISO_8859_1);
    }



}
