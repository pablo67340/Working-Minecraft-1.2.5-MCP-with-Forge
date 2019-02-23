package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.TextureOffset;

public abstract class ModelBase {

   public float field_1244_k;
   public boolean field_1243_l = false;
   public List field_35394_j = new ArrayList();
   public boolean field_40301_k = true;
   private Map field_39000_a = new HashMap();
   public int field_40299_l = 64;
   public int field_40300_m = 32;


   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {}

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {}

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {}

   protected void func_40298_a(String p_40298_1_, int p_40298_2_, int p_40298_3_) {
      this.field_39000_a.put(p_40298_1_, new TextureOffset(p_40298_2_, p_40298_3_));
   }

   public TextureOffset func_40297_a(String p_40297_1_) {
      return (TextureOffset)this.field_39000_a.get(p_40297_1_);
   }
}
