package DM;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * ModibaDonald - a robot by (Donald Modiba)
 */
public class ModibaDonald extends Robot
{
	/**
	 * run: ModibaDonald's default behavior
	 */
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		setBulletColor(Color.black);
		setColors(Color.green,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(200);
			turnGunRight(270);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		
		if(e.getDistance() < 200){
			if(getEnergy() > 60)
			{
				setColors(Color.yellow,Color.yellow,Color.yellow);
				fire(4);
			}
			else{
				setColors(Color.red,Color.red,Color.red);
				fire(1);
			}	
		}
		else if(e.getDistance() < 400)
		{
			if(getEnergy() > 60)
			{
				setColors(Color.green,Color.blue,Color.green);
				fire(3);
			}
			else{
				setColors(Color.red,Color.red,Color.red);
				fire(1);
			}	
		}
		else
		{
			fire(2);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like

		turnRight(45);
		back(100);
	}
	
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(20);
		back(200);
		turnRight(30);
		ahead(30);
	}	
	
	public void onHitRobot(HitRobotEvent e){
		ahead(100);
		
	}
}