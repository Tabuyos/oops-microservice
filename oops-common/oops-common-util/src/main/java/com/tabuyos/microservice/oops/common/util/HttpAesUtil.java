package com.tabuyos.microservice.oops.common.util;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;
import com.tabuyos.microservice.oops.common.util.exception.HttpAesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.util</i>
 *   <b>class: </b><i>HttpAesUtil</i>
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 *     <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 *     <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 *     <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 10:09 AM
 */
public class HttpAesUtil {

  private static final Logger log = LoggerFactory.getLogger(HttpAesUtil.class);

  private static final String CHAR_SET = "UTF-8";

  /**
   * 加密
   *
   * @param contentParam 需要加密的内容
   * @param keyParam 加密密码
   * @param md5Key 是否对key进行md5加密
   * @param ivParam 加密向量
   * @return 加密后的字节数据 string
   */
  public static String encrypt(
      String contentParam, String keyParam, boolean md5Key, String ivParam) {
    try {
      byte[] content = contentParam.getBytes(CHAR_SET);
      byte[] key = keyParam.getBytes(CHAR_SET);
      byte[] iv = ivParam.getBytes(CHAR_SET);

      if (md5Key) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        key = md.digest(key);
      }
      SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
      // "算法/模式/补码方式"
      Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding");
      // 使用CBC模式, 需要一个向量iv, 可增加加密算法的强度
      IvParameterSpec ivps = new IvParameterSpec(iv);
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivps);
      byte[] bytes = cipher.doFinal(content);
      return Base64Encoder.encode(bytes);
    } catch (Exception ex) {
      log.error("加密密码失败", ex);
      throw new HttpAesException("加密失败");
    }
  }

  /**
   * 解密
   *
   * @param contentParam 需要加密的内容
   * @param keyParam 加密密码
   * @param md5Key 是否对key进行md5加密
   * @param ivParam 加密向量
   * @return string
   */
  public static String decrypt(
      String contentParam, String keyParam, boolean md5Key, String ivParam) {
    try {
      if (PubUtils.isNull(contentParam, keyParam, md5Key, ivParam)) {
        return "";
      }
      byte[] content = Base64Decoder.decode(contentParam);
      byte[] key = keyParam.getBytes(CHAR_SET);
      byte[] iv = ivParam.getBytes(CHAR_SET);

      if (md5Key) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        key = md.digest(key);
      }
      SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
      // "算法/模式/补码方式"
      Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding");
      // 使用CBC模式, 需要一个向量iv, 可增加加密算法的强度
      IvParameterSpec ivps = new IvParameterSpec(iv);
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivps);
      byte[] bytes = cipher.doFinal(content);
      return new String(bytes, CHAR_SET);
    } catch (Exception ex) {
      log.error("解密密码失败", ex);
      throw new HttpAesException("解密失败");
    }
  }
}
