package com.mg.encrypt;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;

/**
 * @author 01391642
 * @date 2021/8/12
 */
@Slf4j
public class TokenUtils {

    private TokenUtils() {}

    private static final int RADIX = 32;

    private static final String JOIN_SYMBOL_STR = "_";

    public static void main(String[] args) {
        String encryptStr = "89019162";
        String seedNumStr = "2021081210491628736502944";
        String token = getToken(encryptStr, seedNumStr);
        String encryptStr2 = parseToken(token, seedNumStr);
    }

    /**
     * 获取token信息
     * 
     * @param encryptStr 用于生成token的基础信息
     * @param seedNumStr 种子
     * @return
     */
    public static final String getToken(String encryptStr, String seedNumStr) {
        if (StringUtils.isBlank(encryptStr)) {
            return StringUtils.EMPTY;
        }

        long curTimeMillis = System.currentTimeMillis();
        String trEncryptStr = encryptStr + JOIN_SYMBOL_STR + curTimeMillis;
        BigInteger biEncryptStr = new BigInteger(trEncryptStr.getBytes());
        BigInteger bir0 = new BigInteger(seedNumStr);
        BigInteger bir1 = bir0.xor(biEncryptStr);
        return bir1.toString(RADIX);
    }

    /**
     * 获取token原始信息
     * 
     * @param token token信息
     * @param seedNumStr 种子
     * @return
     */
    public static final String parseToken(String token, String seedNumStr) {
        if (StringUtils.isBlank(token)) {
            return StringUtils.EMPTY;
        }

        BigInteger biConfuse = new BigInteger(seedNumStr);
        try {
            BigInteger bir1 = new BigInteger(token, RADIX);
            BigInteger bir0 = bir1.xor(biConfuse);
            String trEncryptStr = new String(bir0.toByteArray());
            return trEncryptStr.split(JOIN_SYMBOL_STR)[0];
        } catch (Exception e) {
            log.error("TokenUtils parseToken is error={}", e.toString());
            return StringUtils.EMPTY;
        }
    }
}
