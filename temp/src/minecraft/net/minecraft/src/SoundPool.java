package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.SoundPoolEntry;

public class SoundPool {

   private Random field_1661_c = new Random();
   private Map field_1660_d = new HashMap();
   private List field_1659_e = new ArrayList();
   public int field_1658_a = 0;
   public boolean field_1657_b = true;


   public SoundPoolEntry func_1117_a(String p_1117_1_, File p_1117_2_) {
      try {
         String var3 = p_1117_1_;
         p_1117_1_ = p_1117_1_.substring(0, p_1117_1_.indexOf("."));
         if(this.field_1657_b) {
            while(Character.isDigit(p_1117_1_.charAt(p_1117_1_.length() - 1))) {
               p_1117_1_ = p_1117_1_.substring(0, p_1117_1_.length() - 1);
            }
         }

         p_1117_1_ = p_1117_1_.replaceAll("/", ".");
         if(!this.field_1660_d.containsKey(p_1117_1_)) {
            this.field_1660_d.put(p_1117_1_, new ArrayList());
         }

         SoundPoolEntry var4 = new SoundPoolEntry(var3, p_1117_2_.toURI().toURL());
         ((List)this.field_1660_d.get(p_1117_1_)).add(var4);
         this.field_1659_e.add(var4);
         ++this.field_1658_a;
         return var4;
      } catch (MalformedURLException var5) {
         var5.printStackTrace();
         throw new RuntimeException(var5);
      }
   }

   public SoundPoolEntry func_1118_a(String p_1118_1_) {
      List var2 = (List)this.field_1660_d.get(p_1118_1_);
      return var2 == null?null:(SoundPoolEntry)var2.get(this.field_1661_c.nextInt(var2.size()));
   }

   public SoundPoolEntry func_1116_a() {
      return this.field_1659_e.size() == 0?null:(SoundPoolEntry)this.field_1659_e.get(this.field_1661_c.nextInt(this.field_1659_e.size()));
   }
}
