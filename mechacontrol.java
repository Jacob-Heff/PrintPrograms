package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp(name = "mechacontrol (Blocks to Java)", group = "")
public class mechacontrol extends LinearOpMode {

  private Servo BLS;
  private DcMotor BLM;
  private DcMotor FLM;
  private DcMotor BRM;
  private DcMotor FRM;
  private Servo BRS;
  private Servo AS;
  private DcMotor AM;
  private Servo FLS;
  private Servo FRS;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double Position2;
    double Closed;
    double Stacked;

    BLS = hardwareMap.servo.get("BLS");
    BLM = hardwareMap.dcMotor.get("BLM");
    FLM = hardwareMap.dcMotor.get("FLM");
    BRM = hardwareMap.dcMotor.get("BRM");
    FRM = hardwareMap.dcMotor.get("FRM");
    BRS = hardwareMap.servo.get("BRS");
    AS = hardwareMap.servo.get("AS");
    AM = hardwareMap.dcMotor.get("AM");
    FLS = hardwareMap.servo.get("FLS");
    FRS = hardwareMap.servo.get("FRS");

    // Put initialization blocks here.
    BLS.setDirection(Servo.Direction.REVERSE);
    BLM.setDirection(DcMotorSimple.Direction.REVERSE);
    FLM.setDirection(DcMotorSimple.Direction.REVERSE);
    BRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    BLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    FRM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    FLM.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    Position2 = 0;
    Stacked = 0;
    Closed = 0;
    waitForStart();
    if (opModeIsActive()) {
      BLS.setPosition(0);
      BRS.setPosition(0);
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad2.y) {
          Closed = 1;
        } else if (gamepad2.a) {
          Closed = 2;
        } else {
          Closed = 0;
        }
        while (Closed == 1 && opModeIsActive()) {
          AS.setPosition(0);
          Mecha_Control_System();
          Closed = 0;
        }
        while (Closed == 2 && opModeIsActive()) {
          AS.setPosition(1);
          Mecha_Control_System();
          Closed = 0;
        }
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Mecha_Control_System() {
    AM.setPower(gamepad2.right_stick_y);
    if (!(gamepad1.left_bumper || gamepad1.right_bumper || gamepad1.left_trigger > 0.5 || gamepad1.right_trigger > 0.5 || gamepad1.dpad_left || gamepad1.dpad_right || gamepad1.x || gamepad1.b)) {
      FRM.setPower(-gamepad1.right_stick_y);
      BRM.setPower(-gamepad1.right_stick_y);
      FLM.setPower(-gamepad1.left_stick_y);
      BLM.setPower(-gamepad1.left_stick_y);
    } else {
      if (gamepad1.left_trigger > 0.5) {
        BLM.setPower(-1);
        FLM.setPower(0);
        BRM.setPower(0);
        FRM.setPower(-1);
      }
      if (gamepad1.right_trigger > 0.5) {
        BLM.setPower(0);
        FLM.setPower(-1);
        BRM.setPower(-1);
        FRM.setPower(0);
      }
      if (gamepad1.left_bumper) {
        BLM.setPower(1);
        FLM.setPower(0);
        BRM.setPower(0);
        FRM.setPower(1);
      }
      if (gamepad1.right_bumper) {
        BLM.setPower(0);
        FLM.setPower(1);
        BRM.setPower(1);
        FRM.setPower(0);
      }
      if (gamepad1.dpad_right || gamepad1.b) {
        BLM.setPower(-1);
        FLM.setPower(1);
        BRM.setPower(1);
        FRM.setPower(-1);
      }
      if (gamepad1.dpad_left || gamepad1.x) {
        BLM.setPower(1);
        FLM.setPower(-1);
        BRM.setPower(-1);
        FRM.setPower(1);
      }
      if (gamepad1.dpad_left || gamepad1.x) {
        BLM.setPower(1);
        FLM.setPower(-1);
        BRM.setPower(-1);
        FRM.setPower(1);
      }
    }
  }
}
