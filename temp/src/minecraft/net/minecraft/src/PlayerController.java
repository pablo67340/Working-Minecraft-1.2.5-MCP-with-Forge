package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PlayerControllerCreative;
import net.minecraft.src.World;

public abstract class PlayerController {

   protected final Minecraft field_1065_a;
   public boolean field_1064_b = false;


   public PlayerController(Minecraft p_i411_1_) {
      this.field_1065_a = p_i411_1_;
   }

   public void func_717_a(World p_717_1_) {}

   public abstract void func_719_a(int var1, int var2, int var3, int var4);

   public boolean func_729_b(int p_729_1_, int p_729_2_, int p_729_3_, int p_729_4_) {
      World var5 = this.field_1065_a.field_6324_e;
      Block var6 = Block.field_345_n[var5.func_600_a(p_729_1_, p_729_2_, p_729_3_)];
      if(var6 == null) {
         return false;
      } else {
         var5.func_28106_e(2001, p_729_1_, p_729_2_, p_729_3_, var6.field_376_bc + (var5.func_602_e(p_729_1_, p_729_2_, p_729_3_) << 12));
         int var7 = var5.func_602_e(p_729_1_, p_729_2_, p_729_3_);
         boolean var8 = var5.func_690_d(p_729_1_, p_729_2_, p_729_3_, 0);
         if(var8) {
            var6.func_252_b(var5, p_729_1_, p_729_2_, p_729_3_, var7);
         }

         return var8;
      }
   }

   public abstract void func_6470_c(int var1, int var2, int var3, int var4);

   public abstract void func_6468_a();

   public void func_6467_a(float p_6467_1_) {}

   public abstract float func_727_b();

   public boolean func_6471_a(EntityPlayer p_6471_1_, World p_6471_2_, ItemStack p_6471_3_) {
      int var4 = p_6471_3_.field_1615_a;
      ItemStack var5 = p_6471_3_.func_1093_a(p_6471_2_, p_6471_1_);
      if(var5 == p_6471_3_ && (var5 == null || var5.field_1615_a == var4)) {
         return false;
      } else {
         p_6471_1_.field_778_b.field_843_a[p_6471_1_.field_778_b.field_847_d] = var5;
         if(var5.field_1615_a == 0) {
            p_6471_1_.field_778_b.field_843_a[p_6471_1_.field_778_b.field_847_d] = null;
         }

         return true;
      }
   }

   public void func_6476_a(EntityPlayer p_6476_1_) {}

   public void func_6474_c() {}

   public abstract boolean func_6469_d();

   public void func_6473_b(EntityPlayer p_6473_1_) {
      PlayerControllerCreative.func_35645_e(p_6473_1_);
   }

   public abstract boolean func_722_a(EntityPlayer var1, World var2, ItemStack var3, int var4, int var5, int var6, int var7);

   public EntityPlayer func_4087_b(World p_4087_1_) {
      return new EntityPlayerSP(this.field_1065_a, p_4087_1_, this.field_1065_a.field_6320_i, p_4087_1_.field_4209_q.field_4218_e);
   }

   public void func_6475_a(EntityPlayer p_6475_1_, Entity p_6475_2_) {
      p_6475_1_.func_6415_a_(p_6475_2_);
   }

   public void func_6472_b(EntityPlayer p_6472_1_, Entity p_6472_2_) {
      p_6472_1_.func_463_a(p_6472_2_);
   }

   public ItemStack func_27174_a(int p_27174_1_, int p_27174_2_, int p_27174_3_, boolean p_27174_4_, EntityPlayer p_27174_5_) {
      return p_27174_5_.field_20068_h.func_27280_a(p_27174_2_, p_27174_3_, p_27174_4_, p_27174_5_);
   }

   public void func_20086_a(int p_20086_1_, EntityPlayer p_20086_2_) {
      p_20086_2_.field_20068_h.func_1104_a(p_20086_2_);
      p_20086_2_.field_20068_h = p_20086_2_.field_20069_g;
   }

   public void func_40593_a(int p_40593_1_, int p_40593_2_) {}

   public boolean func_35643_e() {
      return false;
   }

   public void func_35638_c(EntityPlayer p_35638_1_) {
      p_35638_1_.func_35206_ab();
   }

   public boolean func_35642_f() {
      return false;
   }

   public boolean func_35641_g() {
      return true;
   }

   public boolean func_35640_h() {
      return false;
   }

   public boolean func_35636_i() {
      return false;
   }

   public void func_35637_a(ItemStack p_35637_1_, int p_35637_2_) {}

   public void func_35639_a(ItemStack p_35639_1_) {}
}
