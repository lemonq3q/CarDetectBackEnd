package com.example.test.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static Map<String, Pair<Timestamp,Integer>> userTokenMap = new ConcurrentHashMap<>();

    private static long timeout = 1000*60*30;

    public static class Pair<K,V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
        public K getFirst() {
            return first;
        }
        public V getSecond() {
            return second;
        }
        public void setFirst(K first) {
            this.first = first;
        }
        public void setSecond(V second) {
            this.second = second;
        }
    }

    public static void addToken(String token,int userid){
        Pair<Timestamp,Integer> tmpTokenMessage = new Pair<>(new Timestamp(System.currentTimeMillis()),userid);
        userTokenMap.put(token,tmpTokenMessage);
    }

    public static void removeToken(String token){
        userTokenMap.remove(token);
    }

    public static Pair<Timestamp,Integer> getTokenMessage(String token){
        Pair<Timestamp,Integer> tokenMessage = userTokenMap.get(token);
        if(tokenMessage!=null && System.currentTimeMillis()-tokenMessage.first.getTime()>timeout){
            userTokenMap.remove(token);
            return null;
        }
        return userTokenMap.get(token);
    }

    @Override
    //拦截器：鉴权
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        System.out.println("uri: "+ uri);

        //登录页面放行
        if(uri.startsWith("/upload")){
            return true;
        }

        //放行嗅探请求
        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            System.out.println("Method:OPTIONS");
            return true;
        }

        //没有token直接返回
        String token= request.getHeader("lemon-token");
        if(token==null){
//            HandleFalseResponse(response,"noUser");
            System.out.println("NoToken");
//            return false;
            return true; //测试放行
        }

        //token已经被移除
        Pair<Timestamp,Integer> tokenMessage = userTokenMap.get(token);
        if(tokenMessage==null){
//            HandleFalseResponse(response,"noUser");
            System.out.println("NoUser");
//            return false;
            return true; //测试放行
        }
        //token时间记录超过半小时
        if(System.currentTimeMillis()-tokenMessage.first.getTime()>timeout){
            this.userTokenMap.remove(token);
//            HandleFalseResponse(response,"timeout");
            System.out.println("Timeout");
//            return false;
            return true; //测试放行
        }


        //更新token信息
        Integer userid = tokenMessage.second;
        Pair<Timestamp,Integer> tmpTokenMessage = new Pair<>(new Timestamp(System.currentTimeMillis()),userid);
        this.userTokenMap.put(token,tmpTokenMessage);
        System.out.println("Token verity success");
        return true;
    }

    private static void HandleFalseResponse(HttpServletResponse response,String msg) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print("{\"code\":400,\"msg\":\"" + msg + "\"}");
        System.out.println("{\"code\":400,\"msg\":\"" + msg + "\"}");
        response.getWriter().flush();
    }
}
