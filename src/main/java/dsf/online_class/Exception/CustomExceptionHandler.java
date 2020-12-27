package dsf.online_class.Exception;

import dsf.online_class.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomException.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){
        logger.error("系统异常",e);
        if(e instanceof CustomException){
            CustomException customException =( CustomException) e;
            return JsonData.buildError(customException.getCode(),customException.getMsg());
        }else  {
            return  JsonData.buildError("未知错误");
        }
    }
}