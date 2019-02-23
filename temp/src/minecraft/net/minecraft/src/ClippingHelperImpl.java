package net.minecraft.src;

import java.nio.FloatBuffer;
import net.minecraft.src.ClippingHelper;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.MathHelper;
import org.lwjgl.opengl.GL11;

public class ClippingHelperImpl extends ClippingHelper {

   private static ClippingHelperImpl field_1694_e = new ClippingHelperImpl();
   private FloatBuffer field_1693_f = GLAllocation.func_1123_d(16);
   private FloatBuffer field_1692_g = GLAllocation.func_1123_d(16);
   private FloatBuffer field_1691_h = GLAllocation.func_1123_d(16);


   public static ClippingHelper func_1155_a() {
      field_1694_e.func_1153_b();
      return field_1694_e;
   }

   private void func_1154_a(float[][] p_1154_1_, int p_1154_2_) {
      float var3 = MathHelper.func_1113_c(p_1154_1_[p_1154_2_][0] * p_1154_1_[p_1154_2_][0] + p_1154_1_[p_1154_2_][1] * p_1154_1_[p_1154_2_][1] + p_1154_1_[p_1154_2_][2] * p_1154_1_[p_1154_2_][2]);
      p_1154_1_[p_1154_2_][0] /= var3;
      p_1154_1_[p_1154_2_][1] /= var3;
      p_1154_1_[p_1154_2_][2] /= var3;
      p_1154_1_[p_1154_2_][3] /= var3;
   }

