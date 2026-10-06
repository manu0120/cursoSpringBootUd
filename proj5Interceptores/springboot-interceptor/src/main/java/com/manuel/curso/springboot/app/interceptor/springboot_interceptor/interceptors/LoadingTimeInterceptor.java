package com.manuel.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{
    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
            HandlerMethod methodName = (HandlerMethod) handler;
            logger.info("LoadingTimeInterceptor preHandle() entrando.... {}", methodName.getMethod().getName());
            long start = System.currentTimeMillis();
            request.setAttribute("startTime", start);

            Random random = new Random();
            int delay = random.nextInt(500);
            Thread.sleep(delay);
            // if false is retorned, the request or code flow will be stopped
            /*
            Map<String, String> json = new HashMap<>();
            json.put("error", "no tienes acceso a esta página");
            json.put("date", new Date().toString());
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(json);
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(jsonStr);
            return false;
            */

            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        @Nullable ModelAndView modelAndView) throws Exception {
            HandlerMethod methodName = (HandlerMethod) handler;
            logger.info("LoadingTimeInterceptor postHandle() saliendo.... {}", methodName.getMethod().getName());
            long start = (Long) request.getAttribute("startTime");
            long end = System.currentTimeMillis();
            long loadingTime = end - start;
            logger.info("LoadingTimeInterceptor postHandle() tiempo de carga: {} ms", loadingTime);
    }
}
