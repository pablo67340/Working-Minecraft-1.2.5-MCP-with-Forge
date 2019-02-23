package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Facing;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityPiston extends TileEntity {

   private int field_31021_a;
   private int field_31019_b;
   private int field_31025_c;
   private boolean field_31024_i;
   private boolean field_31023_j;
   private float field_31022_k;
   private float field_31020_l;
   private static List field_31018_m = new ArrayList();


   public TileEntityPiston() {}

   public TileEntityPiston(int p_i502_1_, int p_i502_2_, int p_i502_3_, boolean p_i502_4_, boolean p_i502_5_) {
      this.field_31021_a = p_i502_1_;
      this.field_31019_b = p_i502_2_;
      this.field_31025_c = p_i502_3_;
      this.field_31024_i = p_i502_4_;
      this.field_31023_j = p_i502_5_;
   }

   public int func_31016_a() {
      return this.field_31021_a;
   }

   public int func_479_f() {
      return this.field_31019_b;
   }

   public boolean func_31015_b() {
      return this.field_31024_i;
   }

   public int func_31009_d() {
      return this.field_31025_c;
   }

   public boolean func_31012_k() {
      return this.field_31023_j;
   }

   public float func_31008_a(float p_31008_1_) {
      if(p_31008_1_ > 1.0F) {
         p_31008_1_ = 1.0F;
      }

      return this.field_31020_l + (this.field_31022_k - this.field_31020_l) * p_31008_1_;
   }

   public float func_31017_b(float p_31017_1_) {
      return this.field_31024_i?(this.func_31008_a(p_31017_1_) - 1.0F) * (float)Facing.field_31056_b[this.field_31025_c]:(1.0F - this.func_31008_a(p_31017_1_)) * (float)Facing.field_31056_b[this.field_31025_c];
   }

   public float func_31014_c(float p_31014_1_) {
      return this.field_31024_i?(this.func_31008_a(p_31014_1_) - 1.0F) * (float)Facing.field_31059_c[this.field_31025_c]:(1.0F - this.func_31008_a(p_31014_1_)) * (float)Facing.field_31059_c[this.field_31025_c];
   }

   public float func_31013_d(float p_31013_1_) {
      return this.field_31024_i?(this.func_31008_a(p_31013_1_) - 1.0F) * (float)Facing.field_31058_d[this.field_31025_c]:(1.0F - this.func_31008_a(p_31013_1_)) * (float)Facing.field_31058_d[this.field_31025_c];
   }

   private void func_31010_a(float p_31010_1_, float p_31010_2_) {
      if(!this.field_31024_i) {
         --p_31010_1_;
      } else {
         p_31010_1_ = 1.0F - p_31010_1_;
      }

      AxisAlignedBB var3 = Block.field_9268_ac.func_31035_a(this.field_824_e, this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, p_31010_1_, this.field_31025_c);
      if(var3 != null) {
         List var4 = this.field_824_e.func_659_b((Entity)null, var3);
         if(!var4.isEmpty()) {
            field_31018_m.addAll(var4);
            Iterator var5 = field_31018_m.iterator();

            while(var5.hasNext()) {
               Entity var6 = (Entity)var5.next();
               var6.func_349_c((double)(p_31010_2_ * (float)Facing.field_31056_b[this.field_31025_c]), (double)(p_31010_2_ * (float)Facing.field_31059_c[this.field_31025_c]), (double)(p_31010_2_ * (float)Facing.field_31058_d[this.field_31025_c]));
            }

            field_31018_m.clear();
         }
      }

   }

   public void func_31011_l() {
      if(this.field_31020_l < 1.0F && this.field_824_e != null) {
         this.field_31020_l = this.field_31022_k = 1.0F;
         this.field_824_e.func_692_l(this.field_823_f, this.field_822_g, this.field_821_h);
         this.func_31005_i();
         if(this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h) == Block.field_9268_ac.field_376_bc) {
            this.field_824_e.func_688_b(this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, this.field_31019_b);
         }
      }

   }

   public void func_475_b() {
      this.field_31020_l = this.field_31022_k;
      if(this.field_31020_l >= 1.0F) {
         this.func_31010_a(1.0F, 0.25F);
         this.field_824_e.func_692_l(this.field_823_f, this.field_822_g, this.field_821_h);
         this.func_31005_i();
         if(this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h) == Block.field_9268_ac.field_376_bc) {
            this.field_824_e.func_688_b(this.field_823_f, this.field_822_g, this.field_821_h, this.field_31021_a, this.field_31019_b);
         }

      } else {
         this.field_31022_k += 0.5F;
         if(this.field_31022_k >= 1.0F) {
            this.field_31022_k = 1.0F;
         }

         if(this.field_31024_i) {
            this.func_31010_a(this.field_31022_k, this.field_31022_k - this.field_31020_l + 0.0625F);
         }

      }
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      this.field_31021_a = p_482_1_.func_756_e("blockId");
      this.field_31019_b = p_482_1_.func_756_e("blockData");
      this.field_31025_c = p_482_1_.func_756_e("facing");
      this.field_31020_l = this.field_31022_k = p_482_1_.func_752_g("progress");
      this.field_31024_i = p_482_1_.func_760_m("extending");
   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      p_481_1_.func_758_a("blockId", this.field_31021_a);
      p_481_1_.func_758_a("blockData", this.field_31019_b);
      p_481_1_.func_758_a("facing", this.field_31025_c);
      p_481_1_.func_744_a("progress", this.field_31020_l);
      p_481_1_.func_748_a("extending", this.field_31024_i);
   }

}
