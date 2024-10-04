package com.si.hashmap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/make/hashmap")
public class HashMapController {
    private HashMap<String, Integer> aHashMap = new HashMap<>();

    //데이터 넣기
    @PostMapping("put")
    public ResponseEntity<String> put(@RequestBody HashMap<String, Integer> data) {
        //data.keySet() 메서드는 맵(Map)에서 모든 키를 가져오는 메서드
        for (String key : data.keySet()) {
            aHashMap.put(key, data.get(key));
        }
        return ResponseEntity.ok("Data inserted successfully!");
    }

    //데이터 조회
    @GetMapping("get/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        Integer value = aHashMap.get(key);
        if (value == null) {
            return ResponseEntity.status(404).body("value not found! key:" + key);
        } else {
            return ResponseEntity.ok("key:" + key + "and value:" + value);
        }
    }

    //데이터 삭제
    @DeleteMapping("remove/{key}")
    public ResponseEntity<String> remove(@PathVariable String key) {
        aHashMap.remove(key);
        return ResponseEntity.ok(key + "key removed successfully!");
    }
    //해시맵의 크기확인
    @GetMapping("size")
    public ResponseEntity<String> size(){
        return ResponseEntity.ok("size of hashMap: "+aHashMap.size());
    }
}
