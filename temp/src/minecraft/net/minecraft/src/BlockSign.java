package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockSign extends BlockContainer {

   private Class field_455_a;
   private boolean field_454_b;


   protected BlockSign(int p_i501_1_, Class p_i501_2_, boolean p_i501_3_) {
      super(p_i501_1_, Material.field_1335_c);
      this.field_454_b = p_i501_3_;
      this.field_378_bb = 4;
      this.field_455_a = p_i501_2_;
      float var4 = 0.25F;
      float var5 = 1.0F;
      this.func_213_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var5, 0.5F + var4);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public AxisAlignedBB func_246_f(World p_246_1_, int p_246_2_, int p_246_3_, int p_246_4_) {
      this.func_238_a(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
      return super.func_246_f(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      if(!this.field_454_b) {
         int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
         float var6 = 0.28125F;
         float var7 = 0.78125F;
         float var8 = 0.0F;
         float var9 = 1.0F;
         float var10 = 0.125F;
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         if(var5 == 2) {
            this.func_213_a(var8, var6, 1.0F - var10, var9, var7, 1.0F);
         }

         if(var5 == 3) {
            this.func_213_a(var8, var6, 0.0F, var9, var7, var10);
         }

         if(var5 == 4) {
            this.func_213_a(1.0F - var10, var6, var8, 1.0F, var7, var9);
         }

         if(var5 == 5) {
            this.func_213_a(0.0F, var6, var8, var10, var7, var9);
         }

      }
   }

   public int func_210_f() {
      return -1;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return true;
   }

   public boolean func_217_b() {
      return false;
   }

   public TileEntity func_283_a_() {
      try {
         return (TileEntity)this.field_455_a.newInstance();
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_267_as.field_291_aS;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      boolean var6 = false;
      if(this.field_454_b) {
         if(!p_226_1_.func_599_f(p_226_2_, p_226_3_ - 1, p_226_4_).func_878_a()) {
            var6 = true;
         }
      } else {
         int var7 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
         var6 = true;
         if(var7 == 2 && p_226_1_.func_599_f(p_226_2_, p_226_3_, p_226_4_ + 1).func_878_a()) {
            var6 = false;
         }

         if(var7 == 3 && p_226_1_.func_599_f(p_226_2_, p_226_3_, p_226_4_ - 1).func_878_a()) {
            var6 = false;
         }

         if(var7 == 4 && p_226_1_.func_599_f(p_226_2_ + 1, p_226_3_, p_226_4_).func_878_a()) {
            var6 = false;
         }

         if(var7 == 5 && p_226_1_.func_599_f(p_226_2_ - 1, p_226_3_, p_226_4_).func_878_a()) {
            var6 = false;
         }
      }

      if(var6) {
         this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }

      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
   }
}
