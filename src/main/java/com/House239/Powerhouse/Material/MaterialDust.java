package com.House239.Powerhouse.Material;

import java.awt.*;

public class MaterialDust extends Material{

    private int meltingPoint;
    private String chemicalFormula;
    private int tier;
    private float hardness;
    private float blastres;

    public MaterialDust(String name, Color color, int iconset, String modid, int meltingPoint, String translationKey, String chemicalFormula, int tier, float hardness, float blastres) {
        super(name, color, iconset, modid, meltingPoint, translationKey);
        this.meltingPoint = meltingPoint;
        this.chemicalFormula = chemicalFormula;
        this.tier = tier;
        this.hardness = hardness;
        this.blastres = blastres;
    }

    public String getChemicalFormula(){
        return this.chemicalFormula;
    }

    public int getTier(){
        return this.tier;
    }

    public float getHardness(){
        return this.hardness;
    }

    public float getBlastres(){
        return this.blastres;
    }
}
