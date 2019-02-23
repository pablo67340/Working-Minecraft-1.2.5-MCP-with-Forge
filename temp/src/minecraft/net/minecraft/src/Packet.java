package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.Packet100OpenWindow;
import net.minecraft.src.Packet101CloseWindow;
import net.minecraft.src.Packet102WindowClick;
import net.minecraft.src.Packet103SetSlot;
import net.minecraft.src.Packet104WindowItems;
import net.minecraft.src.Packet105UpdateProgressbar;
import net.minecraft.src.Packet106Transaction;
import net.minecraft.src.Packet107CreativeSetSlot;
import net.minecraft.src.Packet108EnchantItem;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet130UpdateSign;
import net.minecraft.src.Packet131MapData;
import net.minecraft.src.Packet132TileEntityData;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet16BlockItemSwitch;
import net.minecraft.src.Packet17Sleep;
import net.minecraft.src.Packet18Animation;
import net.minecraft.src.Packet19EntityAction;
import net.minecraft.src.Packet1Login;
import net.minecraft.src.Packet200Statistic;
import net.minecraft.src.Packet201PlayerInfo;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet20NamedEntitySpawn;
import net.minecraft.src.Packet21PickupSpawn;
import net.minecraft.src.Packet22Collect;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Packet24MobSpawn;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.Packet254ServerPing;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Packet25EntityPainting;
import net.minecraft.src.Packet26EntityExpOrb;
import net.minecraft.src.Packet28EntityVelocity;
import net.minecraft.src.Packet29DestroyEntity;
import net.minecraft.src.Packet2Handshake;
import net.minecraft.src.Packet30Entity;
import net.minecraft.src.Packet31RelEntityMove;
import net.minecraft.src.Packet32EntityLook;
import net.minecraft.src.Packet33RelEntityMoveLook;
import net.minecraft.src.Packet34EntityTeleport;
import net.minecraft.src.Packet35EntityHeadRotation;
import net.minecraft.src.Packet38EntityStatus;
import net.minecraft.src.Packet39AttachEntity;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet40EntityMetadata;
import net.minecraft.src.Packet41EntityEffect;
import net.minecraft.src.Packet42RemoveEntityEffect;
import net.minecraft.src.Packet43Experience;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet50PreChunk;
import net.minecraft.src.Packet51MapChunk;
import net.minecraft.src.Packet52MultiBlockChange;
import net.minecraft.src.Packet53BlockChange;
import net.minecraft.src.Packet54PlayNoteBlock;
import net.minecraft.src.Packet5PlayerInventory;
import net.minecraft.src.Packet60Explosion;
import net.minecraft.src.Packet61DoorChange;
import net.minecraft.src.Packet6SpawnPosition;
import net.minecraft.src.Packet70Bed;
import net.minecraft.src.Packet71Weather;
import net.minecraft.src.Packet7UseEntity;
import net.minecraft.src.Packet8UpdateHealth;
import net.minecraft.src.Packet9Respawn;
import net.minecraft.src.PacketCount;

public abstract class Packet {

   public static IntHashMap field_471_a = new IntHashMap();
   private static Map field_470_b = new HashMap();
   private static Set field_26906_c = new HashSet();
   private static Set field_26905_d = new HashSet();
   public final long field_20018_j = System.currentTimeMillis();
   public static long field_48158_m;
   public static long field_48156_n;
   public static long field_48157_o;
   public static long field_48155_p;
   public boolean field_472_j = false;


   static void func_321_a(int p_321_0_, boolean p_321_1_, boolean p_321_2_, Class p_321_3_) {
      if(field_471_a.func_35858_b(p_321_0_)) {
         throw new IllegalArgumentException("Duplicate packet id:" + p_321_0_);
      } else if(field_470_b.containsKey(p_321_3_)) {
         throw new IllegalArgumentException("Duplicate packet class:" + p_321_3_);
      } else {
         field_471_a.func_1061_a(p_321_0_, p_321_3_);
         field_470_b.put(p_321_3_, Integer.valueOf(p_321_0_));
         if(p_321_1_) {
            field_26906_c.add(Integer.valueOf(p_321_0_));
         }

         if(p_321_2_) {
            field_26905_d.add(Integer.valueOf(p_321_0_));
         }

      }
   }

   public static Packet func_325_a(int p_325_0_) {
      try {
         Class var1 = (Class)field_471_a.func_1057_a(p_325_0_);
         return var1 == null?null:(Packet)var1.newInstance();
      } catch (Exception var2) {
         var2.printStackTrace();
         System.out.println("Skipping packet with id " + p_325_0_);
         return null;
      }
   }

