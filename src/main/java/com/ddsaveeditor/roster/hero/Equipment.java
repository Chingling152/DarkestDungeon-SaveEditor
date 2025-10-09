package com.ddsaveeditor.roster.hero;

class InvalidEquipmentRankException extends IndexOutOfBoundsException
{
    public InvalidEquipmentRankException(int index) {
        super("Equipment Rank is invalid: " + index);//TODO: Improve error message
    }
}

class Equipment {
    private static final int MAX_WEAPON_RANK = 4;
    private static final int MAX_ARMOUR_RANK = 4;

    private int weaponRank;
    private int armourRank;

    Equipment(int weaponRank, int armourRank){
        this.weaponRank = weaponRank;
        this.armourRank = armourRank;
    }

    int getMaxWeaponRank(){
        return this.weaponRank;
    }
    void setWeaponRank(int weaponRank) {
        if(weaponRank < 0 || weaponRank > MAX_WEAPON_RANK){
            throw new InvalidEquipmentRankException(weaponRank);
        }
        this.weaponRank = weaponRank;
    }
    int getMaxArmourRank(){
        return this.armourRank;
    }
    void setMaxArmourRank(int armourRank){
        if(armourRank < 0 || armourRank > MAX_ARMOUR_RANK){
            throw new InvalidEquipmentRankException(armourRank);
        }
        this.armourRank = armourRank;
    }
}