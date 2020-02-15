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
@Autonomous(name = "GrabFoundationRed (Blocks to Java)", group = "GrabFoundation")
public class GrabFoundationRed extends LinearOpMode {

  private Servo BRS;
  private DcMotor FRM;
  private DcMotor BRM;
  private DcMotor BLM;
  private DcMotor FLM;
  private Servo BLS;
  private ColorSensor BCS;

  float Hue;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    BRS = hardwareMap.servo.get("BRS");
    FRM = hardwareMap.dcMotor.get("FRM");
    BRM = hardwareMap.dcMotor.get("BRM");
    BLM = hardwareMap.dcMotor.get("BLM");
    FLM = hardwareMap.dcMotor.get("FLM");
    BLS = hardwareMap.servo.get("BLS");
    BCS = hardwareMap.colorSensor.get("BCS");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      BRS.setDirection(Servo.Direction.REVERSE);
      FRM.setPower(0.5);
      BRM.setPower(-0.5);
      BLM.setPower(-0.5);
      FLM.setPower(0.5);
      sleep(300);
      BRM.setPower(0);
      FRM.setPower(0);
      BRM.setPower(0);
      FRM.setPower(0);
      sleep(500);
      BRM.setPower(-1);
      FRM.setPower(-1);
      FLM.setPower(1);
      BLM.setPower(1);
      sleep(1500);
      BRM.setPower(0);
      FRM.setPower(0);
      FLM.setPower(0);
      BLM.setPower(0);
      sleep(500);
      BRS.setPosition(1);
      sleep(1000);
      BLS.setPosition(1);
      sleep(1000);
      BRM.setPower(1);
      FRM.setPower(1);
      FLM.setPower(-1);
      BLM.setPower(-1);
      sleep(1600);
      BRM.setPower(0);
      FRM.setPower(0);
      FLM.setPower(0);
      BLM.setPower(0);
      sleep(500);
      BRS.setPosition(0);
      sleep(1000);
      BLS.setPosition(0);
      sleep(1000);
      BRM.setPower(-1);
      FRM.setPower(-1);
      BLM.setPower(1);
      FLM.setPower(1);
      sleep(50);
      BRM.setPower(0);
      FRM.setPower(0);
      BLM.setPower(0);
      FLM.setPower(0);
      sleep(100);
      CheckColor();
      while (Hue >= 250 && opModeIsActive()) {
        BRM.setPower(0.5);
        FRM.setPower(-0.5);
        FLM.setPower(-0.5);
        BLM.setPower(0.5);
        CheckColor();
      }
      FLM.setPower(0);
      BLM.setPower(0);
      FRM.setPower(0);
      BRM.setPower(0);
    }
  }

  /**
   * Describe this function...
   */
  private void CheckColor() {
    int CurrentColor;

    CurrentColor = Color.argb(BCS.alpha(), BCS.red(), BCS.green(), BCS.blue());
    Hue = JavaUtil.colorToHue(CurrentColor);
  }
}