   public final int func_326_b() {
      return ((Integer)field_470_b.get(this.getClass())).intValue();
   }

   public static Packet func_324_b(DataInputStream p_324_0_, boolean p_324_1_) throws IOException {
      boolean var2 = false;
      Packet var3 = null;

      int var6;
      try {
         var6 = p_324_0_.read();
         if(var6 == -1) {
            return null;
         }

         if(p_324_1_ && !field_26905_d.contains(Integer.valueOf(var6)) || !p_324_1_ && !field_26906_c.contains(Integer.valueOf(var6))) {
            throw new IOException("Bad packet id " + var6);
         }

         var3 = func_325_a(var6);
         if(var3 == null) {
            throw new IOException("Bad packet id " + var6);
         }

         var3.func_327_a(p_324_0_);
         ++field_48158_m;
         field_48156_n += (long)var3.func_329_a();
      } catch (EOFException var5) {
         System.out.println("Reached end of stream");
         return null;
      }

      PacketCount.func_40561_a(var6, (long)var3.func_329_a());
      ++field_48158_m;
      field_48156_n += (long)var3.func_329_a();
      return var3;
   }

   public static void func_328_a(Packet p_328_0_, DataOutputStream p_328_1_) throws IOException {
      p_328_1_.write(p_328_0_.func_326_b());
      p_328_0_.func_322_a(p_328_1_);
      ++field_48157_o;
      field_48155_p += (long)p_328_0_.func_329_a();
   }

   public static void func_27049_a(String p_27049_0_, DataOutputStream p_27049_1_) throws IOException {
      if(p_27049_0_.length() > 32767) {
         throw new IOException("String too big");
      } else {
         p_27049_1_.writeShort(p_27049_0_.length());
         p_27049_1_.writeChars(p_27049_0_);
      }
   }

