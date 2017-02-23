# 2017-Robot
Team 236's robot for 2017 FIRST Steamworks

## Subsystems
The robot has 5 distinct subsystems:
* Drive
* Climber
* Garage door
* Intake
* Shooter

### Drive
The drive system this year is a 6-wheel drop-center tank  drive on Colson 4-inch
wheels, which provides maneuverability and traction. Each side is powered by
twin CIM motors connected into a WCP DS gearbox with a two-speed pneumatic
gearshift which provides two distinct speeds to give greater control over the
robot.

Because the robot is a tank drive, 236 is using our
[TickTank](http://github.com/Team236/TickTank)
class which provides a variety of features including motion profiling and
abstract interfaces. More information on motion profiling, turning and other
autonomous behaviors is in the Autonomous section below. By default, the tank
drive runs in a simple tank drive control mode on two joysticks. However, the
driver is also provided with buttons to activate a more precise drive mode for
alignment with the peg for gear delivery and a reversed drive mode. Because this
year's robot has functions on both sides of the robot, it lacks a clearly
defined "front." Giving the driver the ability to reverse the drive can make
driving more intuitive.

### Climber
The climber is the simplest subsystem of the robot. It consists of two 775Pro
motors mechanically linked with a VersaPlanetary dual-input gearbox attached to
a custom-built wheel designed to capture a knot on the rope. A racheting wrench
is used to prevent the weight of the robot from causing the motor to backdrive
and to hold up the robot when the match ends and the motors lose power.

### Garage Door
The garage door is the colloquial name given to the robot's gear delivery
device. It is so named because the movement of the mechanism approximates that
of a garage door. The door part consists of a lexan sheet attached to delrin
tracks that allow it to roll up and down and spin by 90 degrees. The raised
position allows the gear to easily slide onto the door. Then, the lowered
position allows the gear to be placed precisely onto the peg for delivery to
the airship. The door also has a cutout designed to push up the spring so the
gear can be placed without actuation.

On the front of the garage door are two small arms made of delrin that can be
opened and closed. When the robot receives a gear from the loading station, it
opens the flaps to guide the gear to the correct position. When the door is
lowered, the flaps close to hold the gear securely while placing it on the peg.

The garage door is powered by two pneumatic pistons - one to pull the door up
and another to open and close the flaps. This allows powerful control over the
door while simplifying the wiring and programming.

### Intake
The intake of the robot is an arm that is lowered over the bumpers to obtain
fuel and move it to the hopper. The intake roller is powered by two 775Pro
motors with gearboxes on opposite sides of the intake. The intake arm is
lowered over the bumper by a pair of Bosch seat motors on opposite sides of the
robot. Limit switches on the top and bottom of the intake prevent the seat
motors from driving into the floor or the robot. Because seat motors burn out
very easily, these limit switches are crucial in preventing damage to the
motors over the course of the season.

### Shooter
The shooter is one of the most tightly tuned and controlled components of the
robot. Fuel is launched by a flywheel which rotates at speeds of around 3,000 to
4,000 RPM to push fuel around a curved hood. The hood itself is a curved piece
of lexan held in place by a custom-machined aluminum frame, which is raised and
lowered by a linear servo.

Because the flywheel is compliant and can expand, there is a lot of pressure
between the ball and flywheel at high speeds. The increased friction increases
the load on the flywheel significantly, lowereing its speed when the next ball
enters the hood. To prevent this, we run a PI loop at 200 hz which uses a banner
light sensor to count the speed of the wheel and to vary the motor speed to
maintain a consistent RPM. Using this system, we are able to return to full
speed after shooting a ball within hundredths of a second.

The shooter can be set to a variety of different "presets" which have an
associated speed (in RPM) and a hood angle (absolute). This provides a variety
of different points on the carpet to shoot from, making the robot harder to
defend. In order to align the robot with the boiler, the robot has a flashlight
which the drivers can see on the boiler stack, as well as a camera which can be
rotated to see the boiler. Later in the season, we may add a coprocessor to run
vision on the robot to aid in alignment.
