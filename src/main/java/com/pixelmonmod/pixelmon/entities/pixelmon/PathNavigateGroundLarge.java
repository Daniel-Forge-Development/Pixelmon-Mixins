package com.pixelmonmod.pixelmon.entities.pixelmon;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class PathNavigateGroundLarge extends PathNavigateGround {

    public PathNavigateGroundLarge(EntityLiving entitylivingIn, World worldIn) {
        super(entitylivingIn, worldIn);
    }

    @Override
    protected boolean isDirectPathBetweenPoints(Vec3d posVec31, Vec3d posVec32, int sizeX, int sizeY, int sizeZ) {
        int i = MathHelper.floor(posVec31.x);
        int j = MathHelper.floor(posVec31.z);
        double d0 = posVec32.x - posVec31.x;
        double d1 = posVec32.z - posVec31.z;
        double d2 = d0 * d0 + d1 * d1;

        if (d2 < 1.0E-8D)
        {
            return false;
        }
        else {
            double d3 = 1.0D / Math.sqrt(d2);
            d0 = d0 * d3;
            d1 = d1 * d3;
            sizeX = sizeX + 2;
            sizeZ = sizeZ + 2;

            sizeX = sizeX - 2;
            sizeZ = sizeZ - 2;
            double d4 = 1.0D / Math.abs(d0);
            double d5 = 1.0D / Math.abs(d1);
            double d6 = (double) i - posVec31.x;
            double d7 = (double) j - posVec31.z;

            if (d0 >= 0.0D) {
                ++d6;
            }

            if (d1 >= 0.0D) {
                ++d7;
            }

            d6 = d6 / d0;
            d7 = d7 / d1;
            int k = d0 < 0.0D ? -1 : 1;
            int l = d1 < 0.0D ? -1 : 1;
            int i1 = MathHelper.floor(posVec32.x);
            int j1 = MathHelper.floor(posVec32.z);
            int k1 = i1 - i;
            int l1 = j1 - j;

            if (k1 * k > 0 || l1 * l > 0) {
                if (d6 < d7) {
                    d6 += d4;
                    i += k;
                    k1 = i1 - i;
                } else {
                    d7 += d5;
                    j += l;
                    l1 = j1 - j;
                }

                return true;
            }

            return true;
        }
    }
}
