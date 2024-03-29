package org.chenfeng.taling.common.utils;

import org.chenfeng.taling.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * @author chenfeng
 * @Package org.chenfeng.taling.common.utils
 * @date 2019-08-31 18:25
 */
public class ShiroUtils {
    /**
     * md5加密方式
     */
    public final static String HASH_ALGORITHM_NAME = "MD5";

    /**
     * 加密迭代次数
     */
    public final static int HASH_ITERATIONS = 2;

    /**
     * rememberMe cookie加密秘钥
     */
    public final static String CIPHER_KEY = "EKCW3ATrgUk9naKebkOU7A==";

    /**
     * 基于MD5的加密算法
     * @param password
     * @param salt
     * @return
     */
    public static String MD5(String password, String salt) {
        return new SimpleHash(HASH_ALGORITHM_NAME, password, salt, HASH_ITERATIONS).toHex();
    }

    /**
     * 判断当前用户是否登录
     * @return
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     * 退出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取随机盐
     * @return
     */
    public static String getSalt(){
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }

    /**
     * 获取当前登录用户
     *
     * @return User
     */
    public static User getCurrentUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static void  main(String[] args){
        /*生成盐以及加密码并保存*/
        String salt = "16fcfcb77c137bfbb3b3dc6b8f2e462b";
        String md5Password = ShiroUtils.MD5("123",salt);

        System.out.println( salt);
        System.out.println( md5Password);

        try {
            KeyGenerator  keygen = KeyGenerator.getInstance("AES");
            SecretKey deskey = keygen.generateKey();
            System.out.println(Base64.encodeToString(deskey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
