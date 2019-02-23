package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.World;

public interface IChunkProvider {

   boolean func_537_a(int var1, int var2);

   Chunk func_533_b(int var1, int var2);

   Chunk func_538_d(int var1, int var2);

   void func_534_a(IChunkProvider var1, int var2, int var3);

   boolean func_535_a(boolean var1, IProgressUpdate var2);

   boolean func_532_a();

   boolean func_536_b();

   String func_21109_c();

   List func_40377_a(EnumCreatureType var1, int var2, int var3, int var4);

   ChunkPosition func_40376_a(World var1, String var2, int var3, int var4, int var5);
}
