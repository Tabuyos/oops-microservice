package com.tabuyos.microservice.oops.oauth2.authorization.config;

import cn.hutool.core.codec.Base64Encoder;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * Description:
 *
 * <pre>
 *   <b>project: </b>oops-microservice
 *   <b>package: </b>com.tabuyos.microservice.oops.oauth2.authorization.config
 *   <b>class: </b>KeyConfig
 *   comment here.
 * </pre>
 *
 * @author
 *     <pre><b>username: </b><a href="http://www.tabuyos.com">Tabuyos</a></pre>
 *     <pre><b>site: </b><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></pre>
 *     <pre><b>email: </b>tabuyos@outlook.com</pre>
 *     <pre><b>description: </b>
 *       <pre>
 *         Talk is cheap, show me the code.
 *       </pre>
 *     </pre>
 *
 * @version 0.1.0
 * @since 0.1.0 - 3/3/21 4:24 PM
 */
public class KeyConfig {
  private static final String KEY_STORE_FILE = ".keystore-oauth2-demo";
  private static final String KEY_STORE_PASSWORD = "tabuyos";
  private static final String KEY_ALIAS = "oauth2-demo-key";
  private static final KeyStoreKeyFactory KEY_STORE_KEY_FACTORY =
      new KeyStoreKeyFactory(
          new ClassPathResource(KEY_STORE_FILE), KEY_STORE_PASSWORD.toCharArray());
  static final String VERIFIER_KEY_ID =
      Base64Encoder.encode(KeyGenerators.secureRandom(32).generateKey());

  static RSAPublicKey getVerifierKey() {
    return (RSAPublicKey) getKeyPair().getPublic();
  }

  static RSAPrivateKey getSignerKey() {
    return (RSAPrivateKey) getKeyPair().getPrivate();
  }

  private static KeyPair getKeyPair() {
    return KEY_STORE_KEY_FACTORY.getKeyPair(KEY_ALIAS);
  }
}
