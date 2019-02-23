package net.minecraft.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostHttp
{
    /**
     * Builds an encoded HTTP POST content string from a string map
     */
    public static String buildPostString(Map par0Map)
    {
        StringBuilder var1 = new StringBuilder();
        Iterator var2 = par0Map.entrySet().iterator();

        while (var2.hasNext())
        {
            Entry var3 = (Entry)var2.next();

            if (var1.length() > 0)
            {
                var1.append('&');
            }

            try
            {
                var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException var6)
            {
                var6.printStackTrace();
            }

            if (var3.getValue() != null)
            {
                var1.append('=');

                try
                {
                    var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException var5)
                {
                    var5.printStackTrace();
                }
            }
        }

        return var1.toString();
    }

    /**
     * Sends a HTTP POST request to the given URL with data from a map
     */
    public static String sendPost(URL par0URL, Map par1Map, boolean par2)
    {
        return sendPost(par0URL, buildPostString(par1Map), par2);
    }

    /**
     * Sends a HTTP POST request to the given URL with data from a string
     */
    public static String sendPost(URL par0URL, String par1Str, boolean par2)
    {
        try
        {
            HttpURLConnection var4 = (HttpURLConnection)par0URL.openConnection();
            var4.setRequestMethod("POST");
            var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            var4.setRequestProperty("Content-Length", "" + par1Str.getBytes().length);
            var4.setRequestProperty("Content-Language", "en-US");
            var4.setUseCaches(false);
            var4.setDoInput(true);
            var4.setDoOutput(true);
            DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
            var5.writeBytes(par1Str);
            var5.flush();
            var5.close();
            BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
            StringBuffer var8 = new StringBuffer();
            String var7;

            while ((var7 = var6.readLine()) != null)
            {
                var8.append(var7);
                var8.append('\r');
            }

            var6.close();
            return var8.toString();
        }
        catch (Exception var9)
        {
            if (!par2)
            {
                Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not post to " + par0URL, var9);
            }

            return "";
        }
    }
}
