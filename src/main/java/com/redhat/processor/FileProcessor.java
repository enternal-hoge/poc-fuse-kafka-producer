package com.redhat.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        // ファイルの内容を出力
        String body = exchange.getIn().getBody(String.class);
        System.out.println("body: " + body);

        // ファイルのパスを出力
        Map<String, Object> headers = exchange.getIn().getHeaders();
        System.out.println("fileName: " + headers.get("CamelFileAbsolutePath"));
    }
}