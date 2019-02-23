package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class EntityMooshroom extends EntityCow {

   public EntityMooshroom(World p_i491_1_) {
      super(p_i491_1_);
      this.field_9357_z = "/mob/redcow.png";
      this.func_371_a(0.9F, 1.3F);
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(var2 != null && var2.field_1617_c == Item.field_264_C.field_291_aS && this.func_48123_at() >= 0) {
         if(var2.field_1615_a == 1) {
            p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, new ItemStack(Item.field_263_D));
            return true;
         }

         if(p_353_1_.field_778_b.func_504_a(new ItemStack(Item.field_263_D)) && !p_353_1_.field_35212_aW.field_35756_d) {
            p_353_1_.field_778_b.func_473_a(p_353_1_.field_778_b.field_847_d, 1);
            return true;
         }
      }

      if(var2 != null && var2.field_1617_c == Item.field_31001_bc.field_291_aS && this.func_48123_at() >= 0) {
         this.func_395_F();
         this.field_615_ag.func_694_a("largeexplode", this.field_611_ak, this.field_610_al + (double)(this.field_643_aD / 2.0F), this.field_609_am, 0.0D, 0.0D, 0.0D);
         if(!this.field_615_ag.field_1026_y) {
            EntityCow var3 = new EntityCow(this.field_615_ag);
            var3.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);
            var3.func_40121_k(this.func_40114_aH());
            var3.field_735_n = this.field_735_n;
            this.field_615_ag.func_674_a(var3);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.field_615_ag.func_674_a(new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al + (double)this.field_643_aD, this.field_609_am, new ItemStack(Block.field_414_ah)));
            }
         }

         return true;
      } else {
         return super.func_353_a(p_353_1_);
      }
   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      return new EntityMooshroom(this.field_615_ag);
   }
}
