package com.skypyb.sejwt.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.skypyb.sejwt.cryptography.Codec;


/**
 * jwt 头部主要用于储存算法类型。
 * 在 web 端请求敏感资源时返回 jwt 可方便的供服务端选择对应的算法进行匹配/解密
 *
 * @author pyb
 * @time 2019-01-28
 */
public final class Header {
    private Codec codec;
    private String alg;//签名的算法(algorithm)
    private static final String typ = "JWT";


    protected Header(Codec.Type codecType) {
        this.codec = codecType.create();
        this.alg = codecType.name();
    }

    protected Header(Codec codec, String alg) {
        this.codec = codec;
        this.alg = alg;
    }

    public Codec getEncryptor() {
        return codec;
    }

    public String toJson() {
        ObjectNode objectNode = new ObjectMapper().createObjectNode();
        objectNode.put("alg", alg);
        objectNode.put("typ", typ);
        return objectNode.toString();
    }


}