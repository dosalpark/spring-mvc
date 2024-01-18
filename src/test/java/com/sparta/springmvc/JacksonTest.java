package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {
    @Test
    @DisplayName("Object To JSON : get Method 필요")
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);     //Object(star)에서 json으로 변경
        ObjectMapper objectMapper = new ObjectMapper();     // Jackson 라이브러리의 ObjectMapper
        String json = objectMapper.writeValueAsString(star);//objectMapper에 star를 담아서 String형태인 json으로 변환

        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : 기본생성자& (get or set) Method 필요")
    void test2() throws JsonProcessingException{
        String json = "{\"name\":\"Robbie\",\"age\":95}";       //json에서 Object(star)로 변경
        ObjectMapper objectMapper = new ObjectMapper();         //json을 Object로 변경하기위해 ObjectMapper 생성
        Star star = objectMapper.readValue(json, Star.class);   //Star클래스의 star인스턴스에게 json을 object형식으로 맵핑해서 입력

        System.out.println("star.getName() =" + star.getName());
        System.out.println("star.getAge() =" + star.getAge());
    }


}
