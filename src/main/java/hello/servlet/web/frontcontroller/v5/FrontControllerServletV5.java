package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/front-controller/v5/*")
@Slf4j
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String, Object> handlers = new HashMap<>();
    private final List<MyHandlerAdapter> adapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlers();
        initHandlerAdapters();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Object handler = findHandler(req);

        if (handler == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            log.info("NOT FOUND HANDLER");
            return;
        }
        final MyHandlerAdapter adapter = findAdapter(handler);

        final ModelView mv = adapter.handle(req, resp, handler);
        final MyView myView = viewResolver(mv);

        myView.render(mv.getModel(), req, resp);
    }

    private MyView viewResolver(ModelView modelView) {
        return new MyView("/WEB-INF/view/" + modelView.getViewName() + ".jsp");
    }

    private Object findHandler(HttpServletRequest req) {
        final String uri = req.getRequestURI();

        final Object handler = handlers.get(uri);
        return handler;
    }

    private MyHandlerAdapter findAdapter(Object handler) {
        return adapters.stream()
                .filter(adapter -> adapter.supports(handler))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private void initHandlerAdapters() {
        this.adapters.add(new ControllerV3HandlerAdapter());
        this.adapters.add(new ControllerV4HandlerAdapter());
    }

    private void initHandlers() {
        this.handlers.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        this.handlers.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        this.handlers.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        this.handlers.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        this.handlers.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        this.handlers.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }
}
