package com.semtax.application.interceptor;

import com.semtax.application.entity.Post;
import com.semtax.application.repository.PostRepository;
import com.semtax.application.util.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class PostAuthInterceptor implements HandlerInterceptor {

    @Autowired
    PostRepository postRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String httpMethod = request.getMethod();

        if(httpMethod.equals("POST") || httpMethod.equals("DELETE")) {
            String sessionItem = (String)request.getSession().getAttribute(Sessions.SESSION_ID);
            Map<?, ?> pathVariables = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            Long id = Long.parseLong((String)pathVariables.get("id"));

            Post post = postRepository.findById(id).get();
            String postWriter = post.getCreatedBy();

            if(!postWriter.equals(sessionItem)){
                response.getOutputStream().println("NOT AUTHORIZE!!");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
