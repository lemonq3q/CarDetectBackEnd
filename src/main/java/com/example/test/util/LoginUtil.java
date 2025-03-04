package com.example.test.util;

import java.util.Random;

public class LoginUtil {

    /**
     * 生成验证码
     * @return
     */

    //Captcha：验证码
    //用随机数生成5位的验证码并返回
    public static String generateCaptcha(){
        Random random = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(10);//生成[0，10）的随机数
            captcha += Integer.toString(x);
        }
        return captcha;
    }
    /**
     * 验证激活码是否正确
     * @param activationCode
     * @return
     */
    public static int verifyActivationCode(String activationCode){
        try {
            int plainLength = (int)activationCode.charAt(0)-33;
            String plaintext = activationCode.substring(1, 1 + plainLength);
            int cipherLength = (int)activationCode.charAt(1+plainLength)-33;
            String ciphertext = activationCode.substring(2 + plainLength, 2 + plainLength + cipherLength);
            if(ciphertext.equals(encrypt(plaintext))){
                return 1;
            }
            return 0;
        }
        catch (Exception e){
            return 0;
        }
    }

    /**
     * 加密
     * @param plaintext
     * @return
     */
    public static String encrypt(String plaintext){
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            if((i+1)%2==0){
                ciphertext += plaintext.charAt(i);
            }
            ciphertext += (char)((int)(plaintext.charAt(i)+i)%94+33);
        }
        return ciphertext;
    }

    /**
     * 生成激活码
     * @return
     */
    public static String generateActivationCode(){
        String activationCode = "";
        String plaintext = "";
        String ciphertext;
        Random random = new Random();
        int plainLength = random.nextInt(6)+20;
        activationCode += (char)(plainLength+33);
        for (int i = 0; i < plainLength; i++) {
            plaintext += (char)(random.nextInt(94)+33);
        }
        ciphertext = encrypt(plaintext);
        activationCode += plaintext;
        activationCode += (char)(ciphertext.length()+33);
        activationCode += ciphertext;
        for (int i = 0; i < random.nextInt(6)+15; i++) {
            activationCode += (char)(random.nextInt(94)+33);
        }
        return activationCode;
    }

    public static void main(String[] args) {
//        String x = "11111111";
//        String y = encrypt(x);
//        String code = "";
//        code += (char)(x.length()+33);
//        code += x;
//        code += (char)(y.length()+33);
//        code += y;
//        String z = "2222";
//        code += z;
//        System.out.println(code);
//        System.out.println(verifyActivationCode(code));
        System.out.println(generateActivationCode());
        String x = "8K?JxLVs,3b\\ih[c/>Z~BQcOCl?amx>qV|<,T\\b.)i77[+4/_oZ.SBv(c;(}lrR63&ut^y/dt24d<9";
    }
}
