package mine.spring.mvc.controller;

import java.util.Locale;

import javax.validation.Valid;

import mine.spring.mvc.common.MessageConstant;
import mine.spring.mvc.domain.dto.AbstractResponse;
import mine.spring.mvc.domain.dto.EqualValidationDto;
import mine.spring.mvc.domain.dto.SimpleResponse;
import mine.spring.mvc.util.MessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equalValidation")
public class EqualValidationController {

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(method = RequestMethod.GET)
    public AbstractResponse validate(@Valid @ModelAttribute EqualValidationDto equalValidationDto,
            BindingResult bindingResult, Locale locale) throws Exception {
        SimpleResponse response = null;
        if (bindingResult.hasErrors()) {
            response = messageUtil.addFailureMessagesToResponse(SimpleResponse.class, locale,
                    bindingResult.getAllErrors(), MessageConstant.COMMON_INPUT_ERROR);
        } else {
            response = messageUtil.addSuccessMessageToResponse(SimpleResponse.class, locale,
                    MessageConstant.COMMON_SUCCESS);
        }
        return response;
    }
}