   private void func_1153_b() {
      this.field_1693_f.clear();
      this.field_1692_g.clear();
      this.field_1691_h.clear();
      GL11.glGetFloat(2983, this.field_1693_f);
      GL11.glGetFloat(2982, this.field_1692_g);
      this.field_1693_f.flip().limit(16);
      this.field_1693_f.get(this.field_1687_b);
      this.field_1692_g.flip().limit(16);
      this.field_1692_g.get(this.field_1690_c);
      this.field_1689_d[0] = this.field_1690_c[0] * this.field_1687_b[0] + this.field_1690_c[1] * this.field_1687_b[4] + this.field_1690_c[2] * this.field_1687_b[8] + this.field_1690_c[3] * this.field_1687_b[12];
      this.field_1689_d[1] = this.field_1690_c[0] * this.field_1687_b[1] + this.field_1690_c[1] * this.field_1687_b[5] + this.field_1690_c[2] * this.field_1687_b[9] + this.field_1690_c[3] * this.field_1687_b[13];
      this.field_1689_d[2] = this.field_1690_c[0] * this.field_1687_b[2] + this.field_1690_c[1] * this.field_1687_b[6] + this.field_1690_c[2] * this.field_1687_b[10] + this.field_1690_c[3] * this.field_1687_b[14];
      this.field_1689_d[3] = this.field_1690_c[0] * this.field_1687_b[3] + this.field_1690_c[1] * this.field_1687_b[7] + this.field_1690_c[2] * this.field_1687_b[11] + this.field_1690_c[3] * this.field_1687_b[15];
      this.field_1689_d[4] = this.field_1690_c[4] * this.field_1687_b[0] + this.field_1690_c[5] * this.field_1687_b[4] + this.field_1690_c[6] * this.field_1687_b[8] + this.field_1690_c[7] * this.field_1687_b[12];
      this.field_1689_d[5] = this.field_1690_c[4] * this.field_1687_b[1] + this.field_1690_c[5] * this.field_1687_b[5] + this.field_1690_c[6] * this.field_1687_b[9] + this.field_1690_c[7] * this.field_1687_b[13];
      this.field_1689_d[6] = this.field_1690_c[4] * this.field_1687_b[2] + this.field_1690_c[5] * this.field_1687_b[6] + this.field_1690_c[6] * this.field_1687_b[10] + this.field_1690_c[7] * this.field_1687_b[14];
      this.field_1689_d[7] = this.field_1690_c[4] * this.field_1687_b[3] + this.field_1690_c[5] * this.field_1687_b[7] + this.field_1690_c[6] * this.field_1687_b[11] + this.field_1690_c[7] * this.field_1687_b[15];
      this.field_1689_d[8] = this.field_1690_c[8] * this.field_1687_b[0] + this.field_1690_c[9] * this.field_1687_b[4] + this.field_1690_c[10] * this.field_1687_b[8] + this.field_1690_c[11] * this.field_1687_b[12];
      this.field_1689_d[9] = this.field_1690_c[8] * this.field_1687_b[1] + this.field_1690_c[9] * this.field_1687_b[5] + this.field_1690_c[10] * this.field_1687_b[9] + this.field_1690_c[11] * this.field_1687_b[13];
      this.field_1689_d[10] = this.field_1690_c[8] * this.field_1687_b[2] + this.field_1690_c[9] * this.field_1687_b[6] + this.field_1690_c[10] * this.field_1687_b[10] + this.field_1690_c[11] * this.field_1687_b[14];
      this.field_1689_d[11] = this.field_1690_c[8] * this.field_1687_b[3] + this.field_1690_c[9] * this.field_1687_b[7] + this.field_1690_c[10] * this.field_1687_b[11] + this.field_1690_c[11] * this.field_1687_b[15];
      this.field_1689_d[12] = this.field_1690_c[12] * this.field_1687_b[0] + this.field_1690_c[13] * this.field_1687_b[4] + this.field_1690_c[14] * this.field_1687_b[8] + this.field_1690_c[15] * this.field_1687_b[12];
      this.field_1689_d[13] = this.field_1690_c[12] * this.field_1687_b[1] + this.field_1690_c[13] * this.field_1687_b[5] + this.field_1690_c[14] * this.field_1687_b[9] + this.field_1690_c[15] * this.field_1687_b[13];
      this.field_1689_d[14] = this.field_1690_c[12] * this.field_1687_b[2] + this.field_1690_c[13] * this.field_1687_b[6] + this.field_1690_c[14] * this.field_1687_b[10] + this.field_1690_c[15] * this.field_1687_b[14];
      this.field_1689_d[15] = this.field_1690_c[12] * this.field_1687_b[3] + this.field_1690_c[13] * this.field_1687_b[7] + this.field_1690_c[14] * this.field_1687_b[11] + this.field_1690_c[15] * this.field_1687_b[15];
      this.field_1688_a[0][0] = this.field_1689_d[3] - this.field_1689_d[0];
      this.field_1688_a[0][1] = this.field_1689_d[7] - this.field_1689_d[4];
      this.field_1688_a[0][2] = this.field_1689_d[11] - this.field_1689_d[8];
      this.field_1688_a[0][3] = this.field_1689_d[15] - this.field_1689_d[12];
      this.func_1154_a(this.field_1688_a, 0);
      this.field_1688_a[1][0] = this.field_1689_d[3] + this.field_1689_d[0];
      this.field_1688_a[1][1] = this.field_1689_d[7] + this.field_1689_d[4];
      this.field_1688_a[1][2] = this.field_1689_d[11] + this.field_1689_d[8];
      this.field_1688_a[1][3] = this.field_1689_d[15] + this.field_1689_d[12];
      this.func_1154_a(this.field_1688_a, 1);
      this.field_1688_a[2][0] = this.field_1689_d[3] + this.field_1689_d[1];
      this.field_1688_a[2][1] = this.field_1689_d[7] + this.field_1689_d[5];
      this.field_1688_a[2][2] = this.field_1689_d[11] + this.field_1689_d[9];
      this.field_1688_a[2][3] = this.field_1689_d[15] + this.field_1689_d[13];
      this.func_1154_a(this.field_1688_a, 2);
      this.field_1688_a[3][0] = this.field_1689_d[3] - this.field_1689_d[1];
      this.field_1688_a[3][1] = this.field_1689_d[7] - this.field_1689_d[5];
      this.field_1688_a[3][2] = this.field_1689_d[11] - this.field_1689_d[9];
      this.field_1688_a[3][3] = this.field_1689_d[15] - this.field_1689_d[13];
      this.func_1154_a(this.field_1688_a, 3);
      this.field_1688_a[4][0] = this.field_1689_d[3] - this.field_1689_d[2];
      this.field_1688_a[4][1] = this.field_1689_d[7] - this.field_1689_d[6];
      this.field_1688_a[4][2] = this.field_1689_d[11] - this.field_1689_d[10];
      this.field_1688_a[4][3] = this.field_1689_d[15] - this.field_1689_d[14];
      this.func_1154_a(this.field_1688_a, 4);
      this.field_1688_a[5][0] = this.field_1689_d[3] + this.field_1689_d[2];
      this.field_1688_a[5][1] = this.field_1689_d[7] + this.field_1689_d[6];
      this.field_1688_a[5][2] = this.field_1689_d[11] + this.field_1689_d[10];
      this.field_1688_a[5][3] = this.field_1689_d[15] + this.field_1689_d[14];
      this.func_1154_a(this.field_1688_a, 5);
   }

}
