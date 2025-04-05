package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    // 이전과 달리 뷰의 이름을 리턴(String),

    /**
     * @param params Http 요청에서 넘어온 데이터
     * @param model MVC model
     * @return view 의 이름
     */
    String process(Map<String, Object> params, Map<String, Object> model);
}
