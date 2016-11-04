package com.brendon.lee.service;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Brendon Hakmin Lee
 * @date 2016. 11. 4.
 * @comment Comparator를 구현하여 정렬을 해주는 객체
 */
public class TagComparator implements Comparator<String> {
    private Map<String, Integer> tags;

    public TagComparator(Map<String, Integer> tags) {
        this.tags = tags;
    }

    @Override
    public int compare(String key1, String key2) {
        if (tags.get(key1) >= tags.get(key2)) {
            return -1;
        } else {
            return 1;
        }
    }
}