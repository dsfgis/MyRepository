package dsf.online_class.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import dsf.online_class.utils.JWTUtils;
import dsf.online_class.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前进行拦截，检校token信息
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        try {

            //从http头或参数中获取token值
            String token = request.getHeader("token");
            if(token == null){
                token = request.getParameter("token");
            }
            if(StringUtils.isNotBlank(token)){
                //解密token
                Claims claims = JWTUtils.checkJWT(token);
                if(claims == null){
                    //登录过期
                    sendJsonMessage(response,JsonData.buildError("login error"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("user_id",id);
                request.setAttribute("name",name);
                return true;
            }
            sendJsonMessage(response,JsonData.buildError("login error"));
            return false;
        }
        catch (Exception e ){

            sendJsonMessage(response,JsonData.buildError("login error"));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 响应登录信息给前端
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response,Object obj){
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        }catch (Exception e) {
            e.printStackTrace();
        }
     }

}
