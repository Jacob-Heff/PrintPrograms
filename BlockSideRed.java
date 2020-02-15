package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.JavaUtil;

@Disabled
@Autonomous(name = "BlockSideRed (Blocks to Java)", group = "BlockSide")
public class BlockSideRed extends LinearOpMode {

  private ColorSensor ACS;
  private DcMotor FRM;
  private DcMotor FLM;
  private DcMotor BRM;
  private DcMotor BLM;
  private Servo AS;
  private ColorSensor BCS;

  float Hue;
  float Sat;
  float BHue;

  /**
   * Describe this function...
   */
  private void CheckColor() {
    int CurrentColor;
    float Val;

    CurrentColor = Color.argb(ACS.alpha(), ACS.red(), ACS.green(), ACS.blue());
    Hue = JavaUtil.colorToHue(CurrentColor);
    Val = JavaUtil.colorToValue(CurrentColor);
    Sat = JavaUtil.colorToSaturation(CurrentColor);
  }

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    ACS = hardwareMap.colorSensor.get("ACS");
    FRM = hardwareMap.dcMotor.get("FRM");
    FLM = hardwareMap.dcMotor.get("FLM");
    BRM = hardwareMap.dcMotor.get("BRM");
    BLM = hardwareMap.dcMotor.get("BLM");
    AS = hardwareMap.servo.get("AS");
    BCS = hardwareMap.colorSensor.get("BCS");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      telemetry.update();
      FRM.setPower(1);
      FLM.setPower(-1);
      BRM.setPower(1);
      BLM.setPower(-1);
      sleep(1100);
      FRM.setPower(0);
      FLM.setPower(0);
      BRM.setPower(0);
      BLM.setPower(0);
      sleep(500);
      CheckColor();
      if (Hue > 250 && Sat > 0.55 && opModeIsActive()) {
        FRM.setPower(1);
        FLM.setPower(-1);
        BRM.setPower(1);
        BLM.setPower(-1);
        sleep(500);
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        AS.setPosition(0);
        sleep(1000);
        FRM.setPower(-1);
        FLM.setPower(1);
        BRM.setPower(-1);
        BLM.setPower(1);
        sleep(1000);
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        CheckBottomColor();
        while (BHue >= 250 && opModeIsActive()) {
          BRM.setPower(0.5);
          FRM.setPower(-0.5);
          FLM.setPower(-0.5);
          BLM.setPower(0.5);
          CheckBottomColor();
        }
        FLM.setPower(0);
        BLM.setPower(0);
        FRM.setPower(0);
        BRM.setPower(0);
      } else {
        FRM.setPower(-1);
        FLM.setPower(1);
        BRM.setPower(-1);
        BLM.setPower(1);
        sleep(100);
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        sleep(500);
        CheckBottomColor();
        while (BHue >= 250 && opModeIsActive()) {
          BRM.setPower(0.5);
          FRM.setPower(-0.5);
          FLM.setPower(-0.5);
          BLM.setPower(0.5);
          CheckBottomColor();
        }
        FLM.setPower(0);
        BLM.setPower(0);
        FRM.setPower(0);
        BRM.setPower(0);
      }
      telemetry.update();
    }
  }

  /**
   * Describe this function...
   */
  private void CheckBottomColor() {
    int CurrentBColor;
    float BSat;
    float BVal;

    CurrentBColor = Color.argb(BCS.alpha(), BCS.red(), BCS.green(), BCS.blue());
    BHue = JavaUtil.colorToHue(CurrentBColor);
    BVal = JavaUtil.colorToValue(CurrentBColor);
    BSat = JavaUtil.colorToSaturation(CurrentBColor);
  }
}
