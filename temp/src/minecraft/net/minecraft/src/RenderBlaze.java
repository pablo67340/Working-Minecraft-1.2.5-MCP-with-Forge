package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBlaze;
import net.minecraft.src.RenderLiving;

public class RenderBlaze extends RenderLiving {

   private int field_40278_c;


   public RenderBlaze() {
      super(new ModelBlaze(), 0.5F);
      this.field_40278_c = ((ModelBlaze)this.field_20920_e).func_40321_a();
   }

   public void func_40277_a(EntityBlaze p_40277_1_, double p_40277_2_, double p_40277_4_, double p_40277_6_, float p_40277_8_, float p_40277_9_) {
      int var10 = ((ModelBlaze)this.field_20920_e).func_40321_a();
      if(var10 != this.field_40278_c) {
         this.field_40278_c = var10;
         this.field_20920_e = new ModelBlaze();
      }

      super.func_171_a(p_40277_1_, p_40277_2_, p_40277_4_, p_40277_6_, p_40277_8_, p_40277_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_40277_a((EntityBlaze)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_40277_a((EntityBlaze)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
