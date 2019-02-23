package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityItem extends Entity {

   public ItemStack field_801_a;
   public int field_800_b = 0;
   public int field_805_c;
   private int field_802_f = 5;
   public float field_804_d = (float)(Math.random() * 3.141592653589793D * 2.0D);


   public EntityItem(World p_i327_1_, double p_i327_2_, double p_i327_4_, double p_i327_6_, ItemStack p_i327_8_) {
      super(p_i327_1_);
      this.func_371_a(0.25F, 0.25F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
      this.func_347_a(p_i327_2_, p_i327_4_, p_i327_6_);
      this.field_801_a = p_i327_8_;
      this.field_605_aq = (float)(Math.random() * 360.0D);
      this.field_608_an = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
      this.field_607_ao = 0.20000000298023224D;
      this.field_606_ap = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
   }

   protected boolean func_25021_m() {
      return false;
   }

   public EntityItem(World p_i328_1_) {
      super(p_i328_1_);
      this.func_371_a(0.25F, 0.25F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
   }

   protected void func_21057_b() {}

   public void func_370_e_() {
      super.func_370_e_();
      if(this.field_805_c > 0) {
         --this.field_805_c;
      }

      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.field_607_ao -= 0.03999999910593033D;
      if(this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) == Material.field_1331_g) {
         this.field_607_ao = 0.20000000298023224D;
         this.field_608_an = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
         this.field_606_ap = (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F);
         this.field_615_ag.func_623_a(this, "random.fizz", 0.4F, 2.0F + this.field_9312_bd.nextFloat() * 0.4F);
      }

      this.func_28014_c(this.field_611_ak, (this.field_601_au.field_1697_b + this.field_601_au.field_1702_e) / 2.0D, this.field_609_am);
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      float var1 = 0.98F;
      if(this.field_9298_aH) {
         var1 = 0.58800006F;
         int var2 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
         if(var2 > 0) {
            var1 = Block.field_345_n[var2].field_355_bo * 0.98F;
         }
      }

      this.field_608_an *= (double)var1;
      this.field_607_ao *= 0.9800000190734863D;
      this.field_606_ap *= (double)var1;
      if(this.field_9298_aH) {
         this.field_607_ao *= -0.5D;
      }

      ++this.field_800_b;
      if(this.field_800_b >= 6000) {
         this.func_395_F();
      }

   }

   public boolean func_397_g_() {
      return this.field_615_ag.func_682_a(this.field_601_au, Material.field_1332_f, this);
   }

   protected void func_355_a(int p_355_1_) {
      this.func_396_a(DamageSource.field_35542_a, p_355_1_);
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.func_9281_M();
      this.field_802_f -= p_396_2_;
      if(this.field_802_f <= 0) {
         this.func_395_F();
      }

      return false;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("Health", (short)((byte)this.field_802_f));
      p_352_1_.func_749_a("Age", (short)this.field_800_b);
      p_352_1_.func_763_a("Item", this.field_801_a.func_1086_a(new NBTTagCompound()));
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_802_f = p_357_1_.func_745_d("Health") & 255;
      this.field_800_b = p_357_1_.func_745_d("Age");
      NBTTagCompound var2 = p_357_1_.func_743_k("Item");
      this.field_801_a = ItemStack.func_35864_a(var2);
      if(this.field_801_a == null) {
         this.func_395_F();
      }

   }

   public void func_6378_b(EntityPlayer p_6378_1_) {
      if(!this.field_615_ag.field_1026_y) {
         int var2 = this.field_801_a.field_1615_a;
         if(this.field_805_c == 0 && p_6378_1_.field_778_b.func_504_a(this.field_801_a)) {
            if(this.field_801_a.field_1617_c == Block.field_385_K.field_376_bc) {
               p_6378_1_.func_27026_a(AchievementList.field_25198_c);
            }

            if(this.field_801_a.field_1617_c == Item.field_306_aD.field_291_aS) {
               p_6378_1_.func_27026_a(AchievementList.field_27376_t);
            }

            if(this.field_801_a.field_1617_c == Item.field_224_l.field_291_aS) {
               p_6378_1_.func_27026_a(AchievementList.field_40464_w);
            }

            if(this.field_801_a.field_1617_c == Item.field_40417_bo.field_291_aS) {
               p_6378_1_.func_27026_a(AchievementList.field_40465_z);
            }

            this.field_615_ag.func_623_a(this, "random.pop", 0.2F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            p_6378_1_.func_443_a_(this, var2);
            if(this.field_801_a.field_1615_a <= 0) {
               this.func_395_F();
            }
         }

      }
   }

   public boolean func_48080_j() {
      return false;
   }
}