   public static String func_27048_a(DataInputStream p_27048_0_, int p_27048_1_) throws IOException {
      short var2 = p_27048_0_.readShort();
      if(var2 > p_27048_1_) {
         throw new IOException("Received string length longer than maximum allowed (" + var2 + " > " + p_27048_1_ + ")");
      } else if(var2 < 0) {
         throw new IOException("Received string length is less than zero! Weird string!");
      } else {
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var2; ++var4) {
            var3.append(p_27048_0_.readChar());
         }

         return var3.toString();
      }
   }

   public abstract void func_327_a(DataInputStream var1) throws IOException;

   public abstract void func_322_a(DataOutputStream var1) throws IOException;

   public abstract void func_323_a(NetHandler var1);

   public abstract int func_329_a();

   protected ItemStack func_40187_b(DataInputStream p_40187_1_) throws IOException {
      ItemStack var2 = null;
      short var3 = p_40187_1_.readShort();
      if(var3 >= 0) {
         byte var4 = p_40187_1_.readByte();
         short var5 = p_40187_1_.readShort();
         var2 = new ItemStack(var3, var4, var5);
         if(Item.field_233_c[var3].func_25007_g() || Item.field_233_c[var3].func_46056_k()) {
            var2.field_40715_d = this.func_40186_c(p_40187_1_);
         }
      }

      return var2;
   }

   protected void func_40188_a(ItemStack p_40188_1_, DataOutputStream p_40188_2_) throws IOException {
      if(p_40188_1_ == null) {
         p_40188_2_.writeShort(-1);
      } else {
         p_40188_2_.writeShort(p_40188_1_.field_1617_c);
         p_40188_2_.writeByte(p_40188_1_.field_1615_a);
         p_40188_2_.writeShort(p_40188_1_.func_21181_i());
         if(p_40188_1_.func_1091_a().func_25007_g() || p_40188_1_.func_1091_a().func_46056_k()) {
            this.func_40189_a(p_40188_1_.field_40715_d, p_40188_2_);
         }
      }

   }

   protected NBTTagCompound func_40186_c(DataInputStream p_40186_1_) throws IOException {
      short var2 = p_40186_1_.readShort();
      if(var2 < 0) {
         return null;
      } else {
         byte[] var3 = new byte[var2];
         p_40186_1_.readFully(var3);
         return CompressedStreamTools.func_40592_a(var3);
      }
   }

   protected void func_40189_a(NBTTagCompound p_40189_1_, DataOutputStream p_40189_2_) throws IOException {
      if(p_40189_1_ == null) {
         p_40189_2_.writeShort(-1);
      } else {
         byte[] var3 = CompressedStreamTools.func_40591_a(p_40189_1_);
         p_40189_2_.writeShort((short)var3.length);
         p_40189_2_.write(var3);
      }

   }

   static {
      func_321_a(0, true, true, Packet0KeepAlive.class);
      func_321_a(1, true, true, Packet1Login.class);
      func_321_a(2, true, true, Packet2Handshake.class);
      func_321_a(3, true, true, Packet3Chat.class);
      func_321_a(4, true, false, Packet4UpdateTime.class);
      func_321_a(5, true, false, Packet5PlayerInventory.class);
      func_321_a(6, true, false, Packet6SpawnPosition.class);
      func_321_a(7, false, true, Packet7UseEntity.class);
      func_321_a(8, true, false, Packet8UpdateHealth.class);
      func_321_a(9, true, true, Packet9Respawn.class);
      func_321_a(10, true, true, Packet10Flying.class);
      func_321_a(11, true, true, Packet11PlayerPosition.class);
      func_321_a(12, true, true, Packet12PlayerLook.class);
      func_321_a(13, true, true, Packet13PlayerLookMove.class);
      func_321_a(14, false, true, Packet14BlockDig.class);
      func_321_a(15, false, true, Packet15Place.class);
      func_321_a(16, false, true, Packet16BlockItemSwitch.class);
      func_321_a(17, true, false, Packet17Sleep.class);
      func_321_a(18, true, true, Packet18Animation.class);
      func_321_a(19, false, true, Packet19EntityAction.class);
      func_321_a(20, true, false, Packet20NamedEntitySpawn.class);
      func_321_a(21, true, false, Packet21PickupSpawn.class);
      func_321_a(22, true, false, Packet22Collect.class);
      func_321_a(23, true, false, Packet23VehicleSpawn.class);
      func_321_a(24, true, false, Packet24MobSpawn.class);
      func_321_a(25, true, false, Packet25EntityPainting.class);
      func_321_a(26, true, false, Packet26EntityExpOrb.class);
      func_321_a(28, true, false, Packet28EntityVelocity.class);
      func_321_a(29, true, false, Packet29DestroyEntity.class);
      func_321_a(30, true, false, Packet30Entity.class);
      func_321_a(31, true, false, Packet31RelEntityMove.class);
      func_321_a(32, true, false, Packet32EntityLook.class);
      func_321_a(33, true, false, Packet33RelEntityMoveLook.class);
      func_321_a(34, true, false, Packet34EntityTeleport.class);
      func_321_a(35, true, false, Packet35EntityHeadRotation.class);
      func_321_a(38, true, false, Packet38EntityStatus.class);
      func_321_a(39, true, false, Packet39AttachEntity.class);
      func_321_a(40, true, false, Packet40EntityMetadata.class);
      func_321_a(41, true, false, Packet41EntityEffect.class);
      func_321_a(42, true, false, Packet42RemoveEntityEffect.class);
      func_321_a(43, true, false, Packet43Experience.class);
      func_321_a(50, true, false, Packet50PreChunk.class);
      func_321_a(51, true, false, Packet51MapChunk.class);
      func_321_a(52, true, false, Packet52MultiBlockChange.class);
      func_321_a(53, true, false, Packet53BlockChange.class);
      func_321_a(54, true, false, Packet54PlayNoteBlock.class);
      func_321_a(60, true, false, Packet60Explosion.class);
      func_321_a(61, true, false, Packet61DoorChange.class);
      func_321_a(70, true, false, Packet70Bed.class);
      func_321_a(71, true, false, Packet71Weather.class);
      func_321_a(100, true, false, Packet100OpenWindow.class);
      func_321_a(101, true, true, Packet101CloseWindow.class);
      func_321_a(102, false, true, Packet102WindowClick.class);
      func_321_a(103, true, false, Packet103SetSlot.class);
      func_321_a(104, true, false, Packet104WindowItems.class);
      func_321_a(105, true, false, Packet105UpdateProgressbar.class);
      func_321_a(106, true, true, Packet106Transaction.class);
      func_321_a(107, true, true, Packet107CreativeSetSlot.class);
      func_321_a(108, false, true, Packet108EnchantItem.class);
      func_321_a(130, true, true, Packet130UpdateSign.class);
      func_321_a(131, true, false, Packet131MapData.class);
      func_321_a(132, true, false, Packet132TileEntityData.class);
      func_321_a(200, true, false, Packet200Statistic.class);
      func_321_a(201, true, false, Packet201PlayerInfo.class);
      func_321_a(202, true, true, Packet202PlayerAbilities.class);
      func_321_a(250, true, true, Packet250CustomPayload.class);
      func_321_a(254, false, true, Packet254ServerPing.class);
      func_321_a(255, true, true, Packet255KickDisconnect.class);
   }
}
