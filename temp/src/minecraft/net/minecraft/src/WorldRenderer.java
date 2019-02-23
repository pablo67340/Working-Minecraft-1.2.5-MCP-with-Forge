package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCache;
import net.minecraft.src.Entity;
import net.minecraft.src.ICamera;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderItem;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {

   public World field_1763_a;
   private int field_1744_C = -1;
   private static Tessellator field_1742_D = Tessellator.field_1512_a;
   public static int field_1762_b = 0;
   public int field_1761_c;
   public int field_1760_d;
   public int field_1759_e;
   public int field_1755_i;
   public int field_1754_j;
   public int field_1753_k;
   public int field_1752_l;
   public int field_1751_m;
   public int field_1750_n;
   public boolean field_1749_o = false;
   public boolean[] field_1748_p = new boolean[2];
   public int field_1746_q;
   public int field_1743_r;
   public int field_1741_s;
   public boolean field_1738_u;
   public AxisAlignedBB field_1736_v;
   public int field_1735_w;
   public boolean field_1734_x = true;
   public boolean field_1733_y;
   public int field_1732_z;
   public boolean field_1747_A;
   private boolean field_1739_E = false;
   public List field_1745_B = new ArrayList();
   private List field_1737_F;
   private int field_40590_G;


   public WorldRenderer(World p_i1030_1_, List p_i1030_2_, int p_i1030_3_, int p_i1030_4_, int p_i1030_5_, int p_i1030_6_) {
      this.field_1763_a = p_i1030_1_;
      this.field_1737_F = p_i1030_2_;
      this.field_1744_C = p_i1030_6_;
      this.field_1761_c = -999;
      this.func_1197_a(p_i1030_3_, p_i1030_4_, p_i1030_5_);
      this.field_1738_u = false;
   }

   public void func_1197_a(int p_1197_1_, int p_1197_2_, int p_1197_3_) {
      if(p_1197_1_ != this.field_1761_c || p_1197_2_ != this.field_1760_d || p_1197_3_ != this.field_1759_e) {
         this.func_1195_b();
         this.field_1761_c = p_1197_1_;
         this.field_1760_d = p_1197_2_;
         this.field_1759_e = p_1197_3_;
         this.field_1746_q = p_1197_1_ + 8;
         this.field_1743_r = p_1197_2_ + 8;
         this.field_1741_s = p_1197_3_ + 8;
         this.field_1752_l = p_1197_1_ & 1023;
         this.field_1751_m = p_1197_2_;
         this.field_1750_n = p_1197_3_ & 1023;
         this.field_1755_i = p_1197_1_ - this.field_1752_l;
         this.field_1754_j = p_1197_2_ - this.field_1751_m;
         this.field_1753_k = p_1197_3_ - this.field_1750_n;
         float var4 = 6.0F;
         this.field_1736_v = AxisAlignedBB.func_1168_a((double)((float)p_1197_1_ - var4), (double)((float)p_1197_2_ - var4), (double)((float)p_1197_3_ - var4), (double)((float)(p_1197_1_ + 16) + var4), (double)((float)(p_1197_2_ + 16) + var4), (double)((float)(p_1197_3_ + 16) + var4));
         GL11.glNewList(this.field_1744_C + 2, 4864);
         RenderItem.func_142_a(AxisAlignedBB.func_1161_b((double)((float)this.field_1752_l - var4), (double)((float)this.field_1751_m - var4), (double)((float)this.field_1750_n - var4), (double)((float)(this.field_1752_l + 16) + var4), (double)((float)(this.field_1751_m + 16) + var4), (double)((float)(this.field_1750_n + 16) + var4)));
         GL11.glEndList();
         this.func_1194_f();
      }
   }

   private void func_1203_g() {
      GL11.glTranslatef((float)this.field_1752_l, (float)this.field_1751_m, (float)this.field_1750_n);
   }

   public void func_1198_a() {
      if(this.field_1738_u) {
         this.field_1738_u = false;
         int var1 = this.field_1761_c;
         int var2 = this.field_1760_d;
         int var3 = this.field_1759_e;
         int var4 = this.field_1761_c + 16;
         int var5 = this.field_1760_d + 16;
         int var6 = this.field_1759_e + 16;

         for(int var7 = 0; var7 < 2; ++var7) {
            this.field_1748_p[var7] = true;
         }

         Chunk.field_1540_a = false;
         HashSet var21 = new HashSet();
         var21.addAll(this.field_1745_B);
         this.field_1745_B.clear();
         byte var8 = 1;
         ChunkCache var9 = new ChunkCache(this.field_1763_a, var1 - var8, var2 - var8, var3 - var8, var4 + var8, var5 + var8, var6 + var8);
         if(!var9.func_48452_a()) {
            ++field_1762_b;
            RenderBlocks var10 = new RenderBlocks(var9);
            this.field_40590_G = 0;

            for(int var11 = 0; var11 < 2; ++var11) {
               boolean var12 = false;
               boolean var13 = false;
               boolean var14 = false;

               for(int var15 = var2; var15 < var5; ++var15) {
                  for(int var16 = var3; var16 < var6; ++var16) {
                     for(int var17 = var1; var17 < var4; ++var17) {
                        int var18 = var9.func_600_a(var17, var15, var16);
                        if(var18 > 0) {
                           if(!var14) {
                              var14 = true;
                              GL11.glNewList(this.field_1744_C + var11, 4864);
                              GL11.glPushMatrix();
                              this.func_1203_g();
                              float var19 = 1.000001F;
                              GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
                              GL11.glScalef(var19, var19, var19);
                              GL11.glTranslatef(8.0F, 8.0F, 8.0F);
                              field_1742_D.func_977_b();
                              field_1742_D.func_984_b((double)(-this.field_1761_c), (double)(-this.field_1760_d), (double)(-this.field_1759_e));
                           }

                           if(var11 == 0 && Block.field_345_n[var18].func_48205_p()) {
                              TileEntity var23 = var9.func_603_b(var17, var15, var16);
                              if(TileEntityRenderer.field_1554_a.func_1028_a(var23)) {
                                 this.field_1745_B.add(var23);
                              }
                           }

                           Block var24 = Block.field_345_n[var18];
                           int var20 = var24.func_234_g();
                           if(var20 != var11) {
                              var12 = true;
                           } else if(var20 == var11) {
                              var13 |= var10.func_1234_a(var24, var17, var15, var16);
                           }
                        }
                     }
                  }
               }

               if(var14) {
                  this.field_40590_G += field_1742_D.func_982_a();
                  GL11.glPopMatrix();
                  GL11.glEndList();
                  field_1742_D.func_984_b(0.0D, 0.0D, 0.0D);
               } else {
                  var13 = false;
               }

               if(var13) {
                  this.field_1748_p[var11] = false;
               }

               if(!var12) {
                  break;
               }
            }
         }

         HashSet var22 = new HashSet();
         var22.addAll(this.field_1745_B);
         var22.removeAll(var21);
         this.field_1737_F.addAll(var22);
         var21.removeAll(this.field_1745_B);
         this.field_1737_F.removeAll(var21);
         this.field_1747_A = Chunk.field_1540_a;
         this.field_1739_E = true;
      }
   }

   public float func_1202_a(Entity p_1202_1_) {
      float var2 = (float)(p_1202_1_.field_611_ak - (double)this.field_1746_q);
      float var3 = (float)(p_1202_1_.field_610_al - (double)this.field_1743_r);
      float var4 = (float)(p_1202_1_.field_609_am - (double)this.field_1741_s);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public void func_1195_b() {
      for(int var1 = 0; var1 < 2; ++var1) {
         this.field_1748_p[var1] = true;
      }

      this.field_1749_o = false;
      this.field_1739_E = false;
   }

   public void func_1204_c() {
      this.func_1195_b();
      this.field_1763_a = null;
   }

   public int func_1200_a(int p_1200_1_) {
      return !this.field_1749_o?-1:(!this.field_1748_p[p_1200_1_]?this.field_1744_C + p_1200_1_:-1);
   }

   public void func_1199_a(ICamera p_1199_1_) {
      this.field_1749_o = p_1199_1_.func_342_a(this.field_1736_v);
   }

   public void func_1201_d() {
      GL11.glCallList(this.field_1744_C + 2);
   }

   public boolean func_1196_e() {
      return !this.field_1739_E?false:this.field_1748_p[0] && this.field_1748_p[1];
   }

   public void func_1194_f() {
      this.field_1738_u = true;
   }

}
