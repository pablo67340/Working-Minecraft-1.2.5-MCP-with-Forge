package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemAppleGold;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemAxe;
import net.minecraft.src.ItemBed;
import net.minecraft.src.ItemBoat;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemBucket;
import net.minecraft.src.ItemBucketMilk;
import net.minecraft.src.ItemCoal;
import net.minecraft.src.ItemDoor;
import net.minecraft.src.ItemDye;
import net.minecraft.src.ItemEgg;
import net.minecraft.src.ItemEnderEye;
import net.minecraft.src.ItemEnderPearl;
import net.minecraft.src.ItemExpBottle;
import net.minecraft.src.ItemFireball;
import net.minecraft.src.ItemFishingRod;
import net.minecraft.src.ItemFlintAndSteel;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemGlassBottle;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.ItemMap;
import net.minecraft.src.ItemMinecart;
import net.minecraft.src.ItemMonsterPlacer;
import net.minecraft.src.ItemPainting;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemRecord;
import net.minecraft.src.ItemRedstone;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemSaddle;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemShears;
import net.minecraft.src.ItemSign;
import net.minecraft.src.ItemSnowball;
import net.minecraft.src.ItemSoup;
import net.minecraft.src.ItemSpade;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class Item {

   protected static Random field_4015_b = new Random();
   public static Item[] field_233_c = new Item[32000];
   public static Item field_232_d = (new ItemSpade(0, EnumToolMaterial.IRON)).func_20010_a(2, 5).func_20011_a("shovelIron");
   public static Item field_231_e = (new ItemPickaxe(1, EnumToolMaterial.IRON)).func_20010_a(2, 6).func_20011_a("pickaxeIron");
   public static Item field_230_f = (new ItemAxe(2, EnumToolMaterial.IRON)).func_20010_a(2, 7).func_20011_a("hatchetIron");
   public static Item field_4014_g = (new ItemFlintAndSteel(3)).func_20010_a(5, 0).func_20011_a("flintAndSteel");
   public static Item field_228_h = (new ItemFood(4, 4, 0.3F, false)).func_20010_a(10, 0).func_20011_a("apple");
   public static Item field_227_i = (new ItemBow(5)).func_20010_a(5, 1).func_20011_a("bow");
   public static Item field_226_j = (new Item(6)).func_20010_a(5, 2).func_20011_a("arrow");
   public static Item field_225_k = (new ItemCoal(7)).func_20010_a(7, 0).func_20011_a("coal");
   public static Item field_224_l = (new Item(8)).func_20010_a(7, 3).func_20011_a("emerald");
   public static Item field_223_m = (new Item(9)).func_20010_a(7, 1).func_20011_a("ingotIron");
   public static Item field_222_n = (new Item(10)).func_20010_a(7, 2).func_20011_a("ingotGold");
   public static Item field_221_o = (new ItemSword(11, EnumToolMaterial.IRON)).func_20010_a(2, 4).func_20011_a("swordIron");
   public static Item field_220_p = (new ItemSword(12, EnumToolMaterial.WOOD)).func_20010_a(0, 4).func_20011_a("swordWood");
   public static Item field_219_q = (new ItemSpade(13, EnumToolMaterial.WOOD)).func_20010_a(0, 5).func_20011_a("shovelWood");
   public static Item field_218_r = (new ItemPickaxe(14, EnumToolMaterial.WOOD)).func_20010_a(0, 6).func_20011_a("pickaxeWood");
   public static Item field_217_s = (new ItemAxe(15, EnumToolMaterial.WOOD)).func_20010_a(0, 7).func_20011_a("hatchetWood");
   public static Item field_216_t = (new ItemSword(16, EnumToolMaterial.STONE)).func_20010_a(1, 4).func_20011_a("swordStone");
   public static Item field_215_u = (new ItemSpade(17, EnumToolMaterial.STONE)).func_20010_a(1, 5).func_20011_a("shovelStone");
   public static Item field_214_v = (new ItemPickaxe(18, EnumToolMaterial.STONE)).func_20010_a(1, 6).func_20011_a("pickaxeStone");
   public static Item field_213_w = (new ItemAxe(19, EnumToolMaterial.STONE)).func_20010_a(1, 7).func_20011_a("hatchetStone");
   public static Item field_212_x = (new ItemSword(20, EnumToolMaterial.EMERALD)).func_20010_a(3, 4).func_20011_a("swordDiamond");
   public static Item field_211_y = (new ItemSpade(21, EnumToolMaterial.EMERALD)).func_20010_a(3, 5).func_20011_a("shovelDiamond");
   public static Item field_210_z = (new ItemPickaxe(22, EnumToolMaterial.EMERALD)).func_20010_a(3, 6).func_20011_a("pickaxeDiamond");
   public static Item field_268_A = (new ItemAxe(23, EnumToolMaterial.EMERALD)).func_20010_a(3, 7).func_20011_a("hatchetDiamond");
   public static Item field_266_B = (new Item(24)).func_20010_a(5, 3).func_4016_e().func_20011_a("stick");
   public static Item field_264_C = (new Item(25)).func_20010_a(7, 4).func_20011_a("bowl");
   public static Item field_263_D = (new ItemSoup(26, 8)).func_20010_a(8, 4).func_20011_a("mushroomStew");
   public static Item field_261_E = (new ItemSword(27, EnumToolMaterial.GOLD)).func_20010_a(4, 4).func_20011_a("swordGold");
   public static Item field_259_F = (new ItemSpade(28, EnumToolMaterial.GOLD)).func_20010_a(4, 5).func_20011_a("shovelGold");
   public static Item field_257_G = (new ItemPickaxe(29, EnumToolMaterial.GOLD)).func_20010_a(4, 6).func_20011_a("pickaxeGold");
   public static Item field_255_H = (new ItemAxe(30, EnumToolMaterial.GOLD)).func_20010_a(4, 7).func_20011_a("hatchetGold");
   public static Item field_253_I = (new Item(31)).func_20010_a(8, 0).func_20011_a("string");
   public static Item field_251_J = (new Item(32)).func_20010_a(8, 1).func_20011_a("feather");
   public static Item field_250_K = (new Item(33)).func_20010_a(8, 2).func_20011_a("sulphur").func_40407_b(PotionHelper.field_40373_k);
   public static Item field_249_L = (new ItemHoe(34, EnumToolMaterial.WOOD)).func_20010_a(0, 8).func_20011_a("hoeWood");
   public static Item field_248_M = (new ItemHoe(35, EnumToolMaterial.STONE)).func_20010_a(1, 8).func_20011_a("hoeStone");
   public static Item field_247_N = (new ItemHoe(36, EnumToolMaterial.IRON)).func_20010_a(2, 8).func_20011_a("hoeIron");
   public static Item field_246_O = (new ItemHoe(37, EnumToolMaterial.EMERALD)).func_20010_a(3, 8).func_20011_a("hoeDiamond");
   public static Item field_245_P = (new ItemHoe(38, EnumToolMaterial.GOLD)).func_20010_a(4, 8).func_20011_a("hoeGold");
   public static Item field_244_Q = (new ItemSeeds(39, Block.field_447_aA.field_376_bc, Block.field_446_aB.field_376_bc)).func_20010_a(9, 0).func_20011_a("seeds");
   public static Item field_243_R = (new Item(40)).func_20010_a(9, 1).func_20011_a("wheat");
   public static Item field_242_S = (new ItemFood(41, 5, 0.6F, false)).func_20010_a(9, 2).func_20011_a("bread");
   public static Item field_241_T = (new ItemArmor(42, EnumArmorMaterial.CLOTH, 0, 0)).func_20010_a(0, 0).func_20011_a("helmetCloth");
   public static Item field_240_U = (new ItemArmor(43, EnumArmorMaterial.CLOTH, 0, 1)).func_20010_a(0, 1).func_20011_a("chestplateCloth");
   public static Item field_239_V = (new ItemArmor(44, EnumArmorMaterial.CLOTH, 0, 2)).func_20010_a(0, 2).func_20011_a("leggingsCloth");
   public static Item field_238_W = (new ItemArmor(45, EnumArmorMaterial.CLOTH, 0, 3)).func_20010_a(0, 3).func_20011_a("bootsCloth");
   public static Item field_237_X = (new ItemArmor(46, EnumArmorMaterial.CHAIN, 1, 0)).func_20010_a(1, 0).func_20011_a("helmetChain");
   public static Item field_236_Y = (new ItemArmor(47, EnumArmorMaterial.CHAIN, 1, 1)).func_20010_a(1, 1).func_20011_a("chestplateChain");
   public static Item field_235_Z = (new ItemArmor(48, EnumArmorMaterial.CHAIN, 1, 2)).func_20010_a(1, 2).func_20011_a("leggingsChain");
   public static Item field_286_aa = (new ItemArmor(49, EnumArmorMaterial.CHAIN, 1, 3)).func_20010_a(1, 3).func_20011_a("bootsChain");
   public static Item field_285_ab = (new ItemArmor(50, EnumArmorMaterial.IRON, 2, 0)).func_20010_a(2, 0).func_20011_a("helmetIron");
   public static Item field_284_ac = (new ItemArmor(51, EnumArmorMaterial.IRON, 2, 1)).func_20010_a(2, 1).func_20011_a("chestplateIron");
   public static Item field_283_ad = (new ItemArmor(52, EnumArmorMaterial.IRON, 2, 2)).func_20010_a(2, 2).func_20011_a("leggingsIron");
   public static Item field_282_ae = (new ItemArmor(53, EnumArmorMaterial.IRON, 2, 3)).func_20010_a(2, 3).func_20011_a("bootsIron");
   public static Item field_281_af = (new ItemArmor(54, EnumArmorMaterial.DIAMOND, 3, 0)).func_20010_a(3, 0).func_20011_a("helmetDiamond");
   public static Item field_280_ag = (new ItemArmor(55, EnumArmorMaterial.DIAMOND, 3, 1)).func_20010_a(3, 1).func_20011_a("chestplateDiamond");
   public static Item field_279_ah = (new ItemArmor(56, EnumArmorMaterial.DIAMOND, 3, 2)).func_20010_a(3, 2).func_20011_a("leggingsDiamond");
   public static Item field_278_ai = (new ItemArmor(57, EnumArmorMaterial.DIAMOND, 3, 3)).func_20010_a(3, 3).func_20011_a("bootsDiamond");
   public static Item field_277_aj = (new ItemArmor(58, EnumArmorMaterial.GOLD, 4, 0)).func_20010_a(4, 0).func_20011_a("helmetGold");
   public static Item field_276_ak = (new ItemArmor(59, EnumArmorMaterial.GOLD, 4, 1)).func_20010_a(4, 1).func_20011_a("chestplateGold");
   public static Item field_275_al = (new ItemArmor(60, EnumArmorMaterial.GOLD, 4, 2)).func_20010_a(4, 2).func_20011_a("leggingsGold");
   public static Item field_274_am = (new ItemArmor(61, EnumArmorMaterial.GOLD, 4, 3)).func_20010_a(4, 3).func_20011_a("bootsGold");
   public static Item field_273_an = (new Item(62)).func_20010_a(6, 0).func_20011_a("flint");
   public static Item field_272_ao = (new ItemFood(63, 3, 0.3F, true)).func_20010_a(7, 5).func_20011_a("porkchopRaw");
   public static Item field_4017_ap = (new ItemFood(64, 8, 0.8F, true)).func_20010_a(8, 5).func_20011_a("porkchopCooked");
   public static Item field_270_aq = (new ItemPainting(65)).func_20010_a(10, 1).func_20011_a("painting");
   public static Item field_269_ar = (new ItemAppleGold(66, 4, 1.2F, false)).func_35424_o().func_35425_a(Potion.field_35681_l.field_35670_H, 5, 0, 1.0F).func_20010_a(11, 0).func_20011_a("appleGold");
   public static Item field_267_as = (new ItemSign(67)).func_20010_a(10, 2).func_20011_a("sign");
   public static Item field_265_at = (new ItemDoor(68, Material.field_1335_c)).func_20010_a(11, 2).func_20011_a("doorWood");
   public static Item field_262_au = (new ItemBucket(69, 0)).func_20010_a(10, 4).func_20011_a("bucket");
   public static Item field_4016_av = (new ItemBucket(70, Block.field_401_B.field_376_bc)).func_20010_a(11, 4).func_20011_a("bucketWater").func_21017_a(field_262_au);
   public static Item field_258_aw = (new ItemBucket(71, Block.field_397_D.field_376_bc)).func_20010_a(12, 4).func_20011_a("bucketLava").func_21017_a(field_262_au);
   public static Item field_256_ax = (new ItemMinecart(72, 0)).func_20010_a(7, 8).func_20011_a("minecart");
   public static Item field_254_ay = (new ItemSaddle(73)).func_20010_a(8, 6).func_20011_a("saddle");
   public static Item field_252_az = (new ItemDoor(74, Material.field_1333_e)).func_20010_a(12, 2).func_20011_a("doorIron");
   public static Item field_309_aA = (new ItemRedstone(75)).func_20010_a(8, 3).func_20011_a("redstone").func_40407_b(PotionHelper.field_40375_i);
   public static Item field_308_aB = (new ItemSnowball(76)).func_20010_a(14, 0).func_20011_a("snowball");
   public static Item field_4031_aC = (new ItemBoat(77)).func_20010_a(8, 8).func_20011_a("boat");
   public static Item field_306_aD = (new Item(78)).func_20010_a(7, 6).func_20011_a("leather");
   public static Item field_305_aE = (new ItemBucketMilk(79)).func_20010_a(13, 4).func_20011_a("milk").func_21017_a(field_262_au);
   public static Item field_4030_aF = (new Item(80)).func_20010_a(6, 1).func_20011_a("brick");
   public static Item field_303_aG = (new Item(81)).func_20010_a(9, 3).func_20011_a("clay");
   public static Item field_302_aH = (new ItemReed(82, Block.field_423_aY)).func_20010_a(11, 1).func_20011_a("reeds");
   public static Item field_4029_aI = (new Item(83)).func_20010_a(10, 3).func_20011_a("paper");
   public static Item field_4028_aJ = (new Item(84)).func_20010_a(11, 3).func_20011_a("book");
   public static Item field_299_aK = (new Item(85)).func_20010_a(14, 1).func_20011_a("slimeball");
   public static Item field_4027_aL = (new ItemMinecart(86, 1)).func_20010_a(7, 9).func_20011_a("minecartChest");
   public static Item field_4026_aM = (new ItemMinecart(87, 2)).func_20010_a(7, 10).func_20011_a("minecartFurnace");
   public static Item field_296_aN = (new ItemEgg(88)).func_20010_a(12, 0).func_20011_a("egg");
   public static Item field_4025_aO = (new Item(89)).func_20010_a(6, 3).func_20011_a("compass");
   public static Item field_4024_aP = (new ItemFishingRod(90)).func_20010_a(5, 4).func_20011_a("fishingRod");
   public static Item field_4023_aQ = (new Item(91)).func_20010_a(6, 4).func_20011_a("clock");
   public static Item field_4022_aR = (new Item(92)).func_20010_a(9, 4).func_20011_a("yellowDust").func_40407_b(PotionHelper.field_40372_j);
   public static Item field_4021_aS = (new ItemFood(93, 2, 0.3F, false)).func_20010_a(9, 5).func_20011_a("fishRaw");
   public static Item field_4020_aT = (new ItemFood(94, 5, 0.6F, false)).func_20010_a(10, 5).func_20011_a("fishCooked");
   public static Item field_21021_aU = (new ItemDye(95)).func_20010_a(14, 4).func_20011_a("dyePowder");
   public static Item field_21020_aV = (new Item(96)).func_20010_a(12, 1).func_20011_a("bone").func_4016_e();
   public static Item field_21019_aW = (new Item(97)).func_20010_a(13, 0).func_20011_a("sugar").func_40407_b(PotionHelper.field_40365_b);
   public static Item field_21022_aX = (new ItemReed(98, Block.field_21026_bg)).func_21009_c(1).func_20010_a(13, 1).func_20011_a("cake");
   public static Item field_22019_aY = (new ItemBed(99)).func_21009_c(1).func_20010_a(13, 2).func_20011_a("bed");
   public static Item field_22018_aZ = (new ItemReed(100, Block.field_22021_bh)).func_20010_a(6, 5).func_20011_a("diode");
   public static Item field_25010_ba = (new ItemFood(101, 1, 0.1F, false)).func_20010_a(12, 5).func_20011_a("cookie");
   public static ItemMap field_28010_bb = (ItemMap)(new ItemMap(102)).func_20010_a(12, 3).func_20011_a("map");
   public static ItemShears field_31001_bc = (ItemShears)(new ItemShears(103)).func_20010_a(13, 5).func_20011_a("shears");
   public static Item field_35421_bg = (new ItemFood(104, 2, 0.3F, false)).func_20010_a(13, 6).func_20011_a("melon");
   public static Item field_35422_bh = (new ItemSeeds(105, Block.field_35284_bt.field_376_bc, Block.field_446_aB.field_376_bc)).func_20010_a(13, 3).func_20011_a("seeds_pumpkin");
   public static Item field_35423_bi = (new ItemSeeds(106, Block.field_35283_bu.field_376_bc, Block.field_446_aB.field_376_bc)).func_20010_a(14, 3).func_20011_a("seeds_melon");
   public static Item field_35417_bj = (new ItemFood(107, 3, 0.3F, true)).func_20010_a(9, 6).func_20011_a("beefRaw");
   public static Item field_35418_bk = (new ItemFood(108, 8, 0.8F, true)).func_20010_a(10, 6).func_20011_a("beefCooked");
   public static Item field_35419_bl = (new ItemFood(109, 2, 0.3F, true)).func_35425_a(Potion.field_35691_s.field_35670_H, 30, 0, 0.3F).func_20010_a(9, 7).func_20011_a("chickenRaw");
   public static Item field_35420_bm = (new ItemFood(110, 6, 0.6F, true)).func_20010_a(10, 7).func_20011_a("chickenCooked");
   public static Item field_35415_bn = (new ItemFood(111, 4, 0.1F, true)).func_35425_a(Potion.field_35691_s.field_35670_H, 30, 0, 0.8F).func_20010_a(11, 5).func_20011_a("rottenFlesh");
   public static Item field_35416_bo = (new ItemEnderPearl(112)).func_20010_a(11, 6).func_20011_a("enderPearl");
   public static Item field_40417_bo = (new Item(113)).func_20010_a(12, 6).func_20011_a("blazeRod");
   public static Item field_40418_bp = (new Item(114)).func_20010_a(11, 7).func_20011_a("ghastTear").func_40407_b(PotionHelper.field_40366_c);
   public static Item field_40419_bq = (new Item(115)).func_20010_a(12, 7).func_20011_a("goldNugget");
   public static Item field_40414_br = (new ItemSeeds(116, Block.field_40205_bE.field_376_bc, Block.field_4051_bd.field_376_bc)).func_20010_a(13, 7).func_20011_a("netherStalkSeeds").func_40407_b("+4");
   public static ItemPotion field_40413_bs = (ItemPotion)(new ItemPotion(117)).func_20010_a(13, 8).func_20011_a("potion");
   public static Item field_40416_bt = (new ItemGlassBottle(118)).func_20010_a(12, 8).func_20011_a("glassBottle");
   public static Item field_40415_bu = (new ItemFood(119, 2, 0.8F, false)).func_35425_a(Potion.field_35689_u.field_35670_H, 5, 0, 1.0F).func_20010_a(11, 8).func_20011_a("spiderEye").func_40407_b(PotionHelper.field_40363_d);
   public static Item field_40410_bv = (new Item(120)).func_20010_a(10, 8).func_20011_a("fermentedSpiderEye").func_40407_b(PotionHelper.field_40364_e);
   public static Item field_40409_bw = (new Item(121)).func_20010_a(13, 9).func_20011_a("blazePowder").func_40407_b(PotionHelper.field_40362_g);
   public static Item field_40412_bx = (new Item(122)).func_20010_a(13, 10).func_20011_a("magmaCream").func_40407_b(PotionHelper.field_40374_h);
   public static Item field_40411_by = (new ItemReed(123, Block.field_40211_bG)).func_20010_a(12, 10).func_20011_a("brewingStand");
   public static Item field_40408_bz = (new ItemReed(124, Block.field_40208_bH)).func_20010_a(12, 9).func_20011_a("cauldron");
   public static Item field_40420_bA = (new ItemEnderEye(125)).func_20010_a(11, 9).func_20011_a("eyeOfEnder");
   public static Item field_40426_bB = (new Item(126)).func_20010_a(9, 8).func_20011_a("speckledMelon").func_40407_b(PotionHelper.field_40361_f);
   public static Item field_44019_bC = (new ItemMonsterPlacer(127)).func_20010_a(9, 9).func_20011_a("monsterPlacer");
   public static Item field_48438_bD = (new ItemExpBottle(128)).func_20010_a(11, 10).func_20011_a("expBottle");
   public static Item field_48439_bE = (new ItemFireball(129)).func_20010_a(14, 2).func_20011_a("fireball");
   public static Item field_293_aQ = (new ItemRecord(2000, "13")).func_20010_a(0, 15).func_20011_a("record");
   public static Item field_4019_aV = (new ItemRecord(2001, "cat")).func_20010_a(1, 15).func_20011_a("record");
   public static Item field_40425_bE = (new ItemRecord(2002, "blocks")).func_20010_a(2, 15).func_20011_a("record");
   public static Item field_40429_bF = (new ItemRecord(2003, "chirp")).func_20010_a(3, 15).func_20011_a("record");
   public static Item field_40430_bG = (new ItemRecord(2004, "far")).func_20010_a(4, 15).func_20011_a("record");
   public static Item field_40427_bH = (new ItemRecord(2005, "mall")).func_20010_a(5, 15).func_20011_a("record");
   public static Item field_40428_bI = (new ItemRecord(2006, "mellohi")).func_20010_a(6, 15).func_20011_a("record");
   public static Item field_40423_bJ = (new ItemRecord(2007, "stal")).func_20010_a(7, 15).func_20011_a("record");
   public static Item field_40424_bK = (new ItemRecord(2008, "strad")).func_20010_a(8, 15).func_20011_a("record");
   public static Item field_40421_bL = (new ItemRecord(2009, "ward")).func_20010_a(9, 15).func_20011_a("record");
   public static Item field_40422_bM = (new ItemRecord(2010, "11")).func_20010_a(10, 15).func_20011_a("record");
   public final int field_291_aS;
   protected int field_290_aT = 64;
   private int field_289_aU = 0;
   protected int field_4018_aZ;
   protected boolean field_287_aW = false;
   protected boolean field_21018_bf = false;
   private Item field_20926_a = null;
   private String field_39010_c = null;
   private String field_332_a;


   protected Item(int p_i704_1_) {
      this.field_291_aS = 256 + p_i704_1_;
      if(field_233_c[256 + p_i704_1_] != null) {
         System.out.println("CONFLICT @ " + p_i704_1_);
      }

      field_233_c[256 + p_i704_1_] = this;
   }

   public Item func_4022_a(int p_4022_1_) {
      this.field_4018_aZ = p_4022_1_;
      return this;
   }

   public Item func_21009_c(int p_21009_1_) {
      this.field_290_aT = p_21009_1_;
      return this;
   }

   public Item func_20010_a(int p_20010_1_, int p_20010_2_) {
      this.field_4018_aZ = p_20010_1_ + p_20010_2_ * 16;
      return this;
   }

   public int func_27009_a(int p_27009_1_) {
      return this.field_4018_aZ;
   }

   public final int func_196_a(ItemStack p_196_1_) {
      return this.func_27009_a(p_196_1_.func_21181_i());
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      return false;
   }

   public float func_204_a(ItemStack p_204_1_, Block p_204_2_) {
      return 1.0F;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      return p_193_1_;
   }

   public ItemStack func_35413_b(ItemStack p_35413_1_, World p_35413_2_, EntityPlayer p_35413_3_) {
      return p_35413_1_;
   }

   public int func_200_b() {
      return this.field_290_aT;
   }

   public int func_21012_a(int p_21012_1_) {
      return 0;
   }

   public boolean func_21010_e() {
      return this.field_21018_bf;
   }

   protected Item func_21015_a(boolean p_21015_1_) {
      this.field_21018_bf = p_21015_1_;
      return this;
   }

   public int func_197_c() {
      return this.field_289_aU;
   }

   protected Item func_21013_d(int p_21013_1_) {
      this.field_289_aU = p_21013_1_;
      return this;
   }

   public boolean func_25007_g() {
      return this.field_289_aU > 0 && !this.field_21018_bf;
   }

   public boolean func_4021_a(ItemStack p_4021_1_, EntityLiving p_4021_2_, EntityLiving p_4021_3_) {
      return false;
   }

   public boolean func_25008_a(ItemStack p_25008_1_, int p_25008_2_, int p_25008_3_, int p_25008_4_, int p_25008_5_, EntityLiving p_25008_6_) {
      return false;
   }

   public int func_4020_a(Entity p_4020_1_) {
      return 1;
   }

   public boolean func_4018_a(Block p_4018_1_) {
      return false;
   }

   public void func_4019_b(ItemStack p_4019_1_, EntityLiving p_4019_2_) {}

   public Item func_4016_e() {
      this.field_287_aW = true;
      return this;
   }

   public boolean func_4017_a() {
      return this.field_287_aW;
   }

   public boolean func_4023_b() {
      return false;
   }

   public Item func_20011_a(String p_20011_1_) {
      this.field_332_a = "item." + p_20011_1_;
      return this;
   }

   public String func_40400_h(ItemStack p_40400_1_) {
      String var2 = this.func_21011_b(p_40400_1_);
      return var2 == null?"":StatCollector.func_25200_a(var2);
   }

   public String func_20009_a() {
      return this.field_332_a;
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      return this.field_332_a;
   }

   public Item func_21017_a(Item p_21017_1_) {
      this.field_20926_a = p_21017_1_;
      return this;
   }

   public boolean func_46059_i(ItemStack p_46059_1_) {
      return true;
   }

   public boolean func_46056_k() {
      return false;
   }

   public Item func_21016_h() {
      return this.field_20926_a;
   }

   public boolean func_21014_i() {
      return this.field_20926_a != null;
   }

   public String func_25009_k() {
      return StatCollector.func_25200_a(this.func_20009_a() + ".name");
   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      return 16777215;
   }

   public void func_28008_a(ItemStack p_28008_1_, World p_28008_2_, Entity p_28008_3_, int p_28008_4_, boolean p_28008_5_) {}

   public void func_28009_b(ItemStack p_28009_1_, World p_28009_2_, EntityPlayer p_28009_3_) {}

   public EnumAction func_35412_b(ItemStack p_35412_1_) {
      return EnumAction.none;
   }

   public int func_35411_c(ItemStack p_35411_1_) {
      return 0;
   }

   public void func_35414_a(ItemStack p_35414_1_, World p_35414_2_, EntityPlayer p_35414_3_, int p_35414_4_) {}

   protected Item func_40407_b(String p_40407_1_) {
      this.field_39010_c = p_40407_1_;
      return this;
   }

   public String func_40405_m() {
      return this.field_39010_c;
   }

   public boolean func_40406_n() {
      return this.field_39010_c != null;
   }

   public void func_40404_a(ItemStack p_40404_1_, List p_40404_2_) {}

   public String func_40397_d(ItemStack p_40397_1_) {
      String var2 = ("" + StringTranslate.func_20162_a().func_20161_b(this.func_40400_h(p_40397_1_))).trim();
      return var2;
   }

   public boolean func_40403_e(ItemStack p_40403_1_) {
      return p_40403_1_.func_40711_u();
   }

   public EnumRarity func_40398_f(ItemStack p_40398_1_) {
      return p_40398_1_.func_40711_u()?EnumRarity.rare:EnumRarity.common;
   }

   public boolean func_40401_i(ItemStack p_40401_1_) {
      return this.func_200_b() == 1 && this.func_25007_g();
   }

   protected MovingObjectPosition func_40402_a(World p_40402_1_, EntityPlayer p_40402_2_, boolean p_40402_3_) {
      float var4 = 1.0F;
      float var5 = p_40402_2_.field_602_at + (p_40402_2_.field_604_ar - p_40402_2_.field_602_at) * var4;
      float var6 = p_40402_2_.field_603_as + (p_40402_2_.field_605_aq - p_40402_2_.field_603_as) * var4;
      double var7 = p_40402_2_.field_9285_at + (p_40402_2_.field_611_ak - p_40402_2_.field_9285_at) * (double)var4;
      double var9 = p_40402_2_.field_9284_au + (p_40402_2_.field_610_al - p_40402_2_.field_9284_au) * (double)var4 + 1.62D - (double)p_40402_2_.field_9292_aO;
      double var11 = p_40402_2_.field_9283_av + (p_40402_2_.field_609_am - p_40402_2_.field_9283_av) * (double)var4;
      Vec3D var13 = Vec3D.func_1248_b(var7, var9, var11);
      float var14 = MathHelper.func_1114_b(-var6 * 0.017453292F - 3.1415927F);
      float var15 = MathHelper.func_1106_a(-var6 * 0.017453292F - 3.1415927F);
      float var16 = -MathHelper.func_1114_b(-var5 * 0.017453292F);
      float var17 = MathHelper.func_1106_a(-var5 * 0.017453292F);
      float var18 = var15 * var16;
      float var20 = var14 * var16;
      double var21 = 5.0D;
      Vec3D var23 = var13.func_1257_c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
      MovingObjectPosition var24 = p_40402_1_.func_28105_a(var13, var23, p_40402_3_, !p_40402_3_);
      return var24;
   }

   public int func_40399_b() {
      return 0;
   }

   public boolean func_46058_c() {
      return false;
   }

   public int func_46057_a(int p_46057_1_, int p_46057_2_) {
      return this.func_27009_a(p_46057_1_);
   }

   static {
      StatList.func_25151_b();
   }
}
