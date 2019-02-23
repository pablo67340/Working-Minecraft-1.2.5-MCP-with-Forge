package net.minecraft.src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5String {

   private String field_27370_a;


   public MD5String(String p_i715_1_) {
      this.field_27370_a = p_i715_1_;
   }

   public String func_27369_a(String p_27369_1_) {
      try {
         String var2 = this.field_27370_a + p_27369_1_;
         MessageDigest var3 = MessageDigest.getInstance("MD5");
         var3.update(var2.getBytes(), 0, var2.length());
         return (new BigInteger(1, var3.digest())).toString(16);
      } catch (NoSuchAlgorithmException var4) {
         throw new RuntimeException(var4);
      }
   }
}
