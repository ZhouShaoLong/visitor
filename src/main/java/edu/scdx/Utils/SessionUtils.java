package edu.scdx.Utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Menfer on 2017/7/22.
 */
public class SessionUtils {
    /**
     * getCurrentSession方法
     * 新建session并返回当前session
     **/
    public static HttpSession getCurrentSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(true);   //如没有session就创建一个
        return session;
    }
}
