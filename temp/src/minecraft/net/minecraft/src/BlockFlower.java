package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFlower extends Block {

   protected BlockFlower(int p_i1059_1_, int p_i1059_2_, Material p_i1059_3_) {
      super(p_i1059_1_, p_i1059_3_);
      this.field_378_bb = p_i1059_2_;
      this.func_253_b(true);
      float var4 = 0.2F;
      this.func_213_a(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
   }

   protected BlockFlower(int p_i548_1_, int p_i548_2_) {
      this(p_i548_1_, p_i548_2_, Material.field_1329_i);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_) && this.func_269_b(p_243_1_.func_600_a(p_243_2_, p_243_3_ - 1, p_243_4_));
   }

   protected boolean func_269_b(int p_269_1_) {
      return p_269_1_ == Block.field_337_v.field_376_bc || p_269_1_ == Block.field_336_w.field_376_bc || p_269_1_ == Block.field_446_aB.field_376_bc;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      this.func_268_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      this.func_268_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
   }

   protected final void func_268_h(World p_268_1_, int p_268_2_, int p_268_3_, int p_268_4_) {
      if(!this.func_223_g(p_268_1_, p_268_2_, p_268_3_, p_268_4_)) {
         this.func_259_b_(p_268_1_, p_268_2_, p_268_3_, p_268_4_, p_268_1_.func_602_e(p_268_2_, p_268_3_, p_268_4_), 0);
         p_268_1_.func_690_d(p_268_2_, p_268_3_, p_268_4_, 0);
      }

   }

   public boolean func_223_g(World p_223_1_, int p_223_2_, int p_223_3_, int p_223_4_) {
      return (p_223_1_.func_28104_m(p_223_2_, p_223_3_, p_223_4_) >= 8 || p_223_1_.func_647_i(p_223_2_, p_223_3_, p_223_4_)) && this.func_269_b(p_223_1_.func_600_a(p_223_2_, p_223_3_ - 1, p_223_4_));
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 1;
   }
}
