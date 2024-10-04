package com.si.hashmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class HashMapStudyController<S, S1> {
    @GetMapping("hash/out")
    public ResponseEntity<String> practice1() throws JsonProcessingException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "red");
        hashMap.put("b", "blue");
        hashMap.put("c", "pink");

        //forEach로 hashMap의 키 밸류 인자값을 받아서 출력해보기
        hashMap.forEach((k, v) -> {
            System.out.println(String.format("key**: %s, value**: %s", k, v));
        });

        //해시맵 담겨진 형태
        System.out.println("hashMap?" + hashMap);

        /* @@RestCOntroller, @ResponseBody 빼고
         직접 json 문자열로 바꿔서 내보내기*/
        String jsonStr = new ObjectMapper().writeValueAsString(hashMap);
        return ResponseEntity.ok().body(jsonStr);
    }


    /*keySet은 myHashMap의 키를 직접 참조하는 뷰이기 때문에,
    키셋에서 수행하는 모든 수정 작업은 원본 HashMap에도 반영이 된다 */
    @ResponseBody
    @GetMapping("hash/keyset")
    public Set<Integer> practice2() {
        Map<Integer, String> myHashMap = new HashMap<>();
        myHashMap.put(1, "say");
        myHashMap.put(2, "hello");
        myHashMap.put(3, "babe");
        Set<Integer> myKeySet = myHashMap.keySet();
        myKeySet.remove(2);

        System.out.println("myHashMap:" + myHashMap);
        return myKeySet;
    }

}
