package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MapData;

public class MapInfo {

   public final EntityPlayer field_28120_a;
   public int[] field_28119_b;
   public int[] field_28124_c;
   private int field_28122_e;
   private int field_28121_f;
   // $FF: synthetic field
   final MapData field_28123_d;


   public MapInfo(MapData p_i475_1_, EntityPlayer p_i475_2_) {
      this.field_28123_d = p_i475_1_;
      this.field_28119_b = new int[128];
      this.field_28124_c = new int[128];
      this.field_28122_e = 0;
      this.field_28121_f = 0;
      this.field_28120_a = p_i475_2_;

      for(int var3 = 0; var3 < this.field_28119_b.length; ++var3) {
         this.field_28119_b[var3] = 0;
         this.field_28124_c[var3] = 127;
      }

   }
}
