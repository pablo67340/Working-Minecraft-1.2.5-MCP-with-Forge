package net.minecraft.src;

import java.io.File;
import java.util.List;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;

public interface ISaveHandler {

   WorldInfo func_22151_c();

   void func_22150_b();

   IChunkLoader func_22149_a(WorldProvider var1);

   void func_22148_a(WorldInfo var1, List var2);

   void func_22152_a(WorldInfo var1);

   File func_28113_a(String var1);

   String func_40530_d();
}
