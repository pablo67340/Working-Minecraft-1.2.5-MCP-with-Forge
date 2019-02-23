package net.minecraft.src;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityRecordPlayer extends TileEntity {

   public int field_28017_a;


   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      this.field_28017_a = p_482_1_.func_756_e("Record");
   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      if(this.field_28017_a > 0) {
         p_481_1_.func_758_a("Record", this.field_28017_a);
      }

   }
}
