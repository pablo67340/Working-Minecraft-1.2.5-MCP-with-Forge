package net.minecraft.src;

class GuiChatConfirmLink extends GuiConfirmOpenLink
{
    final ChatClickData field_50056_a;

    final GuiChat field_50055_b;

    GuiChatConfirmLink(GuiChat par1GuiChat, GuiScreen par2GuiScreen, String par3Str, int par4, ChatClickData par5ChatClickData)
    {
        super(par2GuiScreen, par3Str, par4);
        this.field_50055_b = par1GuiChat;
        this.field_50056_a = par5ChatClickData;
    }

    public void func_50052_d()
    {
        setClipboardString(this.field_50056_a.func_50088_a());
    }
}
