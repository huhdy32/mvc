package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/front-controller/v3/*")
@Slf4j
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        this.controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        this.controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        this.controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ControllerV3 controller = controllerMap.get(req.getRequestURI());
        log.info("controller: {}", controller);
        if (controller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final Map<String, Object> params = createParamMap(req);
        final ModelView modelView = controller.process(params);

        final MyView myView = viewResolver(modelView);
        myView.render(modelView.getModel(), req, resp);
    }

    private MyView viewResolver(ModelView modelView) {
        return new MyView("/WEB-INF/view/" + modelView.getViewName() + ".jsp");
    }

    private Map<String, Object> createParamMap(HttpServletRequest req) {
        final Map<String, Object> params = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(param -> params.put(param, req.getParameter(param)));
        return params;
    }
}

