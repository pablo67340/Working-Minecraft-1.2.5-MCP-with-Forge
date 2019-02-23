package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityCaveSpider;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EntityEggInfo;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.EntityEnderEye;
import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityMooshroom;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySilverfish;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntitySnowman;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityList {

   private static Map field_1611_a = new HashMap();
   private static Map field_1610_b = new HashMap();
   private static Map field_1613_c = new HashMap();
   private static Map field_1612_d = new HashMap();
   private static Map field_48506_f = new HashMap();
   public static HashMap field_44041_a = new HashMap();


   private static void func_1080_a(Class p_1080_0_, String p_1080_1_, int p_1080_2_) {
      field_1611_a.put(p_1080_1_, p_1080_0_);
      field_1610_b.put(p_1080_0_, p_1080_1_);
      field_1613_c.put(Integer.valueOf(p_1080_2_), p_1080_0_);
      field_1612_d.put(p_1080_0_, Integer.valueOf(p_1080_2_));
      field_48506_f.put(p_1080_1_, Integer.valueOf(p_1080_2_));
   }

   private static void func_46152_a(Class p_46152_0_, String p_46152_1_, int p_46152_2_, int p_46152_3_, int p_46152_4_) {
      func_1080_a(p_46152_0_, p_46152_1_, p_46152_2_);
      field_44041_a.put(Integer.valueOf(p_46152_2_), new EntityEggInfo(p_46152_2_, p_46152_3_, p_46152_4_));
   }

   public static Entity func_1079_a(String p_1079_0_, World p_1079_1_) {
      Entity var2 = null;

      try {
         Class var3 = (Class)field_1611_a.get(p_1079_0_);
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_1079_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public static Entity func_1081_a(NBTTagCompound p_1081_0_, World p_1081_1_) {
      Entity var2 = null;

      try {
         Class var3 = (Class)field_1611_a.get(p_1081_0_.func_755_i("id"));
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_1081_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 != null) {
         var2.func_368_e(p_1081_0_);
      } else {
         System.out.println("Skipping Entity with id " + p_1081_0_.func_755_i("id"));
      }

      return var2;
   }

   public static Entity func_1084_a(int p_1084_0_, World p_1084_1_) {
      Entity var2 = null;

      try {
         Class var3 = (Class)field_1613_c.get(Integer.valueOf(p_1084_0_));
         if(var3 != null) {
            var2 = (Entity)var3.getConstructor(new Class[]{World.class}).newInstance(new Object[]{p_1084_1_});
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if(var2 == null) {
         System.out.println("Skipping Entity with id " + p_1084_0_);
      }

      return var2;
   }

   public static int func_1082_a(Entity p_1082_0_) {
      return ((Integer)field_1612_d.get(p_1082_0_.getClass())).intValue();
   }

   public static String func_1083_b(Entity p_1083_0_) {
      return (String)field_1610_b.get(p_1083_0_.getClass());
   }

   public static String func_44040_a(int p_44040_0_) {
      Class var1 = (Class)field_1613_c.get(Integer.valueOf(p_44040_0_));
      return var1 != null?(String)field_1610_b.get(var1):null;
   }

   static {
      func_1080_a(EntityItem.class, "Item", 1);
      func_1080_a(EntityXPOrb.class, "XPOrb", 2);
      func_1080_a(EntityPainting.class, "Painting", 9);
      func_1080_a(EntityArrow.class, "Arrow", 10);
      func_1080_a(EntitySnowball.class, "Snowball", 11);
      func_1080_a(EntityFireball.class, "Fireball", 12);
      func_1080_a(EntitySmallFireball.class, "SmallFireball", 13);
      func_1080_a(EntityEnderPearl.class, "ThrownEnderpearl", 14);
      func_1080_a(EntityEnderEye.class, "EyeOfEnderSignal", 15);
      func_1080_a(EntityPotion.class, "ThrownPotion", 16);
      func_1080_a(EntityExpBottle.class, "ThrownExpBottle", 17);
      func_1080_a(EntityTNTPrimed.class, "PrimedTnt", 20);
      func_1080_a(EntityFallingSand.class, "FallingSand", 21);
      func_1080_a(EntityMinecart.class, "Minecart", 40);
      func_1080_a(EntityBoat.class, "Boat", 41);
      func_1080_a(EntityLiving.class, "Mob", 48);
      func_1080_a(EntityMob.class, "Monster", 49);
      func_46152_a(EntityCreeper.class, "Creeper", 50, 894731, 0);
      func_46152_a(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
      func_46152_a(EntitySpider.class, "Spider", 52, 3419431, 11013646);
      func_1080_a(EntityGiantZombie.class, "Giant", 53);
      func_46152_a(EntityZombie.class, "Zombie", 54, '\uafaf', 7969893);
      func_46152_a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
      func_46152_a(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
      func_46152_a(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
      func_46152_a(EntityEnderman.class, "Enderman", 58, 1447446, 0);
      func_46152_a(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
      func_46152_a(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
      func_46152_a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
      func_46152_a(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
      func_1080_a(EntityDragon.class, "EnderDragon", 63);
      func_46152_a(EntityPig.class, "Pig", 90, 15771042, 14377823);
      func_46152_a(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
      func_46152_a(EntityCow.class, "Cow", 92, 4470310, 10592673);
      func_46152_a(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
      func_46152_a(EntitySquid.class, "Squid", 94, 2243405, 7375001);
      func_46152_a(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
      func_46152_a(EntityMooshroom.class, "MushroomCow", 96, 10489616, 12040119);
      func_1080_a(EntitySnowman.class, "SnowMan", 97);
      func_46152_a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
      func_1080_a(EntityIronGolem.class, "VillagerGolem", 99);
      func_46152_a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
      func_1080_a(EntityEnderCrystal.class, "EnderCrystal", 200);
   }
}
