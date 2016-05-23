
package com.shufensoft.crm.polySpire.api.base;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *  @ProjectName: sf-crm  
 *  @Description: BaseController
 *  @author litu  litu@shufensoft.com
 *  @date 2015/5/15  
 */
public class BaseController {

    /**
     * logger
     */
    private static final Logger logger = Logger.getLogger(BaseController.class);



    /**
     * 分页默认页大小：40
     */
    protected static final int PAGE_SIZE = 40;

    /**
     * 返回错误信息key
     */
    protected static final String ERROR_MESSAGE_KEY = "errorMessage";

    /**
     * 返回错误码key
     */
    protected static final String ERROR_CODE_KEY = "errorCode";

    /**
     * 返回内容key
     */
    protected static final String INFO_KEY = "info";

    /**
     * 返回内容key
     */
    protected static final String PAGINATOR_KEY = "paginator";

    protected static final String PAGINATOR_ACTIVITY_KEY = "activityPaginator";

    /**
     * 返回码
     */
    protected static interface ErrorCode{

        public static final String ERROR = "-1";

        public static final String SUCCESS = "0";

    }



    /**
     * 解析validate校验的结果,把错误信息进行封装
     *
     * @param result
     * @return
     */
    protected String getError(BindingResult result) {
        if (result == null || result.getErrorCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : result.getAllErrors()) {
            sb.append(objectError.getDefaultMessage()).append("<br/>");
        }
        return sb.toString();
    }

    /**
     * 统一错误处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    public void exception(HttpServletRequest request, Exception e) {

        logger.error("统一错误处理", e);
        //添加自己的异常处理逻辑，如日志记录　　　
        request.setAttribute("exceptionMessage", e.getMessage());

        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    logger.error("BaseController.exception:",e1);
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        String header = request.getHeader("X-Requested-With");
        boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;
        if(isAjax){
            request.setAttribute(ERROR_MESSAGE_KEY,sw.toString());
            return ;
        }
        request.setAttribute(ERROR_MESSAGE_KEY, sw.toString());
    }
}
