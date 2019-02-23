package net.minecraft.src;

import java.io.File;
import java.util.List;
import net.minecraft.src.AnvilChunkLoader;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.SaveHandler;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldProviderEnd;
import net.minecraft.src.WorldProviderHell;

public class AnvilSaveHandler extends SaveHandler {

   public AnvilSaveHandler(File p_i1012_1_, String p_i1012_2_, boolean p_i1012_3_) {
      super(p_i1012_1_, p_i1012_2_, p_i1012_3_);
   }

   public IChunkLoader func_22149_a(WorldProvider p_22149_1_) {
      File var2 = this.func_22153_a();
      File var3;
      if(p_22149_1_ instanceof WorldProviderHell) {
         var3 = new File(var2, "DIM-1");
         var3.mkdirs();
         return new AnvilChunkLoader(var3);
      } else if(p_22149_1_ instanceof WorldProviderEnd) {
         var3 = new File(var2, "DIM1");
         var3.mkdirs();
         return new AnvilChunkLoader(var3);
      } else {
         return new AnvilChunkLoader(var2);
      }
   }

   public void func_22148_a(WorldInfo p_22148_1_, List p_22148_2_) {
      p_22148_1_.func_22289_d(19133);
      super.func_22148_a(p_22148_1_, p_22148_2_);
   }
}
