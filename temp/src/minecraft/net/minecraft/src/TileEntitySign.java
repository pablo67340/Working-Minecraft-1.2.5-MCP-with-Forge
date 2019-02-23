package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntitySign extends TileEntity {

   public String[] field_826_a = new String[]{"", "", "", ""};
   public int field_825_b = -1;
   private boolean field_25062_c = true;


   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      p_481_1_.func_754_a("Text1", this.field_826_a[0]);
      p_481_1_.func_754_a("Text2", this.field_826_a[1]);
      p_481_1_.func_754_a("Text3", this.field_826_a[2]);
      p_481_1_.func_754_a("Text4", this.field_826_a[3]);
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      this.field_25062_c = false;
      super.func_482_a(p_482_1_);

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_826_a[var2] = p_482_1_.func_755_i("Text" + (var2 + 1));
         if(this.field_826_a[var2].length() > 15) {
            this.field_826_a[var2] = this.field_826_a[var2].substring(0, 15);
         }
      }

   }

   public boolean func_50007_a() {
      return this.field_25062_c;
   }

   public void func_50006_a(boolean p_50006_1_) {
      this.field_25062_c = p_50006_1_;
   }
}
