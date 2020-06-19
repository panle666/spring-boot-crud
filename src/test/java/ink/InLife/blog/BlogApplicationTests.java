package ink.InLife.blog;

import ink.InLife.blog.helper.HttpHelp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
		String str = doEncryptRSA("154471992999058139479994460025815654498183391593444870454838266974581244599191659985455957889064163942388409487313472074598227824609910604156744751985833898809065078785899074110993629452358669379496163284362583792866500058660069050752020922895749548342185553141417346777273482310707415185758164008066298773949","123");
	}

	public String doEncryptRSA(String module,String msg) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		BigInteger modulus = new BigInteger(module,10);
		BigInteger publicExponent = new BigInteger("10001");
		RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus,publicExponent);
		PublicKey publicKey = keyFactory.generatePublic(rsaPublicKeySpec);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE,publicKey);
		byte[]  encryptData = cipher.doFinal(msg.getBytes());
		String res = bytesToHexString(encryptData);
		return ("RSA-"+res).toUpperCase();
	}

	/**
	 * 生成16进制字符串这个要看具体后端处理方式选择返回什么字符串有的只需要Basic64就行了
	 * @param bArr
	 * @return
	 */
	public static  String bytesToHexString(byte[] bArr) {
		StringBuffer sb = new StringBuffer(bArr.length);
		String sTmp;

		for (int i = 0; i < bArr.length; i++) {
			sTmp = Integer.toHexString(0xFF & bArr[i]);
			if (sTmp.length() < 2)
				sb.append(0);
			sb.append(sTmp.toUpperCase());
		}

		return sb.toString();
	}

}
