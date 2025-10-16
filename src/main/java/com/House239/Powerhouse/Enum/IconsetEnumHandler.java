package com.House239.Powerhouse.Enum;

import net.minecraft.util.IStringSerializable;

public class IconsetEnumHandler {
    public enum IconsetEnumType implements IStringSerializable {
        standard(0, "standard"),
        shiny(1, "shiny"),
        metallic_cubic(2, "metallic_cubic"),
        rough(3, "rough"),
        slimy(4, "slimy");


        private static final IconsetEnumHandler.IconsetEnumType[] META_LOOKUP = new IconsetEnumHandler.IconsetEnumType[values().length];
        private final int meta;
        private final String name, translationKey;

        private IconsetEnumType(int meta, String name){
            this(meta, name, name);
        }

        private IconsetEnumType(int meta, String name, String unlocalizedname){
            this.meta = meta;
            this.name = name;
            this.translationKey = unlocalizedname;
        }
        public String GetName(){
            return this.name;
        }
        public int GetMeta(){
            return this.meta;
        }
        public String getTranslationKey(){
            return this.translationKey;
        }

        @Override
        public String toString(){
            return this.name;
        }
        public static IconsetEnumHandler.IconsetEnumType byMetadata(int meta){
            return META_LOOKUP[meta];
        }

        static{
            for(IconsetEnumHandler.IconsetEnumType enumtype : values()){
                META_LOOKUP[enumtype.GetMeta()] = enumtype;
            }
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
