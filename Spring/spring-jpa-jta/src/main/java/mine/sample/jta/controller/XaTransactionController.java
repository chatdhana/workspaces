package mine.sample.jta.controller;

import mine.sample.jta.dto.XaTransactionDto1;
import mine.sample.jta.dto.XaTransactionDto2;
import mine.sample.jta.service.XaTransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/XaTxn")
public class XaTransactionController {
    private Logger logger = LoggerFactory.getLogger(XaTransactionController.class);

    @Autowired
    private XaTransactionService service;

    /**
     * 
     * @return status
     */
    @RequestMapping(method = RequestMethod.GET)
    public String doXaTransaction() {
        logger.info("Invoking XA Transaction service");
        service.doXaTransaction();
        return "Done";
    }

    @RequestMapping("/failureCase")
    public String doXaTransaction(@ModelAttribute XaTransactionDto1 dto1, @ModelAttribute XaTransactionDto2 dto2) {
        logger.info("Invoking XA Transaction service");
        service.doXaTransaction(dto1, dto2);
        return "Done";
    }

}
