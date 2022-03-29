package com.shiyi.mybatis_plus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    ServerRequest serverRequest;


    @Test
    void test2() {
        String[] arr = { "ma", "zhi", "chu", "is", "java", "developer", "family" };
        Stream<String> stream1 = Arrays.stream(arr);

        String sentence = "ma zhi chu is a Java wechat official account.";
        //匹配非单词\W
        Stream<String> wordStream = Pattern.compile("\\W")
                .splitAsStream(sentence);
        String[] wordArr = wordStream.toArray(String[]::new);
        System.out.println(Arrays.toString(wordArr));


    }
    @Test
    void test3() {
        System.out.println(serverRequest.exchange().getRequest().getQueryParams());

    }


}
