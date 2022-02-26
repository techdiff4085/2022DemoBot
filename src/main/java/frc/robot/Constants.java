// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int LeftFrontWheel = 12;
    public static int RightFrontWheel = 2;
    public static int LeftRearWheel = 13;
    public static int RightRearWheel = 0;

    public static int SpinnyLimitSwitch = 9;
    public static int SpinnyThing = 1;

    public static double KP = 0.01f;
    public static double KI = 0;
    public static double KD = 0.001;
}
