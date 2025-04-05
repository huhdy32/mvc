package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        final ControllerV4 controller = (ControllerV4) handler;

        final Map<String, Object> params = getParams(request);
        final Map<String, Object> model = new HashMap<>();

        final String viewPath = controller.process(params, model);

        final ModelView mv = new ModelView(viewPath);
        mv.setModel(model);

        return mv;
    }

    private Map<String, Object> getParams(HttpServletRequest request) {
        final Map<String, Object> params = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(param -> {params.put(param, request.getParameter(param));});
        return params;
    }
}
