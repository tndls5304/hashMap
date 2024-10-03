package com.si.hashmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HashMapController<S, S1> {

    @GetMapping("hash1/out")
    public Map<String,String> practice(){
        //해시로 저장하고 꺼내보기
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("a","red");
        hashMap.put("b","blue");
        hashMap.put("c","pink");

         hashMap.forEach((k,v)->{
             System.out.println(String.format("key: %s, value: %s", k, v));
         });
         return hashMap;
    }
}
