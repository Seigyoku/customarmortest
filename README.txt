Custom Armor Test Mod
Minecraft 1.4.7
Minecraft Forge 6.6.0.497

This is the source code for a Custom Armor Test Mod to be used with Forge.
Please place customarmortest-master's contents (where this README.txt is)
inside \forge\mcp\src\minecraft\mod\customarmortest for Eclipse to recognize this in your workspace.

This achieves custom armor rendering, however the files:

test_1.png
test_2.png
testalt_1.png
testalt_2.png

must be placed within \forge\mcp\jars\bin\minecraft.jar\armor for this to properly work. This approach does not make use of IArmorTextureProvider, however this should be of help for those who wish to understand how to make this work in the first place. Compare and contrast with https://github.com/Seigyoku/customarmortestiatp to see how the different approaches work.

The Mod is not written for MultiPlayer, so there is no supplied server-side coding.
