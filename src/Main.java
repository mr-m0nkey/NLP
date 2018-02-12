
import Lex.English.Tokenizers.EnglishTokenizer;
import Lex.Tokenizer.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayowa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EnglishTokenizer a = new EnglishTokenizer("Version:1.0.0\n" +
"\n" +
"*************************\n" +
"About this document\n" +
"\n" +
"Thank you for purchasing LOST PLANET 2.\n" +
"Please read the following instructions before playing.\n" +
"\n" +
"※Unless otherwise specified, this document contains information accurate as of September 2010. Some unforeseen changes to the content or URL links in this document may occur.\n" +
"*************************\n" +
"\n" +
"\n" +
"Contents\n" +
"1. System Requirements\n" +
"2. Game Sound\n" +
"3. Microsoft(R) DirectX(R)\n" +
"4. Copyright Notice\n" +
"\n" +
"\n" +
"----------------------------------------\n" +
"1. System Requirements\n" +
"----------------------------------------\n" +
"\n" +
"     Operating System: \n" +
"        - Microsoft(R) Windows(R) XP *1\n" +
"        - Microsoft(R) Windows Vista(R) *1\n" +
"        - Microsoft(R) Windows(R) 7 *1\n" +
"\n" +
"     Hard Disk Space:\n" +
"        at least 13GB\n" +
"\n" +
"     Internet connection:\n" +
"        Broadband Internet connection is required for online play.\n" +
"\n" +
"     Input Devices:\n" +
"        - Mouse & Keyboard\n" +
"        - Xbox 360(R) Controller for Windows(R)\n" +
"\n" +
"        *1 Please make sure the latest service pack is installed.\n" +
"\n" +
"\n" +
"Minimum System Requirements\n" +
"\n" +
"     CPU:\n" +
"        - Intel(R) Core(TM)2 Duo processor or higher\n" +
"        - AMD Athlon(TM) X2 Dual-Core Processor or higher\n" +
"\n" +
"     System RAM:\n" +
"        - Windows(R) XP : 1GB or higher\n" +
"        - Windows Vista(R) : 2GB or higher\n" +
"        - Windows(R) 7 : 2GB or higher\n" +
"\n" +
"\n" +
"     Video Card:\n" +
"        DirectX(R)9.0c/Shader3.0 compatible with at least 256MB of video RAM\n" +
"        - NVIDIA(R) GeForce(R) 7800 series or higher\n" +
"        - ATI Radeon(TM) HD 2400 Pro or higher\n" +
"\n" +
"     Sound Card:\n" +
"        DirectX(R)9.0c compatible sound card\n" +
"\n" +
"     DVD-ROM Drive:\n" +
"        DVD9 compatible Drive\n" +
"\n" +
"     Monitor:\n" +
"       640 x 480（SVGA） or higher\n" +
"\n" +
"\n" +
"\n" +
"Recommended System Requirements\n" +
"\n" +
"     CPU:\n" +
"        - Intel(R) Core(TM)2 Quad processor or higher\n" +
"        - AMD Phenom(TM) X4 Quad-Core Processor or higher\n" +
"\n" +
"     System RAM:\n" +
"        - Windows(R) XP : at least 2GB\n" +
"        - Windows Vista(R) : at least 3GB\n" +
"        - Windows(R) 7 : at least 3GB\n" +
"\n" +
"     Video Card:\n" +
"        DirectX(R)9.0c/Shader3.0 compatible with at least 512MB of video RAM\n" +
"        - NVIDIA(R) GeForce(R) 9800 series or higher\n" +
"        - ATI Radeon(TM) HD 4800 Pro or higher\n" +
"\n" +
"     Sound Card:\n" +
"        DirectX(R)9.0c compatible sound card\n" +
"\n" +
"     DVD-ROM Drive:\n" +
"        DVD9 compatible Drive\n" +
"\n" +
"     Monitor:\n" +
"        1280 x 720 or higher\n" +
"\n" +
"\n" +
"\n" +
"NVIDIA and GeForce are trademarks and/or registered trademarks of NVIDIA Corporation in the United States and other countries.\n" +
"\n" +
"Intel and Intel Core are trademarks of Intel Corporation in the United States and other countries. \n" +
"\n" +
"Microsoft, DirectX, Xbox360, Windows Vista, and Windows are either registered trademarks or trademarks of Microsoft Corporation in the United States and/or other countries. \n" +
"\n" +
"AMD Athlon, AMD Phenom and ATI Radeon are trademarks of Advanced Micro Devices, Inc.\n" +
"\n" +
"Please exit any other applications before playing this game.\n" +
"Running this game with other applications in the background may cause unforeseen problems.\n" +
"Even if the above system requirements are met, there is a possibility that individual settings could cause incompatibility.\n" +
"\n" +
"----------------------------------------\n" +
"2. Game Sound\n" +
"-----------------------------------------\n" +
"The sound for this game has been optimized for speaker layouts following the \"ITU-R Recommended Speaker Layout.\" By following the recommendations contained in the web address below, it will be possible to obtain the optimum sound experience.\n" +
"\n" +
"http://www.dolby.com/consumer/home_entertainment/roomlayout.html\n" +
"\n" +
"----------------------------------------\n" +
"3. Microsoft(R) DirectX(R)\n" +
"----------------------------------------\n" +
"TThis game requires Microsoft(R) DirectX(R) 9.0c or higher. It is recommended that you confirm your version of the drivers and, if necessary, download the latest version of Microsoft(R) DirectX(R) from the following web address.\n" +
"\n" +
"Microsoft(R) DirectX(R)\n" +
"http://www.microsoft.com/windows/directx/\n" +
"\n" +
"※Capcom Co., Ltd. is not liable for any problems that result from upgrading or installing Microsoft(R) DirectX(R). If you choose to update your video drivers, you accept full responsibility for any problems that may result.\n" +
"\n" +
"\n" +
"\n" +
"----------------------------------------\n" +
"4. Copyright Notice\n" +
"----------------------------------------\n" +
"(C)CAPCOM CO., LTD. 2010 ALL RIGHTS RESERVED\n" +
"\n" +
"Ogg Vorbis is Copyright (C)2010, Xiph.Org Foundation");
        
        Map<String, String> map = new HashMap();
        map.put(".", "");
        map.put("*", "");
        ArrayList<Token> t;
        t = a.getTokens();
        t.stream().forEach((t1) -> {
            System.out.println(t1.word_form);
        });
    }
    
}
