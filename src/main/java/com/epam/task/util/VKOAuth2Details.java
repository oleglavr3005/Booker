package com.epam.task.util;

public class VKOAuth2Details {
    public static final String userAuthorizationUri="https://oauth.vk.com/authorize";
    public static final String clientId="5616331";
    public static final String clientSecret="0B5ZmAwGPqZ3xNzqtp9R";
    public static final String scope="email"; 
    public static final String redirectUri="http://localhost:8080/booker/vk_oauth";
    public static final String usersGetMethodUri="https://api.vk.com/method/users.get";
    public static final String wallPostMethodUri="https://api.vk.com/method/wall.post";
}
