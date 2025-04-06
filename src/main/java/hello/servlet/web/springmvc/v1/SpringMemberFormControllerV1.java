package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// @Component 를 포함함으로 빈 등록 대상,
// @Controller 를 가지고 있음으로, RequestMappingHandlerMapping 의 매핑 대상
@Controller
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }
}
