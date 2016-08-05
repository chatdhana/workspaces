package mine.sample.nonjta.controller;

import mine.sample.jta.service.XaTransactionService;
import mine.sample.nonjta.dto.NonXaTransactionDto1;
import mine.sample.nonjta.dto.NonXaTransactionDto2;
import mine.sample.nonjta.service.NonXaTransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NonXaTxn")
public class NonXaTransactionController {
    private Logger logger = LoggerFactory.getLogger(NonXaTransactionController.class);

    @Autowired
    private NonXaTransactionService service;

    /**
     * 
     * @return status
     */
    @RequestMapping(method = RequestMethod.GET)
    public String doXaTransaction() {
        logger.info("Invoking Non-XA Transaction service");
        service.doXaTransaction();
        return "Done";
    }

    @RequestMapping("/failureCase")
    public String doXaTransaction(@ModelAttribute NonXaTransactionDto1 dto1, @ModelAttribute NonXaTransactionDto2 dto2) {
        logger.info("Invoking Non-XA Transaction service");
        service.doXaTransaction(dto1, dto2);
        return "Done";
    }

}
