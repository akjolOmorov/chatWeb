package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

	private String algorithm;
	
	public Digest(String algorithm) {
		this.algorithm = algorithm;
	}
	
	public String doEncypt(String message) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(algorithm);
 
        byte[] dataBytes = message.getBytes();
 
        md.update(dataBytes, 0, dataBytes.length);
        byte[] mdbytes = md.digest();
 
        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
 
       return sb.toString();
 
	}

}
