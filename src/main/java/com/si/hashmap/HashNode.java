package com.si.hashmap;

public class HashNode<K, V> {
    final int hash;//해시값.이 해시값을 통해 HashMap이 저장 위치를 결정
    final K key;//키.키는 고유하며, 이를 사용해 값을 찾는다
    V value;//값: 해시 충돌이 발생했을 때, 연결 리스트 형태로 다음 노드를 가리킴
    HashNode<K, V> next; //다음 노드 (다음 키-밸류 쌍)

    public HashNode(int hash, K key, V value, HashNode<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
    //HashMap의 내부 구조에서, 각 Node는 키와 값을 저장하는 한 쌍의 데이터를 표현하는 객체입니다. H
}
